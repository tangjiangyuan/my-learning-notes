package com.tjy.configuration;

import com.tjy.service.inter.client.Client;
import com.tjy.service.inter.client.Gather;
import com.tjy.service.inter.server.DBStore;
import com.tjy.service.inter.server.Server;
import com.tjy.util.Backup;

/*
    配置模块实现类
        1.解析config.xml配置文件
        2.获取其他模块对象，添加map集合统一管理
        3.获取其他模块属性值，添加到Properties统一管理
 */
public interface Configuration {
//    public Log getLogger() throws Exception ;

    Server getServer() throws Exception ;

    Client getClient() throws Exception ;

    DBStore getDbStore() throws Exception ;

    Gather getGather() throws Exception ;

}
