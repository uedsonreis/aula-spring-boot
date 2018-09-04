package aula.gerente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import aula.FirestoreDAO;

public class Gerente {

	@Autowired
	private FirestoreDAO dao;
	
	public Boolean contratar(Funcionario funcionario) {
		
		funcionario.setEmail(
				funcionario.getNome().toLowerCase().trim()
				+"."
				+funcionario.getSobreNome().toLowerCase().trim()
				+"@unime.edu.br");
		
		return this.dao.save(funcionario);
	}
	
	public boolean demitir(Funcionario funcionario) {
		return this.dao.delete(funcionario.getEmail());
	}
	
	public List<Funcionario> getFuncionarios() {
		return this.dao.getFuncionarios();
	}
}
