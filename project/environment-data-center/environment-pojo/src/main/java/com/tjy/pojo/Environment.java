package com.tjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @version 1.0
 * @date 2025/8/27 11:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Environment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    //环境种类名称
    private String name;
    //发送端id
    private String srcId;
    //树莓派系统id
    private String desId;
    //实验箱区域模块id(1-8)
    private String devId;
    //模块上传感器地址
    private String sersorAddress;
    //传感器个数
    private int count;
    //发送指令标号 3表示接收数据 16表示发送命令
    private String cmd;
    //状态 默认1表示成功
    private int status;
    //环境值
    private float data;
    //采集时间
    private LocalDateTime gather_date;
}
