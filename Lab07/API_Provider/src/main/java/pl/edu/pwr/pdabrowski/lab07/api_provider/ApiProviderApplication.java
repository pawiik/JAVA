package pl.edu.pwr.pdabrowski.lab07.api_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.pwr.pdabrowski.lab07.api_provider.config.HibernateUtil;

@SpringBootApplication
public class ApiProviderApplication {

    public static HibernateUtil hibernateUtil = new HibernateUtil();

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApiProviderApplication.class, args);
        hibernateUtil.setUp();
    }
}
