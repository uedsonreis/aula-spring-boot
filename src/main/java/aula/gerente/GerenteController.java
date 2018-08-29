package aula.gerente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GerenteController {

	@Autowired
	private Gerente gerente;
	
	@RequestMapping("/funcionario/contratar")
    public Boolean contratar(
    		@RequestParam(value="nome") String nome,
    		@RequestParam(value="sobreNome") String sobreNome,
    		@RequestParam(value="idade") Integer idade) {
    	
		Funcionario f = new Funcionario();
		f.setNome(nome);
		f.setSobreNome(sobreNome);
		f.setIdade(idade);
    	
        return this.gerente.contratar(f);
    }
	
	@RequestMapping("/funcionario/demitir")
    public Boolean demitir(@RequestParam String email) {
    	
		Funcionario f = new Funcionario();
		f.setEmail(email);
    	
        return this.gerente.demitir(f);
    }
	
	@RequestMapping("/funcionarios")
	public List<Funcionario> getFuncionarios() {
		return this.gerente.getFuncionarios();
	}
}
