package com.runjie.consult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

//允许跨域请求 全局设置
@CrossOrigin(origins = {"*", "null"})
@SpringBootApplication
public class ConsultApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultApplication.class, args);
	}

}
