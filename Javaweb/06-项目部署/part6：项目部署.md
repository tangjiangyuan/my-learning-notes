# part6：项目部署

## 一、Linux

### 1、介绍

![image-20250828194413088](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828194413088.png)



### 2、Linux 概述

#### 2.1、系统安装

##### 2.1.1、系统版本

![image-20250828194907862](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828194907862.png)

##### 2.1.2、安装方式

![image-20250828195123757](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828195123757.png)

![image-20250828195251948](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828195251948.png)

===验证

![image-20250828195355943](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828195355943.png)

##### 2.1.3、虚拟机网络配置

![image-20250828195530092](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828195530092.png)

##### 2.1.4、挂载镜像 

![image-20250828195612860](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828195612860.png)

![image-20250828200011868](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828200011868.png)

![image-20250828200140224](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828200140224.png)

===可能出现的错误

![image-20250828200448040](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828200448040.png)

##### 2.1.5、关闭虚拟机 

![image-20250828200823617](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828200823617.png)

===挂起：下一次可以快速启动linux，并保存上一次服务的状态

===通过指令

```
init 0 : 关闭linux
init 6 : 重启linux
```

===小结

![image-20250828201303716](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828201303716.png)

#### 2.2、远程连接

##### 2.2.1、思考

![image-20250828201454369](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828201454369.png)

##### 2.2.2、远程连接工具

![image-20250828201558804](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828201558804.png)

##### 2.2.3、finalShell 安装

![image-20250828201645084](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828201645084.png)

##### 2.2.4、finalShell连接linux

![image-20250828201803047](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250828201803047.png)

![image-20250830173618439](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250830173618439.png)

![image-20250830173711703](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250830173711703.png)



#### 2.3、目录介绍

##### 2.3.1、Linux 目录 vs Windows 目录

![image-20250830173844796](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250830173844796.png)

##### 2.3.2、目录结构

![image-20250830200056650](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250830200056650.png)

##### 2.3.3、小结

![image-20250830200153351](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250830200153351.png)

### 3、Linux 常用命令

![image-20250831131408098](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831131408098.png)

#### 3.1、目录操作命令

##### 3.1.1、ls

![image-20250831131747807](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831131747807.png)

![image-20250831131908713](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831131908713.png)

![image-20250831132239620](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831132239620.png)

![image-20250831132303190](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831132303190.png)

![image-20250831132454020](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831132454020.png)

##### 3.1.2、cd

![image-20250831132813502](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831132813502.png)

![image-20250831133024493](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831133024493.png)

![image-20250831133333788](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831133333788.png)

##### 3.1.3、mkdir

![image-20250831133455565](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831133455565.png)

![image-20250831133702684](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831133702684.png)

![image-20250831133842346](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831133842346.png)

![image-20250831134036755](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831134036755.png)

##### 3.1.4、rm

![image-20250831134217311](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831134217311.png)

![image-20250831134444348](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831134444348.png)

![image-20250831134640127](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831134640127.png)

![image-20250831134753794](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831134753794.png)

##### 3.1.5、小结

![image-20250831134918691](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831134918691.png)



#### 3.2、文件操作命令

##### 3.2.1、cat

![image-20250831150214636](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831150214636.png)

===补充：cat不适合查看大型文件，容易出现刷屏现象。

##### 3.2.2、more

![image-20250831150459242](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831150459242.png)

##### 3.2.3、head

![image-20250831150712120](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831150712120.png)

##### 3.2.4、tail

![image-20250831150919522](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831150919522.png)

![image-20250831151105865](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831151105865.png)

![image-20250831151316586](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831151316586.png)

![image-20250831151443676](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831151443676.png)

##### 3.2.5、小结

![image-20250831151715654](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250831151715654.png)

#### 3.3、拷贝移动命令

##### 3.3.1、cp

![image-20250901090243170](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901090243170.png)

![image-20250901090422830](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901090422830.png)

##### 3.3.2、mv

![image-20250901101857095](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901101857095.png)

##### 3.3.3、小结

