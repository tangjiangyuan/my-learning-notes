package com.itheima;

import com.example.HeaderConfig;
import com.example.HeaderParser;
import com.example.MyImportSelector;
import com.example.TokenParser;
import com.google.gson.Gson;
import com.itheima.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringbootWebTests {

    @Autowired
    private Gson gson;

    @Test
    public void testJson() {
        System.out.println(gson.toJson(Result.success("Hello Gson")));
    }

    /*@Autowired
    private TokenParser tokenParser;

    @Test
    public void testTokenParse() {
        tokenParser.parse();
    }*/

    @Autowired
    private HeaderParser headerParser;

    @Test
    public void testHeaderParser() {
        headerParser.parse();
    }
}
