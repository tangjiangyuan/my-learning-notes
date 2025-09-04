package com.tjy.service.impl.client;

import com.tjy.configuration.impl.ConfigurationImpl;
import com.tjy.pojo.Environment;
import com.tjy.service.inter.client.Gather;
import com.tjy.util.Backup;
import com.tjy.util.WoosModuleInit;
import com.tjy.util.impl.BackupImpl;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @version 1.0
 * @date 2025/8/27 11:08
 */
@Slf4j
@SuppressWarnings("all")
public class GatherImpl implements Gather, WoosModuleInit {

    // 数据统计
    static int count1 = 0; // temperature
    static int count2 = 0; // humidity
    static int count3 = 0; // light intensity
    static int count4 = 0; // carbon dioxide

    private static String path;
    private static String gatherBackup;

    @Override
    public void init(Properties prop) throws Exception {
        path = prop.getProperty("path");
        gatherBackup = prop.getProperty("gatherBackup");
    }

    @Override
    public Collection<Environment> gather() throws Exception {
        Backup backup = new BackupImpl();
        // 采集备份准备
        // 1. 定义文件中最后的偏移量
        long lastOffset = 0;
        // 2. 加载备份文件，并获取文件的偏移量
        Object load = backup.load(gatherBackup, Backup.LOAD_UN_REMOVE);
        if (load instanceof Long) {
            lastOffset = (Long) load;
        }

        // 4. 获取数据文件输入流
        InputStream is = getClass().getClassLoader().getResourceAsStream(path);
        // 5. 健壮性判断: 避免文件为空，如果上一次的偏移量大于0，则跳过上次的偏移量
        if (is != null && lastOffset > 0) {
            is.skip(lastOffset);
        }

        // 6. 如果偏移量为0，则备份文件中无数据，从头开始备份
        long currentOffset = lastOffset;
        // 7. 使用 StringBuilder往备份文件中写入数据
        StringBuilder proceedData = new StringBuilder();

        // 使用set集合存储环境对象 -- 去重
        Set<Environment> environmentSet = new HashSet<>();
        long startTime = System.currentTimeMillis();
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(is))
        ) {

            log.info("开始采集数据...");

            String line = null;
            while ((line = br.readLine()) != null) {
                // 8. 存储数据
                proceedData.append(line).append("\n");
                String[] split = line.split("\\|");

                // 健壮性判断
                if (split.length < 9) {
                    log.error("数据错误！" + line);
                    continue;
                }

                int sensorAddressInt = Integer.parseInt(split[3]);

                switch (sensorAddressInt) {
                    case 16: // 温湿度
                        Environment temperatureEnv = createTemperatureEnvironment(split);
                        if (temperatureEnv != null && environmentSet.add(temperatureEnv)) {
                            count1++;
                        }

                        Environment humidityEnv = createHumidityEnvironment(split);
                        if (humidityEnv != null && environmentSet.add(humidityEnv)) {
                            count2++;
                        }
                        break;
                    case 256: // 光照强度
                        Environment lightIntensityEnv = createLightIntensityEnvironment(split);
                        if (lightIntensityEnv != null && environmentSet.add(lightIntensityEnv)) {
                            count3++;
                        }
                        break;
                    case 1280: // 二氧化碳
                        Environment carbonDioxideEnv = createCarbonDioxideEnvironment(split);
                        if (carbonDioxideEnv != null && environmentSet.add(carbonDioxideEnv)) {
                            count4++;
                        }
                        break;
                    default:
                        log.error("数据异常[sensorAddressInt:" + sensorAddressInt + "]");
                        break;
                }
            }
            // 9. 存储完数据，更新偏移量
            currentOffset += proceedData.length();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        // 10. 采集完成，将偏移量存入备份文件
        log.info("采集备份成功！");
        backup.store(gatherBackup, currentOffset, Backup.STORE_APPEND);
        log.info("数据采集完毕。温度数据个数:{},湿度数据个数:{},光照强度数据个数:{},二氧化碳数据个数:{}; 共耗时: {}ms", count1, count2, count3, count4, (endTime - startTime));
        return environmentSet;
    }

    /**
     * 获取温度数据
     */
    private Environment createTemperatureEnvironment(String[] data) {
        Environment env = new Environment();
        env.setName("temperature");
        env.setSrcId(data[0]);
        env.setDesId(data[1]);
        env.setDevId(data[2]);
        env.setSersorAddress(data[3]);
        env.setCount(Integer.parseInt(data[4]));
        env.setCmd(data[5]);
        env.setStatus(Integer.parseInt(data[7]));

        // 计算温度值
        String temperatureHex = data[6].substring(0, 4);
        int temperatureValue = Integer.parseInt(temperatureHex, 16);
        env.setData(temperatureValue * (0.00268127F) - 46.85F);

        // 时间转换
        Instant instant = Instant.ofEpochMilli(Long.parseLong(data[8]));
        LocalDateTime gather_date = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        env.setGather_date(gather_date);

        return env;
    }

    /**
     * 获取湿度数据
     */
    private Environment createHumidityEnvironment(String[] data) {
        Environment env = new Environment();
        env.setName("humidity");
        env.setSrcId(data[0]);
        env.setDesId(data[1]);
        env.setDevId(data[2]);
        env.setSersorAddress(data[3]);
        env.setCount(Integer.parseInt(data[4]));
        env.setCmd(data[5]);
        env.setStatus(Integer.parseInt(data[7]));

        // 计算湿度值
        String humidityHex = data[6].substring(4, 8);
        int humidityValue = Integer.parseInt(humidityHex, 16);
        env.setData((humidityValue * 0.00190735F) - 6);

        // 时间转换
        Instant instant = Instant.ofEpochMilli(Long.parseLong(data[8]));
        LocalDateTime gather_date = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        env.setGather_date(gather_date);

        return env;
    }

    /**
     * 获取光照强度数据
     */
    private Environment createLightIntensityEnvironment(String[] data) {
        Environment env = new Environment();
        env.setName("LightIntensity");
        env.setSrcId(data[0]);
        env.setDesId(data[1]);
        env.setDevId(data[2]);
        env.setSersorAddress(data[3]);
        env.setCount(Integer.parseInt(data[4]));
        env.setCmd(data[5]);
        env.setStatus(Integer.parseInt(data[7]));

        // 计算光照强度值
        env.setData(Integer.parseInt(data[6].substring(0, 4), 16));

        // 时间转换
        Instant instant = Instant.ofEpochMilli(Long.parseLong(data[8]));
        LocalDateTime gather_date = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        env.setGather_date(gather_date);

        return env;
    }

    /**
     * 获取二氧化碳数据
     */
    private Environment createCarbonDioxideEnvironment(String[] data) {
        Environment env = new Environment();
        env.setName("CarbonDioxide");
        env.setSrcId(data[0]);
        env.setDesId(data[1]);
        env.setDevId(data[2]);
        env.setSersorAddress(data[3]);
        env.setCount(Integer.parseInt(data[4]));
        env.setCmd(data[5]);
        env.setStatus(Integer.parseInt(data[7]));

        // 计算二氧化碳值
        env.setData(Integer.parseInt(data[6].substring(0, 4), 16));

        // 时间转换
        Instant instant = Instant.ofEpochMilli(Long.parseLong(data[8]));
        LocalDateTime gather_date = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        env.setGather_date(gather_date);

        return env;
    }

    /*
    int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        // 关联文件（建议使用相对路径或classpath）
        File file = new File("src/main/resources/data-file-simple");
        // 创建集合接收对象
        Collection<Environment> list = new ArrayList<>();
        // 读取文件中的对象
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");

                Environment env = new Environment();
                env.setSrcId(split[0]);
                env.setDesId(split[1]);
                env.setDevId(split[2]);
                String sensorAddress = split[3];  // 修正变量名
                env.setSersorAddress(sensorAddress);

                String name = null;
                int sensorAddressInt = Integer.parseInt(split[3]);
                if (sensorAddressInt == 16) {
                    name = "Temperature";
                    env.setName(name);
                    count1++;
                } else if (sensorAddressInt == 256) {
                    name = "LightIntensity";
                    env.setName(name);
                    count3++;
                } else if (sensorAddressInt == 1280) {
                    name = "CarbonDioxide";
                    env.setName(name);
                    count4++;
                }

                env.setCount(Integer.parseInt(split[4]));
                env.setCmd(split[5]);
                env.setStatus(Integer.parseInt(split[7]));
                float data = 0;

                if (name.equals("Temperature")) { // 温度
                    String temperature = split[6].substring(0, 4);
                    int t = Integer.parseInt(temperature, 16);
                    data = t * (0.00268127F) - 46.85F;
                    env.setData(data);
                } else if (name.equals("LightIntensity")) {
                    data = Integer.parseInt(split[6].substring(0, 4), 16);
                    env.setData(data);
                } else if (name.equals("CarbonDioxide")) {
                    data = Integer.parseInt(split[6].substring(0, 4), 16);
                    env.setData(data);
                }

                String time = split[8];
                long timestamp = Long.parseLong(time);
                Instant instant = Instant.ofEpochMilli(timestamp);
                LocalDateTime gather_date = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
                env.setGather_date(gather_date);

                list.add(env);

                Environment env1 = new Environment();

                env1.setSrcId(split[0]);
                env1.setDesId(split[1]);
                env1.setDevId(split[2]);
                env1.setSersorAddress(split[3]);

                String name1 = null;
                if (Integer.parseInt(split[3]) == 16) {
                    name1 = "Humidity";
                    env1.setName(name1);
                    count2++;
                } else if (Integer.parseInt(split[3]) == 256) {
                    name1 = "LightIntensity";
                    env1.setName(name1);
                    count3++;
                } else if (Integer.parseInt(split[3]) == 1280) {
                    name1 = "CarbonDioxide";
                    env1.setName(name1);
                    count4++;
                }

                env1.setCount(Integer.parseInt(split[4]));
                env1.setCmd(split[5]);
                env1.setStatus(Integer.parseInt(split[7]));
                float data1 = 0;

                if (name1.equals("Humidity")) { // 湿度
                    String humidity = split[6].substring(4, 8);
                    int h = Integer.parseInt(humidity, 16);
                    data1 = (h * 0.00190735F) - 6;
                    env1.setData(data1);
                } else if (name1.equals("LightIntensity")) {
                    data1 = Integer.parseInt(split[6].substring(0, 4), 16);
                    env1.setData(data1);
                } else if (name1.equals("CarbonDioxide")) {
                    data1 = Integer.parseInt(split[6].substring(0, 4), 16);
                    env1.setData(data1);
                }


                Instant instant1 = Instant.ofEpochMilli(Long.parseLong(split[8]));
                LocalDateTime gather_date1 = instant1.atZone(ZoneId.systemDefault()).toLocalDateTime();
                env1.setGather_date(gather_date1);

                list.add(env1);

            }
        } catch (Exception e) {
            System.out.println("读取文件时发生错误: " + e.getMessage());
        }
//        list.forEach(System.out::println);
        System.out.println("温度个数:" + count1);
        System.out.println("湿度个数:" + count2);
        System.out.println("光照强度个数:" + count3);
        System.out.println("二氧化碳个数:" + count4);
     */
}
