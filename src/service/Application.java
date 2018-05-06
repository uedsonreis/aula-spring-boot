package service;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import bo.GerenciaLogin;
import bo.Login;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot: ");
            
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            
            System.out.println("Oh my God! That works!");
        };
    }
    
//    @Bean
//    public SpringConfig springConfig() {
//    		return new SpringConfig();
//    }
    
    @Bean
    public GerenciaLogin gerenciaLogin() {
    		return new GerenciaLogin();
    }
    
    @Bean
    public Login login() {
    		return new Login();
    }

}