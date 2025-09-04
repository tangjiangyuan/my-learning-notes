package com.tjy.service.inter.client;

import com.tjy.pojo.Environment;

import java.io.IOException;
import java.util.Collection;

public interface Client {
    void send(Collection<Environment> coll) throws IOException;
}
