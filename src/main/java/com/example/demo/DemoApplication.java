package com.example.demo;

import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

import javax.annotation.Resource;

@Controller
@SpringBootApplication
public class DemoApplication {

	@Resource
	SqlSession sqlSession;

	@RequestMapping("/")
	@ResponseBody
	String home() {
		sqlSession.getConnection();

		return "Happy Coding!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
