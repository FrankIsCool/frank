package com.sxmaps.mms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;

@EnableRetry
@EnableScheduling
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableAsync
@MapperScan(basePackages = "com.sxmaps.my.mapper")
public class MmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsApplication.class, args);
	}
}