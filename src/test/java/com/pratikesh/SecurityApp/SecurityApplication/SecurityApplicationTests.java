package com.pratikesh.SecurityApp.SecurityApplication;

import com.pratikesh.SecurityApp.SecurityApplication.entities.User;
import com.pratikesh.SecurityApp.SecurityApplication.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {

		User user = new User(4L, "prat@gmail.com", "6721");
		String token = jwtService.generateToken(user);
		System.out.println(token);

		Long id = jwtService.getUserIdFromToken(token);
		System.out.println(id);
	}

}
