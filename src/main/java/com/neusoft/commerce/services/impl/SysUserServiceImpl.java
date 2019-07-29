package com.neusoft.commerce.services.impl;

import com.neusoft.commerce.dao.DsrDropshipperMapper;
import com.neusoft.commerce.dao.SysUserMapper;
import com.neusoft.commerce.models.DsrDropshipper;
import com.neusoft.commerce.models.SysUser;
import com.neusoft.commerce.models.dto.BvoInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zqy
 * @Date 2019/07/18
 */
@Service
public class SysUserServiceImpl implements SysUserMapper {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private DsrDropshipperMapper dropshipperMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return 0;
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return 0;
    }

    @Override
    public SysUser selectByPrimaryKey(Integer userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return 0;
    }

    @Override
    public SysUser selectByAccount(String username) {
        return sysUserMapper.selectByAccount(username);
    }

    @Override
    public int updateManId(Integer manId, Integer userId) {
        return sysUserMapper.updateManId(manId,userId);
    }

    @Override
    public BvoInfoDTO selectBvoInfo(Integer userId) {
        return sysUserMapper.selectBvoInfo(userId);
    }


    //修改借卖方信息
    @Transactional
    public int updateBvoInfo(BvoInfoDTO bvo) {

        DsrDropshipper dropshipper=new DsrDropshipper();
        dropshipper.setDsrId(bvo.getDsrId());
        dropshipper.setName(bvo.getName());
        Integer num=0;
        if(bvo.getDsrId()==null){
            num =dropshipperMapper.insertSelective(dropshipper);
        }else {
            num=dropshipperMapper.updateByPrimaryKeySelective(dropshipper);
        }


        SysUser user=new SysUser();
        user.setUserId(bvo.getUserId());
        user.setEmail(bvo.getEmail());
        user.setPhone(bvo.getPhone());
        user.setManBuyerId(dropshipper.getDsrId());

        sysUserMapper.updateByPrimaryKeySelective(user);
        return num;
    }
}
