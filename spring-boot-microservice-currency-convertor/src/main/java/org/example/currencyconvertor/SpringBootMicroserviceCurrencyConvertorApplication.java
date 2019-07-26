package org.example.currencyconvertor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("org.example.currencyconvertor")
@EnableDiscoveryClient
public class SpringBootMicroserviceCurrencyConvertorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceCurrencyConvertorApplication.class, args);
	}
}
