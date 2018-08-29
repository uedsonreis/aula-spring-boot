package aula.hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aula.FirestoreDAO;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private FirestoreDAO dao;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name") String name) {
    	
    	Greeting obj = new Greeting(this.counter.incrementAndGet(), String.format(template, name));
    	
		this.dao.save(obj);
    	
        return obj;
    }
    
    @RequestMapping("/get")
    public List<Greeting> getGreetings() {
    		return this.dao.getAll();
    }
}