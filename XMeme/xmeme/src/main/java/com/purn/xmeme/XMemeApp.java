package com.purn.xmeme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XMemeApp {

	public static void main(String[] args) {
		SpringApplication.run(XMemeApp.class, args);
		System.out.println("!!!!!!!!! Your XMeme App server has started on port :8081. !!!!!!!!!!");
	}

}
