create database alibaba_shop_aye;
create table user (
  id              int(11) not null auto_increment primary key,
  user_name       varchar(30),
  password        varchar(20),
  c_email         varchar(20),
  age             int(20),
  sex             tinyint,
  c_tel           varchar(20),
  c_addr          varchar(50),
  card            varchar(20),
  married         tinyint,
  salary          decimal(8, 2),
  d_create_time   datetime,
  d_modified_time datetime
)
  engine = innodb
  default charset = utf8;
insert into user (user_name,
                  password,
                  c_email,
                  age,
                  sex,
                  c_tel,
                  c_addr,
                  card,
                  married,
                  salary,
                  d_create_time,
                  d_modified_time)
VALUE ('admin',
       'admin',
       'admin@163.com',
       18,
       1,
       '1234567890',
       '良品大厦',
       '4396',
       1,
       15.5,
       '2020-12-17 00:00:00',
       '2020-12-17 00:00:00'),
      ('aye',
       'aye',
       'aye@163.com',
       18,
       1,
       '1234567890',
       '良品大厦',
       '4396',
       1,
       15.5,
       '2020-12-17 00:00:00',
       '2020-12-17 00:00:00');

create table t_product (
  id              int(11) auto_increment primary key    not null,
  c_product_name  varchar(30) comment '商品名称',
  c_sku           varchar(20) comment 'sku',
  c_image         varchar(20) comment '图片',
  i_shelve        tinyint comment '商品上架状态',
  i_status        tinyint comment '商品可售状态',
  f_price           decimal(8, 2) comment '商品价格',
  d_shelve_time   timestamp default current_timestamp not null
  comment '上架时间',
  d_modified_time timestamp on update current_timestamp not null
  comment '修改时间',
  d_create_time   timestamp default current_timestamp   not null
  comment '创建时间'
)
  engine = innodb
  default charset = utf8;
INSERT INTO t_product (c_product_name, c_sku, c_image, i_shelve, i_status, f_price)
VALUES ('百香果', 'ZH123', 'www.pic.com', 1, 1, 12.30),
       ('霸王花', 'ZH321', 'www.wall.com', 0, 1, 13.40);









