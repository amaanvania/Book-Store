package com.example.demo;

import com.example.demo.ctrl.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SmokeTest {

	@Autowired BookController bookCtrl;
	@Autowired OrderController orderCtrl;
	@Autowired UserController userCtrl;
	@Autowired CategoryController catCtrl;
	@Autowired OrderItemController oitCtrl;
	@Autowired ReviewController revCtrl;

	
	@Test
	void contextLoads() {
		assertThat(bookCtrl).isNotNull();
		assertThat(orderCtrl).isNotNull();
		assertThat(userCtrl).isNotNull();
		assertThat(catCtrl).isNotNull();
		assertThat(oitCtrl).isNotNull();
		assertThat(revCtrl).isNotNull();

	}

}
