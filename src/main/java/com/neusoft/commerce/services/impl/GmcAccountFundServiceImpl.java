package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.common.OrderCodeFactory;
import com.neusoft.commerce.dao.GmcpAccountFundMapper;
import com.neusoft.commerce.dao.GmcpTransactionAuditMapper;
import com.neusoft.commerce.dao.GmcpTransactionRecordMapper;
import com.neusoft.commerce.dao.SaoSalesOrderMapper;
import com.neusoft.commerce.models.GmcpAccountFund;
import com.neusoft.commerce.models.GmcpTransactionAudit;
import com.neusoft.commerce.models.GmcpTransactionRecord;
import com.neusoft.commerce.models.dto.RecordAuditDTO;
import com.neusoft.commerce.services.GmcAccountFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author zqy
 * @Date 2019/08/01
 */
@Service
public class GmcAccountFundServiceImpl implements GmcAccountFundService {

    @Autowired
    private GmcpAccountFundMapper gmcpAccountFundMapper;
    @Autowired
    private GmcpTransactionAuditMapper gmcpTransactionAuditMapper;
    @Autowired
    private GmcpTransactionRecordMapper gmcpTransactionRecordMapper;
    @Autowired
    private SaoSalesOrderMapper salesOrderMapper;

    @Override
    public int insert(GmcpAccountFund record) {
        return 0;
    }

    @Override
    public int insertSelective(GmcpAccountFund record) {
        return gmcpAccountFundMapper.insertSelective(record);
    }

    @Override
    public int updateMoney(BigDecimal money, Integer buyerId) {
        return gmcpAccountFundMapper.updateMoney(money,buyerId);
    }


    //提现
    @Transactional
    public void depositMoney(BigDecimal oldMoney,BigDecimal money, Integer buyerId,String acName) {
        //修改fund表余额
        gmcpAccountFundMapper.updateMoney(oldMoney.subtract(money),buyerId);

        //插入流水表
        //transaction_type  业务类型 1-充值 2-提现 3-消费 4-退款
        //finance_type 类型 1-入款 2-出款
        //status状态 2 -申请 , 4 -完成 , -1-失败
        GmcpTransactionRecord record=new GmcpTransactionRecord();
        record.setAccountName(acName); // 账户名
        record.setBuyerId(buyerId);  //卖方id
        record.setTransactionMoney(money); //交易金额
        record.setTransactionNumber(OrderCodeFactory.getOrderCode(new Long(buyerId))); //订单流水号
        record.setBalance(oldMoney.subtract(money));  //余额
        byte type=2;
        record.setTransactionType(type);
        byte status=2;
        record.setStatus(status);
        byte finance=1;
        record.setFinanceType(finance);
        gmcpTransactionRecordMapper.insert(record);


        //插入审计表
        GmcpTransactionAudit audit=new GmcpTransactionAudit();
        audit.setTransactionId(record.getTransactionId());
        audit.setBuyerId(buyerId);
        //前可用余额
        audit.setAvailableMoneyBefore(oldMoney);
        audit.setWithdrawingMoneyBefore(oldMoney);
        audit.setOperateMoney(money);
        //operation_type 操作类型 1-申请 2-提现 3-消费 4-退款
        byte op=1;
        audit.setOperateType(op);
        audit.setAvailableMoneyAfter(oldMoney.subtract(money));
        //st 操作状态 2-申请 , 4 -完成 , -1-失败
        byte st=2;
        audit.setStatus(st);
        gmcpTransactionAuditMapper.insert(audit);

    }



    //查看流水
    public List<RecordAuditDTO> selectRecordAndAudit(Integer buyerId){
        return gmcpTransactionRecordMapper.selectRecordAndAudit(buyerId);
    }


    //支付
    @Transactional
    public void payMoney(Integer buyerId,Integer brandId,String name, String address, Integer amount,
                         String phone, String code, BigDecimal total,
                         String wallet, BigDecimal money, BigDecimal brandMoney,String password,Integer orderId) {

        //1.fund 修改
        gmcpAccountFundMapper.updateMoney(money.subtract(total),buyerId);
        gmcpAccountFundMapper.updateMoney(brandMoney.add(total),brandId);

        //2.生成流水

        //插入流水表
        //transaction_type  业务类型 1-充值 2-提现 3-消费 4-退款
        //finance_type 类型 1-入款 2-出款
        //status状态 2 -申请 , 4 -完成 , -1-失败
        GmcpTransactionRecord record=new GmcpTransactionRecord();
        record.setAccountName(name); // 账户名
        record.setBuyerId(buyerId);  //卖方id
        record.setTransactionMoney(total); //交易金额
        record.setTransactionNumber(OrderCodeFactory.getOrderCode(new Long(buyerId))); //订单流水号
        record.setBalance(money.subtract(total));  //余额
        byte type=3;
        record.setTransactionType(type);
        byte status=4;
        record.setStatus(status);
        byte finance=2;
        record.setFinanceType(finance);
        gmcpTransactionRecordMapper.insert(record);


        //插入审计表
        GmcpTransactionAudit audit=new GmcpTransactionAudit();
        audit.setTransactionId(record.getTransactionId());
        audit.setBuyerId(buyerId);
        //前可用余额
        audit.setAvailableMoneyBefore(money);
        audit.setWithdrawingMoneyBefore(money);
        audit.setOperateMoney(money);
        //operation_type 操作类型 1-申请 2-提现 3-消费 4-退款
        byte op=3;
        audit.setOperateType(op);
        audit.setAvailableMoneyAfter(money.subtract(total));
        //st 操作状态 2-申请 , 4 -完成 , -1-失败
        byte st=4;
        audit.setStatus(st);
        gmcpTransactionAuditMapper.insertSelective(audit);


        //3.更新sao 的order_sts
        //订单状态: 1. AwaitingPayment  待支付 2. AwaitingShipment 待发货 3. SHIPPED 已发货 4. Complete 已完成5. Canceled已取消
        salesOrderMapper.updateBySaoId(orderId,"2");

    }




}
