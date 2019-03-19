package com.casino.live.dealer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.medmedchiheb.simpleapp.SimpleAppApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleAppApplicationTests {

	Logger LOGGER = LoggerFactory.getLogger(SimpleAppApplicationTests.class);
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testController() {
		LOGGER.info(" >>> unit-test <<<");
		SimpleAppApplication app = new SimpleAppApplication();
		
		assertThat(app.start()).isNotNull();
	}

}
