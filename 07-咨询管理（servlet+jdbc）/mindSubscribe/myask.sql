/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : myask

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 03/08/2020 15:01:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `admin_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用于登录的管理员账户',
  `admin_pwd` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用于登录的密码',
  `name` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '管理员姓名',
  `sex` int(1) NULL DEFAULT NULL COMMENT '0女，1男',
  `age` int(3) NULL DEFAULT NULL COMMENT '管理员年龄',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '管理员电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '管理员电子邮件',
  `is_active` int(1) NULL DEFAULT NULL COMMENT '管理员账户状态  0停用，1激活',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '管理员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (4, 'admin', 'admin', 'jack', 1, 20, NULL, NULL, 1);

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `announcement_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '公告标题',
  `context` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '公告的内容',
  `creater_id` int(9) NULL DEFAULT NULL COMMENT '公告的创建者id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '公告发布时间',
  `is_active` int(1) NULL DEFAULT NULL COMMENT '0 不显示，1显示',
  PRIMARY KEY (`announcement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '公告面板，发布通知' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`  (
  `client_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '来访者的id主键',
  `client_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '来访者登录的普通账户',
  `client_pwd` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '来访者登录的密码',
  `name` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '来访者姓名',
  `sex` int(1) NULL DEFAULT NULL COMMENT '0女，1男',
  `age` int(3) NULL DEFAULT NULL COMMENT '来访者年龄',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '来访者电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '来访者电子邮件',
  `is_active` int(1) NULL DEFAULT NULL COMMENT '来访者账户状态  0停用，1激活',
  `region_time` datetime NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '来访者，普通需要咨询的人' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for client_archive
-- ----------------------------
DROP TABLE IF EXISTS `client_archive`;
CREATE TABLE `client_archive`  (
  `archives_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '咨询者的一次咨询记录',
  `client_id` int(9) NOT NULL COMMENT '本次咨询的，来访者的id',
  `doctor_id` int(9) NOT NULL COMMENT '本次咨询的，咨询师的id',
  `client_description` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '无' COMMENT '申请人的主观描述',
  `question_context` varchar(5000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '未填写' COMMENT '申请人做的问卷 内容 ',
  `level` int(3) NOT NULL DEFAULT 0 COMMENT '等级分数',
  `apply_time` datetime NOT NULL COMMENT '申请时间',
  `expect_place` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '未填写' COMMENT '申请人期望的咨询地点，最终只是一个参考',
  `expect_time` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '未填写' COMMENT '申请人期望的咨询时间，最终只是一个参考',
  `start_datetime` datetime NULL DEFAULT NULL COMMENT '咨询开始时间，几月几日几时',
  `end_datetime` datetime NULL DEFAULT NULL COMMENT '咨询结束时间，几月几日几时',
  `sub_place` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '未填写' COMMENT '咨询具体地点',
  `status` int(1) NOT NULL DEFAULT 0 COMMENT '-1 失败，0 申请中，1 通过申请但未完成，2完成咨询但未完善资料,3全部完成',
  `doc_path` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '一次咨询的记录文档，命名：日期_来访者id_咨询师id.xxx',
  `second_question_context` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '未回访' COMMENT '回访记录内容',
  `is_second_do` int(1) NOT NULL DEFAULT 0 COMMENT '是否回访,0否，1是',
  PRIMARY KEY (`archives_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '来访者的一次咨询的档案' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `doctor_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `doctor_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '咨询师登录的普通账户',
  `doctor_pwd` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用于登录的密码',
  `name` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '咨询师姓名',
  `sex` int(1) NULL DEFAULT NULL COMMENT '0女，1男',
  `age` int(3) NULL DEFAULT NULL COMMENT '咨询师年龄',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '咨询师电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '咨询师电子邮件',
  `is_active` int(1) NULL DEFAULT NULL COMMENT '咨询师账户状态  0停用，1激活',
  `level` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '咨询师等级（一级、二级 等）',
  `skill` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '咨询师擅长方向（家庭、亲密关系，挫折等）',
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '展示给来访者的 个人照片',
  `place` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '咨询师 的咨询地点',
  PRIMARY KEY (`doctor_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '心理咨询师用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` int(9) NOT NULL AUTO_INCREMENT,
  `sender` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '发送者身份，admin 管理员，doctor 咨询师，client 咨询者',
  `sender_id` int(9) NOT NULL COMMENT '发送者的id',
  `sender_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '发送者名字',
  `receiver` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接受者身份，admin 管理员，doctor 咨询师，client 咨询者',
  `receiver_id` int(9) NOT NULL COMMENT '接受者id',
  `receiver_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接受者名字',
  `send_time` datetime NULL DEFAULT NULL COMMENT '发送时间',
  `is_read` int(1) NULL DEFAULT NULL COMMENT '是否已经读过了，0 未读，1 已读',
  `context` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '消息内容',
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for message_board
-- ----------------------------
DROP TABLE IF EXISTS `message_board`;
CREATE TABLE `message_board`  (
  `board_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '留言主键id',
  `context` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '留言的内容',
  `creater_id` int(9) NULL DEFAULT NULL COMMENT '留言的创建者id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '留言时间',
  `is_active` int(1) NULL DEFAULT NULL COMMENT '0 不显示，1显示',
  PRIMARY KEY (`board_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `question_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '一个问卷题目id',
  `question_num` int(5) NOT NULL COMMENT '题目题号，按照题号排列题目',
  `context` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '题目内容',
  `answer_yes_score` int(1) NOT NULL COMMENT '回答是的分值',
  `answer_no_score` int(1) NOT NULL COMMENT '回答否的分值',
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
