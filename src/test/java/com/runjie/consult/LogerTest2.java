package com.runjie.consult;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LogerTest2 {
	
	@Test
	public void test2 () {
		String name = "test";
		String age = "18";
		log.info("name:{} and age: {}", name, age);
		log.debug("debug...");
		log.info("info..." + "haha");
		log.error("error...");
	}
}
