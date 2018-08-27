package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    private final FirestoreDAO dao = new FirestoreDAO();

    @RequestMapping("/greeting")
    public Greeting greeting(
    		@RequestParam(value="name", defaultValue="World")
    		String name) {
    	
    		Greeting obj = new Greeting(counter.incrementAndGet(), String.format(template, name));
    		
    		this.dao.save(obj);
    	
        return obj;
    }
    
    @RequestMapping("/get")
    public List<Greeting> getGreetings() {
    		return this.dao.getAll();
    }
}