![image-20250901102241649](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901102241649.png)

#### 3.4、打包压缩命令

##### 3.4.1、tar

![image-20250901102724952](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901102724952.png)

![image-20250901111523663](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901111523663.png)

![image-20250901111754874](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901111754874.png)

![image-20250901112007326](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901112007326.png)

![image-20250901112145654](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901112145654.png)

![image-20250901112347547](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901112347547.png)

![image-20250901112542153](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901112542153.png)

##### 3.4.2、小结

![image-20250901112742698](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901112742698.png)



#### 3.5、文本编辑命令

##### 3.5.1、vi / vim介绍

![image-20250901113014717](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901113014717.png)

##### 3.5.2、vim

![image-20250901113516150](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901113516150.png)

![image-20250901141541557](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901141541557.png)

![image-20250901141612314](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901141612314.png)

![image-20250901141706508](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901141706508.png)

![image-20250901141938111](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901141938111.png)

##### 3.5.3、小结

![image-20250901142449106](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901142449106.png)



#### 3.6、查找命令

##### 3.6.1、find

![image-20250901142711206](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901142711206.png)

##### 3.6.2、grep

![image-20250901143126412](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901143126412.png)

##### 3.6.3、小结

![image-20250901143606170](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901143606170.png)

### 4、Linux 软件安装

#### 4.1、安装方式

![image-20250901144124255](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901144124255.png)

===补充：选择方式，根据依赖的官方提供的下载方式。

#### 4.2、安装 JDK

##### 4.2.1、安装步骤

![image-20250901144608730](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901144608730.png)

##### 4.2.2、进入Linux系统中的文件管理器

![image-20250901145005781](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901145005781.png)

##### 4.2.3、从Windows中将压缩包上传到Linux系统中

![image-20250901144748441](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901144748441.png)

![image-20250901145124822](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901145124822.png)

![image-20250901145205335](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901145205335.png)

##### 4.2.4、解压缩

![image-20250901145319947](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901145319947.png)

![image-20250901145429359](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901145429359.png)

===此时可以通过pwd查看JDK的安装目录

##### 4.2.5、配置环境变量

![image-20250901145542958](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901145542958.png)

![image-20250901145900929](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901145900929.png)

![image-20250901150016789](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901150016789.png)

##### 4.2.6、配置文件生效

![image-20250901150101553](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901150101553.png)

##### 4.2.7、验证

![image-20250901150155988](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901150155988.png)



#### 4.3、安装MySQL

##### 4.3.1、安装步骤

===提示：提供资料中CentOS镜像中已安装了合适MySQL，只需启动服务，输入用户名和密码登录即可。

![image-20250901150650925](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901150650925.png)

![image-20250901150916687](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901150916687.png)

##### 4.3.2、准备工作

```
rpm -qa | grep mariadb
rpm -e -nodeps mariadb-libs-5.5.60-1.el7_5.x86_64
```

![image-20250901152647731](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901152647731.png)

![image-20250901152921901](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901152921901.png)

##### 4.3.3、下载并上传mysql安装包

===同JDK一样

##### 4.3.4、解压安装包到当前目录，并移动到指定目录

```
tar -xvf mysql-8.0.30-linux-glibc2.12-x86_64.tar.xz
```

![image-20250901160818941](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901160818941.png)

![image-20250901160947129](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901160947129.png)

##### 4.3.5、配置环境变量

```
vim /etc/profile
export MYSQL_HOME=/usr/local/mysql
export PATH=$MYSQL_HOME:$PATH
```

===同JDK一样



##### 4.3.6、注册MySQL为系统服务

```
cp /usr/local/mysql/support-files/mysql.server /etc/init.d/mysql
chkconfig --add mysql
```



##### 4.3.7、初始化数据库

```
groupadd mysql
useradd -r -g mysql -s /bin/false mysql
mysqld --initialize --user=mysql --basedir=/usr/local/mysql --datadir=/usr/local/mysql/data
```

![image-20250901161329438](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901161329438.png)

![image-20250901161455204](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901161455204.png)

