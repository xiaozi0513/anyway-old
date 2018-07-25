CREATE TABLE `aw_cust` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '客户ID',
  `cust_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '客户姓名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '手机号',
  `gender` tinyint(1) DEFAULT '0' COMMENT '性别（0-未知，1-男，2-女）',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` varchar(50) NOT NULL COMMENT '菜单名称',
  `pid` bigint(20) DEFAULT NULL COMMENT '父菜单ID',
  `url` varchar(200) DEFAULT '' COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT '' COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` tinyint(1) NOT NULL COMMENT '类型  0-目录，1-菜单，2-按钮',
  `icon` varchar(50) DEFAULT '' COMMENT '菜单图标',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态  0-无效，1-有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;