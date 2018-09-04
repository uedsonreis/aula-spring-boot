package aula.gerente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class GerenteController {

	@Autowired
	private Gerente gerente;
	
	@RequestMapping("/funcionario/contratar")
    public Boolean contratar(@RequestBody Funcionario f) {
        return this.gerente.contratar(f);
    }
	
	@RequestMapping("/funcionario/demitir")
    public Boolean demitir(@RequestBody Funcionario f) {    	
        return this.gerente.demitir(f);
    }
	
	@RequestMapping("/funcionarios")
	public List<Funcionario> getFuncionarios() {
		return this.gerente.getFuncionarios();
	}
}