##### 4.3.8、启动服务登录MySQL

```
systemctl start mysql
mysql -uroot -pxxxx
```

![image-20250901161643396](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901161643396.png)

##### 4.3.9、配置MySQL的root用户和密码，授权远程访问

```shell
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '1234';
# 创建远程访问的用户
CREATE USER 'root'@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';
FLUSH PRIVILEGES;
```

![image-20250901161910677](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901161910677.png)

![image-20250901162200596](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901162200596.png)

##### 4.3.10、Windows连接Linux中的MySQL服务器

![image-20250901162426704](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901162426704.png)



##### 4.3.11、防火墙操作

![image-20250901162925678](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901162925678.png)

![image-20250901163014492](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901163014492.png)

![image-20250901163043808](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901163043808.png)

##### （1）关闭防火墙方式一（不推荐）

![image-20250901163129394](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901163129394.png)

##### （2）关闭防火墙方式二（推荐）

![image-20250901163655665](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901163655665.png)

===使用图形化界面工具连接MySQL服务器

![image-20250901163935143](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901163935143.png)

![image-20250901164055197](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901164055197.png)

#### 4.4、安装Nginx

##### 4.4.1、安装步骤

![image-20250901164608412](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901164608412.png)

##### 4.4.2、上传nginx的源码包

===同JDK操作

![image-20250901165051372](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901165051372.png)

##### 4.4.3、解压源码包到当前目录

```shell
tar -zxvf nginx-1.20.2.tar.gz

cp nginx... : 进入nginx解压后的目录，后续操作都基于此
```



##### 4.4.4、进入解压目录，执行指令

```shell
./configure --prifix=/usr/local/nginx
```



##### 4.4.5、编译

```shell
make
```



##### 4.4.6、下载

```shell
make install
```

![image-20250901165524563](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901165524563.png)

![image-20250901165702488](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901165702488.png)

##### 4.4.7、启动

===在外部时：

```shell
sbin/nginx
```

===在sbin（nginx的可执行文件）：

```
./nginx
```

===开放Nginx监听的端口号80

![image-20250901170051249](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901170051249.png)

===浏览器访问：

```
190.168.100.128
```



### 5、项目部署

#### 5.1、前端项目部署

##### 5.1.1、操作步骤

![image-20250901170642630](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901170642630.png)

##### 5.1.2、上传打包好的前端资源

![image-20250901170757398](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901170757398.png)

##### 5.1.3、覆盖配置文件

![image-20250901170956915](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901170956915.png)

##### 5.1.4、重新加载配置文件

![image-20250901171126931](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901171126931.png)

![image-20250901171238334](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901171238334.png)

##### 5.1.5、小结

![image-20250901171408474](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901171408474.png)



#### 5.2、后端项目部署

##### 5.2.1、操作步骤

![image-20250901171620659](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901171620659.png)

##### 5.2.2、后端代码测试打包

![image-20250901171818337](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901171818337.png)

![image-20250901172155123](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901172155123.png)

##### 5.2.3、上传后端打包后的jar包

![image-20250901172432211](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901172432211.png)

![image-20250901172522330](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901172522330.png)

##### 5.2.4、执行

===说明：只有进入jar包所在的目录下，才能执行该jar包

![image-20250901172625989](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901172625989.png)

5.2.5、验证

![image-20250901173031387](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901173031387.png)

![image-20250901183359056](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901183359056.png)

![image-20250901183453608](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901183453608.png)

![image-20250901183619106](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901183619106.png)

![image-20250901183653977](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901183653977.png)

##### 5.2.5、问题解决

![image-20250901184141303](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901184141303.png)

===补充

![image-20250901184311910](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901184311910.png)

![image-20250901184527799](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901184527799.png)

![image-20250901184924030](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901184924030.png)

##### 5.2.6、小结

![image-20250901185205100](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901185205100.png)



## 二、Docker

### 1、Linux系统项目部署的弊端

![image-20250901190554791](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901190554791.png)

![image-20250901190635248](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901190635248.png)

### 2、Docker介绍

