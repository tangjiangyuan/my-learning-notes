package com.tjy.service.impl.server;

import com.tjy.configuration.impl.ConfigurationImpl;
import com.tjy.pojo.Environment;
import com.tjy.service.inter.server.DBStore;
import com.tjy.util.Backup;
import com.tjy.util.WoosModuleInit;
import com.tjy.util.impl.BackupImpl;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @version 1.0
 * @date 2025/8/28 9:11
 * msg 数据入库操作
 */
@Slf4j
@SuppressWarnings("all")
public class DBStoreImpl implements DBStore, WoosModuleInit {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/env";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1223";
    private static String dbBackUp; // 定义备份文件
    private static int batchSize;

    @Override
    public void init(Properties prop) throws Exception {
        batchSize = Integer.parseInt(prop.getProperty("batchSize"));
        dbBackUp = prop.getProperty("dbBackUp");
    }

    // 设置批处理大小
    @Override
    public void saveDB(Collection<Environment> coll) throws ClassNotFoundException {

        long startTime = System.currentTimeMillis();

        // 检查是否有剩余数据
        handleRemainData();

        // 通过表名对环境数据分组
        Map<String, Collection<Environment>> tableDataMap = groupDataByTableName(coll);

        // 处理每张表的数据
        for (Map.Entry<String, Collection<Environment>> entry : tableDataMap.entrySet()) {
            String tableName = entry.getKey();
            Collection<Environment> tableData = entry.getValue();
            processTableData(tableName, tableData);
        }

        long endTime = System.currentTimeMillis();

        log.info("数据入库完成..., 共耗时: {}ms", (endTime - startTime));
    }

    /**
     * 将发生异常后的数据进行备份
     */
    private void saveRemainData(Environment[] dataArr, int index) throws Exception {
        log.warn("发生异常，将剩余数据进行备份，起始索引: {}", index);
        try {
            // 将剩余数据进行备份
            if (index < dataArr.length) {
                // 创建新集合来存储剩余数据
                Collection<Environment> remainData = new ArrayList<>();
                // 将数组转换为集合
                remainData.addAll(Arrays.asList(dataArr).subList(index, dataArr.length));
                // 创建备份对象，并进行数据备份
                new BackupImpl().store(dbBackUp, remainData, Backup.STORE_APPEND);
                log.info("备份数据成功，备份文件: {}", dbBackUp);
            } else {
                log.info("没有剩余数据需要备份...");
            }
        } catch (Exception e) {
            log.error("备份数据时发生异常: {}", e.getMessage());
        }
    }

    /**
     * 处理单个表的数据
     */
    private void processTableData(String tableName, Collection<Environment> tableData) {
        // 将集合转为数组，如果出现异常时，容易获取为发生异常数据的索引，从而进行数据备份
        // 集合转数组的方法: 数组名[] 数组对象名 = 集合对象.toArray(new 数组名[0])
        Environment[] dataArr =  tableData.toArray(new Environment[0]);

        // language=MySQL
        String sql = "insert into " + tableName + "(name, srcId, desId, devId, sensorAddress, count, cmd, status, data, gather_date) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        log.info("创建新pstmt: {}", sql);

        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            int totalCount = 0;
            int count = 0;
            for (int i = 0; i < dataArr.length; i++) {
                Environment env = dataArr[i];
                try {
                    ps.setString(1, env.getName());
                    ps.setString(2, env.getSrcId());
                    ps.setString(3, env.getDesId());
                    ps.setString(4, env.getDevId());
                    ps.setString(5, env.getSersorAddress());
                    ps.setInt(6, env.getCount());
                    ps.setString(7, env.getCmd());
                    ps.setInt(8, env.getStatus());
                    ps.setFloat(9, env.getData());
                    ps.setObject(10, env.getGather_date());
                    ps.addBatch();

                    // 如果达到批处理大小或处理完所有数据
                    if ((i + 1) % batchSize == 0 || i == dataArr.length - 1) {
                        int[] result = ps.executeBatch();
                        count = result.length;
                        totalCount += result.length;
//                        log.info("表 :{},批操作完成，本次插入: {} 条数据。", tableName, count);
                        ps.clearBatch(); // 清除已完成的批处理
                    }
                } catch (SQLException e) {
                    log.error("处理第: {} 条数据时发生错误: {}", i, e.getMessage());
                    // 出现异常，对剩余数据进行备份
                    saveRemainData(dataArr, i);
                    throw new RuntimeException(e);
                }
            }
            log.info("表: {} 批处理插入完成，共插入: {} 条记录。", tableName, totalCount);
        } catch (Exception e) {
            log.error("批处理操作错误: {}", e.getMessage());
        }
    }

    /**
     * 根据表名对数据进行分组
     */
    private static Map<String, Collection<Environment>> groupDataByTableName(Collection<Environment> coll) {
        Map<String, Collection<Environment>> tableDataMap = new HashMap<>();
        // 遍历集合获取对象中的时间，根据时间中天数来决定存入数据库中的那张表
        for (Environment env : coll) {
            // 定义天数变量
            int day = 0;
            // 将日期类型转换为字符串，并截取为字符串数组
            String[] split = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss").format(env.getGather_date()).split("-");
            if (split.length >= 3) {
                day = Integer.parseInt(split[2]);
            }
            // 创建表名
             String tableName = "e_detail_" + day;

            // computeIfAbsent 是jdk8中map集合的默认方法，判断第一个参数(键)是否存在
            // 存在 : 在key对应的value中添加对应的值
            // 不存在 : 则为key创建对应的value，并添加对应的值
            tableDataMap.computeIfAbsent(tableName, k -> new ArrayList<>()).add(env);
        }
        return tableDataMap;
    }

    /**
     * 查看备份数据中是否有剩余数据，如果有则先让备份数据入库
     */
    private void handleRemainData() {
        log.info("检查备份文件中是否有数据...");
        // 获取备份数据
        Collection<Environment> coll = (Collection<Environment>) new BackupImpl().load(dbBackUp, Backup.LOAD_REMOVE);
        // 判断
        if (coll != null && !coll.isEmpty()) {
            log.info("备份文件中有数据，开始入库...");
            Map<String, Collection<Environment>> tableDataMap = groupDataByTableName(coll);
            for (Map.Entry<String, Collection<Environment>> entry : tableDataMap.entrySet()) {
                String tableName = entry.getKey();
                Collection<Environment> tableData = entry.getValue();
                processTableData(tableName, tableData);
            }
            log.info("备份文件中的数据入库完毕...");
        } else {
            log.info("备份文件中没有数据，不需要入库。");
        }
    }
}
