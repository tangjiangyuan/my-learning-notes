package com.javalearn.p1_stream.domain;

public class Actor {
    private String name;

    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Actor{name = " + name + "}";
    }
}
