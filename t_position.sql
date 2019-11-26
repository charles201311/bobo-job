/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : 1707e

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2019-11-26 10:28:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_position`
-- ----------------------------
DROP TABLE IF EXISTS `t_position`;
CREATE TABLE `t_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_position
-- ----------------------------
INSERT INTO `t_position` VALUES ('1', '经理');
INSERT INTO `t_position` VALUES ('2', '会计');
INSERT INTO `t_position` VALUES ('3', '出纳');
INSERT INTO `t_position` VALUES ('4', '销售');

-- ----------------------------
-- Table structure for `t_score`
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score` (
  `pid` int(11) NOT NULL DEFAULT '0',
  `uid` int(11) NOT NULL DEFAULT '0',
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`,`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_score
-- ----------------------------
INSERT INTO `t_score` VALUES ('1', '10', '80');
INSERT INTO `t_score` VALUES ('1', '11', '88');
INSERT INTO `t_score` VALUES ('1', '12', '60');
INSERT INTO `t_score` VALUES ('2', '10', '90');
INSERT INTO `t_score` VALUES ('2', '12', '70');
INSERT INTO `t_score` VALUES ('4', '11', '90');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `created` date DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `picUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('10', '李四', '2019-12-12', null, '男', '9134633e-f536-445f-833a-7165c25e7d32.png');
INSERT INTO `t_user` VALUES ('11', '赵六', '2019-12-12', null, '女', 'e7a8fdbd-f5a0-46cc-8526-38d6bc432fd0.png');
INSERT INTO `t_user` VALUES ('12', '赵六', '2010-12-12', null, '男', 'db74e015-919c-4e1e-a639-3c44952fc429.png');
