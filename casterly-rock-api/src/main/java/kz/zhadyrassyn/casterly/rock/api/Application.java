package kz.zhadyrassyn.casterly.rock.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = "kz.zhadyrassyn.casterly.rock")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}