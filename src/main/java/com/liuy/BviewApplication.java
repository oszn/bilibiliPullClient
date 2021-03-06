package com.liuy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan({"com.liuy.dao.**"})
@SpringBootApplication
@EnableAutoConfiguration()
public class BviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(BviewApplication.class, args);
	}

}
