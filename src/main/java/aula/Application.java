package aula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import aula.gerente.Gerente;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public FirestoreDAO dao() {
    	return new FirestoreDAO();
    }
    
    @Bean
    public Gerente gerente() {
    	return new Gerente();
    }
}