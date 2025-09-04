package com.aliyun.oss;

/**
 * @version 1.0
 * @date 2025/8/18 15:27
 */
@SuppressWarnings("all")
public class AliyunOSSProperties {
    private String endpoint;
    private String bucketName;
    private String region;

    public AliyunOSSProperties() {
    }

    public AliyunOSSProperties(String endpoint, String bucketName, String region) {
        this.endpoint = endpoint;
        this.bucketName = bucketName;
        this.region = region;
    }

    /**
     * 获取
     * @return endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * 设置
     * @param endpoint
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * 获取
     * @return bucketName
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * 设置
     * @param bucketName
     */
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * 获取
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    public String toString() {
        return "AliyunOSSProperties{endpoint = " + endpoint + ", bucketName = " + bucketName + ", region = " + region + "}";
    }
}
