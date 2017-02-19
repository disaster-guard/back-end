package Controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationController implements CommandLineRunner {
//    public static void main(String[] args) {
//        SpringApplication.run(ApplicationController.class, args);
//    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationController.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running app......partay.");
    }
}
