package com.myLogger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.myLogger.dao.**"})
public class MyLoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyLoggerApplication.class, args);
	}

}
