# 1. 项目启动准备
###1-1. 数据库安装版本 5.7.31 官网下载免安装版本,简书安装教程,执行sql文件夹下面的 创建数据库以及表语句
###1-2.Nacos 开箱即用 nacos-server-1.3.2.zip(git上有下载) 修改bin目录下的启动文件  startup.cmd --> set MODE="standalone"[单节点模式],然后导入config文件中的配置
###注意:Nacos配置中心,先创建一个命名空间,需要修改本地配置中的[namespace]
###1-3.mq-->简书安装教程
# 2.网关路由规则:
###2-1.访问reg模块访问 localhost:9000/reg-service +路径 例如: localhost:9000/reg-service/user?token=1
###2-2.访问product模块访问 localhost:9000/product-service +路径 例如:localhost:9000/product-service/product?token=1