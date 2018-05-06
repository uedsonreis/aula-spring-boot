package bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Component
public class GerenciaLogin {
	
	private final List<Login> logins = new ArrayList<Login>();

	public GerenciaLogin() {
		Login adm = new Login();
		adm.setNome("admin");
		adm.setSenha("123");
		
		this.logins.add(adm);
	}
	
	public boolean adicionar(Login login) {
		if (this.logins.contains(login)) {
			return false;
		} else {
			this.logins.add(login);
			return true;
		}
	}
	
	public boolean validar(Login login) {
		for (Login l : this.logins) {
			if (l.equals(login)) {
				if (l.getSenha().equals(login.getSenha())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Collection<Login> getListaLogins() {
		return this.logins;
	}
}
