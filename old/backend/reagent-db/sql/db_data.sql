INSERT INTO reagent_admin (username,password,icon,email,nick_name,note,create_time,login_time,status) VALUES
('test11111','$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG','','test@qq.com','测试账号','111111','2018-09-29 13:55:30','2018-09-29 13:55:39',1),
('admin','$2a$10$oPur9/vFF0u/SzpVQ1KUNeKf5vfUHee44xvYziwoM1VPh6l7FX4MC','','admin@163.com','系统管理员','系统管理员','2018-10-08 13:32:47','2019-04-20 12:45:16',1),
('macro','$2a$10$Bx4jZPR7GhEpIQfefDQtVeS58GfT5n6mxs/b4nLLK65eMFa16topa','string','macro@qq.com','macro','macro专用','2019-10-06 15:53:51','2020-02-03 14:55:55',1);
INSERT INTO reagent_admin_role_relation (admin_id,role_id) VALUES
(9,1);
INSERT INTO reagent_menu (parent_id,create_time,title,`level`,sort,name,icon,hidden) VALUES
(0,'2020-02-02 14:50:36','入库',0,0,'ims','product',0),
(1,'2020-02-02 14:51:50','入库列表',1,0,'incident','product-list',0),
(0,'2020-02-07 16:29:13','权限',0,0,'ums','ums',0),
(21,'2020-02-07 16:29:51','用户列表',1,0,'admin','ums-admin',0),
(21,'2020-02-07 16:30:13','角色列表',1,0,'role','ums-role',0),
(21,'2020-02-07 16:30:53','菜单列表',1,0,'menu','ums-menu',0),
(21,'2020-02-07 16:31:13','资源列表',1,0,'resource','ums-resource',0),
(1,'2020-02-02 14:52:44','添加事件',1,0,'addIncident','product-add',0),
(1,'2020-02-02 14:53:51','事件分类',1,0,'productCate','product-cate',0);
INSERT INTO reagent_permission (pid,name,value,icon,`type`,uri,status,create_time,sort) VALUES
(0,'商品',NULL,NULL,0,NULL,1,'2018-09-29 16:15:14',0),
(1,'商品列表','pms:product:read',NULL,1,'/pms/product/index',1,'2018-09-29 16:17:01',0),
(1,'添加商品','pms:product:create',NULL,1,'/pms/product/add',1,'2018-09-29 16:18:51',0),
(1,'商品分类','pms:productCategory:read',NULL,1,'/pms/productCate/index',1,'2018-09-29 16:23:07',0),
(1,'商品类型','pms:productAttribute:read',NULL,1,'/pms/productAttr/index',1,'2018-09-29 16:24:43',0),
(1,'品牌管理','pms:brand:read',NULL,1,'/pms/brand/index',1,'2018-09-29 16:25:45',0),
(2,'编辑商品','pms:product:update',NULL,2,'/pms/product/updateProduct',1,'2018-09-29 16:34:23',0),
(2,'删除商品','pms:product:delete',NULL,2,'/pms/product/delete',1,'2018-09-29 16:38:33',0),
(4,'添加商品分类','pms:productCategory:create',NULL,2,'/pms/productCate/create',1,'2018-09-29 16:43:23',0),
(4,'修改商品分类','pms:productCategory:update',NULL,2,'/pms/productCate/update',1,'2018-09-29 16:43:55',0);
INSERT INTO reagent_permission (pid,name,value,icon,`type`,uri,status,create_time,sort) VALUES
(4,'删除商品分类','pms:productCategory:delete',NULL,2,'/pms/productAttr/delete',1,'2018-09-29 16:44:38',0),
(5,'添加商品类型','pms:productAttribute:create',NULL,2,'/pms/productAttr/create',1,'2018-09-29 16:45:25',0),
(5,'修改商品类型','pms:productAttribute:update',NULL,2,'/pms/productAttr/update',1,'2018-09-29 16:48:08',0),
(5,'删除商品类型','pms:productAttribute:delete',NULL,2,'/pms/productAttr/delete',1,'2018-09-29 16:48:44',0),
(6,'添加品牌','pms:brand:create',NULL,2,'/pms/brand/add',1,'2018-09-29 16:49:34',0),
(6,'修改品牌','pms:brand:update',NULL,2,'/pms/brand/update',1,'2018-09-29 16:50:55',0),
(6,'删除品牌','pms:brand:delete',NULL,2,'/pms/brand/delete',1,'2018-09-29 16:50:59',0),
(0,'首页',NULL,NULL,0,NULL,1,'2018-09-29 16:51:57',0),
(1,'事件列表','ims:incident:read','',1,'/ims/incident/index',1,'2018-09-29 16:17:01',0),
(1,'添加事件','ims:incident:create','',1,'/ims/incident/add',1,'2018-09-29 16:18:51',0);
INSERT INTO reagent_permission (pid,name,value,icon,`type`,uri,status,create_time,sort) VALUES
(2,'编辑事件','ims:incident:update','',2,'/ims/incident/update',1,'2018-09-29 16:34:23',0),
(2,'删除事件','ims:incident:delete','',2,'/ims/incident/delete',1,'2018-09-29 16:38:33',0);
INSERT INTO reagent_resource (create_time,name,url,description,category_id) VALUES
('2020-02-04 17:04:55','商品品牌管理','/brand/**',NULL,1),
('2020-02-04 17:05:35','商品属性分类管理','/productAttribute/**',NULL,1),
('2020-02-04 17:06:13','商品属性管理','/productAttribute/**',NULL,1),
('2020-02-04 17:07:15','商品分类管理','/productCategory/**',NULL,1),
('2020-02-04 17:09:16','商品管理','/product/**',NULL,1),
('2020-02-04 17:09:53','商品库存管理','/sku/**',NULL,1),
('2020-02-05 14:43:37','订单管理','/order/**','',2),
('2020-02-05 14:44:22',' 订单退货申请管理','/returnApply/**','',2),
('2020-02-05 14:45:08','退货原因管理','/returnReason/**','',2),
('2020-02-05 14:45:43','订单设置管理','/orderSetting/**','',2);
INSERT INTO reagent_resource (create_time,name,url,description,category_id) VALUES
('2020-02-05 14:46:23','收货地址管理','/companyAddress/**','',2),
('2020-02-07 16:37:22','优惠券管理','/coupon/**','',3),
('2020-02-07 16:37:59','优惠券领取记录管理','/couponHistory/**','',3),
('2020-02-07 16:38:28','限时购活动管理','/flash/**','',3),
('2020-02-07 16:38:59','限时购商品关系管理','/flashProductRelation/**','',3),
('2020-02-07 16:39:22','限时购场次管理','/flashSession/**','',3),
('2020-02-07 16:40:07','首页轮播广告管理','/home/advertise/**','',3),
('2020-02-07 16:40:34','首页品牌管理','/home/brand/**','',3),
('2020-02-07 16:41:06','首页新品管理','/home/newProduct/**','',3),
('2020-02-07 16:42:16','首页人气推荐管理','/home/recommendProduct/**','',3);
INSERT INTO reagent_resource (create_time,name,url,description,category_id) VALUES
('2020-02-07 16:42:48','首页专题推荐管理','/home/recommendSubject/**','',3),
('2020-02-07 16:44:56',' 商品优选管理','/prefrenceArea/**','',5),
('2020-02-07 16:45:39','商品专题管理','/subject/**','',5),
('2020-02-07 16:47:34','后台用户管理','/admin/**','',4),
('2020-02-07 16:48:24','后台用户角色管理','/role/**','',4),
('2020-02-07 16:48:48','后台菜单管理','/menu/**','',4),
('2020-02-07 16:49:18','后台资源分类管理','/resourceCategory/**','',4),
('2020-02-07 16:49:45','后台资源管理','/resource/**','',4),
('2020-02-04 17:09:16','事件管理','/incident/**','',1);
INSERT INTO reagent_resource_category (create_time,name,sort) VALUES
('2020-02-05 10:21:44','商品模块',0),
('2020-02-05 10:22:34','订单模块',0),
('2020-02-05 10:22:48','营销模块',0),
('2020-02-05 10:23:04','权限模块',0),
('2020-02-07 16:34:27','内容模块',0),
('2020-02-07 16:35:49','其他模块',0);
INSERT INTO reagent_role (name,description,admin_count,create_time,status,sort) VALUES
('系统管理员','系统维护',0,NULL,1,0),
('中心库管理员','一级库管理',0,NULL,1,0),
('科室管理员','2级库管理',0,NULL,1,0),
('试剂操作员','试剂使用',0,NULL,1,0),
('供货商','进货',0,NULL,1,0);
INSERT INTO reagent_role_menu_relation (role_id,menu_id) VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6);
INSERT INTO reagent_role_permission_relation (role_id,permission_id) VALUES
(1,1),
(1,2),
(1,3),
(1,7),
(1,8),
(2,4),
(2,9),
(2,10),
(2,11),
(3,5);
INSERT INTO reagent_role_permission_relation (role_id,permission_id) VALUES
(3,12),
(3,13),
(3,14),
(4,6),
(4,15),
(4,16),
(4,17);
INSERT INTO reagent_role_resource_relation (role_id,resource_id) VALUES
(2,8),
(2,9),
(2,10),
(2,11),
(2,12),
(5,1),
(5,2),
(5,3),
(5,4),
(5,5);
INSERT INTO reagent_role_resource_relation (role_id,resource_id) VALUES
(5,6),
(5,8),
(5,9),
(5,10),
(5,11),
(5,12),
(5,13),
(5,14),
(5,15),
(5,16);
INSERT INTO reagent_role_resource_relation (role_id,resource_id) VALUES
(5,17),
(5,18),
(5,19),
(5,20),
(5,21),
(5,22),
(5,23),
(5,24),
(5,25),
(5,26);
INSERT INTO reagent_role_resource_relation (role_id,resource_id) VALUES
(5,27),
(5,28),
(5,29),
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,54),
(1,55);
INSERT INTO reagent_role_resource_relation (role_id,resource_id) VALUES
(1,56);