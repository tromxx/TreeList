package com.TreeListProject.TreeList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 날짜, 시간정보 자동 생성을 위해 추가
@SpringBootApplication
public class TreeListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreeListApplication.class, args);
	}

}
