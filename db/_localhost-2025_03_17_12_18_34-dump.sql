-- MySQL dump 10.13  Distrib 5.7.31, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: lijunxi-auth
-- ------------------------------------------------------
-- Server version	5.7.31-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '部门名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '上级部门id',
  `tree_path` varchar(255) DEFAULT ',' COMMENT '树结构',
  `sort_value` int(11) DEFAULT '1' COMMENT '排序',
  `leader` varchar(20) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态（1正常 0停用）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 1:已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2018 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='组织机构';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (1,'XXX集团有限公司',0,',1,',1,'CEO','15659090912',1,'2025-03-15 15:05:46','2025-03-15 15:05:46',0),(10,'湖南分公司',1,',1,10,',1,'李经理','18790007789',1,'2025-03-15 15:05:46','2025-03-15 15:05:46',0),(20,'上海分公司',1,',1,20,',1,'王经理','15090987678',1,'2025-03-15 15:05:46','2025-03-15 15:05:46',0),(30,'深圳分公司',1,',1,30,',1,'陈经理','15090987678',1,'2025-03-15 15:05:46','2025-03-15 15:05:46',0),(1010,'研发部',10,',1,10,1010,',1,'赵总监','15090987678',1,'2025-03-15 15:08:08','2025-03-15 15:08:08',0),(1020,'运营部',10,',1,10,1020,',1,'王总监','15090987678',1,'2025-03-15 15:11:05','2025-03-15 15:11:05',0),(1021,'后端开发工程师',1010,',1,10,1010,1021,',1,'张工','15090987678',1,'2025-03-15 15:13:02','2025-03-15 15:13:02',0),(1022,'大数据开发工程师',1010,',1,10,1010,1022,',1,'李工','15090987678',1,'2025-03-15 15:13:02','2025-03-15 15:13:02',0),(1024,'前端开发工程师',1010,',1,10,1010,1024,',1,'陈工','15090987678',1,'2025-03-15 15:13:02','2025-03-15 15:13:02',0),(1025,'客服',1020,',1,10,1020,1025,',1,'小明','15090987678',1,'2025-03-15 15:13:02','2025-03-15 15:13:02',0),(1026,'网站推广',1020,',1,10,1020,1026,',1,'老刘','15090987678',1,'2025-03-15 15:13:02','2025-03-15 15:13:02',0),(1027,'运营部门',1020,',1,10,1020,1027,',1,'李总监','15090987678',1,'2025-03-15 15:09:46','2025-03-15 15:09:46',0),(1028,'设计',1020,',1,10,1020,1028,',1,'乐乐','15090987678',1,'2025-03-15 15:13:02','2025-03-15 15:13:02',0),(2012,'研发部',20,',1,20,2012,',1,'陆总监','18909890765',1,'2025-03-15 15:08:08','2025-03-15 15:08:08',0),(2013,'研发部',30,',1,30,2013,',1,'王总监','18567867895',1,'2025-03-15 15:08:08','2025-03-15 15:08:08',0),(2016,'后端开发工程师',2012,',1,20,2012,2012,',1,'吴工','15090909909',1,'2025-03-15 15:13:02','2025-03-15 15:13:02',0),(2017,'大数据开发工程师',2012,',1,20,2012,2012,',1,'孙工','15090980989',1,'2025-03-15 15:13:02','2025-03-15 15:13:02',0);
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_login_log`
--

DROP TABLE IF EXISTS `sys_login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `username` varchar(50) DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) DEFAULT '' COMMENT '登录IP地址',
  `status` tinyint(1) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示信息',
  `access_time` datetime DEFAULT NULL COMMENT '访问时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 1:已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1900888001941131268 DEFAULT CHARSET=utf8 COMMENT='系统访问记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_login_log`
--

LOCK TABLES `sys_login_log` WRITE;
/*!40000 ALTER TABLE `sys_login_log` DISABLE KEYS */;
INSERT INTO `sys_login_log` VALUES (1,'admin','0:0:0:0:0:0:0:1',1,'登录成功',NULL,'2024-12-22 11:47:00','2024-12-22 11:47:00',0),(2,'admin','127.0.0.1',1,'登录成功',NULL,'2024-12-22 11:47:00','2024-12-22 11:47:00',0),(3,'admin','127.0.0.1',1,'登录成功',NULL,'2025-03-02 04:10:40',NULL,0),(4,'admin','127.0.0.1',1,'登录成功',NULL,'2025-03-02 12:03:46',NULL,0),(1900887987273650177,'lijunxi','127.0.0.1',1,'登录成功',NULL,'2025-03-15 12:33:07',NULL,0),(1900887993296670722,'lijunxi','127.0.0.1',1,'登录成功',NULL,'2025-03-15 12:33:09',NULL,0),(1900887997256093697,'lijunxi','127.0.0.1',1,'登录成功',NULL,'2025-03-15 12:33:09',NULL,0),(1900888000112414722,'lijunxi','127.0.0.1',1,'登录成功',NULL,'2025-03-15 12:33:10',NULL,0),(1900888001941131265,'lijunxi','127.0.0.1',1,'登录成功',NULL,'2025-03-15 12:33:11',NULL,0),(1900888001941131266,'lijunxi','127.0.0.1',1,'登录成功',NULL,'2025-03-15 12:52:11',NULL,0),(1900888001941131267,'admin','127.0.0.1',1,'登录成功',NULL,'2025-03-15 12:53:02',NULL,0);
/*!40000 ALTER TABLE `sys_login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '所属上级',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '名称',
  `type` tinyint(3) NOT NULL DEFAULT '0' COMMENT '类型(0:目录,1:菜单,2:按钮)',
  `path` varchar(100) DEFAULT NULL COMMENT '路由地址',
  `component` varchar(100) DEFAULT NULL COMMENT '组件路径',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `sort_value` int(11) DEFAULT NULL COMMENT '排序',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 1:已删除）',
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (2,0,'系统管理',0,'system','Layout',NULL,'el-icon-s-tools',1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(3,2,'用户管理',1,'sysUser','system/sysUser/index','','el-icon-s-custom',1,1,'2024-12-22 11:47:46','2025-02-17 11:17:08',0),(4,2,'角色管理',1,'sysRole','system/sysRole/index','','el-icon-user-solid',2,1,'2024-12-22 11:47:46','2025-02-17 11:17:08',0),(5,2,'菜单管理',1,'sysMenu','system/sysMenu/index','','el-icon-s-unfold',3,1,'2024-12-22 11:47:46','2025-02-17 11:17:08',0),(6,3,'查看',2,NULL,NULL,'bnt.sysUser.list',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(7,3,'添加',2,NULL,NULL,'bnt.sysUser.add',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(8,3,'修改',2,NULL,NULL,'bnt.sysUser.update',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(9,3,'删除',2,NULL,NULL,'bnt.sysUser.remove',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(10,4,'查看',2,NULL,NULL,'bnt.sysRole.list',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(11,4,'添加',2,NULL,NULL,'bnt.sysRole.add',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(12,4,'修改',2,NULL,NULL,'bnt.sysRole.update',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(13,4,'删除',2,NULL,NULL,'bnt.sysRole.remove',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(14,5,'查看',2,NULL,NULL,'bnt.sysMenu.list',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(15,5,'添加',2,NULL,NULL,'bnt.sysMenu.add',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(16,5,'修改',2,NULL,NULL,'bnt.sysMenu.update',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(17,5,'删除',2,NULL,NULL,'bnt.sysMenu.remove',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(18,3,'分配角色',2,NULL,NULL,'bnt.sysUser.assignRole',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(19,4,'分配权限',2,'assignAuth','system/sysRole/assignAuth','bnt.sysRole.assignAuth',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(20,2,'部门管理',1,'sysDept','system/sysDept/index','','el-icon-s-operation',4,1,'2024-12-22 11:47:46','2025-02-17 11:17:08',0),(21,20,'查看',2,NULL,NULL,'bnt.sysDept.list',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(22,2,'岗位管理',1,'sysPost','system/sysPost/index','','el-icon-more-outline',5,1,'2024-12-22 11:47:46','2025-02-17 11:17:08',0),(23,22,'查看',2,NULL,NULL,'bnt.sysPost.list',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(24,20,'添加',2,NULL,NULL,'bnt.sysDept.add',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(25,20,'修改',2,NULL,NULL,'bnt.sysDept.update',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(26,20,'删除',2,NULL,NULL,'bnt.sysDept.remove',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(27,22,'添加',2,NULL,NULL,'bnt.sysPost.add',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(28,22,'修改',2,NULL,NULL,'bnt.sysPost.update',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(29,22,'删除',2,NULL,NULL,'bnt.sysPost.remove',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(30,34,'操作日志',1,'sysOperLog','system/lsysOperLog/index','','el-icon-document-remove',7,1,'2024-12-22 11:47:46','2025-02-17 11:17:08',0),(31,30,'查看',2,NULL,NULL,'bnt.sysOperLog.list',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(32,34,'登录日志',1,'sysLoginLog','system/sysLoginLog/index','','el-icon-s-goods',8,1,'2024-12-22 11:47:46','2025-02-17 11:17:08',0),(33,32,'查看',2,NULL,NULL,'bnt.sysLoginLog.list',NULL,1,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(34,2,'日志管理',0,'log','ParentView','','el-icon-tickets',6,1,'2024-12-22 11:47:46','2024-12-22 11:47:46',0),(35,2,'测试菜单',1,'1','11','','el-icon-s-tools',1,1,'2025-02-10 08:28:12','2025-02-10 08:36:38',1),(36,2,'测试新增菜单',1,'/system/test','test/index','','el-icon-s-tools',1,1,'2025-03-15 06:42:18','2025-03-15 06:42:34',1);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_oper_log`
--

DROP TABLE IF EXISTS `sys_oper_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_oper_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) DEFAULT '' COMMENT '模块标题',
  `business_type` varchar(20) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operator_type` varchar(20) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) DEFAULT '' COMMENT '主机地址',
  `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 1:已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_oper_log`
--

LOCK TABLES `sys_oper_log` WRITE;
/*!40000 ALTER TABLE `sys_oper_log` DISABLE KEYS */;
INSERT INTO `sys_oper_log` VALUES (1,'角色管理','1','com.lijunxi.auth.controller.SysRoleController.save()','POST','1','admin','','/admin/auth/sysRole/save','','{\"param\":{},\"roleCode\":\"\",\"roleName\":\"test\",\"id\":5}','{\"code\":200,\"message\":\"成功\"}',0,'',NULL,'2025-03-02 04:10:40','2025-03-15 13:11:36',0),(2,'角色管理','DELETE','com.lijunxi.auth.controller.SysRoleController.save().auth.controller.SysRoleController.remove()','DELETE','MANAGE','admin','','/admin/auth/sysRole/remove/5','','','{\"code\":200,\"message\":\"成功\"}',0,'',NULL,'2025-03-02 12:03:46','2025-03-15 13:11:36',0),(3,'角色管理','DELETE','com.lijunxi.auth.controller.SysRoleController.save().auth.controller.SysRoleController.remove()','DELETE','MANAGE','admin','','/admin/auth/sysRole/remove/4','127.0.0.1','','{\"code\":200,\"message\":\"成功\"}',1,'',NULL,'2025-03-15 12:33:07','2025-03-15 13:11:36',0),(4,'角色管理','UPDATE','com.lijunxi.auth.controller.SysRoleController.save().auth.controller.SysRoleController.updateById()','PUT','MANAGE','admin','','/admin/auth/sysRole/update','127.0.0.1','{\"isDeleted\":0,\"createTime\":1622507920000,\"param\":{},\"roleCode\":\"\",\"roleName\":\"普通管理员\",\"description\":\"普通管理员\",\"updateTime\":1645670566000,\"id\":2}','{\"code\":200,\"message\":\"成功\"}',1,'',NULL,'2025-03-15 12:33:09','2025-03-15 13:11:36',0),(5,'菜单管理','UPDATE','com.lijunxi.auth.controller.SysRoleController.save().auth.controller.SysMenuController.updateById()','PUT','MANAGE','admin','','/admin/auth/sysMenu/update','127.0.0.1','{\"code\":\"SysRole\",\"select\":false,\"level\":3,\"updateTime\":1653287810000,\"type\":1,\"parentId\":2,\"isDeleted\":0,\"children\":[{\"code\":\"btn.SysRole.list\",\"select\":false,\"level\":4,\"updateTime\":1622460772000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"查看\",\"id\":10},{\"code\":\"btn.SysRole.add\",\"select\":false,\"level\":4,\"updateTime\":1653547976000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"添加\",\"id\":11},{\"code\":\"btn.SysRole.update\",\"select\":false,\"level\":4,\"updateTime\":1653547981000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"修改\",\"id\":12},{\"code\":\"btn.SysRole.remove\",\"select\":false,\"level\":4,\"updateTime\":1622507874000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1622455537000,\"param\":{},\"name\":\"删除\",\"id\":13},{\"code\":\"btn.SysRole.assignAuth\",\"select\":false,\"level\":4,\"toCode\":\"AssignAuth\",\"updateTime\":1653376735000,\"type\":2,\"parentId\":4,\"isDeleted\":0,\"children\":[],\"createTime\":1653297494000,\"param\":{},\"name\":\"分配权限\",\"id\":19}],\"createTime\":1622455537000,\"param\":{},\"name\":\"角色管理\",\"id\":4}','{\"code\":200,\"message\":\"成功\"}',1,'',NULL,'2025-03-15 12:33:09','2025-03-15 13:11:36',0),(6,'岗位管理','UPDATE','com.lijunxi.auth.controller.SysRoleController.save().auth.controller.SysPostController.updateById()','PUT','MANAGE','admin','','/admin/auth/sysPost/update','127.0.0.1','{\"isDeleted\":0,\"createTime\":1653359648000,\"param\":{},\"name\":\"总经理\",\"description\":\"2\",\"postCode\":\"zjl\",\"id\":6,\"status\":1}','{\"code\":200,\"message\":\"成功\"}',1,'',NULL,'2025-03-15 12:33:10','2025-03-15 13:11:36',0),(7,'岗位管理','INSERT','com.lijunxi.auth.controller.SysPostController.save()','POST','MANAGE','admin','','/admin/auth/sysPost/save','127.0.0.1','{\"param\":{},\"name\":\"网咨\",\"description\":\"\",\"postCode\":\"wz\",\"id\":7,\"status\":1}','{\"code\":200,\"message\":\"成功\"}',1,'',NULL,'2025-03-15 12:33:11','2025-03-15 13:11:36',0),(8,'岗位管理','DELETE','com.lijunxi.auth.controller.SysRoleController.save().auth.controller.SysPostController.remove()','DELETE','MANAGE','admin','','/admin/auth/sysPost/remove/7','127.0.0.1','','{\"code\":200,\"message\":\"成功\"}',1,'',NULL,'2025-03-15 12:52:11','2025-03-15 13:11:36',0),(9,'菜单管理','UPDATE','com.lijunxi.auth.controller.SysRoleController.save().auth.controller.SysMenuController.updateById()','PUT','MANAGE','admin','','/admin/auth/sysMenu/update','127.0.0.1','{\"code\":\"btn.sysDept.list\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653358064000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653358064000,\"param\":{},\"name\":\"查看\",\"id\":21}','{\"code\":200,\"message\":\"成功\"}',1,'',NULL,'2025-03-15 12:53:02','2025-03-15 13:11:36',0),(10,'菜单管理','UPDATE','com.lijunxi.auth.controller.SysRoleController.save().auth.controller.SysMenuController.updateById()','PUT','MANAGE','admin','','/admin/auth/sysMenu/update','127.0.0.1','{\"code\":\"btn.sysDept.add\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653463887000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463887000,\"param\":{},\"name\":\"添加\",\"id\":24}','{\"code\":200,\"message\":\"成功\"}',1,'',NULL,'2025-03-15 12:54:02','2025-03-15 13:12:13',0),(11,'菜单管理','UPDATE','com.lijunxi.auth.controller.SysRoleController.save()].auth.controller.SysMenuController.updateById()','PUT','MANAGE','admin','','/admin/auth/sysMenu/update','127.0.0.1','{\"code\":\"btn.sysDept.update\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653463901000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463901000,\"param\":{},\"name\":\"修改\",\"id\":25}','{\"code\":200,\"message\":\"成功\"}',1,'',NULL,'2025-03-15 12:55:02','2025-03-15 13:12:13',0),(12,'菜单管理','UPDATE','com.lijunxi.auth.controller.SysRoleController.save().auth.controller.SysMenuController.updateById()','PUT','MANAGE','admin','','/admin/auth/sysMenu/update','127.0.0.1','{\"code\":\"btn.sysDept.remove\",\"select\":false,\"level\":4,\"toCode\":\"\",\"updateTime\":1653463919000,\"type\":2,\"parentId\":20,\"isDeleted\":0,\"children\":[],\"createTime\":1653463919000,\"param\":{},\"name\":\"删除\",\"id\":26}','{\"code\":200,\"message\":\"成功\"}',1,'',NULL,'2025-03-15 12:56:02','2025-03-15 13:12:13',0);
/*!40000 ALTER TABLE `sys_oper_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_post`
--

DROP TABLE IF EXISTS `sys_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) NOT NULL COMMENT '岗位编码',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '岗位名称',
  `description` varchar(255) NOT NULL DEFAULT '' COMMENT '描述',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态（1正常 0停用）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 1:已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='岗位信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_post`
--

LOCK TABLES `sys_post` WRITE;
/*!40000 ALTER TABLE `sys_post` DISABLE KEYS */;
INSERT INTO `sys_post` VALUES (5,'dsz','董事长','1',1,'2024-12-22 11:49:12','2024-12-22 11:49:12',0),(6,'zjl','总经理','2',1,'2024-12-22 11:49:12','2024-12-22 11:49:12',0),(7,'wz','网咨','',1,'2025-02-17 15:05:56','2025-02-17 15:05:56',0),(8,'yyzj','运营总监','',1,'2024-12-22 11:49:12','2024-12-22 11:49:12',0),(9,'cs','测试1','',1,'2025-02-17 16:19:53','2025-02-17 16:38:43',0),(10,'cs2','测试2','',1,'2025-02-17 16:37:06','2025-02-17 16:37:06',1);
/*!40000 ALTER TABLE `sys_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_code` varchar(20) DEFAULT NULL COMMENT '角色编码',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 1:已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'系统管理员','SYSTEM','系统管理员','2024-12-22 10:09:18','2024-12-23 01:21:10',0),(2,'普通管理员','COMMON','普通管理员','2024-12-22 00:38:40','2024-12-23 02:42:46',0),(8,'用户管理员','yhgly','用户管理员','2024-12-22 09:39:04','2024-12-31 07:08:47',0),(9,'测试管理员','test1','test','2024-12-26 06:43:25','2025-02-09 03:47:39',1),(10,'超级管理员','ADMIN','超级管理员','2024-12-28 13:06:49','2024-12-31 07:09:33',0),(11,'测试新增11','TEST','测试新增接口1','2024-12-30 14:31:44','2024-12-31 08:20:02',1),(12,'测试新增111','TEST','description','2024-12-30 14:44:00','2024-12-31 08:20:02',1),(13,'测试新增111','TEST','description','2024-12-30 14:44:44','2024-12-31 08:20:02',1),(14,'测试新增11','TEST','测试新增接口2','2024-12-30 14:47:00','2024-12-31 08:19:41',1),(15,'王二狗','WRG','测试','2024-12-31 07:34:24','2024-12-31 07:41:48',1),(16,'王二狗','WRG','测试','2024-12-31 07:37:37','2024-12-31 08:19:41',1),(17,'测试1 ','cs1','测试1','2025-02-09 03:45:32','2025-02-09 03:47:39',1),(18,'测试管理员','TEST',NULL,'2025-02-17 12:37:48','2025-02-17 12:37:48',0),(19,'角色管理员','ROLE',NULL,'2025-02-23 10:27:16','2025-02-23 10:27:16',0),(20,'test','test','test','2025-03-02 10:32:40','2025-03-02 10:35:53',1),(21,'testAdd','testAdd','testAdd','2025-03-02 10:36:11','2025-03-02 10:39:18',1),(22,'test','test','test','2025-03-02 10:39:23','2025-03-02 10:39:23',0);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL DEFAULT '0',
  `menu_id` bigint(11) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 1:已删除）',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_menu_id` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8 COMMENT='角色菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (1,2,2,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(2,2,3,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(3,2,6,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(4,2,7,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(5,2,8,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(6,2,9,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(7,2,18,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(8,2,4,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(9,2,10,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(10,2,11,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(11,2,12,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(12,2,13,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(13,2,19,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(14,2,5,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(15,2,14,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(16,2,15,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(17,2,16,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(18,2,17,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(19,2,2,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(20,2,3,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(21,2,6,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(22,2,7,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(23,2,8,'2024-12-22 11:49:39','2024-12-22 11:49:39',1),(24,2,2,'2024-12-22 11:49:39','2024-12-22 11:49:39',0),(25,2,3,'2024-12-22 11:49:39','2024-12-22 11:49:39',0),(26,2,6,'2024-12-22 11:49:39','2024-12-22 11:49:39',0),(27,2,7,'2024-12-22 11:49:39','2024-12-22 11:49:39',0),(28,2,8,'2024-12-22 11:49:39','2024-12-22 11:49:39',0),(29,2,5,'2024-12-22 11:49:39','2024-12-22 11:49:39',0),(30,2,14,'2024-12-22 11:49:39','2024-12-22 11:49:39',0),(31,2,20,'2024-12-22 11:49:39','2024-12-22 11:49:39',0),(32,2,21,'2024-12-22 11:49:39','2024-12-22 11:49:39',0),(33,10,2,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(34,10,3,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(35,10,6,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(36,10,7,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(37,10,8,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(38,10,9,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(39,10,18,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(40,10,4,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(41,10,10,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(42,10,11,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(43,10,12,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(44,10,13,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(45,10,19,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(46,10,5,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(47,10,14,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(48,10,15,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(49,10,16,'2025-02-11 06:36:09','2025-02-11 06:36:09',0),(50,10,17,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(51,10,20,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(52,10,21,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(53,10,24,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(54,10,25,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(55,10,26,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(56,10,22,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(57,10,23,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(58,10,27,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(59,10,28,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(60,10,29,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(61,10,34,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(62,10,30,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(63,10,31,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(64,10,32,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(65,10,33,'2025-02-11 06:36:10','2025-02-11 06:36:10',0),(66,8,2,'2025-02-11 06:36:33','2025-02-23 10:18:21',1),(67,8,3,'2025-02-11 06:36:33','2025-02-23 10:18:21',1),(68,8,6,'2025-02-11 06:36:33','2025-02-23 10:18:21',1),(69,8,7,'2025-02-11 06:36:33','2025-02-23 10:18:21',1),(70,8,8,'2025-02-11 06:36:33','2025-02-23 10:18:21',1),(71,8,9,'2025-02-11 06:36:33','2025-02-23 10:18:21',1),(72,8,18,'2025-02-11 06:36:33','2025-02-23 10:18:21',1),(73,1,2,'2025-02-11 06:36:46','2025-02-11 06:36:46',0),(74,1,34,'2025-02-11 06:36:46','2025-02-11 06:36:46',0),(75,1,30,'2025-02-11 06:36:46','2025-02-11 06:36:46',0),(76,1,31,'2025-02-11 06:36:46','2025-02-11 06:36:46',0),(77,1,32,'2025-02-11 06:36:46','2025-02-11 06:36:46',0),(78,1,33,'2025-02-11 06:36:46','2025-02-11 06:36:46',0),(79,18,2,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(80,18,3,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(81,18,6,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(82,18,7,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(83,18,8,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(84,18,9,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(85,18,18,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(86,18,4,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(87,18,10,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(88,18,11,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(89,18,12,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(90,18,13,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(91,18,19,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(92,18,5,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(93,18,14,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(94,18,15,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(95,18,16,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(96,18,17,'2025-02-17 12:38:03','2025-02-17 14:02:04',1),(97,18,2,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(98,18,3,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(99,18,6,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(100,18,8,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(101,18,9,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(102,18,18,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(103,18,4,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(104,18,10,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(105,18,11,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(106,18,12,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(107,18,13,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(108,18,19,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(109,18,5,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(110,18,14,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(111,18,15,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(112,18,16,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(113,18,17,'2025-02-17 14:02:04','2025-02-23 10:28:00',1),(114,8,2,'2025-02-23 10:18:21','2025-02-23 10:18:21',0),(115,8,3,'2025-02-23 10:18:21','2025-02-23 10:18:21',0),(116,8,6,'2025-02-23 10:18:21','2025-02-23 10:18:21',0),(117,19,2,'2025-02-23 10:27:38','2025-02-23 10:27:38',0),(118,19,4,'2025-02-23 10:27:39','2025-02-23 10:27:39',0),(119,19,10,'2025-02-23 10:27:39','2025-02-23 10:27:39',0),(120,19,19,'2025-02-23 10:27:39','2025-02-23 10:27:39',0),(121,18,2,'2025-02-23 10:28:00','2025-02-23 10:28:00',0),(122,18,4,'2025-02-23 10:28:00','2025-02-23 10:28:00',0),(123,18,10,'2025-02-23 10:28:00','2025-02-23 10:28:00',0);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `head_url` varchar(200) DEFAULT NULL COMMENT '头像地址',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `post_id` bigint(20) DEFAULT NULL COMMENT '岗位id',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` tinyint(3) DEFAULT NULL COMMENT '状态（1：正常 0：停用）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 1:已删除）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'admin','e10adc3949ba59abbe56e057f20f883e','admin','15099909888','http://r61cnlsfq.hn-bkt.clouddn.com/7daa4595-dfde-45da-8513-c5c2b81d20cc',1021,5,NULL,1,'2024-12-22 11:50:00','2025-02-17 05:28:49',0),(2,'wangqq','e10adc3949ba59abbe56e057f20f883e','王倩倩','15010546381','http://r61cnlsfq.hn-bkt.clouddn.com/b09b3467-3d99-437a-bd2e-dd8c9be92bb8',1022,6,NULL,1,'2024-12-22 11:50:00','2025-02-17 05:28:49',0),(3,'wanggang','e10adc3949ba59abbe56e057f20f883e','王刚','18909098909',NULL,1024,5,NULL,1,'2024-12-22 11:50:00','2025-02-17 05:28:49',0),(4,'lijunxi','e10adc3949ba59abbe56e057f20f883e','总测试','17666666670','http://www.baidu.com',NULL,NULL,NULL,1,'2025-02-17 05:28:15','2025-02-17 06:03:03',0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT '0' COMMENT '删除标记（0:可用 1:已删除）',
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_admin_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='用户角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (19,18,4,'2025-03-15 06:37:20','2025-03-15 06:37:20',0),(20,1,1,'2025-03-15 13:30:47','2025-03-15 13:30:47',0),(21,2,1,'2025-03-15 13:30:47','2025-03-15 13:30:47',0),(22,8,1,'2025-03-15 13:30:47','2025-03-15 13:30:47',0),(23,10,1,'2025-03-15 13:30:47','2025-03-15 13:30:47',0),(24,18,1,'2025-03-15 13:30:47','2025-03-15 13:30:47',0),(25,19,1,'2025-03-15 13:30:47','2025-03-15 13:30:47',0),(26,22,1,'2025-03-15 13:30:47','2025-03-15 13:30:47',0);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `user_role_menu`
--

DROP TABLE IF EXISTS `user_role_menu`;
/*!50001 DROP VIEW IF EXISTS `user_role_menu`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `user_role_menu` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `menu_name`,
 1 AS `phone`,
 1 AS `role_id`,
 1 AS `menu_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `user_role_menu`
--

/*!50001 DROP VIEW IF EXISTS `user_role_menu`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_role_menu` AS select `su`.`id` AS `id`,`su`.`name` AS `name`,`sm`.`name` AS `menu_name`,`su`.`phone` AS `phone`,`sr`.`id` AS `role_id`,`sm`.`id` AS `menu_id` from (((`sys_user` `su` left join `sys_user_role` `sr` on((`su`.`id` = `sr`.`user_id`))) left join `sys_role_menu` `srm` on((`sr`.`id` = `srm`.`role_id`))) left join `sys_menu` `sm` on((`sm`.`id` = `srm`.`menu_id`))) order by `su`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-17 12:18:34
