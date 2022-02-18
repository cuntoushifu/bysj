CREATE DATABASE yiqing CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
USE yiqing;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authentication
-- ----------------------------
DROP TABLE IF EXISTS `authentication`;
CREATE TABLE `authentication`  (
                                   `id` INT(11) NOT NULL AUTO_INCREMENT,
                                   `description` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                   `name` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for base
-- ----------------------------
DROP TABLE IF EXISTS `base`;
CREATE TABLE `base`  (
                         `id` INT(11) NOT NULL AUTO_INCREMENT,
                         `idCard` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `name` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `age` INT(11) NULL DEFAULT NULL,
                         `gender` CHAR(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `address` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `phone` BIGINT(11) NULL DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE,
                         UNIQUE INDEX `idCard`(`idCard`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 79 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for cure
-- ----------------------------
DROP TABLE IF EXISTS `cure`;
CREATE TABLE `cure`  (
                         `baseId` INT(11) NOT NULL,
                         `dischargeDate` DATE NULL DEFAULT NULL,
                         `current` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         PRIMARY KEY (`baseId`) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for dead
-- ----------------------------
DROP TABLE IF EXISTS `dead`;
CREATE TABLE `dead`  (
                         `baseId` INT(11) NOT NULL,
                         `deadTime` DATE NULL DEFAULT NULL,
                         PRIMARY KEY (`baseId`) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for inspect
-- ----------------------------
DROP TABLE IF EXISTS `inspect`;
CREATE TABLE `inspect`  (
                            `testId` INT(11) NOT NULL AUTO_INCREMENT,
                            `baseId` INT(11) NOT NULL,
                            `testDate` DATE NULL DEFAULT NULL,
                            `ctTest` VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `nuTest` VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            PRIMARY KEY (`testId`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
                            `baseId` INT(11) NOT NULL,
                            `infectionSource` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `onsetDate` DATE NULL DEFAULT NULL,
                            `symptoms` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `hospital` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `critical` VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            `note` VARCHAR(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                            PRIMARY KEY (`baseId`) USING BTREE
) ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for touch
-- ----------------------------
DROP TABLE IF EXISTS `touch`;
CREATE TABLE `touch`  (
                          `baseId` INT(11) NULL DEFAULT NULL,
                          `comeFrom` VARCHAR(56) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `isoAddress` VARCHAR(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `startDate` DATE NULL DEFAULT NULL,
                          `finished` ENUM('是','否') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `id` INT(11) NOT NULL AUTO_INCREMENT,
                         `username` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                         `password` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `phone` INT(11) NULL DEFAULT NULL,
                         `unit` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `name` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Table structure for user_authorities
-- ----------------------------
DROP TABLE IF EXISTS `user_authorities`;
CREATE TABLE `user_authorities`  (
                                     `id` INT(11) NOT NULL AUTO_INCREMENT,
                                     `authentication_id` INT(11) NULL DEFAULT NULL,
                                     `user_id` INT(11) NULL DEFAULT NULL,
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

SET FOREIGN_KEY_CHECKS = 1;
