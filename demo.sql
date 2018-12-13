/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 13/12/2018 15:58:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lmx_app
-- ----------------------------
DROP TABLE IF EXISTS `lmx_app`;
CREATE TABLE `lmx_app`  (
  `app_id` int(11) NOT NULL AUTO_INCREMENT,
  `app_key` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `app_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `app_introduce` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `app_create_time` date DEFAULT NULL,
  PRIMARY KEY (`app_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lmx_app
-- ----------------------------
INSERT INTO `lmx_app` VALUES (1, '手机理财', '银联', '省费！', '2018-11-20');
INSERT INTO `lmx_app` VALUES (2, '商务应用', 'WPS', '好用！', '2018-11-20');
INSERT INTO `lmx_app` VALUES (3, '娱乐', '网易云音乐', '好听！', '2018-11-20');
INSERT INTO `lmx_app` VALUES (6, '游戏', '刺激战场', '好听！', '2008-10-11');

-- ----------------------------
-- Table structure for lmx_version
-- ----------------------------
DROP TABLE IF EXISTS `lmx_version`;
CREATE TABLE `lmx_version`  (
  `version_id` int(11) NOT NULL AUTO_INCREMENT,
  `app_id` int(11) NOT NULL,
  `version_key` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `app_key` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version_tag` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `update_time` date NOT NULL,
  PRIMARY KEY (`version_id`) USING BTREE,
  INDEX `version_app_fk`(`app_id`) USING BTREE,
  CONSTRAINT `version_app_fk` FOREIGN KEY (`app_id`) REFERENCES `lmx_app` (`app_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lmx_version
-- ----------------------------
INSERT INTO `lmx_version` VALUES (1, 1, '版本一', '手机理财', '1.1.0', '2018-11-21');
INSERT INTO `lmx_version` VALUES (2, 2, '版本二', '商务应用', '1.0.0', '2018-11-20');
INSERT INTO `lmx_version` VALUES (3, 6, '版本三', '游戏', '1.0.0', '2009-11-20');
INSERT INTO `lmx_version` VALUES (4, 6, '第一版本', '游戏', '1.0.1', '2009-11-20');

-- ----------------------------
-- Table structure for sys_app
-- ----------------------------
DROP TABLE IF EXISTS `sys_app`;
CREATE TABLE `sys_app`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `APP_NAME` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `APP_INTRODUCE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `APP_VERSION` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_app
-- ----------------------------
INSERT INTO `sys_app` VALUES (1, '课堂考勤', '随机验证码考勤', '1.1版本');
INSERT INTO `sys_app` VALUES (8, '钉钉', '打卡', '3.3.4');
INSERT INTO `sys_app` VALUES (15, '霜霜千年', '一个只做好歌的APP', '1.1.0');

SET FOREIGN_KEY_CHECKS = 1;
