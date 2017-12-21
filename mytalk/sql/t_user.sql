/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : mytalk

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-12-21 14:26:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `head_image` varchar(255) DEFAULT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('8983fdb5-da31-11e7-bb90-3464a922c036', 'origen', '95a4c4522dfddcf64ff23c8c52af2c60e912801f818eace46e942048e7bd227fa52d42f4cc61371d', '123@qq.com', 'chaoer', null, null, '2017-12-06 10:59:45');
SET FOREIGN_KEY_CHECKS=1;
