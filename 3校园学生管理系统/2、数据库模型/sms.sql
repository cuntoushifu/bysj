/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.28 : Database - ssm_sms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm_sms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ssm_sms`;

/*Table structure for table `tb_admin` */

DROP TABLE IF EXISTS `tb_admin`;

CREATE TABLE `tb_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(12) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `portrait_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8;

/*Data for the table `tb_admin` */

insert  into `tb_admin`(`id`,`name`,`gender`,`password`,`email`,`telephone`,`address`,`portrait_path`) values (155,'admin','男','admin','3083968068@qq.com','15111111111','北京',NULL);

/*Table structure for table `tb_clazz` */

DROP TABLE IF EXISTS `tb_clazz`;

CREATE TABLE `tb_clazz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `number` int(3) DEFAULT NULL,
  `introducation` varchar(200) DEFAULT NULL,
  `coordinator` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(12) DEFAULT NULL,
  `grade_name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_clazz` */

insert  into `tb_clazz`(`id`,`name`,`number`,`introducation`,`coordinator`,`email`,`telephone`,`grade_name`) values (1,'一年一班',30,'小花的一年一班好','小花花','xiaohua@163.com','13854389438','一年级');

/*Table structure for table `tb_grade` */

DROP TABLE IF EXISTS `tb_grade`;

CREATE TABLE `tb_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL DEFAULT '',
  `manager` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(12) DEFAULT NULL,
  `introducation` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_grade` */

insert  into `tb_grade`(`id`,`name`,`manager`,`email`,`telephone`,`introducation`) values (1,'一年级','大熊','daxiong@163.com','13838385438','一年级小学生'),(2,'二年级','小熊','xiaoxiong@163.com','13232323232','二年级小学生'),(3,'三年级','小圆','xiaoyuan@163.com','15858589458','三年级 小学生'),(4,'四年级',' 光头强','qiangge@163.com','19212345678','四年级小学生');

/*Table structure for table `tb_student` */

DROP TABLE IF EXISTS `tb_student`;

CREATE TABLE `tb_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sno` varchar(20) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(12) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `introducation` varchar(200) DEFAULT NULL,
  `portrait_path` varchar(200) DEFAULT NULL,
  `clazz_name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_student` */

insert  into `tb_student`(`id`,`sno`,`name`,`gender`,`password`,`email`,`telephone`,`address`,`introducation`,`portrait_path`,`clazz_name`) values (1,'0001','王小强','男','111111','xiaoqiang@163.com','13112345678','北京天通苑','不好好学习','','一年一班');

/*Table structure for table `tb_teacher` */

DROP TABLE IF EXISTS `tb_teacher`;

CREATE TABLE `tb_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tno` varchar(20) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(12) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `portrait_path` varchar(200) DEFAULT NULL,
  `clazz_name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_teacher` */

insert  into `tb_teacher`(`id`,`tno`,`name`,`gender`,`password`,`email`,`telephone`,`address`,`portrait_path`,`clazz_name`) values (1,'0038','小花','女','123456','xiaohua@163.com','13854389438','学习宿舍','','一年一班');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
