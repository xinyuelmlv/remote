/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50515
Source Host           : localhost:3306


Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2017-03-29 19:37:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `e_order`
-- ----------------------------
DROP TABLE IF EXISTS `e_order`;
CREATE TABLE `e_order` (
  `id` bigint(20) NOT NULL PRIMARY KEY auto_increment,
  `cost` double NOT NULL,
  `num` int(11) NOT NULL,
  `price` double NOT NULL,
  `refund_status` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `num_iid` bigint(20) DEFAULT NULL,
  `tid` bigint(20) DEFAULT NULL,
  KEY `FK18vc8h7d9kyc3632c7a4y6w0l` (`num_iid`),
  KEY `FK49vkqj4watuenfvhajepmgd8v` (`tid`),
  CONSTRAINT `FK49vkqj4watuenfvhajepmgd8v` FOREIGN KEY (`tid`) REFERENCES `e_trade` (`tid`),
  CONSTRAINT `FK18vc8h7d9kyc3632c7a4y6w0l` FOREIGN KEY (`num_iid`) REFERENCES `e_product` (`num_iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_order
-- ----------------------------

-- ----------------------------
-- Table structure for `e_product`
-- ----------------------------
DROP TABLE IF EXISTS `e_product`;
CREATE TABLE `e_product` (
  `num_iid` bigint(20) NOT NULL,
  `apprrove_status` varchar(255) DEFAULT NULL,
  `modified` varchar(255) DEFAULT NULL,
  `num` bigint(20) NOT NULL,
  `price` double NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `u_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`num_iid`),
  KEY `FKspni8rvif0ua45uj217y0n033` (`u_id`),
  CONSTRAINT `FKspni8rvif0ua45uj217y0n033` FOREIGN KEY (`u_id`) REFERENCES `e_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_product
-- ----------------------------

-- ----------------------------
-- Table structure for `e_product_cost`
-- ----------------------------
DROP TABLE IF EXISTS `e_product_cost`;
CREATE TABLE `e_product_cost` (
  `id` bigint(20) NOT NULL PRIMARY KEY auto_increment,
  `begin_date` datetime DEFAULT NULL,
  `cost` double NOT NULL,
  `end_date` datetime DEFAULT NULL,
  `num_iid` bigint(20) DEFAULT NULL,
  KEY `FKjbi6xbw7srx8neoah0rs4lvu4` (`num_iid`),
  CONSTRAINT `FKjbi6xbw7srx8neoah0rs4lvu4` FOREIGN KEY (`num_iid`) REFERENCES `e_product` (`num_iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_product_cost
-- ----------------------------

-- ----------------------------
-- Table structure for `e_trade`
-- ----------------------------
DROP TABLE IF EXISTS `e_trade`;
CREATE TABLE `e_trade` (
  `tid` bigint(20) NOT NULL,
  `created` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `modified_time` varchar(255) DEFAULT NULL,
  `pay_time` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_fee` double DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `FKkyjxif23sivvtmm5d06k9y29v` (`user_id`),
  CONSTRAINT `FKkyjxif23sivvtmm5d06k9y29v` FOREIGN KEY (`user_id`) REFERENCES `e_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `order_report`;
CREATE TABLE `order_report` (
  `tid` bigint(20) NOT NULL,
  `product_cost` double DEFAULT NULL,
  `extra_cost` double DEFAULT NULL,
  `total_fee` double DEFAULT NULL,
  `gain` double DEFAULT NULL,
  `report_date` varchar(255) DEFAULT NULL,
   `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_trade
-- ----------------------------

-- ----------------------------
-- Table structure for `e_user`
-- ----------------------------
DROP TABLE IF EXISTS `e_user`;
CREATE TABLE `e_user` (
  `user_id` bigint(20) NOT NULL,
  `nick` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of e_user
-- ----------------------------

