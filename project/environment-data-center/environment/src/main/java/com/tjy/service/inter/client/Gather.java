package com.tjy.service.inter.client;

import com.tjy.pojo.Environment;

import java.util.Collection;

public interface Gather {
    /* 采集模块功能实现
        逐行解析data-file-simple中数据，
        每行 --> 1或2个 Environment对象
        将所有对象添加到Collection集合中，最终返回
     */
    Collection<Environment> gather() throws Exception;
}
