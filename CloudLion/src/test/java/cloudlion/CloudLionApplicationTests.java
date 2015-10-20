package cloudlion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import cloudlion.CloudLionApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CloudLionApplication.class)
@WebAppConfiguration
public class CloudLionApplicationTests {

	@Test
	public void contextLoads() {
	}

}
