package com.casino.live.dealer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.medmedchiheb.simpleapp.SimpleAppApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleAppApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testController() {
		SimpleAppApplication app = new SimpleAppApplication();
		
		assertThat(app.start()).isNotNull();
	}

}
