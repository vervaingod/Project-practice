/*
Navicat MySQL Data Transfer

Source Server         : 192.168.207.35_3306
Source Server Version : 50173
Source Host           : 192.168.207.35:3306
Source Database       : thefourthmeeting

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-08-30 11:27:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentid` int(11) NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('14', '外交部');
INSERT INTO `department` VALUES ('15', '人事部');
INSERT INTO `department` VALUES ('16', '市场部');
INSERT INTO `department` VALUES ('17', '后勤部');
INSERT INTO `department` VALUES ('18', '公关部');
INSERT INTO `department` VALUES ('19', '技术部');
INSERT INTO `department` VALUES ('21', 'A部');
INSERT INTO `department` VALUES ('23', 'C部');
INSERT INTO `department` VALUES ('25', 'B部');
INSERT INTO `department` VALUES ('26', 'F部');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employeeid` int(11) NOT NULL AUTO_INCREMENT,
  `employeename` varchar(50) DEFAULT NULL,
  `accountname` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `departmentid` int(11) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0',
  `role` int(1) unsigned zerofill DEFAULT '0',
  PRIMARY KEY (`employeeid`),
  KEY `accountname` (`accountname`),
  KEY `departmentid` (`departmentid`),
  CONSTRAINT `departmentid` FOREIGN KEY (`departmentid`) REFERENCES `department` (`departmentid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'mary', 'Bob', '123123', '16', '18735191390', '73636@qq.com', '0', '0');
INSERT INTO `employee` VALUES ('3', 'linda', 'ss', '123123', '15', '15334394325', 'sdfa@qq.com', '1', '1');
INSERT INTO `employee` VALUES ('4', 'ddd', 'yy', '123456', '19', '15643654862', 'nihao@qq.com', '1', '0');
INSERT INTO `employee` VALUES ('5', 'haha', 'haha', '111112', '17', '584156', 'fs@qq.com', '0', '0');
INSERT INTO `employee` VALUES ('6', 'web', 'web', '111112', '17', '54534351', 'fds@qq.com', '0', '0');

-- ----------------------------
-- Table structure for meetinginfo
-- ----------------------------
DROP TABLE IF EXISTS `meetinginfo`;
CREATE TABLE `meetinginfo` (
  `meetingid` int(11) NOT NULL AUTO_INCREMENT,
  `meetingname` varchar(255) NOT NULL,
  `capacity` varchar(50) DEFAULT NULL,
  `numofattendents` int(255) DEFAULT NULL,
  `startdate` varchar(50) DEFAULT NULL,
  `enddate` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `accountname` varchar(255) DEFAULT NULL,
  `meetingstatus` int(1) unsigned zerofill DEFAULT '1',
  `deletereason` varchar(255) DEFAULT NULL,
  `adddate` datetime DEFAULT NULL,
  `selectEmployees` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`meetingid`),
  KEY `roomnumber` (`capacity`),
  KEY `accountname` (`accountname`),
  CONSTRAINT `capacity` FOREIGN KEY (`capacity`) REFERENCES `meetingroom` (`capacity`) ON DELETE CASCADE,
  CONSTRAINT `accountname` FOREIGN KEY (`accountname`) REFERENCES `employee` (`accountname`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meetinginfo
-- ----------------------------
INSERT INTO `meetinginfo` VALUES ('6', '业务峰会', '第十会议室', '11', '2015-9-10 10：00：00', '2015-9-10 12：00：00', '阿斯大时代飞', 'Bob', '1', '', '2015-08-30 09:47:59', '4,7,');
INSERT INTO `meetinginfo` VALUES ('8', '工作会议', '第十会议室', '50', '2015-8-30 10:00:00', '2015-8-30 12:00:00', '工作会议', 'ss', '0', '啊发我饿', '2015-08-26 10:05:00', '3,8,');

-- ----------------------------
-- Table structure for meetingroom
-- ----------------------------
DROP TABLE IF EXISTS `meetingroom`;
CREATE TABLE `meetingroom` (
  `roomnumber` int(11) NOT NULL,
  `capacity` varchar(255) DEFAULT NULL,
  `roomcapacity` int(255) DEFAULT NULL,
  `status` int(1) DEFAULT '0',
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roomnumber`),
  KEY `capacity` (`capacity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meetingroom
-- ----------------------------
INSERT INTO `meetingroom` VALUES ('201', '第三会议室', '40', '0', '第三会议室');
INSERT INTO `meetingroom` VALUES ('205', '测试', '100', '0', '这是测试数据');
INSERT INTO `meetingroom` VALUES ('206', 'god阳的测试会议室', '100', '1', 'god阳的测试会议室');
INSERT INTO `meetingroom` VALUES ('208', '第三会议室', '100', '1', '哈');
INSERT INTO `meetingroom` VALUES ('209', 'A01会议室', '50', '1', '这是A01班的专教');
INSERT INTO `meetingroom` VALUES ('210', 'god阳的专用会议室', '100', '0', '这是god阳的专用会议室');
INSERT INTO `meetingroom` VALUES ('211', 'A02专教', '80', '1', '这是A02班的专教');
INSERT INTO `meetingroom` VALUES ('226', '安卓实验室', '100', '1', '这是安卓的专用实验室');
INSERT INTO `meetingroom` VALUES ('255', '专用会议室', '20', '1', '这是专用会议室');
INSERT INTO `meetingroom` VALUES ('289', 'A04专教', '100', '0', '这是A04的专教');
INSERT INTO `meetingroom` VALUES ('406', '第十会议室', '100', '0', '哈');