![image-20250901190745925](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901190745925.png)

### 3、下载

===补充：资料中的CentOS中已下载Docker

#### 3.1、卸载旧版

首先如果系统中已经存在旧的Docker，则先卸载：

```shell
yum remove docker \
    docker-client \
    docker-client-latest \
    docker-common \
    docker-latest \
    docker-latest-logrotate \
    docker-logrotate \
    docker-engine \
    docker-selinux 
```



#### 3.2、配置Docker的yum库

首先要安装一个yum工具

```shell
sudo yum install -y yum-utils device-mapper-persistent-data lvm2
```

安装成功后，执行命令，配置Docker的yum源（已更新为阿里云源）：

```shell
sudo yum-config-manager --add-repo https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo

sudo sed -i 's+download.docker.com+mirrors.aliyun.com/docker-ce+' /etc/yum.repos.d/docker-ce.repo
```

更新yum，建立缓存

```shell
sudo yum makecache fast
```



#### 3.3、安装Docker

最后，执行命令，安装Docker

```shell
yum install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```



#### 3.4、启动和校验

```shell
# 启动Docker
systemctl start docker

# 停止Docker
systemctl stop docker

# 重启
systemctl restart docker

# 设置开机自启
systemctl enable docker

# 执行docker ps命令，如果不报错，说明安装启动成功
docker ps
```



#### 4.5、配置镜像加速

镜像地址可能会变更，如果失效可以百度找最新的docker镜像。

配置镜像步骤如下：

```shell
# 创建目录
rm -f /etc/docker/daemon.json

# 复制内容
tee /etc/docker/daemon.json <<-'EOF'
{
    "registry-mirrors": [
        "http://hub-mirror.c.163.com",
        "https://mirrors.tuna.tsinghua.edu.cn",
        "http://mirrors.sohu.com",
        "https://ustc-edu-cn.mirror.aliyuncs.com",
        "https://ccr.ccs.tencentyun.com",
        "https://docker.m.daocloud.io",
        "https://docker.awsl9527.cn"
    ]
}
EOF

# 重新加载配置
systemctl daemon-reload

# 重启Docker
systemctl restart docker
```

![image-20250901191752053](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901191752053.png)

### 4、快速入门

#### 4.1、安装MySQL

![image-20250901191931037](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901191931037.png)

===直接全部赋值粘贴到Linux中

```shell
docker run -d \
  --name mysql \
  -p 3307:3306 \
  -e TZ=Asia/Shanghai \
  -e MYSQL_ROOT_PASSWORD=123 \
mysql:8
```

![image-20250901192143367](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901192143367.png)

![image-20250901192515051](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901192515051.png)

===验证

![image-20250901192625795](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901192625795.png)

#### 4.2、镜像和容器

![image-20250901192922817](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901192922817.png)

![image-20250901193144472](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901193144472.png)

![image-20250901193312647](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901193312647.png)

===演示多个容器之间是相互隔离的

![image-20250901193431849](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901193431849.png)

![image-20250901193617821](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901193617821.png)

![image-20250901193719674](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901193719674.png)

#### 4.3、小结

![image-20250901193938580](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901193938580.png)

#### 4.4、命令解读

![image-20250901195253944](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901195253944.png)



#### 4.5、镜像命名规范

![image-20250901195359997](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901195359997.png)

![image-20250901195612723](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901195612723.png)

### 5、Docker核心

#### 5.1、常见命令

##### 5.1.1、镜像相关

![image-20250901200446651](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901200446651.png)

##### 5.1.2、容器相关

![image-20250901200813212](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901200813212.png)

##### 5.1.3、案例

![image-20250901200906314](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901200906314.png)

（1）在DockerHub中搜索Nginx镜像，查看镜像的名称

![image-20250901201053590](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901201053590.png)

（2）拉取镜像

![image-20250901201500825](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901201500825.png)

（3）查看本地镜像列表

![image-20250901201644504](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901201644504.png)

![image-20250901201940994](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901201940994.png)

===默认下载到桌面

