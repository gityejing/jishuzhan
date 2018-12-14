/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : db1

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2016-07-06 22:05:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `books`
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '���',
  `title` varchar(100) NOT NULL COMMENT '����',
  `price` decimal(10,2) DEFAULT NULL COMMENT '�۸�',
  `publishDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '��������',
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', 'Java���˼��', '98.50', '2005-01-02 00:00:00');
INSERT INTO `books` VALUES ('2', 'HeadFirst���ģʽ', '55.70', '2010-11-09 00:00:00');
INSERT INTO `books` VALUES ('3', '��һ��Android����', '69.90', '2015-06-23 00:00:00');
INSERT INTO `books` VALUES ('4', 'C++���˼��', '88.50', '2004-01-09 00:00:00');
INSERT INTO `books` VALUES ('5', 'HeadFirst Java', '55.70', '2013-12-17 00:00:00');
INSERT INTO `books` VALUES ('6', '���Android', '19.50', '2014-07-31 00:00:00');