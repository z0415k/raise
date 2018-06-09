package com.black.kun.raise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 项目启动文件
 * @author zk
 */
@SpringBootApplication
@EnableCaching
public class RaiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaiseApplication.class, args);
	}
}