![image-20250901202026274](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901202026274.png)

===上传到Linux中加载镜像

![image-20250901202238472](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901202238472.png)

![image-20250901202419537](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250901202419537.png)

（4）创建并运行Nginx容器

![image-20250902100308335](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902100308335.png)

（5）查看容器

![image-20250902100625854](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902100625854.png)

（6）停止容器

![image-20250902100809051](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902100809051.png)

![image-20250902100854233](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902100854233.png)

（7）再次启动容器

```
docker start 容器名
docker restart 容器名
```

（8）进入Nginx容器

![image-20250902101244450](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902101244450.png)

```
docker exec -it nginx bash
在命令 docker exec -it nginx bash 中，-it 表示：

	-i： 开启交互模式，允许你输入命令。
	-t： 分配一个伪终端，让容器内的 bash shell 拥有完整的终端功能（提示符、行编辑等）。

这两个选项必须同时使用，才能在 Docker 容器内获得一个功能齐全、可交互的命令行会话体验。如果你只使用 -i，你可能可以输入命令，但看不到提示符并且行编辑会混乱；如果只使用 -t，终端环境有了，但你无法输入任何命令（因为没有保持 stdin 打开）。

因此，-it 是 docker exec 或 docker run 命令中启动交互式 shell 的标准和必要参数组合。
```

===退出容器

```
exit
```

（9）删除容器

![image-20250902101947972](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902101947972.png)

![image-20250902102139910](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902102139910.png)

#### 5.2、数据卷

##### 5.2.1、案例

![image-20250902102342547](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902102342547.png)

===

创建并运行容器

```
docker run -d --name nginx -p 80:80 nginx:1.20.2
```

查看nginx目录下的index.html文件

```
docker exec -it bash
cd /usr/share/nginx/
```

进入到html文件里

```
cd index.html
```

![image-20250902103210877](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902103210877.png)

因为要保证容器的大小，所以容器内没有提供ls -al 等指令---此时需要用到数据卷

##### 5.2.2、数据卷介绍

![image-20250902110913968](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902110913968.png)

##### 5.2.3、数据卷-操作命令

![image-20250902111030577](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902111030577.png)

##### 5.2.4、完善案例

![image-20250902111247551](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902111247551.png)

![image-20250902111428825](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902111428825.png)

![image-20250902111726587](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902111726587.png)

![image-20250902111906442](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902111906442.png)

![image-20250902112017520](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902112017520.png)

===此时，可以通过 vim index.html进入，并进行修改文件；

===需求二：将指定的静态资源上传到容器中：先删除宿主机上html文件中的静态资源（由于双向绑定，容器中对应的静态资源也会删除），此时再将准备好的静态资源上传到宿主机中。

![image-20250902112526402](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902112526402.png)

![image-20250902112558700](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902112558700.png)

##### 5.2.5、小结

![image-20250902112902991](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902112902991.png)

##### 5.2.6、扩展-匿名数据卷

===即使容器被删除了，但是数据卷中仍然保留着容器内的数据（备份作用）。也可以用于快速创建容器。

![image-20250902113543269](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902113543269.png)



5.2.7、本地目录挂载

![image-20250902114035748](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902114035748.png)

##### 5.2.8、案例

![image-20250902140359206](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902140359206.png)

![image-20250902140649992](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902140649992.png)

![image-20250902140904337](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902140904337.png)

![image-20250902140938176](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902140938176.png)

![image-20250902141928884](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902141928884.png)

```shell
docker run -d \
 --name mysql \
 -p 3307:3306 \
 -e TZ=Asiz/Shanghai \
 -e MYSQL_ROOT_PASSWORD=123 \
 -v /root/mysql/data:/var/lib/mysql \
 -v /root/mysql/conf:/etc/mysql/conf.d \
 -v /root/mysql/init:/docker-entrypoint-initdb.d \
mysql:8
```

![image-20250902142035811](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902142035811.png)

![image-20250902142207730](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902142207730.png)

![image-20250902142340711](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902142340711.png)

##### 5.2.9、小结

