package com.tjy.configuration.impl;

import com.tjy.configuration.Configuration;
import com.tjy.service.impl.client.ClientImpl;
import com.tjy.service.impl.client.GatherImpl;
import com.tjy.service.impl.server.DBStoreImpl;
import com.tjy.service.impl.server.ServerImpl;
import com.tjy.service.inter.client.Client;
import com.tjy.service.inter.client.Gather;
import com.tjy.service.inter.server.DBStore;
import com.tjy.service.inter.server.Server;
import com.tjy.util.Backup;
import com.tjy.util.WoosModuleInit;
import com.tjy.util.impl.BackupImpl;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.*;

/**
 * @version 1.0
 * @date 2025/8/29 15:05
 */
@SuppressWarnings("all")
public class ConfigurationImpl implements Configuration {

    public static Properties prop = new Properties();
    private static Map<String, Element> moduleMap = new HashMap<>();
    private static boolean isParsed = false;

    /**
     * 解析所有模块
     */
    private static void parseAll() throws Exception {
        if (isParsed) return;
        // 解析部分
        SAXReader reader = new SAXReader();
        Document document = reader.read("D:\\Dev-work\\environment-data-center\\environment\\src\\main\\resources\\config.xml");
        // 得到根标签 <Element>
        Element rootElement = document.getRootElement();
        // 获取根标签下所有子标签 <Gather>, <Client>, <DBStore>, <Backup>
        List<Element> elements = rootElement.elements();
        for (Element module : elements) {
            // 存入每个子标签名以及对应的模块 <Gather>...</Gather> ...
            moduleMap.put(module.getName(), module);
        }
        isParsed = true;
    }

    private static void parseToProperties(String moduleName) throws Exception {
        // 确保所有模块已解析
        parseAll();

        Element module = moduleMap.get(moduleName);
        if (module != null) {
            // 遍历每个子标签，获取属性名以及属性值
            List<Element> elements = module.elements();
            for (Element element : elements) {
                prop.setProperty(element.getName(), element.getText());
            }
        }
    }

    @Override
    public Server getServer() throws Exception {
        parseToProperties("Server");
        Server server = new ServerImpl();
        if (server instanceof WoosModuleInit) {
            ((WoosModuleInit) server).init(prop);
        }
        return server;
    }

    @Override
    public Client getClient() throws Exception {
        parseToProperties("Client");
        Client client = new ClientImpl();
        if (client instanceof WoosModuleInit) {
            ((WoosModuleInit) client).init(prop);
        }
        return new ClientImpl();
    }

    @Override
    public DBStore getDbStore() throws Exception {
        parseToProperties("DBStore");
        DBStore dbStore = new DBStoreImpl();
        if (dbStore instanceof WoosModuleInit) {
            ((WoosModuleInit) dbStore).init(prop);
        }
        return new DBStoreImpl();
    }

    @Override
    public Gather getGather() throws Exception {
        parseToProperties("Gather");
        Gather gather = new GatherImpl();
        if (gather instanceof WoosModuleInit) {
            ((WoosModuleInit) gather).init(prop);
        }
        return new GatherImpl();
    }

}
