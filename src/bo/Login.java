package bo;

import org.springframework.stereotype.Component;

@Component
public class Login {

	private String nome;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		if (this.nome != null) {
			return this.nome;
		}
		return super.toString();
	}
	
	public int hashCode() {
		return this.nome.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Login other = (Login) obj;
		if (this.nome == null) {
			if (other.nome != null) return false;
		} else if (!this.nome.equals(other.nome))
			return false;
		return true;
	}
}