![image-20250902142635007](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902142635007.png)

#### 5.3、自定义镜像

##### 5.3.1、思路

![image-20250902143239905](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902143239905.png)

##### 5.3.2、镜像结构

![image-20250902143717189](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902143717189.png)

===分层好处：便于复用。如 当我们自己想要制作一个Java镜像，但是又不知道JVM使用了哪些系统函数库，就可以使用别人制作的Java镜像，对其修改为自己需要的镜像。

##### 5.3.3、Dockerfile

![image-20250902144330180](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902144330180.png)

![image-20250902145425230](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902145425230.png)

![image-20250902145708525](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902145708525.png)

===补充

![image-20250902150053809](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902150053809.png)

![image-20250902150305363](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902150305363.png)

![image-20250902150453391](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902150453391.png)

![image-20250902150600559](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902150600559.png)

##### 5.3.4、小结

![image-20250902150844098](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902150844098.png)

#### 5.4、网络

##### 5.4.1、引言

![image-20250902151143001](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902151143001.png)

![image-20250902151230522](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902151230522.png)

![image-20250902151414210](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902151414210.png)

##### 5.4.2、介绍

![image-20250902151852985](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902151852985.png)

![image-20250902151707381](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902151707381.png)

##### 5.4.3、自定义网络

```
为什么要使用自定义网络？
如果有一个java容器访问了mysql的ip地址，当mysql关闭之后再次启动，mysql的ip地址就可能改变了，此时java容器无法访问到了mysql的服务器，需要重新访问mysql新的ip地址。无比繁琐，就可以使用自定义网络。
```

![image-20250902152045330](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902152045330.png)

![image-20250902153209610](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902153209610.png)

##### 5.4.4、演示

![image-20250902152634944](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902152634944.png)

![image-20250902160717821](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902160717821.png)



### 6、项目部署

#### 6.1、服务端部署

##### 6.1.1、案例

![image-20250902161141949](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902161141949.png)

===主备工作：删除不需要的镜像

![image-20250902161239924](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902161239924.png)

===准备Java应用

![image-20250902161950979](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902161950979.png)

![image-20250902162046942](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902162046942.png)

===编写dockerfile文件

![image-20250902162413931](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902162413931.png)

===构建docker镜像

![image-20250902162849353](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902162849353.png)

![image-20250902162926084](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902162926084.png)

![image-20250902163113032](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902163113032.png)

===部署docker镜像

```
docker run -d --name 容器名 -p 宿主机端口:容器内部端口 --network 网路名 镜像名:版本
加入到统一网络中，可以通过容器名相互通信。
```

![image-20250902163423866](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902163423866.png)

#### 6.2、前端部署

##### 6.2.1、思路

![image-20250902164235011](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902164235011.png)

![image-20250902164736961](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902164736961.png)

![image-20250902165019255](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902165019255.png)

![image-20250902165459017](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902165459017.png)

#### 6.3、DockerCompose

##### 6.3.1、引言

![image-20250902170235751](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902170235751.png)

##### 6.3.2、介绍

![image-20250902170523060](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902170523060.png)

##### 6.3.3、传统容器创建于配置文件创建容器的对比

![image-20250902171003957](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902171003957.png)

##### 6.3.4、案例

![image-20250902171141338](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902171141338.png)

===准备工作

![image-20250902171255800](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902171255800.png)

![image-20250902171431868](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902171431868.png)

（1）准备资源

![image-20250902172701562](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902172701562.png)

![image-20250902172759989](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902172759989.png)

（2）准备配置文件

![image-20250902172819103](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902172819103.png)

![image-20250902172839915](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902172839915.png)

![image-20250902172851126](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902172851126.png)

![image-20250902172900619](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902172900619.png)

（3）基于DockerComponse一键部署

![image-20250902173043449](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902173043449.png)

![image-20250902173226486](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902173226486.png)

![image-20250902173353825](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902173353825.png)

![image-20250902173629639](D:\软件工程\JavaWeb + AI\06-项目部署\assets\image-20250902173629639.png)