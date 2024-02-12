package lt.codeacademy.bookverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class BookverseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookverseApplication.class, args);
	}
}
