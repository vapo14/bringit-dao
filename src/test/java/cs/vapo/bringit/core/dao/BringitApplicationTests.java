package cs.vapo.bringit.core.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@SpringBootApplication
@AutoConfigurationPackage(basePackages = "cs.vapo.bringit.core.dao.*")
class BringitApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(BringitApplicationTests.class, args);
	}

	@Test
	void contextLoads() {
	}

}
