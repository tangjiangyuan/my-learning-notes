package com.tjy.service.inter.server;

import com.tjy.pojo.Environment;

import java.util.Collection;

public interface DBStore {
    void saveDB(Collection<Environment> coll) throws ClassNotFoundException;
}
