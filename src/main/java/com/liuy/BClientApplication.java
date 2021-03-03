package com.liuy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.liuy.dao.**"})
@SpringBootApplication
public class BClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BClientApplication.class, args);
	}

}
