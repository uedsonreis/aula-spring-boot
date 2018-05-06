package service;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.GerenciaLogin;
import bo.Login;

@RestController
public class LoginController {
	
	@Autowired
	private GerenciaLogin gerenciaLogin;
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/logar")
	public Boolean logar(@RequestBody Login login, HttpServletRequest request) {
		
		if (this.gerenciaLogin.validar(login)) {
			request.getSession().setAttribute("login", login);
			return true;
		}
		
		return false;
	}
	
	@RequestMapping("/logout")
	public Boolean logout(HttpServletRequest request) {
		request.getSession().setAttribute("login", null);
		return true;
	}
	
	@RequestMapping("/validar")
	public String validar(HttpServletRequest request) {
		Login login = (Login) request.getSession().getAttribute("login");
		if (login == null) {
			return "false";
		}
		return login.getNome();
	}
	
	@RequestMapping("/salvar")
	public Boolean salvar(@RequestBody Login login) {
		return this.gerenciaLogin.adicionar(login);
	}
	
	@RequestMapping("/listar")
	public Collection<Login> listar() {
		return this.gerenciaLogin.getListaLogins();
	}
}
