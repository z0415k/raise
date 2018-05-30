/*
package com.black.kun.raise.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

*/
/**
 * elasticsearch 配置文件
 *
 * @author zk
 *//*

@Configuration
public class ElasticSearchConfig {

    @Value("${localhost}")
    private String host;
    @Value("${spring.elasticsearch.port}")
    private int port;

    private static final Logger log = LogManager.getLogger(ElasticSearchConfig.class);

    @Bean
    public TransportClient elasticsearchClient() {   //向spring注入es的客户端操作对象
        TransportClient transportClient = null;

        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", "bigData-cluster").build();
        try {
            transportClient = TransportClient
                    .builder()
                    .settings(settings)
                    .build()
                    .addTransportAddress(
                            new InetSocketTransportAddress(InetAddress.getByName(host), port)
                    );
        } catch (UnknownHostException e) {
            log.error("创建elasticsearch客户端失败");
        }
        log.info("创建elasticsearch客户端成功");

        return transportClient;
    }

}
*/
