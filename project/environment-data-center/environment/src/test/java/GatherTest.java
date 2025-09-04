import com.tjy.pojo.Environment;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @version 1.0
 * @date 2025/8/27 11:15
 */
public class GatherTest {
    @Test
    public void test01() throws Exception {
        //IO流绑定解析文件
        //env-gather-impl\src\main\resources\data-file-simple
        BufferedReader br =
                new BufferedReader(new FileReader("src/main/resources/data-file-simple"));
        System.out.println(br);

        //读取一行数据
        String line = br.readLine();
        System.out.println("read: " + line);

        if(br != null)
            br.close();
    }

    @Test
    public void test02() {
        String s1 = "100|101|2|16|1|3|5d806ff802|1|1516323615936";
        //注意：| 是特殊字符，需要去除其特殊含义：[|] 或 \\|
        String[] split = s1.split("[|]");
        System.out.println("length: " + split.length);
        System.out.println(Arrays.toString(split));
    }

    @Test
    public void test03() {
        //温湿度数据解析
        String s1 = "5d806ff802";
        String substring = s1.substring(0, 4);
        System.out.println(substring);
    }

    @Test
    public void test4() {
        //将16进制的字符串 转换为 int值
        int i = Integer.parseInt("5d80", 16);
        System.out.println(i);
    }

    @Test
    public void test5() {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        // 关联文件（建议使用相对路径或classpath）
        File file = new File("src/main/resources/data-file");
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

                if (name.equals("Temperature")) {
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

                if (name1.equals("Humidity")) {
                    String temperature = split[6].substring(0, 4);
                    int t = Integer.parseInt(temperature, 16);
                    data1 = t * (0.00268127F) - 46.85F;
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


            }
        } catch (Exception e) {
            System.out.println("读取文件时发生错误: " + e.getMessage());
        }
//        list.forEach(System.out::println);
        System.out.println("温度个数:" + count1);
        System.out.println("湿度个数:" + count2);
        System.out.println("光照强度个数:" + count3);
        System.out.println("二氧化碳个数:" + count4);
    }
}
