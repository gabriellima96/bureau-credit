package site.gabriellima.bureau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BureauCreditServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BureauCreditServerApplication.class, args);
	}

}
