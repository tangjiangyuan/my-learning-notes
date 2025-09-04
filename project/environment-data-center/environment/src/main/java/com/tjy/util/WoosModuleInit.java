package com.tjy.util;

import java.util.Properties;

/**
 * 将所需要的该类，该配置信息传递进类得到配置信息后进行初始化。
 * 建议在执行该类其他方法之前，先执行这个方法
 * 一个Properties实例封装了初始化所需的各种配置信息
 */
public interface WoosModuleInit {
    void init(Properties prop) throws Exception;
}
