/**
 * Project Name: cis-pro
 * File Name: FastdfsConfig
 * Package Name: cn.cxinternet.paas.file.config
 * Date: 2020/10/26 10:27
 * Author: 方瑞冬
 */
package com.example.fastdfs.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 方瑞冬
 */
@Configuration
@ConfigurationProperties("fastdfs")
@Data
public class FastdfsConfig {
    private Integer connectTimeoutInSeconds;

    private Integer networkTimeoutInSeconds;

    private String charset;

    private String trackerServers;

    private String storageServer;
}
