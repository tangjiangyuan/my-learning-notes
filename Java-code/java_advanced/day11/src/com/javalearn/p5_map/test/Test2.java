package com.javalearn.p5_map.test;

import java.util.*;

public class Test2 {
    /*
        练习 --- Map集合练习
        定义一个Map集合，键用来表示省份名称，值表示市，但是市会有多少个。
        添加完毕后，遍历结果：
        格式如下：
        江苏省=南京市, 扬州市, 苏州市, 无锡市, 常州市
        湖北省=武汉市, 孝感市, 十堰市, 宜昌市, 鄂州市
        四川省=成都市, 锦阳市, 自贡市, 攀枝花市, 泸州市
     */
    public static void main(String[] args) {

        HashMap<String, List<String>> hm = new HashMap<>();

        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "南京市", "扬州市", "苏州市", "无锡市", "常州市");
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "武汉市", "孝感市", "十堰市", "宜昌市", "鄂州市");
        ArrayList<String> list3 = new ArrayList<>();
        Collections.addAll(list3, "成都市", "锦阳市", "自贡市", "攀枝花市", "泸州市");

        hm.put("江苏省", list1);
        hm.put("湖北省", list2);
        hm.put("四川省", list3);

        Set<Map.Entry<String, List<String>>> entrySet = hm.entrySet();

        for (Map.Entry<String, List<String>> entry : entrySet) {
            // 获得所有省
            String key = entry.getKey();
            System.out.print(key + "=");
            // 获得所有市
            List<String> list = entry.getValue();
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if (i == list.size() - 1) {
                    System.out.println(s);
                } else {
                    System.out.print(s + ",");
                }
            }
        }
    }
}
