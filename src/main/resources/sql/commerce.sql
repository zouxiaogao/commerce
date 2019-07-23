/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : commerce

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-07-23 16:33:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `brd_brand`
-- ----------------------------
DROP TABLE IF EXISTS `brd_brand`;
CREATE TABLE `brd_brand` (
  `BRD_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MAN_ID` int(11) NOT NULL COMMENT '公司信息，外键关联man表主键',
  `NAME_EN` varchar(100) DEFAULT NULL COMMENT '公司名称（英文）',
  `NAME_CN` varchar(100) DEFAULT NULL COMMENT '公司名称（中文）',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`BRD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brd_brand
-- ----------------------------
INSERT INTO `brd_brand` VALUES ('1', '1', 'hongmi', '红米', null, '2017-07-24 21:26:51', null, '2017-07-24 21:26:51', '0', null, 'A');

-- ----------------------------
-- Table structure for `cdm_code_master`
-- ----------------------------
DROP TABLE IF EXISTS `cdm_code_master`;
CREATE TABLE `cdm_code_master` (
  `CDM_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CODE_TYPE` varchar(16) DEFAULT NULL COMMENT '字典类型',
  `DESCRIPTION` varchar(45) DEFAULT NULL COMMENT '用途描述',
  `TYPE_CD` varchar(45) NOT NULL COMMENT '编码',
  `CODE_VAL` varchar(45) NOT NULL COMMENT '编码值',
  `SEQ_NO` int(11) DEFAULT NULL COMMENT '排序',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`CDM_ID`),
  KEY `fk_type_cd_idx` (`TYPE_CD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cdm_code_master
-- ----------------------------

-- ----------------------------
-- Table structure for `drp_dropship_price`
-- ----------------------------
DROP TABLE IF EXISTS `drp_dropship_price`;
CREATE TABLE `drp_dropship_price` (
  `DRP_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `OFP_ID` int(11) NOT NULL COMMENT '商品价格ID',
  `DSR_ID` int(11) DEFAULT NULL COMMENT '借卖方ID',
  `WAR_ID` int(11) DEFAULT NULL COMMENT '仓库ID',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`DRP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drp_dropship_price
-- ----------------------------

-- ----------------------------
-- Table structure for `dsr_dropshipper`
-- ----------------------------
DROP TABLE IF EXISTS `dsr_dropshipper`;
CREATE TABLE `dsr_dropshipper` (
  `DSR_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(45) DEFAULT NULL COMMENT '借卖方名称',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATION_DATE` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '修改人',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  `REGISTER_DATE` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '注册时间',
  PRIMARY KEY (`DSR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dsr_dropshipper
-- ----------------------------

-- ----------------------------
-- Table structure for `eba_ebay_authorization`
-- ----------------------------
DROP TABLE IF EXISTS `eba_ebay_authorization`;
CREATE TABLE `eba_ebay_authorization` (
  `EBA_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `STR_ID` int(11) DEFAULT NULL COMMENT '网店ID',
  `APP_ID` varchar(255) DEFAULT NULL COMMENT 'ebay账号ID',
  `SECRET_KEY` varchar(255) DEFAULT NULL COMMENT 'ebay密钥',
  `TOKEN` longtext COMMENT 'ebay TOKEN',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  `EXP_DATE` datetime DEFAULT NULL COMMENT 'token失效时间',
  `CANCLE_DATE` datetime DEFAULT NULL COMMENT '取消授权时间',
  `ACCOUNT_ID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`EBA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eba_ebay_authorization
-- ----------------------------

-- ----------------------------
-- Table structure for `fre_freight_template`
-- ----------------------------
DROP TABLE IF EXISTS `fre_freight_template`;
CREATE TABLE `fre_freight_template` (
  `FRE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `FRE_COMPANY` varchar(45) DEFAULT NULL COMMENT '快递公司:中通/圆通/申通/韵达',
  `WAR_ID` int(11) DEFAULT NULL COMMENT '仓库ID',
  `DES_COUNTRY` varchar(45) DEFAULT NULL COMMENT '目的地国家',
  `DES_COUNTRY_ID` varchar(45) DEFAULT NULL COMMENT '目的地国家编码',
  `DES_PROVINCE` varchar(45) DEFAULT NULL COMMENT '目的地省份',
  `DES_PROVINCE_ID` varchar(45) DEFAULT NULL COMMENT '目的地省份编码',
  `FRE_FEE` decimal(7,2) DEFAULT '0.00' COMMENT '单位运费',
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`FRE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fre_freight_template
-- ----------------------------

-- ----------------------------
-- Table structure for `gmcp$account`
-- ----------------------------
DROP TABLE IF EXISTS `gmcp$account`;
CREATE TABLE `gmcp$account` (
  `buyer_id` int(10) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(50) NOT NULL COMMENT '账户名',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `password` varchar(256) NOT NULL COMMENT '支付密码, 加密串',
  `active_time` datetime DEFAULT NULL COMMENT '激活时间',
  `is_active` char(1) NOT NULL COMMENT '是否激活 N - 未激活 , Y - 激活',
  `status` tinyint(2) NOT NULL COMMENT '状态  7 -正常,  17 -冻结',
  `create_by` varchar(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(20) DEFAULT NULL,
  `last_update_time` timestamp NULL DEFAULT NULL COMMENT '最后更新时间',
  `account_type` int(11) NOT NULL COMMENT '账户类型:1-客户 2-厂家',
  `hold_order_time` char(2) DEFAULT NULL,
  `auto_pay_status` varchar(2) DEFAULT NULL COMMENT '0-FALSE 1-TRUE',
  PRIMARY KEY (`buyer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='GMC钱包账户表';

-- ----------------------------
-- Records of gmcp$account
-- ----------------------------
INSERT INTO `gmcp$account` VALUES ('1', 'test', '124@163.com', '123456', null, '1', '0', null, '2017-07-18 08:59:11', null, '0000-00-00 00:00:00', '1', null, null);
INSERT INTO `gmcp$account` VALUES ('2', 'test2', '124@163.com', '123456', null, '1', '0', null, '2017-07-18 08:59:21', null, '0000-00-00 00:00:00', '1', null, null);

-- ----------------------------
-- Table structure for `gmcp$account_fund`
-- ----------------------------
DROP TABLE IF EXISTS `gmcp$account_fund`;
CREATE TABLE `gmcp$account_fund` (
  `buyer_id` int(10) NOT NULL COMMENT '买家id',
  `available_money` decimal(10,4) NOT NULL COMMENT '可用金额',
  `depositing_money` decimal(10,4) NOT NULL COMMENT '充值中金额',
  `withdrawing_money` decimal(10,4) NOT NULL COMMENT '提现中金额',
  `create_by` varchar(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(20) DEFAULT NULL,
  `last_update_time` timestamp NULL DEFAULT NULL COMMENT '最后更新时间',
  `currency` varchar(16) NOT NULL COMMENT '账户币种:USD,RMB'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='GMC钱包余额表';

-- ----------------------------
-- Records of gmcp$account_fund
-- ----------------------------

-- ----------------------------
-- Table structure for `gmcp$transaction_audit`
-- ----------------------------
DROP TABLE IF EXISTS `gmcp$transaction_audit`;
CREATE TABLE `gmcp$transaction_audit` (
  `transaction_audit_id` int(10) NOT NULL AUTO_INCREMENT,
  `buyer_id` int(10) NOT NULL COMMENT '买家id',
  `transaction_id` int(10) NOT NULL COMMENT '业务记录id',
  `available_money_before` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '前可用余额',
  `depositing_money_before` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '前充值中金额',
  `withdrawing_money_before` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '前提现中金额',
  `operate_money` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '操作金额',
  `operate_type` tinyint(2) NOT NULL COMMENT '操作类型 1-申请 2-提现 3-消费 4-退款',
  `available_money_after` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '变更后可用余额',
  `depositing_money_after` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '变更后充值中金额',
  `withdrawing_money_after` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '变更后提现中金额',
  `operate_by` varchar(20) DEFAULT NULL,
  `status` tinyint(2) NOT NULL COMMENT '操作状态 2-申请 , 4 -完成 , -1-失败',
  `create_by` varchar(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(20) DEFAULT NULL,
  `last_update_time` timestamp NULL DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`transaction_audit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='钱包流水审计表';

-- ----------------------------
-- Records of gmcp$transaction_audit
-- ----------------------------

-- ----------------------------
-- Table structure for `gmcp$transaction_record`
-- ----------------------------
DROP TABLE IF EXISTS `gmcp$transaction_record`;
CREATE TABLE `gmcp$transaction_record` (
  `transaction_id` int(10) NOT NULL AUTO_INCREMENT,
  `buyer_id` int(10) NOT NULL COMMENT '买家Id',
  `bank_card_id` int(10) DEFAULT NULL COMMENT '银行卡id for 充值、提现、退款,  卡账户消费情况下为空',
  `transaction_number` varchar(255) NOT NULL COMMENT '流水号，GM应用生成',
  `transaction_type` tinyint(2) NOT NULL DEFAULT '0' COMMENT '业务类型 1-充值 2-提现 3-消费 4-退款',
  `account_name` varchar(50) NOT NULL COMMENT 'gmcp$account.account_name 账户名',
  `transaction_money` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '金额',
  `commission` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '手续费',
  `discount_commission` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '折后手续费',
  `transaction_method` tinyint(2) NOT NULL COMMENT '方式 0-T/T 1-Paypal 2-现金 3消费',
  `complete_time` datetime DEFAULT NULL COMMENT '完成时间',
  `status` tinyint(2) NOT NULL DEFAULT '7' COMMENT '状态 2 -申请 , 4 -完成 , -1-失败',
  `actual_money` decimal(10,4) NOT NULL COMMENT '实际金额',
  `actual_commission` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '实际手续费',
  `actual_discount_commission` decimal(10,4) NOT NULL DEFAULT '0.0000' COMMENT '折后实际手续费',
  `balance` decimal(10,4) NOT NULL COMMENT '余额',
  `business_id` int(10) DEFAULT NULL COMMENT '订单id 针对消费,  gmsales.trade.id',
  `finance_type` tinyint(2) NOT NULL COMMENT '类型 1-入款 2-出款',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  `operator_name` varchar(64) DEFAULT NULL COMMENT '操作人',
  `operator_ip` varchar(32) DEFAULT NULL COMMENT '操作人IP',
  `create_by` varchar(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `last_update_by` varchar(20) DEFAULT NULL,
  `last_update_time` timestamp NULL DEFAULT NULL COMMENT '最后更新时间',
  `bank_receipt_url` varchar(255) DEFAULT NULL,
  `exchange_rate` decimal(10,4) DEFAULT NULL,
  `transaction_desc` varchar(255) DEFAULT NULL,
  `foreign_exchange_fee` decimal(10,4) DEFAULT NULL,
  `withdraw_fee` decimal(10,4) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='GMC钱包流水表';

-- ----------------------------
-- Records of gmcp$transaction_record
-- ----------------------------

-- ----------------------------
-- Table structure for `goa_government_area`
-- ----------------------------
DROP TABLE IF EXISTS `goa_government_area`;
CREATE TABLE `goa_government_area` (
  `GOA_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `ZIP_CODE` varchar(16) DEFAULT NULL COMMENT '邮编',
  `STATE` varchar(255) DEFAULT NULL COMMENT '洲',
  `STATE_SHORTHAND` varchar(10) DEFAULT NULL COMMENT '洲简称',
  `CITY` varchar(255) DEFAULT NULL COMMENT '城市',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATION_DATE` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '更新人',
  `CALL_CNT` int(11) DEFAULT NULL COMMENT '乐观锁',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '备注',
  `STS_CD` char(1) NOT NULL DEFAULT 'A' COMMENT '数据有效性',
  PRIMARY KEY (`GOA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goa_government_area
-- ----------------------------

-- ----------------------------
-- Table structure for `img_image`
-- ----------------------------
DROP TABLE IF EXISTS `img_image`;
CREATE TABLE `img_image` (
  `IMG_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(255) DEFAULT NULL COMMENT '名字',
  `WIDTH` int(11) DEFAULT '1' COMMENT '图片宽，pixel',
  `HEIGHT` int(11) DEFAULT '1' COMMENT '图片高，pixel',
  `URI` varchar(512) DEFAULT NULL COMMENT '图片地址',
  `TYPE_CD` char(2) DEFAULT 'M' COMMENT 'O - 原图\nM - 中图 （用于列表)\nL - 大图   (用于详情页)\nM2 - 中图(2x)\nL2 - 大图(2x)',
  `ENTITY_ID` int(11) NOT NULL DEFAULT '3' COMMENT '关联表的主键id',
  `ENTITY_CD` varchar(3) NOT NULL DEFAULT 'PRO' COMMENT '关联自定义的code',
  `SEQ_NO` int(11) DEFAULT NULL COMMENT '如果一个产品有多图时，要按小到大的顺序进行显示',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT '0',
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`IMG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of img_image
-- ----------------------------
INSERT INTO `img_image` VALUES ('1', 'brand', null, null, '20170724/d95bd2cc50bd43cb9f0f450c4c4f7437.jpg', null, '1', 'BRD', null, null, '2017-07-24 21:26:44', null, '2017-07-24 21:26:44', null, null, 'A');

-- ----------------------------
-- Table structure for `loa_logistics_account`
-- ----------------------------
DROP TABLE IF EXISTS `loa_logistics_account`;
CREATE TABLE `loa_logistics_account` (
  `LOA_ID` int(11) NOT NULL,
  `LOGISTICS_CD` varchar(50) DEFAULT NULL,
  `SUPIN` varchar(50) DEFAULT NULL,
  `SUCODE` varchar(50) DEFAULT NULL,
  `WAREHOUSE_CD` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮箱关联GMC用户表',
  `PASSWORD` varchar(50) DEFAULT NULL COMMENT '密码',
  `HIRHCODE` varchar(50) DEFAULT NULL,
  `MOBILE` varchar(50) DEFAULT NULL COMMENT '手机',
  `NICK_NAME` varchar(50) DEFAULT NULL COMMENT '昵称',
  `FIRST_NAME` varchar(50) DEFAULT NULL COMMENT '姓氏',
  `LAST_NAME` varchar(50) DEFAULT NULL COMMENT '名字',
  `MAN_ID` int(11) DEFAULT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='斑马注册用户对照表';

-- ----------------------------
-- Records of loa_logistics_account
-- ----------------------------

-- ----------------------------
-- Table structure for `lot_logistics_tracking`
-- ----------------------------
DROP TABLE IF EXISTS `lot_logistics_tracking`;
CREATE TABLE `lot_logistics_tracking` (
  `LOT_ID` int(11) NOT NULL,
  `LOGISTICS_COMPANY_ID` varchar(32) DEFAULT NULL COMMENT '物流转运商id（UPS,DHL等）',
  `LOGISTICS_ORDER_ID` varchar(64) DEFAULT NULL COMMENT '运单号',
  `LOGISTICS_REMARK` varchar(255) DEFAULT NULL COMMENT '物流备注',
  `STATUS` varchar(255) DEFAULT NULL COMMENT '状态（调用后需根据内容调整，是否需要维护code master）',
  `TRANSPORT_ADDRESS` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `TRANSPORT_STATUS` varchar(255) DEFAULT NULL,
  `ORDER_CREATE_TIME` datetime DEFAULT NULL COMMENT '运单创建时间（物流方返回）',
  `ORDER_OCCUR_TIME` datetime DEFAULT NULL COMMENT '运输状态变化时间（物流方返回）',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATION_DATE` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '修改人',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(500) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单物流跟踪';

-- ----------------------------
-- Records of lot_logistics_tracking
-- ----------------------------

-- ----------------------------
-- Table structure for `man_manufacturer`
-- ----------------------------
DROP TABLE IF EXISTS `man_manufacturer`;
CREATE TABLE `man_manufacturer` (
  `MAN_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，制造商ID',
  `NAME_EN` varchar(100) DEFAULT NULL COMMENT '制造商英文名',
  `NAME_CN` varchar(100) DEFAULT NULL COMMENT '制造商中文名',
  `GMC_REPORT_TYPE` varchar(2) DEFAULT NULL COMMENT '品牌商认证类型 1-TÜV,2-UL',
  `GMC_REPORT_URL` varchar(255) DEFAULT NULL COMMENT '证书地址',
  `DESCRIPTION` varchar(500) DEFAULT NULL COMMENT '品牌商公司介绍',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATION_DATE` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '更新人',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`MAN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of man_manufacturer
-- ----------------------------
INSERT INTO `man_manufacturer` VALUES ('1', 'xiaomi', '小米红米', '1', 'http://www.xiaomi.cn/', '科技公司', null, null, null, null, null, null, 'A');

-- ----------------------------
-- Table structure for `mor_monitor_result`
-- ----------------------------
DROP TABLE IF EXISTS `mor_monitor_result`;
CREATE TABLE `mor_monitor_result` (
  `MOR_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'MOR_ID',
  `CLASS_NAME` varchar(100) DEFAULT NULL COMMENT '类名',
  `JSON_STRING` varchar(500) DEFAULT NULL COMMENT 'Json字符串',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_BY` varchar(10) DEFAULT NULL COMMENT '创建人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_BY` varchar(10) DEFAULT NULL COMMENT '更新人',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '描述',
  `STS_CD` varchar(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`MOR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mor_monitor_result
-- ----------------------------
INSERT INTO `mor_monitor_result` VALUES ('1', 'com.admin.Monitor', 'testUpdate', null, null, '2017-08-08 16:15:57', 'system', null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('2', 'com.admin.entity.MonitorBean', '{\'updateBy\':\'lkt\',\'morId\':10086,\'className\':\'com.admin.entity.MonitorBean\',\'createBy\':\'lkt\'}', null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('3', 'user', '{\'updateBy\':\'lkt\',\'morId\':10086,\'className\':\'com.admin.entity.MonitorBean\',\'createBy\':\'lkt\'}', null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('4', 'user', '{\'updateBy\':\'lkt\',\'morId\':10086,\'className\':\'com.admin.entity.MonitorBean\',\'createBy\':\'lkt\'}', null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('5', 'user', '{\'updateBy\':\'lkt\',\'morId\':10086,\'className\':\'com.admin.entity.MonitorBean\',\'createBy\':\'lkt\'}', null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('6', 'com.admin.Monitor', 'test', null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('7', 'com.admin.Monitor', 'test', null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('8', '888', null, null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('9', null, null, null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('10', null, null, null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('11', null, null, null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('12', null, null, null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('13', null, null, null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('14', null, null, null, null, null, null, null, null);
INSERT INTO `mor_monitor_result` VALUES ('15', 'user', 'test', null, null, null, null, null, null);
INSERT INTO `mor_monitor_result` VALUES ('16', 'rrrrr', '566666', null, null, null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('17', 'com.admin.Monitor', 'test', null, null, null, null, null, null);
INSERT INTO `mor_monitor_result` VALUES ('18', 'testSave', 'testjson string', '2017-08-08 16:27:38', 'system', null, null, null, 'A');
INSERT INTO `mor_monitor_result` VALUES ('19', 'test2', 'testjson string 2', '2017-08-08 16:37:13', 'system', null, null, null, 'A');

-- ----------------------------
-- Table structure for `ofp_offer_price`
-- ----------------------------
DROP TABLE IF EXISTS `ofp_offer_price`;
CREATE TABLE `ofp_offer_price` (
  `OFP_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `MAN_ID` int(11) DEFAULT NULL COMMENT '制造商ID',
  `EFFETIVE_START_DATE` timestamp NULL DEFAULT NULL COMMENT '价格有效期开始时间',
  `EFFECTIVE_END_DATE` timestamp NULL DEFAULT NULL COMMENT '价格有效期结束时间',
  `PRO_ID` int(11) DEFAULT NULL COMMENT '商品ID 外键关联pro表',
  `PRICE` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '单价',
  `TYPE_CD` varchar(3) DEFAULT NULL COMMENT '对应master表的PRICE_TYPE\nPUB - 公开借卖价\nPRO - 促销价\nVIP - 专享价',
  `DSR_ID` int(11) DEFAULT NULL COMMENT '借卖方id，关联专享价用，其他类型该字段为空',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATION_DATE` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(200) DEFAULT NULL COMMENT '更新人',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `CALL_CNT` int(11) DEFAULT NULL COMMENT '乐观锁',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '备注',
  `STS_CD` char(1) NOT NULL DEFAULT 'A' COMMENT '有效性',
  `PERIOD` varchar(1) DEFAULT NULL COMMENT '是否自动设置价格（1为自动以相同价格进入下一个周期）',
  PRIMARY KEY (`OFP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ofp_offer_price
-- ----------------------------
INSERT INTO `ofp_offer_price` VALUES ('1', '1', '2017-08-03 15:47:44', '2017-08-03 15:36:17', '1', '98.00', null, null, null, '2017-08-01 15:47:30', null, '2017-08-01 15:47:41', null, null, 'A', null);
INSERT INTO `ofp_offer_price` VALUES ('2', '1', '2017-08-03 15:47:50', '2017-08-01 15:44:13', '2', '280.00', null, null, null, '2017-08-01 15:47:34', null, '2017-08-01 15:47:45', null, null, 'A', null);
INSERT INTO `ofp_offer_price` VALUES ('3', '1', null, null, '7', '111.00', null, null, null, null, 'mvo', null, null, null, 'A', null);
INSERT INTO `ofp_offer_price` VALUES ('4', '1', null, null, '8', '89.00', null, null, null, null, 'mvo', null, null, null, 'A', null);
INSERT INTO `ofp_offer_price` VALUES ('5', '1', null, null, '9', '89.00', null, null, null, null, 'mvo', null, null, null, 'A', null);
INSERT INTO `ofp_offer_price` VALUES ('6', '1', null, null, '10', '102.00', null, null, null, null, 'mvo', null, null, null, 'A', null);
INSERT INTO `ofp_offer_price` VALUES ('7', '1', null, null, '11', '8999.00', null, null, 'mvo', null, null, null, null, null, 'A', null);
INSERT INTO `ofp_offer_price` VALUES ('8', '1', null, null, '13', '102.00', null, null, 'mvo', null, null, null, null, null, 'A', null);
INSERT INTO `ofp_offer_price` VALUES ('9', '1', null, null, '14', '12000.00', null, null, 'mvo', null, null, null, null, null, 'A', null);

-- ----------------------------
-- Table structure for `par_parameter`
-- ----------------------------
DROP TABLE IF EXISTS `par_parameter`;
CREATE TABLE `par_parameter` (
  `PAR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PARAM_CD` varchar(200) NOT NULL COMMENT '参数主键',
  `PARAM_VALUE` varchar(500) DEFAULT NULL COMMENT '参数值',
  `DESCRIPTION` text COMMENT '参数说明',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) NOT NULL DEFAULT '',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`PAR_ID`),
  UNIQUE KEY `PARAM_CD` (`PARAM_CD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of par_parameter
-- ----------------------------

-- ----------------------------
-- Table structure for `pck_package_info`
-- ----------------------------
DROP TABLE IF EXISTS `pck_package_info`;
CREATE TABLE `pck_package_info` (
  `PCK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `WAR_ID` int(11) NOT NULL COMMENT '仓库ID',
  `PRO_ID` int(11) DEFAULT NULL COMMENT '绑定的 PRO_ID\n\n与 VAR_ID 只可能有一个',
  `TYPE_CD` char(1) DEFAULT NULL COMMENT '对应master 表PAC_REGISTER\nM - 厂家设定\nW - 仓库注册',
  `WIDTH` decimal(7,2) DEFAULT NULL COMMENT '宽 - cm',
  `HEIGHT` decimal(7,2) DEFAULT NULL COMMENT '高 - cm',
  `LENGTH` decimal(7,2) DEFAULT NULL COMMENT '长  - cm',
  `WEIGHT` decimal(5,2) DEFAULT NULL COMMENT '重 - kg',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  `HEAVY_CARGO` varchar(2) DEFAULT NULL COMMENT '0',
  `LOGISTICS_COMPANY` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PCK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pck_package_info
-- ----------------------------
INSERT INTO `pck_package_info` VALUES ('3', '1', '7', null, '10.00', '10.00', '100.00', '10.00', null, null, 'mvo', null, null, null, 'A', null, null);
INSERT INTO `pck_package_info` VALUES ('4', '1', '8', null, '21.00', '21.00', '21.00', '12.00', null, null, 'mvo', null, null, null, 'A', null, null);
INSERT INTO `pck_package_info` VALUES ('5', '1', '9', null, '21.00', '21.00', '21.00', '12.00', null, null, 'mvo', null, null, null, 'A', null, null);
INSERT INTO `pck_package_info` VALUES ('6', '1', '10', null, '21.00', '21.00', '21.00', '12.00', null, null, 'mvo', null, null, null, 'A', null, null);
INSERT INTO `pck_package_info` VALUES ('7', '1', '11', null, '30.00', '50.00', '30.00', '3.00', 'mvo', null, null, null, null, null, 'A', null, null);
INSERT INTO `pck_package_info` VALUES ('9', '1', '13', null, '1.00', '1.00', '1.00', '1.00', 'mvo', null, null, null, null, null, 'A', null, null);
INSERT INTO `pck_package_info` VALUES ('10', '1', '14', null, '1.00', '1.00', '1.00', '1.00', 'mvo', null, null, null, null, null, 'A', null, null);

-- ----------------------------
-- Table structure for `pdn_product_descrition`
-- ----------------------------
DROP TABLE IF EXISTS `pdn_product_descrition`;
CREATE TABLE `pdn_product_descrition` (
  `PDN_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `PRO_ID` int(11) DEFAULT NULL COMMENT '外键，关联pro表主键',
  `TYPE_CD` varchar(45) DEFAULT NULL COMMENT '对应master表TEXTTYPE\nRICH_TEXT  - 图文信息\nSIMPLE_TEXT - 简单信息，用于 amazon\nSELLING_POINTS - 卖点，用于 amazon',
  `DESCRITION` longtext COMMENT '商品描述（富文本、纯文本、卖点）',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`PDN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pdn_product_descrition
-- ----------------------------
INSERT INTO `pdn_product_descrition` VALUES ('1', '7', null, null, null, null, 'mvo', null, null, null, 'A');
INSERT INTO `pdn_product_descrition` VALUES ('2', '8', null, null, null, null, 'mvo', null, null, null, 'A');
INSERT INTO `pdn_product_descrition` VALUES ('3', '9', null, null, null, null, 'mvo', null, null, null, 'A');
INSERT INTO `pdn_product_descrition` VALUES ('4', '10', null, null, null, null, 'mvo', null, null, null, 'A');
INSERT INTO `pdn_product_descrition` VALUES ('5', '11', '只要8999', null, 'mvo', null, null, null, null, null, 'A');
INSERT INTO `pdn_product_descrition` VALUES ('6', '13', null, null, 'mvo', null, null, null, null, null, 'A');
INSERT INTO `pdn_product_descrition` VALUES ('7', '14', null, null, 'mvo', null, null, null, null, null, 'A');

-- ----------------------------
-- Table structure for `prc_product_category`
-- ----------------------------
DROP TABLE IF EXISTS `prc_product_category`;
CREATE TABLE `prc_product_category` (
  `PRC_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `PRO_ID` int(11) DEFAULT NULL COMMENT '商品ID',
  `CATEGORY_ID` varchar(45) DEFAULT NULL COMMENT '分类id',
  `CATEGORY_NAME` varchar(100) DEFAULT NULL COMMENT '类别名称',
  `CATEGORY_PATH` varchar(1024) DEFAULT NULL COMMENT '类别全路径如 ce>digital>mp3',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  `PLATEFORM_TYPE` varchar(2) NOT NULL COMMENT '平台类型,ebay：2，Amazon：1',
  PRIMARY KEY (`PRC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prc_product_category
-- ----------------------------

-- ----------------------------
-- Table structure for `pro_product`
-- ----------------------------
DROP TABLE IF EXISTS `pro_product`;
CREATE TABLE `pro_product` (
  `PRO_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `SKU_CD` varchar(8) NOT NULL COMMENT '商品sku编码',
  `BRD_ID` int(11) DEFAULT NULL COMMENT '外键，关联品牌id',
  `MAN_ID` int(11) NOT NULL COMMENT '外键关联man_id',
  `TITLE` varchar(255) DEFAULT NULL COMMENT '标题',
  `UPC` varchar(15) DEFAULT NULL COMMENT 'upc编码',
  `EAN` varchar(13) DEFAULT NULL COMMENT 'ena编码',
  `MODEL` varchar(45) DEFAULT NULL COMMENT '型号',
  `WARRANTY_DAY` varchar(45) DEFAULT NULL COMMENT '保修期（单位有年、月、日）',
  `RETAIL_PRICE` decimal(10,2) DEFAULT NULL COMMENT '建议零售价',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  `MININUM_RETAIL_PRICE` decimal(10,2) DEFAULT NULL COMMENT '最低零售价',
  `REPLENISHMENT_PERIOD` int(11) DEFAULT NULL COMMENT '补货期（天）',
  `KEY_WORDS` varchar(255) DEFAULT NULL COMMENT '关键字，预留后续搜索使用',
  `WARRANTY` text COMMENT '保修政策说明',
  `TIME_UNIT` varchar(10) DEFAULT NULL COMMENT '保修期单位 1、年 2、月 3、日',
  `STOCKSETING` int(11) DEFAULT NULL COMMENT '库存预警设置（当低于预警值时发出警告）',
  `IS_DEL` varchar(11) DEFAULT '1' COMMENT '删除标记',
  PRIMARY KEY (`PRO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_product
-- ----------------------------
INSERT INTO `pro_product` VALUES ('1', 'GM001731', '1', '1', '8848钛合金手机', '', '', '', '', null, 'system', '2017-08-03 13:32:49', 'system', '2017-08-03 13:31:51', null, '', 'A', null, null, '', '', 'day', null, '1');
INSERT INTO `pro_product` VALUES ('2', 'GM001732', '1', '1', '小米RedMiBook', null, null, null, null, null, 'system', '2017-08-03 16:18:18', 'system', '2017-08-03 13:33:58', null, null, 'A', null, null, null, null, 'month', null, '1');
INSERT INTO `pro_product` VALUES ('7', 'Mk12', null, '1', '小米', 'Mi23', 'en12', '型号大大大', null, null, 'mvo', '2019-07-22 11:00:40', null, '2019-07-22 16:23:11', null, null, 'A', null, null, null, null, '不保修', null, '1');
INSERT INTO `pro_product` VALUES ('8', 'sku编码', null, '1', '红米', 'UPC码', '1221', '型号', null, null, 'mvo', '2019-07-22 11:09:02', null, '2019-07-22 16:30:41', null, null, 'A', null, null, null, null, 'day', null, '1');
INSERT INTO `pro_product` VALUES ('9', 'sku编码', null, '1', '华为', 'UPC码', '1221', '型号', null, null, 'mvo', '2019-07-22 11:12:42', null, '2019-07-22 16:30:55', null, null, 'A', null, null, null, null, 'day', null, '1');
INSERT INTO `pro_product` VALUES ('10', 'Ma122', null, '1', '黑莓', 'uos12', '1221', '型号大大大', null, null, 'mvo', '2019-07-22 11:14:04', null, '2019-07-22 16:33:00', null, null, 'A', null, null, null, null, '七天保修', null, '1');
INSERT INTO `pro_product` VALUES ('11', 'MjH123', null, '1', '惠普暗夜精灵5', 'gtx2060', 'ENA', 'i7第九代处理器', null, null, 'mvo', '2019-07-22 13:42:08', null, '2019-07-22 13:47:09', null, null, 'A', null, null, null, null, '京东1年保修', null, '1');
INSERT INTO `pro_product` VALUES ('13', 'Ma122', null, '1', '苹果XS', 'uos12', '1221', '型号大大大', null, null, 'mvo', '2019-07-22 16:28:57', null, '2019-07-22 16:28:57', null, null, 'A', null, null, null, null, '七天保修', null, '1');
INSERT INTO `pro_product` VALUES ('14', 'Ma122', null, '1', 'MacBook', 'uos12', '1112', '标准版', null, null, 'mvo', '2019-07-22 16:30:03', null, '2019-07-22 16:30:03', null, null, 'A', null, null, null, null, '三年保修', null, '1');

-- ----------------------------
-- Table structure for `sal_sales_order_line_item`
-- ----------------------------
DROP TABLE IF EXISTS `sal_sales_order_line_item`;
CREATE TABLE `sal_sales_order_line_item` (
  `SAL_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATION_DATE` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '更新人',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `CALL_CNT` int(11) DEFAULT NULL COMMENT '乐观锁',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '备注',
  `STS_CD` char(1) NOT NULL DEFAULT 'A' COMMENT '数据有效性',
  `SAO_ID` int(11) NOT NULL COMMENT '销售订单主表ID',
  `PRO_ID` int(11) DEFAULT NULL COMMENT '商品ID',
  `QTY` int(11) DEFAULT NULL COMMENT '商品数量',
  `PRICE` decimal(8,2) DEFAULT NULL COMMENT '商品单价',
  `SOL_ID` int(11) NOT NULL COMMENT '同步数据ID',
  `TRACKING_NO` varchar(45) DEFAULT NULL COMMENT '物流跟踪号',
  `WSP_NAME` varchar(45) DEFAULT NULL COMMENT '快递公司',
  PRIMARY KEY (`SAL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sal_sales_order_line_item
-- ----------------------------
INSERT INTO `sal_sales_order_line_item` VALUES ('1', 'system', '2017-08-03 15:25:23', 'system', '2017-08-03 15:25:23', '1', '', 'A', '2', '1', '1', '100.00', '5', '', '');
INSERT INTO `sal_sales_order_line_item` VALUES ('2', 'system', '2017-08-03 15:33:55', 'system', '2017-08-03 15:33:55', '1', '', 'A', '3', '1', '1', '100.00', '6', '', '');
INSERT INTO `sal_sales_order_line_item` VALUES ('3', 'system', '2017-08-03 15:48:35', 'system', '2017-08-03 15:48:35', '1', '', 'A', '4', '2', '1', '280.00', '7', '', '');
INSERT INTO `sal_sales_order_line_item` VALUES ('4', 'system', '2017-08-03 15:57:37', 'system', '2017-08-03 15:57:37', '1', '', 'A', '5', '1', '1', '98.00', '8', '', '');
INSERT INTO `sal_sales_order_line_item` VALUES ('5', 'system', '2017-08-03 15:57:37', 'system', '2017-08-03 15:57:37', '1', '', 'A', '6', '2', '1', '280.00', '9', '', '');
INSERT INTO `sal_sales_order_line_item` VALUES ('6', 'system', '2017-08-03 16:14:26', 'system', '2017-08-03 16:14:26', '1', '', 'A', '7', '2', '1', '280.00', '10', '', '');
INSERT INTO `sal_sales_order_line_item` VALUES ('7', 'system', '2017-08-03 16:15:02', 'system', '2017-08-03 16:15:02', '1', '', 'A', '8', '1', '1', '98.00', '11', '', '');
INSERT INTO `sal_sales_order_line_item` VALUES ('8', 'system', '2017-08-04 17:17:42', 'system', '2017-08-04 17:17:42', '1', '', 'A', '9', '2', '1', '280.00', '12', '', '');
INSERT INTO `sal_sales_order_line_item` VALUES ('9', 'system', '2017-08-04 17:17:42', 'system', '2017-08-04 17:17:42', '1', '', 'A', '10', '2', '1', '280.00', '13', '', '');

-- ----------------------------
-- Table structure for `sao_sales_order`
-- ----------------------------
DROP TABLE IF EXISTS `sao_sales_order`;
CREATE TABLE `sao_sales_order` (
  `SAO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATED_BY` varchar(50) DEFAULT NULL COMMENT '创建人',
  `CREATION_DATE` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '更新人',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `CALL_CNT` int(11) DEFAULT NULL COMMENT '乐观锁',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '备注',
  `STS_CD` char(1) NOT NULL DEFAULT 'A' COMMENT '数据有效性',
  `MAN_ID` int(11) DEFAULT NULL COMMENT '制造商ID',
  `WAR_ID` int(11) DEFAULT NULL COMMENT '仓库ID',
  `SYNC_DATE` timestamp NULL DEFAULT NULL COMMENT '第一次同步时间',
  `PAYMENT_DATE` timestamp NULL DEFAULT NULL COMMENT '支付时间',
  `PUSH_DATE` timestamp NULL DEFAULT NULL COMMENT '推送到仓库的时间',
  `TRACK_NO_DATE` timestamp NULL DEFAULT NULL COMMENT '取得物流跟踪号的时间',
  `FULFILLMENT_DATE` timestamp NULL DEFAULT NULL COMMENT '物流妥投时间',
  `SETTLEMENT_DATE` timestamp NULL DEFAULT NULL COMMENT '结款时间',
  `PRODUCT_AMOUNT` decimal(8,2) DEFAULT '0.00' COMMENT '订单价格',
  `FREIGHT_COST` decimal(8,2) DEFAULT '0.00' COMMENT '运费',
  `HANDLING_FEE` decimal(8,2) DEFAULT '0.00' COMMENT '订单处理费',
  `CUSTOMER_REMARK` varchar(300) DEFAULT NULL COMMENT '消费者备注',
  `ORDER_NO` varchar(45) NOT NULL COMMENT '订单编号, SO + 8位数字: 例如: SO00000001 , 当订单号多于一千万时，第一位变为由A到Z',
  `ORDER_STS` varchar(45) DEFAULT NULL COMMENT '订单状态:\n1. AwaitingPayment \n2. AwaitingShipment \n3. SHIPPED 已发货\n4. Complete 已完成5. Canceled已取消',
  `REFUND_STS` varchar(45) DEFAULT NULL COMMENT '退款状态\n\n1. OPEN - 开启\n2. CLOSE  - 已完结\n',
  `DELIVERY_STS` varchar(45) DEFAULT NULL COMMENT '发货状态\n\n1. SYNC - 已同步到仓库\n2. STOCK_OUT - 已出库\n3. SHIPPING - 发货中\n4. FULFILLED - 已妥投\n',
  `STO_ID` int(11) NOT NULL COMMENT 'GM 平台订单, 已拆单\n\n按 仓库 / 厂家 进行拆单',
  `LAST_FREIGHT_COST` decimal(8,2) DEFAULT NULL COMMENT '斑马返回物流费用',
  `CANCLE_TIME` timestamp NULL DEFAULT NULL COMMENT '取消时间',
  `AUTO_PAY_STATUS` char(2) DEFAULT NULL COMMENT '0自动，1非自动，2取消，3异常，4完成',
  `BUYER_CHECKOUT_MESSAGE` text,
  `AUTO_PAY_TIME` varchar(5) DEFAULT NULL COMMENT '订单自动支付时间',
  PRIMARY KEY (`SAO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sao_sales_order
-- ----------------------------
INSERT INTO `sao_sales_order` VALUES ('1', 'system', '2017-08-03 15:08:40', 'system', '2017-08-03 15:08:40', '1', '', 'A', '1', '1', '2017-08-03 15:08:40', '2017-08-03 15:08:40', '2017-08-03 15:08:41', '2017-08-03 15:08:41', '2017-08-03 15:08:41', '2017-08-03 15:08:41', '100.00', '0.00', '0.00', '', 'AO20177315840', '1', null, null, '10', null, '2017-08-03 15:08:41', '1', '', null);
INSERT INTO `sao_sales_order` VALUES ('2', 'system', '2017-08-03 15:25:23', 'system', '2017-08-03 15:25:23', '1', '', 'A', '1', '1', '2017-08-03 15:25:23', '2017-08-03 15:25:23', '2017-08-03 15:25:23', '2017-08-03 15:25:23', '2017-08-03 15:25:23', '2017-08-03 15:25:23', '100.00', '0.00', '0.00', '', 'AO20170803152523', '1', null, null, '11', null, '2017-08-03 15:25:23', '1', '', null);
INSERT INTO `sao_sales_order` VALUES ('3', 'system', '2017-08-03 15:33:55', 'system', '2017-08-03 15:33:55', '1', '', 'A', '1', '1', '2017-08-03 15:33:55', '2017-08-03 15:33:55', '2017-08-03 15:33:56', '2017-08-03 15:33:56', '2017-08-03 15:33:56', '2017-08-03 15:33:56', '100.00', '0.00', '0.00', '', 'AO20170803153356116', '1', null, null, '12', null, '2017-08-03 15:33:56', '1', '', null);
INSERT INTO `sao_sales_order` VALUES ('4', 'system', '2017-08-03 15:48:35', 'system', '2017-08-03 15:48:35', '1', '', 'A', '1', '1', '2017-08-03 15:48:35', '2017-08-03 15:48:35', '2017-08-03 15:48:35', '2017-08-03 15:48:35', '2017-08-03 15:48:35', '2017-08-03 15:48:35', '280.00', '0.00', '0.00', '', 'AO20170803154835491', '1', null, null, '13', null, '2017-08-03 15:48:35', '1', '', null);
INSERT INTO `sao_sales_order` VALUES ('5', 'system', '2017-08-03 15:57:37', 'system', '2017-08-03 15:57:37', '1', '', 'A', '1', '1', '2017-08-03 15:57:37', '2017-08-03 15:57:37', '2017-08-03 15:57:37', '2017-08-03 15:57:37', '2017-08-03 15:57:37', '2017-08-03 15:57:37', '98.00', '0.00', '0.00', '', 'AO20170803155737206', '1', null, null, '14', null, '2017-08-03 15:57:37', '1', '', null);
INSERT INTO `sao_sales_order` VALUES ('6', 'system', '2017-08-03 15:57:37', 'system', '2017-08-03 15:57:37', '1', '', 'A', '1', '1', '2017-08-03 15:57:37', '2017-08-03 15:57:37', '2017-08-03 15:57:37', '2017-08-03 15:57:37', '2017-08-03 15:57:37', '2017-08-03 15:57:37', '280.00', '0.00', '0.00', '', 'AO20170803155737500', '1', null, null, '15', null, '2017-08-03 15:57:37', '1', '', null);
INSERT INTO `sao_sales_order` VALUES ('7', 'system', '2017-08-03 16:14:26', 'system', '2017-08-03 16:14:26', '1', '', 'A', '1', '1', '2017-08-03 16:14:26', '2017-08-03 16:14:26', '2017-08-03 16:15:02', '2017-08-03 16:15:02', '2017-08-03 16:15:02', '2017-08-03 16:15:02', '280.00', '0.00', '0.00', '', 'AO20170803161426610', '1', null, null, '16', null, '2017-08-03 16:15:02', '1', '', null);
INSERT INTO `sao_sales_order` VALUES ('8', 'system', '2017-08-03 16:15:02', 'system', '2017-08-03 16:15:02', '1', '', 'A', '1', '1', '2017-08-03 16:15:02', '2017-08-03 16:15:02', '2017-08-03 16:15:04', '2017-08-03 16:15:04', '2017-08-03 16:15:04', '2017-08-03 16:15:04', '98.00', '0.00', '0.00', '', 'AO20170803161502505', '1', null, null, '17', null, '2017-08-03 16:15:04', '1', '', null);
INSERT INTO `sao_sales_order` VALUES ('9', 'system', '2017-08-04 17:17:42', 'system', '2017-08-04 17:17:42', '1', '', 'A', '1', '1', '2017-08-04 17:17:42', '2017-08-04 17:17:42', null, null, null, null, '280.00', '0.00', '0.00', '', 'AO20170804171742446', '1', null, null, '18', null, null, '1', '', null);
INSERT INTO `sao_sales_order` VALUES ('10', 'system', '2017-08-04 17:17:42', 'system', '2017-08-04 17:17:42', '1', '', 'A', '1', '1', '2017-08-04 17:17:42', '2017-08-04 17:17:42', null, null, null, null, '280.00', '0.00', '0.00', '', 'AO20170804171742658', '1', null, null, '19', null, null, '1', '', null);

-- ----------------------------
-- Table structure for `sdi_store_dropship_item`
-- ----------------------------
DROP TABLE IF EXISTS `sdi_store_dropship_item`;
CREATE TABLE `sdi_store_dropship_item` (
  `DIL_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `PRO_ID` int(11) DEFAULT NULL COMMENT '商品id',
  `STR_ID` int(11) DEFAULT NULL COMMENT '网店id',
  `STORE_RETENTION` int(11) DEFAULT NULL COMMENT '网点预留量',
  `DROPSHIP_PRICE` decimal(10,2) DEFAULT NULL COMMENT '借卖价格',
  `DROPSHIP_STATUS` varchar(2) NOT NULL DEFAULT '0' COMMENT '0-提交 1-上架  2-下架',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATION_DATE` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '更新人',
  `CALL_CNT` int(11) DEFAULT NULL COMMENT '乐观锁',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '备注',
  `STS_CD` char(1) NOT NULL DEFAULT 'A' COMMENT '数据有效性',
  `SHELF_STOCK` int(11) DEFAULT NULL COMMENT '网店上架商品数量',
  `PREFER_DATE` timestamp NULL DEFAULT NULL COMMENT '商品网店上架时间',
  PRIMARY KEY (`DIL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sdi_store_dropship_item
-- ----------------------------

-- ----------------------------
-- Table structure for `sequence`
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `name` varchar(50) NOT NULL COMMENT '序列名称',
  `current_value` int(11) NOT NULL COMMENT '当前值',
  `increment` int(11) NOT NULL DEFAULT '1' COMMENT '增长值',
  `initial` varchar(10) DEFAULT NULL COMMENT '首字母',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sequence
-- ----------------------------

-- ----------------------------
-- Table structure for `sha_shipping_address`
-- ----------------------------
DROP TABLE IF EXISTS `sha_shipping_address`;
CREATE TABLE `sha_shipping_address` (
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  `FAMILY_NAME` varchar(45) DEFAULT NULL COMMENT '姓',
  `GIVEN_NAME` varchar(45) DEFAULT NULL COMMENT '名字',
  `COUNTRY_NAME` varchar(45) DEFAULT NULL COMMENT '国家',
  `COUNTRY_ISO_CD` varchar(45) NOT NULL COMMENT '国家编码',
  `STATE_OR_PROVINCE_NAME` varchar(45) DEFAULT NULL COMMENT '省份或洲名称',
  `STATE_OR_PROVINCE_CD` varchar(45) DEFAULT NULL COMMENT '省份或洲编码',
  `CITY_NAME` varchar(45) DEFAULT NULL COMMENT '城市名',
  `ADDRESS_LINE1` varchar(64) DEFAULT NULL COMMENT '地址1',
  `ADDRESS_LINE2` varchar(64) DEFAULT NULL COMMENT '地址2',
  `ADDRESS_LINE3` varchar(64) DEFAULT NULL COMMENT '地址3',
  `POSTAL_CD` varchar(45) NOT NULL COMMENT '邮编',
  `CONTACT_PHONE_NO` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `EMAIL` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `STO_ID` int(11) NOT NULL COMMENT '外键关联sto_store_order表主键',
  `CARRIER_NAME` varchar(100) DEFAULT NULL COMMENT '快递公司名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sha_shipping_address
-- ----------------------------
INSERT INTO `sha_shipping_address` VALUES ('system', '2017-08-03 14:14:51', 'system', '2017-08-03 14:14:51', '1', '', 'A', '', 'Stephanie Valliere', 'United States', 'US', 'Massachusetts', 'MA', 'West Wareham', '14 Griffin Way', '', '', '02576-1361', '774 204 2210', 'henryc524@yahoo.com', '9', '');
INSERT INTO `sha_shipping_address` VALUES ('system', '2017-08-03 15:08:40', 'system', '2017-08-03 15:08:40', '1', '', 'A', '', 'Stephanie Valliere', 'United States', 'US', 'Massachusetts', 'MA', 'West Wareham', '14 Griffin Way', '', '', '02576-1361', '774 204 2210', 'henryc524@yahoo.com', '10', '');
INSERT INTO `sha_shipping_address` VALUES ('system', '2017-08-03 15:25:23', 'system', '2017-08-03 15:25:23', '1', '', 'A', '', 'Stephanie Valliere', 'United States', 'US', 'Massachusetts', 'MA', 'West Wareham', '14 Griffin Way', '', '', '02576-1361', '774 204 2210', 'henryc524@yahoo.com', '11', '');
INSERT INTO `sha_shipping_address` VALUES ('system', '2017-08-03 15:33:55', 'system', '2017-08-03 15:33:55', '1', '', 'A', '', 'Stephanie Valliere', 'United States', 'US', 'Massachusetts', 'MA', 'West Wareham', '14 Griffin Way', '', '', '02576-1361', '774 204 2210', 'henryc524@yahoo.com', '12', '');
INSERT INTO `sha_shipping_address` VALUES ('system', '2017-08-03 15:48:35', 'system', '2017-08-03 15:48:35', '1', '', 'A', '', 'Stephanie Valliere', 'United States', 'US', 'Massachusetts', 'MA', 'West Wareham', '14 Griffin Way', '', '', '02576-1361', '774 204 2210', 'henryc524@yahoo.com', '13', '');
INSERT INTO `sha_shipping_address` VALUES ('system', '2017-08-03 15:57:37', 'system', '2017-08-03 15:57:37', '1', '', 'A', '', 'Stephanie Valliere', 'United States', 'US', 'Massachusetts', 'MA', 'West Wareham', '14 Griffin Way', '', '', '02576-1361', '774 204 2210', 'henryc524@yahoo.com', '14', '');
INSERT INTO `sha_shipping_address` VALUES ('system', '2017-08-03 15:57:37', 'system', '2017-08-03 15:57:37', '1', '', 'A', '', 'Stephanie Valliere', 'United States', 'US', 'Massachusetts', 'MA', 'West Wareham', '14 Griffin Way', '', '', '02576-1361', '774 204 2210', 'henryc524@yahoo.com', '15', '');
INSERT INTO `sha_shipping_address` VALUES ('system', '2017-08-03 16:14:26', 'system', '2017-08-03 16:14:26', '1', '', 'A', '', 'Stephanie Valliere', 'United States', 'US', 'Massachusetts', 'MA', 'West Wareham', '14 Griffin Way', '', '', '02576-1361', '774 204 2210', 'henryc524@yahoo.com', '16', '');
INSERT INTO `sha_shipping_address` VALUES ('system', '2017-08-03 16:15:02', 'system', '2017-08-03 16:15:02', '1', '', 'A', '', 'Stephanie Valliere', 'United States', 'US', 'Massachusetts', 'MA', 'West Wareham', '14 Griffin Way', '', '', '02576-1361', '774 204 2210', 'henryc524@yahoo.com', '17', '');
INSERT INTO `sha_shipping_address` VALUES ('system', '2017-08-04 17:17:42', 'system', '2017-08-04 17:17:42', '1', '', 'A', '', 'Stephanie Valliere', 'United States', 'US', 'Massachusetts', 'MA', 'West Wareham', '14 Griffin Way', '', '', '02576-1361', '774 204 2210', 'henryc524@yahoo.com', '18', '');
INSERT INTO `sha_shipping_address` VALUES ('system', '2017-08-04 17:17:42', 'system', '2017-08-04 17:17:42', '1', '', 'A', '', 'Stephanie Valliere', 'United States', 'US', 'Massachusetts', 'MA', 'West Wareham', '14 Griffin Way', '', '', '02576-1361', '774 204 2210', 'henryc524@yahoo.com', '19', '');

-- ----------------------------
-- Table structure for `sol_store_order_line_item`
-- ----------------------------
DROP TABLE IF EXISTS `sol_store_order_line_item`;
CREATE TABLE `sol_store_order_line_item` (
  `SOL_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ORDER_ITEM_ID` varchar(45) DEFAULT NULL COMMENT '第三方平台 LINE_ITEM_ID',
  `STO_ID` int(11) NOT NULL COMMENT '主表主键ID',
  `SALES_PRICE` decimal(8,2) DEFAULT NULL COMMENT '商品单价',
  `QTY` int(11) DEFAULT NULL COMMENT '商品数量',
  `SKU_NO` varchar(45) DEFAULT NULL COMMENT '商品SKU编号',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATION_DATE` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '修改人',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `CALL_CNT` int(11) DEFAULT NULL COMMENT '乐观锁',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '备注',
  `STS_CD` char(1) NOT NULL DEFAULT 'A' COMMENT '有效性',
  `BUYER_CHECKOUT_MESSAGE` text COMMENT '用户留言',
  PRIMARY KEY (`SOL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sol_store_order_line_item
-- ----------------------------
INSERT INTO `sol_store_order_line_item` VALUES ('1', '1', '7', '100.00', '2', 'GM001731', 'system', '2017-08-03 13:53:43', 'system', '2017-08-03 13:53:43', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('2', '1', '8', '100.00', '2', 'GM001731', 'system', '2017-08-03 14:12:05', 'system', '2017-08-03 14:12:05', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('3', '1', '9', '100.00', '2', 'GM001731', 'system', '2017-08-03 14:14:51', 'system', '2017-08-03 14:14:51', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('4', '1', '10', '100.00', '1', 'GM001731', 'system', '2017-08-03 15:08:40', 'system', '2017-08-03 15:08:40', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('5', '1', '11', '100.00', '1', 'GM001731', 'system', '2017-08-03 15:25:23', 'system', '2017-08-03 15:25:23', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('6', '1', '12', '100.00', '1', 'GM001731', 'system', '2017-08-03 15:33:55', 'system', '2017-08-03 15:33:55', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('7', '1', '13', '280.00', '1', 'GM001731', 'system', '2017-08-03 15:48:35', 'system', '2017-08-03 15:48:35', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('8', '1', '14', '98.00', '1', 'GM001731', 'system', '2017-08-03 15:57:37', 'system', '2017-08-03 15:57:37', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('9', '1', '15', '280.00', '1', 'GM001731', 'system', '2017-08-03 15:57:37', 'system', '2017-08-03 15:57:37', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('10', '1', '16', '280.00', '1', 'GM001731', 'system', '2017-08-03 16:14:26', 'system', '2017-08-03 16:14:26', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('11', '1', '17', '98.00', '1', 'GM001731', 'system', '2017-08-03 16:15:02', 'system', '2017-08-03 16:15:02', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('12', '1', '18', '280.00', '1', 'GM001732', 'system', '2017-08-04 17:17:42', 'system', '2017-08-04 17:17:42', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('13', '1', '19', '280.00', '1', 'GM001732', 'system', '2017-08-04 17:17:42', 'system', '2017-08-04 17:17:42', '1', '1', 'A', '');
INSERT INTO `sol_store_order_line_item` VALUES ('14', '1', '20', '280.00', '1', 'GM001732', 'system', '2017-08-04 17:31:13', 'system', '2017-08-04 17:31:13', '1', '1', 'A', '');

-- ----------------------------
-- Table structure for `spa_specific_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `spa_specific_attribute`;
CREATE TABLE `spa_specific_attribute` (
  `SPA_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `PRO_ID` int(11) DEFAULT NULL COMMENT '外键 关联pro表id',
  `NAME_EN` varchar(45) DEFAULT NULL COMMENT '属性中文',
  `NAME_CN` varchar(45) DEFAULT NULL COMMENT '属性英文',
  `SEQ_NO` int(11) DEFAULT NULL COMMENT '排序',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`SPA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spa_specific_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for `spv_specific_attribute_value`
-- ----------------------------
DROP TABLE IF EXISTS `spv_specific_attribute_value`;
CREATE TABLE `spv_specific_attribute_value` (
  `SPV_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `SPA_ID` int(11) NOT NULL COMMENT '外键关联spa表主键',
  `NAME_EN` varchar(100) DEFAULT NULL,
  `NAME_CN` varchar(100) DEFAULT NULL,
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`SPV_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spv_specific_attribute_value
-- ----------------------------

-- ----------------------------
-- Table structure for `sto_store_order`
-- ----------------------------
DROP TABLE IF EXISTS `sto_store_order`;
CREATE TABLE `sto_store_order` (
  `STO_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `STR_ID` int(11) NOT NULL COMMENT '网店ID，外键关联str表主键',
  `ORDER_ID` varchar(45) DEFAULT NULL COMMENT 'AMAZON / EBAY 平台的订单 ID\n例如: \nAMAZON :  058-1233752-8214740\nEBAY : 865826\n',
  `ORDER_CREATED_TIME` varchar(45) DEFAULT NULL,
  `PAID_TIME` varchar(45) DEFAULT NULL,
  `LAST_MODIFIED_TIME` varchar(45) DEFAULT NULL COMMENT '订单创建时间',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `CREATION_DATE` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '更新人',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `CALL_CNT` int(11) DEFAULT NULL COMMENT '乐观锁',
  `REMARK` varchar(50) DEFAULT NULL COMMENT '备注',
  `STS_CD` char(1) NOT NULL DEFAULT 'A' COMMENT '有效性',
  `PLATEFORM_TYPE` varchar(2) DEFAULT NULL COMMENT '平台类别 1、amazon 2、ebay',
  `CANCEL_COMPLETE_DATE` varchar(45) DEFAULT NULL COMMENT '订单取消时间',
  PRIMARY KEY (`STO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sto_store_order
-- ----------------------------
INSERT INTO `sto_store_order` VALUES ('1', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 00:00:00', '2017-08-03 00:00:00', '2017-08-03 00:00:00', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 00:00:00', '1', '', 'A', '1', '2017-08-03 00:00:00');
INSERT INTO `sto_store_order` VALUES ('2', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 00:00:00', '2017-08-03 00:00:00', '2017-08-03 00:00:00', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 00:00:00', '1', '', 'A', '1', '2017-08-03 00:00:00');
INSERT INTO `sto_store_order` VALUES ('3', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 00:00:00', '2017-08-03 00:00:00', '2017-08-03 00:00:00', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 00:00:00', '1', '', 'A', '1', '2017-08-03 00:00:00');
INSERT INTO `sto_store_order` VALUES ('4', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 13:38:37', '2017-08-03 00:00:00', '2017-08-03 13:38:37', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 13:38:37', '1', '', 'A', '1', '2017-08-03 13:38:37');
INSERT INTO `sto_store_order` VALUES ('5', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 13:40:30', '2017-08-03 00:00:00', '2017-08-03 13:40:30', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 13:40:30', '1', '', 'A', '1', '2017-08-03 13:40:30');
INSERT INTO `sto_store_order` VALUES ('6', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 13:42:04', '2017-08-03 00:00:00', '2017-08-03 13:42:04', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 13:42:04', '1', '', 'A', '1', '2017-08-03 13:42:04');
INSERT INTO `sto_store_order` VALUES ('7', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 13:53:43', '2017-08-03 00:00:00', '2017-08-03 13:53:43', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 13:53:43', '1', '', 'A', '1', '2017-08-03 13:53:43');
INSERT INTO `sto_store_order` VALUES ('8', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 14:12:05', '2017-08-03 00:00:00', '2017-08-03 14:12:05', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 14:12:05', '1', '', 'A', '1', '2017-08-03 14:12:05');
INSERT INTO `sto_store_order` VALUES ('9', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 14:14:51', '2017-08-03 00:00:00', '2017-08-03 14:14:51', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 14:14:51', '1', '', 'A', '1', '2017-08-03 14:14:51');
INSERT INTO `sto_store_order` VALUES ('10', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 15:08:40', '2017-08-03 00:00:00', '2017-08-03 15:08:40', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 15:08:40', '1', '', 'A', '1', '2017-08-03 15:08:40');
INSERT INTO `sto_store_order` VALUES ('11', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 15:25:23', '2017-08-03 00:00:00', '2017-08-03 15:25:23', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 15:25:23', '1', '', 'A', '1', '2017-08-03 15:25:23');
INSERT INTO `sto_store_order` VALUES ('12', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 15:33:55', '2017-08-03 00:00:00', '2017-08-03 15:33:55', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 15:33:55', '1', '', 'A', '1', '2017-08-03 15:33:55');
INSERT INTO `sto_store_order` VALUES ('13', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 15:48:35', '2017-08-03 00:00:00', '2017-08-03 15:48:35', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 15:48:35', '1', '', 'A', '1', '2017-08-03 15:48:35');
INSERT INTO `sto_store_order` VALUES ('14', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 15:57:37', '2017-08-03 00:00:00', '2017-08-03 15:57:37', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 15:57:37', '1', '', 'A', '1', '2017-08-03 15:57:37');
INSERT INTO `sto_store_order` VALUES ('15', '2', 'AMAZON :  058-1233752-8214740', '2017-08-03 15:57:37', '2017-08-03 00:00:00', '2017-08-03 15:57:37', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 15:57:37', '1', '', 'A', '1', '2017-08-03 15:57:37');
INSERT INTO `sto_store_order` VALUES ('16', '1', 'AMAZON :  058-1233752-8214740', '2017-08-03 16:14:26', '2017-08-03 00:00:00', '2017-08-03 16:14:26', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 16:14:26', '1', '', 'A', '1', '2017-08-03 16:14:26');
INSERT INTO `sto_store_order` VALUES ('17', '2', 'AMAZON :  058-1233752-8214740', '2017-08-03 16:15:02', '2017-08-03 00:00:00', '2017-08-03 16:15:02', 'system', '2017-08-03 00:00:00', 'system', '2017-08-03 16:15:02', '1', '', 'A', '1', '2017-08-03 16:15:02');
INSERT INTO `sto_store_order` VALUES ('18', '1', 'AMAZON :  058-1233752-8214740', '2017-08-04 17:17:42', '2017-08-03 00:00:00', '2017-08-04 17:17:42', 'system', '2017-08-03 00:00:00', 'system', '2017-08-04 17:17:42', '1', '', 'A', '1', '2017-08-04 17:17:42');
INSERT INTO `sto_store_order` VALUES ('19', '2', 'AMAZON :  058-1233752-8214740', '2017-08-04 17:17:42', '2017-08-03 00:00:00', '2017-08-04 17:17:42', 'system', '2017-08-03 00:00:00', 'system', '2017-08-04 17:17:42', '1', '', 'A', '1', '2017-08-04 17:17:42');
INSERT INTO `sto_store_order` VALUES ('20', '1', 'AMAZON :  058-1233752-8214740', '2017-08-04 17:31:13', '2017-08-04 17:31:13', '2017-08-04 17:31:13', 'system', '2017-08-04 17:31:13', 'system', '2017-08-04 17:31:13', '1', '', 'A', '1', '2017-08-04 17:31:13');

-- ----------------------------
-- Table structure for `str_store`
-- ----------------------------
DROP TABLE IF EXISTS `str_store`;
CREATE TABLE `str_store` (
  `STR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DSR_ID` int(11) NOT NULL COMMENT '借卖ID',
  `PLATAEFORM_TYPE` varchar(2) DEFAULT NULL COMMENT '平台类别,1:Amazon;2:ebay',
  `STORE_NAME` varchar(45) DEFAULT NULL COMMENT '网店名 - 从api中取得',
  `STORE_STS_CD` varchar(45) DEFAULT NULL COMMENT 'API 对接状态\n\n1. INI - 刚授权\n2. WIP - 正常对接\n3. EXP - token 过期\n4. ERR - token 出错\n5. CLS - 网店关闭',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  `REMARK` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`STR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of str_store
-- ----------------------------
INSERT INTO `str_store` VALUES ('1', '1', null, 'test', null, null, '2017-08-01 15:50:44', null, '2017-08-01 15:50:49', null, 'A', null);
INSERT INTO `str_store` VALUES ('2', '1', null, 'test2', null, null, '2017-08-01 15:51:19', null, '2017-08-01 15:51:23', null, 'A', null);

-- ----------------------------
-- Table structure for `sys_andorra`
-- ----------------------------
DROP TABLE IF EXISTS `sys_andorra`;
CREATE TABLE `sys_andorra` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `content` varchar(200) DEFAULT NULL COMMENT '内容',
  `type` char(2) DEFAULT NULL COMMENT '类型 ',
  `adurl` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `publisher` varchar(50) DEFAULT NULL COMMENT '发布人',
  `addtime` datetime DEFAULT NULL COMMENT '添加时间',
  `uptime` datetime DEFAULT NULL COMMENT '修改时间',
  `starttime` varchar(50) DEFAULT NULL COMMENT '开始时间',
  `endtime` varchar(50) DEFAULT NULL COMMENT '结束时间',
  `status` char(2) DEFAULT '0' COMMENT '状态  0为默认未启用，1为启用',
  `tourl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_andorra
-- ----------------------------
INSERT INTO `sys_andorra` VALUES ('11', 'test', '<p style=\"\">text<img src=\"http://10.10.28.214:10300/TP/ae5f19486f2f46e6ba93b0252bea802e.png\" title=\"llq.png\"/></p>', '0', '', 'iuo', '2017-07-05 17:05:02', '2017-07-05 18:56:02', '2017-07-05', '2017-07-13', '0', '-ii');
INSERT INTO `sys_andorra` VALUES ('12', 'te', '<p><img src=\"/upload/43682f32dce94b6ea18dcba43e62b903.jpg\" title=\"c5d988e2b8ed99301d4da5793e682587.jpg\"/><img src=\"/upload/bb179e262cd7433291e92e530c6f7699.jpg\" title=\"手动é?手动é?阿斯蒂芬.jpg\"/></p>', '0', '12.jpg', 'f', '2017-07-05 19:05:47', '2017-07-05 19:06:47', '', '', '0', 'f');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `MENU_ID` int(11) NOT NULL COMMENT '菜单id',
  `MENU_NAME` varchar(255) DEFAULT NULL COMMENT '菜单名',
  `MENU_URL` varchar(255) DEFAULT NULL COMMENT '菜单url',
  `PARENT_ID` int(25) DEFAULT NULL COMMENT '父级菜单id',
  `MENU_ORDER` varchar(100) DEFAULT NULL COMMENT '菜单顺序',
  `MENU_ICON` varchar(30) DEFAULT NULL COMMENT '菜单图标',
  `MENU_TYPE` varchar(10) DEFAULT NULL COMMENT '菜单类型',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATION_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '更新人',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `CALL_CNT` int(11) DEFAULT NULL COMMENT '乐观锁',
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  `STS_CD` char(1) DEFAULT NULL COMMENT '状态码',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '#', '0', '1', 'icon-desktop', '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-18 16:59:34', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('2', '菜单权限', 'newRole/listRole', '1', '2', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-27 09:12:15', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('5', '系统用户', 'user/listUsers', '1', '3', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-27 09:12:17', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('8', '性能监控', 'druid/index.html', '9', '1', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-18 16:59:34', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('9', '系统工具', '#', '0', '2', 'icon-th', '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-18 16:59:34', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('10', 'test', 'andorra/list', '1', '4', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-27 09:12:18', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('11', 'testp', 'pictures/list', '1', '5', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-27 09:12:20', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('16', '菜单列表', 'newMenu/listVisibleTopMenu', '1', '6', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-26 16:20:42', null, 'last action is edit name', 'a');
INSERT INTO `sys_menu` VALUES ('20', '我的信息（制造商）', '/brand-addbrand', '0', '7', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2019-07-21 13:07:58', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('21', '基本信息管理', 'manufacturerInfo/showManufacturerinfo', '20', '1', null, null, 'admin', '2017-07-18 16:59:34', 'admin', '2017-10-18 13:45:48', null, 'last action is edit', 'a');
INSERT INTO `sys_menu` VALUES ('22', '品牌管理', 'Brand/BrandList', '20', '2', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-28 15:19:52', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('23', '商品管理', 'product/showProductList', '20', '3', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-28 15:36:17', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('25', '商品录入', '/brand-productInput-attr', '0', '8', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2019-07-21 17:14:10', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('26', '基础信息', 'product/showProductList', '25', '1', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-28 17:10:13', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('28', '图片', 'ImageController/findImageList', '25', '3', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-31 09:45:59', null, null, 's');
INSERT INTO `sys_menu` VALUES ('29', '订单管理（制造商）', '/brand-orderlist', '0', '9', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2019-07-23 10:35:50', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('30', '查看', 'order/findOrders', '29', '1', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-30 21:03:36', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('32', '钱包', '#', '0', '15', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-18 16:59:34', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('33', '账户管理', 'ewallet/account/home', '32', '1', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-28 15:44:27', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('34', '余额查看及提现', '#test', '32', '2', null, null, 'admin', '2017-07-18 16:59:34', 'admin', '2017-08-04 09:09:26', null, 'last action is edit', 'a');
INSERT INTO `sys_menu` VALUES ('35', '账户流水', '#', '32', '3', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-18 16:59:34', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('37', '我的信息（借卖方）', '#', '0', '11', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-18 16:59:34', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('38', '商品列表', 'dsrProduct/showProductList', '37', '1', null, null, 'admin', '2017-07-18 16:59:34', 'test2', '2017-07-28 16:50:40', null, 'last action is edit', 'a');
INSERT INTO `sys_menu` VALUES ('39', '网店管理', 'strstore/findStrStore', '37', '2', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-28 16:48:36', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('40', '商品管理', '#', '0', '12', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-18 16:59:34', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('41', '已有商品', 'product/showProductList', '40', '1', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-27 09:49:46', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('43', '订单管理（借卖方）', '#', '0', '13', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-18 16:59:34', null, null, 'a');
INSERT INTO `sys_menu` VALUES ('44', '查看', 'orders/showSaoSalesOrderItems', '43', '1', null, '2', 'admin', '2017-07-18 16:59:34', 'admin', '2017-07-28 15:40:24', null, null, 'a');

-- ----------------------------
-- Table structure for `sys_new_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_new_role`;
CREATE TABLE `sys_new_role` (
  `ROLE_ID` int(20) NOT NULL COMMENT '角色id',
  `ROLE_NAME` varchar(20) DEFAULT NULL COMMENT '角色名',
  `VISIBLE_MENU_ID` varchar(255) DEFAULT NULL COMMENT '角色可见菜单',
  `PARENT_ID` int(20) DEFAULT NULL COMMENT '父级id',
  `CREATED_BY` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATION_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL COMMENT '更新人',
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `CALL_CNT` int(11) DEFAULT NULL COMMENT '乐观锁',
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  `STS_CD` char(1) DEFAULT NULL COMMENT '状态码',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_new_role
-- ----------------------------
INSERT INTO `sys_new_role` VALUES ('1', '系统管理员', '1,37,40,43,32,9,20,25,29', '0', 'admin', '2017-07-18 16:59:34', 'admin', '2017-08-06 19:34:44', null, 'last action is update visible menu', 'A');
INSERT INTO `sys_new_role` VALUES ('2', '品牌商', '40,32,9,20,25,29', '0', 'admin', '2017-07-18 16:59:34', 'mvo', '2017-10-19 14:19:28', null, 'last action is update visible menu', 'A');
INSERT INTO `sys_new_role` VALUES ('3', '借卖方', '37,40,43,32,9', '0', 'admin', '2017-07-18 16:59:34', 'admin', '2017-08-04 08:42:19', null, 'last action is update visible menu', 'A');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `LAST_LOGIN` varchar(255) DEFAULT NULL,
  `IP` varchar(100) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `BZ` varchar(255) DEFAULT NULL,
  `SKIN` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `NUMBER` varchar(100) DEFAULT NULL,
  `PHONE` varchar(32) DEFAULT NULL,
  `MAN_BUYER_ID` int(11) DEFAULT NULL COMMENT '产商,借卖方ID',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '系统管理员', '1133671055321055258374707980945218933803269864762743594642571294', '1', '2017-10-19 14:21:05', '0:0:0:0:0:0:0:1', 'a', '系统管理员', 'default', '123@123.com', '001', '18788888888', '1');
INSERT INTO `sys_user` VALUES ('2', 'mvo', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'mvo', '1', '2', '2017-10-19 14:19:40', '0:0:0:0:0:0:0:1', 'a', '品牌商', 'default', 'mvo@163.com', '1111', '13487363613', '1');
INSERT INTO `sys_user` VALUES ('3', 'bvo', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'bvo', '1', '3', '2019-7-21 14:21:05', '0:0:0:0:0:0:0:1', 'a', '借卖方', 'default', 'bvo@163.com', '1112', '13487363612', '1');

-- ----------------------------
-- Table structure for `tb_pictures`
-- ----------------------------
DROP TABLE IF EXISTS `tb_pictures`;
CREATE TABLE `tb_pictures` (
  `PICTURES_ID` varchar(100) NOT NULL,
  `TITLE` varchar(255) DEFAULT NULL COMMENT '标题',
  `NAME` varchar(255) DEFAULT NULL COMMENT '文件名',
  `PATH` varchar(255) DEFAULT NULL COMMENT '路径',
  `CREATETIME` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `MASTER_ID` varchar(255) DEFAULT NULL COMMENT '属于',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`PICTURES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pictures
-- ----------------------------
INSERT INTO `tb_pictures` VALUES ('6800af332d3542429c9f51e03927a628', '图片', '1f644f072d6f41e695f1faead2bbf77d.jpg', '20170721/1f644f072d6f41e695f1faead2bbf77d.jpg', '2017-07-05 10:25:13', '1', '图片管理处上传');
INSERT INTO `tb_pictures` VALUES ('e7f8f67f54d6496b94c7936319bbbd3f', '图片', '378e6218c66149458906875024d1d123.jpg', '20170705/378e6218c66149458906875024d1d123.jpg', '2017-07-05 10:24:05', '1', '图片管理处上传');

-- ----------------------------
-- Table structure for `ull_user_login_logout_log`
-- ----------------------------
DROP TABLE IF EXISTS `ull_user_login_logout_log`;
CREATE TABLE `ull_user_login_logout_log` (
  `ULL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USI_ID` varchar(32) DEFAULT NULL COMMENT '用户表主键',
  `TOKEN` varchar(45) DEFAULT NULL COMMENT '用户登录token',
  `TERMINAL_TYPE` varchar(2) DEFAULT NULL COMMENT '终端版本类别 1-APP 2-web',
  `OPERATING_TYPE` varchar(2) DEFAULT NULL COMMENT '1-login 2-logout',
  `OPERATING_DATE` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) DEFAULT NULL,
  PRIMARY KEY (`ULL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ull_user_login_logout_log
-- ----------------------------
INSERT INTO `ull_user_login_logout_log` VALUES ('1', '1', '1', '2', '1', '2017-07-24 16:39:29', 'admin', '2017-07-24 16:39:29', 'admin', '2017-07-24 16:39:29', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('2', '1', '1', '2', '1', '2017-07-24 17:02:33', 'admin', '2017-07-24 17:02:33', 'admin', '2017-07-24 17:02:33', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('3', '3', '1', '2', '1', '2017-07-24 17:19:53', 'admin', '2017-07-24 17:19:53', 'admin', '2017-07-24 17:19:53', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('4', '1', '1', '2', '1', '2017-07-24 17:20:10', 'admin', '2017-07-24 17:20:10', 'admin', '2017-07-24 17:20:10', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('5', '3', '1', '2', '1', '2017-07-24 17:21:59', 'admin', '2017-07-24 17:21:59', 'admin', '2017-07-24 17:21:59', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('6', '3', '1', '2', '1', '2017-07-24 17:31:10', 'admin', '2017-07-24 17:31:10', 'admin', '2017-07-24 17:31:10', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('7', '3', '1', '2', '1', '2017-07-24 17:37:25', 'admin', '2017-07-24 17:37:25', 'admin', '2017-07-24 17:37:25', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('8', '3', '1', '2', '1', '2017-07-24 17:38:24', 'admin', '2017-07-24 17:38:24', 'admin', '2017-07-24 17:38:24', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('9', '3', '1', '2', '1', '2017-07-24 17:39:56', 'admin', '2017-07-24 17:39:56', 'admin', '2017-07-24 17:39:56', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('10', '1', '1', '2', '1', '2017-07-24 17:40:36', 'admin', '2017-07-24 17:40:36', 'admin', '2017-07-24 17:40:36', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('11', '2', '1', '2', '1', '2017-07-24 17:43:22', 'admin', '2017-07-24 17:43:22', 'admin', '2017-07-24 17:43:22', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('12', '1', '1', '2', '1', '2017-07-24 19:00:17', 'admin', '2017-07-24 19:00:17', 'admin', '2017-07-24 19:00:17', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('13', '1', '1', '2', '1', '2017-07-24 19:17:08', 'admin', '2017-07-24 19:17:08', 'admin', '2017-07-24 19:17:08', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('14', '1', '1', '2', '1', '2017-07-24 19:22:21', 'admin', '2017-07-24 19:22:21', 'admin', '2017-07-24 19:22:21', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('15', '1', '1', '2', '1', '2017-07-24 19:44:09', 'admin', '2017-07-24 19:44:09', 'admin', '2017-07-24 19:44:09', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('16', '1', '1', '2', '1', '2017-07-24 21:19:48', 'admin', '2017-07-24 21:19:48', 'admin', '2017-07-24 21:19:48', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('17', '5', '1', '2', '1', '2017-07-26 10:55:33', 'admin', '2017-07-26 10:55:33', 'admin', '2017-07-26 10:55:33', null, null, null);
INSERT INTO `ull_user_login_logout_log` VALUES ('18', '5', '1', '2', '1', '2017-07-26 10:56:03', 'admin', '2017-07-26 10:56:03', 'admin', '2017-07-26 10:56:03', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('19', '5', '1', '2', '1', '2017-07-26 11:13:51', 'admin', '2017-07-26 11:13:51', 'admin', '2017-07-26 11:13:51', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('20', '5', '1', '2', '1', '2017-07-26 12:28:18', 'admin', '2017-07-26 12:28:18', 'admin', '2017-07-26 12:28:18', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('21', '5', '1', '2', '1', '2017-07-26 13:58:52', 'admin', '2017-07-26 13:58:52', 'admin', '2017-07-26 13:58:52', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('22', '5', '1', '2', '1', '2017-07-26 14:03:15', 'admin', '2017-07-26 14:03:15', 'admin', '2017-07-26 14:03:15', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('23', '5', '1', '2', '1', '2017-07-26 14:06:51', 'admin', '2017-07-26 14:06:51', 'admin', '2017-07-26 14:06:51', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('24', '5', '1', '2', '1', '2017-07-26 14:07:54', 'admin', '2017-07-26 14:07:54', 'admin', '2017-07-26 14:07:54', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('25', '5', '1', '2', '1', '2017-07-26 14:22:15', 'admin', '2017-07-26 14:22:15', 'admin', '2017-07-26 14:22:15', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('26', '5', '1', '2', '1', '2017-07-26 14:22:44', 'admin', '2017-07-26 14:22:44', 'admin', '2017-07-26 14:22:44', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('27', '5', '1', '2', '1', '2017-07-26 14:23:57', 'admin', '2017-07-26 14:23:57', 'admin', '2017-07-26 14:23:57', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('28', '5', '1', '2', '1', '2017-07-26 14:28:11', 'admin', '2017-07-26 14:28:11', 'admin', '2017-07-26 14:28:11', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('29', '5', '1', '2', '1', '2017-07-26 14:29:25', 'admin', '2017-07-26 14:29:25', 'admin', '2017-07-26 14:29:25', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('30', '5', '1', '2', '1', '2017-07-26 14:32:27', 'admin', '2017-07-26 14:32:27', 'admin', '2017-07-26 14:32:27', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('31', '5', '1', '2', '1', '2017-07-26 15:57:30', 'admin', '2017-07-26 15:57:30', 'admin', '2017-07-26 15:57:30', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('32', '5', '1', '2', '1', '2017-07-26 16:02:53', 'admin', '2017-07-26 16:02:53', 'admin', '2017-07-26 16:02:53', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('33', '5', '1', '2', '1', '2017-07-26 16:19:38', 'admin', '2017-07-26 16:19:38', 'admin', '2017-07-26 16:19:38', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('34', '5', '1', '2', '1', '2017-07-26 16:22:21', 'admin', '2017-07-26 16:22:21', 'admin', '2017-07-26 16:22:21', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('35', '5', '1', '2', '1', '2017-07-26 16:30:49', 'admin', '2017-07-26 16:30:49', 'admin', '2017-07-26 16:30:49', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('36', '5', '1', '2', '1', '2017-07-27 08:44:40', 'admin', '2017-07-27 08:44:40', 'admin', '2017-07-27 08:44:40', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('37', '3', '1', '2', '1', '2017-07-27 08:52:27', 'admin', '2017-07-27 08:52:27', 'admin', '2017-07-27 08:52:27', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('38', '4', '1', '2', '1', '2017-07-27 08:55:01', 'admin', '2017-07-27 08:55:01', 'admin', '2017-07-27 08:55:01', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('39', '4', '1', '2', '1', '2017-07-27 08:55:27', 'admin', '2017-07-27 08:55:27', 'admin', '2017-07-27 08:55:27', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('40', '1', '1', '2', '1', '2017-07-27 08:58:22', 'admin', '2017-07-27 08:58:22', 'admin', '2017-07-27 08:58:22', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('41', '1', '1', '2', '1', '2017-07-27 09:12:38', 'admin', '2017-07-27 09:12:38', 'admin', '2017-07-27 09:12:38', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('42', '1', '1', '2', '1', '2017-07-27 09:13:28', 'admin', '2017-07-27 09:13:28', 'admin', '2017-07-27 09:13:28', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('43', '1', '1', '2', '1', '2017-07-27 09:19:00', 'admin', '2017-07-27 09:19:00', 'admin', '2017-07-27 09:19:00', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('44', '1', '1', '2', '1', '2017-07-27 09:50:14', 'admin', '2017-07-27 09:50:14', 'admin', '2017-07-27 09:50:14', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('45', '1', '1', '2', '1', '2017-07-28 14:51:44', 'admin', '2017-07-28 14:51:44', 'admin', '2017-07-28 14:51:44', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('46', '1', '1', '2', '1', '2017-07-28 16:22:45', 'admin', '2017-07-28 16:22:45', 'admin', '2017-07-28 16:22:45', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('47', '1', '1', '2', '1', '2017-07-28 16:43:35', 'admin', '2017-07-28 16:43:35', 'admin', '2017-07-28 16:43:35', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('48', '1', '1', '2', '1', '2017-07-30 21:06:07', 'admin', '2017-07-30 21:06:07', 'admin', '2017-07-30 21:06:07', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('49', '1', '1', '2', '1', '2017-07-30 21:09:28', 'admin', '2017-07-30 21:09:28', 'admin', '2017-07-30 21:09:28', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('50', '1', '1', '2', '1', '2017-07-30 21:31:25', 'admin', '2017-07-30 21:31:25', 'admin', '2017-07-30 21:31:25', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('51', '1', '1', '2', '1', '2017-07-30 21:48:23', 'admin', '2017-07-30 21:48:23', 'admin', '2017-07-30 21:48:23', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('52', '1', '1', '2', '1', '2017-07-31 09:23:58', 'admin', '2017-07-31 09:23:58', 'admin', '2017-07-31 09:23:58', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('53', '1', '1', '2', '1', '2017-07-31 10:46:29', 'admin', '2017-07-31 10:46:29', 'admin', '2017-07-31 10:46:29', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('54', '1', '1', '2', '1', '2017-07-31 11:13:07', 'admin', '2017-07-31 11:13:07', 'admin', '2017-07-31 11:13:07', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('55', '1', '1', '2', '1', '2017-07-31 11:14:39', 'admin', '2017-07-31 11:14:39', 'admin', '2017-07-31 11:14:39', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('56', '1', '1', '2', '1', '2017-07-31 11:17:32', 'admin', '2017-07-31 11:17:32', 'admin', '2017-07-31 11:17:32', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('57', '1', '1', '2', '1', '2017-08-01 15:03:54', 'admin', '2017-08-01 15:03:54', 'admin', '2017-08-01 15:03:54', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('58', '1', '1', '2', '1', '2017-08-03 16:43:57', 'admin', '2017-08-03 16:43:57', 'admin', '2017-08-03 16:43:57', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('59', '1', '1', '2', '1', '2017-08-03 16:50:07', 'admin', '2017-08-03 16:50:07', 'admin', '2017-08-03 16:50:07', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('60', '1', '1', '2', '1', '2017-08-03 16:51:18', 'admin', '2017-08-03 16:51:18', 'admin', '2017-08-03 16:51:18', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('61', '1', '1', '2', '1', '2017-08-03 16:52:02', 'admin', '2017-08-03 16:52:02', 'admin', '2017-08-03 16:52:02', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('62', '1', '1', '2', '1', '2017-08-03 16:57:04', 'admin', '2017-08-03 16:57:04', 'admin', '2017-08-03 16:57:04', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('63', '1', '1', '2', '1', '2017-08-03 17:02:32', 'admin', '2017-08-03 17:02:32', 'admin', '2017-08-03 17:02:32', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('64', '5', '1', '2', '1', '2017-08-03 17:05:04', 'admin', '2017-08-03 17:05:02', 'admin', '2017-08-03 17:05:03', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('65', '1', '1', '2', '1', '2017-08-03 17:21:45', 'admin', '2017-08-03 17:21:45', 'admin', '2017-08-03 17:21:45', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('66', '1', '1', '2', '1', '2017-08-03 17:25:22', 'admin', '2017-08-03 17:25:22', 'admin', '2017-08-03 17:25:22', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('67', '1', '1', '2', '1', '2017-08-03 17:27:42', 'admin', '2017-08-03 17:27:42', 'admin', '2017-08-03 17:27:42', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('68', '1', '1', '2', '1', '2017-08-03 17:32:04', 'admin', '2017-08-03 17:32:04', 'admin', '2017-08-03 17:32:04', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('69', '1', '1', '2', '1', '2017-08-03 17:40:02', 'admin', '2017-08-03 17:40:02', 'admin', '2017-08-03 17:40:02', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('70', '1', '1', '2', '1', '2017-08-03 17:41:32', 'admin', '2017-08-03 17:41:32', 'admin', '2017-08-03 17:41:32', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('71', '1', '1', '2', '1', '2017-08-04 08:41:04', 'admin', '2017-08-04 08:41:04', 'admin', '2017-08-04 08:41:04', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('72', '1', '1', '2', '1', null, 'admin', '2017-08-04 17:17:16', 'admin', '2017-08-04 17:17:16', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('73', '1', '1', '2', '1', null, 'admin', '2017-08-06 19:13:19', 'admin', '2017-08-06 19:13:19', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('74', '1', '1', '2', '1', null, 'admin', '2017-08-06 19:24:15', 'admin', '2017-08-06 19:24:15', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('75', '1', '1', '2', '1', null, 'admin', '2017-08-06 19:33:56', 'admin', '2017-08-06 19:33:56', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('76', '1', '1', '2', '1', null, 'admin', '2017-08-06 19:34:25', 'admin', '2017-08-06 19:34:25', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('77', '1', '1', '2', '1', null, 'admin', '2017-08-06 19:34:58', 'admin', '2017-08-06 19:34:58', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('78', '1', '1', '2', '1', null, 'admin', '2017-08-06 19:38:03', 'admin', '2017-08-06 19:38:03', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('79', '1', '1', '2', '1', null, 'admin', '2017-08-06 19:40:38', 'admin', '2017-08-06 19:40:38', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('80', '1', '1', '2', '1', null, 'admin', '2017-08-06 19:44:02', 'admin', '2017-08-06 19:44:02', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('81', '1', '1', '2', '1', null, 'admin', '2017-08-06 19:46:21', 'admin', '2017-08-06 19:46:21', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('82', '1', '1', '2', '1', null, 'admin', '2017-08-07 08:41:58', 'admin', '2017-08-07 08:41:58', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('83', '1', '1', '2', '1', null, 'admin', '2017-08-07 08:55:00', 'admin', '2017-08-07 08:55:00', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('84', '1', '1', '2', '1', null, 'admin', '2017-08-07 09:00:11', 'admin', '2017-08-07 09:00:11', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('85', '1', '1', '2', '1', null, 'admin', '2017-08-07 15:23:38', 'admin', '2017-08-07 15:23:38', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('86', '1', '1', '2', '1', null, 'admin', '2017-08-07 15:24:16', 'admin', '2017-08-07 15:24:16', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('87', '1', '1', '2', '1', null, 'admin', '2017-08-08 16:22:18', 'admin', '2017-08-08 16:22:18', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('88', '1', '1', '2', '1', null, 'admin', '2017-08-08 16:40:33', 'admin', '2017-08-08 16:40:33', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('89', '1', '1', '2', '1', null, 'admin', '2017-08-09 10:13:55', 'admin', '2017-08-09 10:13:55', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('90', '1', '1', '2', '1', null, 'admin', '2017-08-10 15:51:28', 'admin', '2017-08-10 15:51:28', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('91', '1', '1', '2', '1', null, 'admin', '2017-10-16 19:06:27', 'admin', '2017-10-16 19:06:27', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('92', '1', '1', '2', '1', null, 'admin', '2017-10-18 13:41:27', 'admin', '2017-10-18 13:41:27', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('93', '1', '1', '2', '1', null, 'admin', '2017-10-18 13:46:01', 'admin', '2017-10-18 13:46:01', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('94', '1', '1', '2', '1', null, 'admin', '2017-10-18 13:47:42', 'admin', '2017-10-18 13:47:42', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('95', '1', '1', '2', '1', null, 'admin', '2017-10-18 13:48:05', 'admin', '2017-10-18 13:48:05', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('96', '1', '1', '2', '1', null, 'admin', '2017-10-18 13:50:37', 'admin', '2017-10-18 13:50:37', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('97', '1', '1', '2', '1', null, 'admin', '2017-10-18 13:53:45', 'admin', '2017-10-18 13:53:45', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('98', '1', '1', '2', '1', null, 'admin', '2017-10-18 14:05:43', 'admin', '2017-10-18 14:05:43', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('99', '1', '1', '2', '1', null, 'admin', '2017-10-18 14:41:02', 'admin', '2017-10-18 14:41:02', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('100', '1', '1', '2', '1', null, 'admin', '2017-10-18 14:54:14', 'admin', '2017-10-18 14:54:14', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('101', '1', '1', '2', '1', null, 'admin', '2017-10-18 15:44:58', 'admin', '2017-10-18 15:44:58', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('102', '1', '1', '2', '1', null, 'admin', '2017-10-19 10:50:45', 'admin', '2017-10-19 10:50:45', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('103', '2', '1', '2', '1', null, 'admin', '2017-10-19 14:08:36', 'admin', '2017-10-19 14:08:36', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('104', '6', '1', '2', '1', null, 'admin', '2017-10-19 14:12:17', 'admin', '2017-10-19 14:12:17', null, null, null);
INSERT INTO `ull_user_login_logout_log` VALUES ('105', '6', '1', '2', '1', null, 'admin', '2017-10-19 14:12:28', 'admin', '2017-10-19 14:12:28', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('106', '2', '1', '2', '1', null, 'admin', '2017-10-19 14:17:39', 'admin', '2017-10-19 14:17:39', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('107', '2', '1', '2', '1', null, 'admin', '2017-10-19 14:19:40', 'admin', '2017-10-19 14:19:40', '1', 'default', 'a');
INSERT INTO `ull_user_login_logout_log` VALUES ('108', '1', '1', '2', '1', null, 'admin', '2017-10-19 14:21:05', 'admin', '2017-10-19 14:21:05', '1', 'default', 'a');

-- ----------------------------
-- Table structure for `wit_wishlist`
-- ----------------------------
DROP TABLE IF EXISTS `wit_wishlist`;
CREATE TABLE `wit_wishlist` (
  `WIT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `DSR_ID` int(11) DEFAULT NULL COMMENT '借卖方id，关联dsr表',
  `PRO_ID` int(11) NOT NULL COMMENT '外键 关联Pro表主键',
  `CREATED_BY` varchar(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NULL DEFAULT NULL,
  `LAST_UPDATE_BY` varchar(20) DEFAULT NULL,
  `LAST_UPDATE_DATE` timestamp NULL DEFAULT NULL,
  `CALL_CNT` int(11) DEFAULT NULL,
  `REMARK` varchar(50) DEFAULT NULL,
  `STS_CD` char(1) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`WIT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wit_wishlist
-- ----------------------------
