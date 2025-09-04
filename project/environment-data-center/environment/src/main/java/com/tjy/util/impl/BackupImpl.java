package com.tjy.util.impl;

import com.tjy.util.Backup;
import com.tjy.util.WoosModuleInit;

import java.io.*;
import java.util.Properties;

/**
 * @version 1.0
 * @date 2025/8/28 11:18
 */
public class BackupImpl implements Backup, WoosModuleInit {

    @Override
    public void init(Properties prop) throws Exception {

    }

    /**
     * 读取备份文件中存储的对象
     * @param filePath 备份文件的路径
     * @param del      读取完备份文件后是否要删除此备份文件，true为删除，false为不删除。
     *                 在调用时推荐使用接口中定义的静态常量LOAD_REMOVE、LOAD_UNREMOVE
     * @return 备份文件中存储的对象
     */
    @Override
    public Object load(String filePath, boolean del) {
        File file = new File("D:\\Dev-work\\environment-data-center\\environment\\src\\main\\resources\\", filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("备份模块: 想要读取的备份文件不存在" + filePath);
            return null;
        }

        if (file.length() == 0) {
            System.out.println("备份模块: 备份文件中无数据可读" + filePath);
            return null;
        }

        //读取文件，获取对象
        Object object = null;
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(filePath))) {
            object = ois.readObject();
            System.out.println("备份模块: 成功读取备份文件");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //根据删除标志 删除文件
        if (del) {
            boolean delete = file.delete();
            System.out.println("备份模块: 文件" + (delete ? "删除成功" : "删除失败"));
        }

        return object;
    }

    /**
     * 将需要备份的集合对象写入到备份文件
     *
     * @param filePath 备份文件的路径
     * @param obj      将要写入备份文件的对象
     * @param append   在写入时追加还是覆盖，true为追加，false为覆盖,在调用时推荐使用接口中定义的静态常量STORE_APPEND、STORE_OVERRIDE
     */
    @Override
    public void store(String filePath, Object obj, boolean append) {
        //将obj对象写入备份文件
        try (
                ObjectOutputStream oos =
                        new ObjectOutputStream(new FileOutputStream(filePath, append))
        ) {
            oos.writeObject(obj);
            System.out.println("备份模块: 数据已保存到备份文件中" + filePath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
