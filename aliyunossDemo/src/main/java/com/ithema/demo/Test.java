package com.ithema.demo;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Test {

    public static final String QINGCHENGDIANZISHANGW = "qingchengdianzishangw";

    public static void main(String[] args) throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
          // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，
         // 创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4Fdx8zGRLKjV1Fz2KwqV";
        String accessKeySecret = "C9rm1uYPXZhvYgQnbV6mCDrUxUp4HS";
          // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
         // 上传文件流。
        InputStream inputStream = new FileInputStream("E:\\1.jpg");
        ossClient.putObject(QINGCHENGDIANZISHANGW, "abc.jpg", inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
