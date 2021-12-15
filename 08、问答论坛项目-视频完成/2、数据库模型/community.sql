/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : community

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2020-08-03 00:15:26
*/
CREATE DATABASE /*!32312 IF NOT EXISTS*/`community` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `community`;

-- ----------------------------
-- Table structure for ad
-- ----------------------------
DROP TABLE IF EXISTS `ad`;
CREATE TABLE `ad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `image` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `gmt_start` bigint(20) DEFAULT NULL,
  `gmt_end` bigint(20) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `pos` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ad
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL,
  `type` int(11) NOT NULL,
  `commentator` bigint(20) NOT NULL,
  `gmt_create` bigint(20) NOT NULL,
  `gmt_modified` bigint(20) NOT NULL,
  `like_count` bigint(20) DEFAULT '0',
  `content` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `comment_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '1', '1596359548107', '1596359548107', '0', '是这样的没错', '2');
INSERT INTO `comment` VALUES ('2', '1', '2', '1', '1596359594520', '1596359594520', '0', '约等于', null);
INSERT INTO `comment` VALUES ('3', '1', '2', '1', '1596359607804', '1596359607804', '0', '驱蚊器翁', null);
INSERT INTO `comment` VALUES ('4', '2', '1', '1', '1596381574510', '1596381574510', '0', '学java，到硅谷，多年的java讲师带你系统学习java ，带你飞。', '0');

-- ----------------------------
-- Table structure for nav
-- ----------------------------
DROP TABLE IF EXISTS `nav`;
CREATE TABLE `nav` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `url` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `priority` int(11) DEFAULT '0',
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of nav
-- ----------------------------

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `notifier` bigint(20) NOT NULL,
  `receiver` bigint(20) NOT NULL,
  `outerid` bigint(20) NOT NULL,
  `type` int(11) NOT NULL,
  `gmt_create` bigint(20) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `notifier_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `outer_title` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of notification
-- ----------------------------

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `description` text COLLATE utf8_bin,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  `comment_count` int(11) DEFAULT '0',
  `view_count` int(11) DEFAULT '0',
  `like_count` int(11) DEFAULT '0',
  `tag` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '哈哈哈', 0xE59388E595A5E595A5, '1596359070072', '1596359070072', '1', '1', '9', '0', 'javascript,php,node.js,django,ubuntu,nosql memcached,xcode intellij-idea');
INSERT INTO `question` VALUES ('2', '如何学习java', 0xE69C80E8BF91E59CA8E5ADA6E4B9A06A617661EFBC8CE5A682E4BD95E6898DE883BDE69BB4E7B3BBE7BB9FE79A84E5ADA6E4B9A0E591A2EFBC9F, '1596381515271', '1596381515271', '1', '1', '2', '0', 'java');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `token` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `bio` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `avatar_url` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '16026864', null, '3821b8a5-1678-4b56-bc5d-4daf182c3ed2', '1596358561547', '1596381404939', null, 'https://avatars3.githubusercontent.com/u/16026864?v=4');
