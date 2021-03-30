package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.ctrl.BookController;
import com.example.demo.ctrl.CategoryController;
import com.example.demo.ctrl.OrderController;
import com.example.demo.ctrl.OrderItemController;
import com.example.demo.ctrl.ReviewController;
import com.example.demo.ctrl.UserController;

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
