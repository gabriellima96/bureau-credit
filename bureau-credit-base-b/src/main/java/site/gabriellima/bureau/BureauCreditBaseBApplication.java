package site.gabriellima.bureau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BureauCreditBaseBApplication {

	public static void main(String[] args) {
		SpringApplication.run(BureauCreditBaseBApplication.class, args);
	}

}
