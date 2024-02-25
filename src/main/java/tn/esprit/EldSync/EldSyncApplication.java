package tn.esprit.EldSync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EldSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(EldSyncApplication.class, args);
	}

}
