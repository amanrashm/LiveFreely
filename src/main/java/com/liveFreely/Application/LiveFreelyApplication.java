package com.liveFreely.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
@ComponentScan("com.liveFreely")
public class LiveFreelyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveFreelyApplication.class, args);
	}

}
