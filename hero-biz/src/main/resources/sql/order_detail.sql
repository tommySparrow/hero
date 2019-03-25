/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : stu

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 25/01/2019 18:03:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oder_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `oder_detail`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `order_id` int(11) DEFAULT NULL COMMENT '对应my_order表主键',
  `total_price` int(11) NULL DEFAULT NULL COMMENT '总价',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
