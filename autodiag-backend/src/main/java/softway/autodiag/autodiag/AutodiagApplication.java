package softway.autodiag.autodiag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class AutodiagApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutodiagApplication.class, args);
	}

}
