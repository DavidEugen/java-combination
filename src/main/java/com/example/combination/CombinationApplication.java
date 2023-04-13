package com.example.combination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class CombinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CombinationApplication.class, args);
	}

}
