package site.gabriellima.bureau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class BureauCreditBaseAApplication {

    public static void main(String[] args) {
        SpringApplication.run(BureauCreditBaseAApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

}
