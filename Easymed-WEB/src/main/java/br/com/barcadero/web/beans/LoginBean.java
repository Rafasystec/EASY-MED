package br.com.barcadero.web.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.barcadero.commons.security.HandleEncrypt;
import br.com.barcadero.easymed.core.tables.Usuario;
import br.com.barcadero.web.util.Attributs;




@ManagedBean
@RequestScoped
public class LoginBean {
	public LoginBean (){
		super();
	}

	private String focusProperty = "";
	private SessionContext session;
	private String usuario;
	private String senha;

	

	public String login() {
		System.out.println("entrou login");
		String validate = validate();
		if(validate.trim().isEmpty()){
			//TODO por a regra de login aqui
			return "sucessoLogin";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no login!", validate));
			return null;
		}
	}

	public String validate() {
		String result = "";
		if(getUsuario().trim().isEmpty()){
			result = "Por favor informar o Usuario para o login.";
			setFocusProperty("usuario");
		}else if(getSenha().trim().isEmpty()){
			result = "Por favor informar a senha para o login";
		}
		return result;
	}

	public String logout() {
		
		return "logout";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = HandleEncrypt.toMD5(senha) ;
	}

	public void chamar(){
		System.out.println("chamou");
	}

	public String getFocusProperty() {
		return focusProperty;
	}

	public void setFocusProperty(String focusProperty) {
		this.focusProperty = focusProperty;
	}


	protected void autorizarLogin(Usuario usuario) {
		getSession().setAttribute("autorizado", true);
		getSession().setAttribute(Attributs.USER_NOME,   usuario.getNome());
		getSession().setAttribute(Attributs.USER_LOGIN,  usuario.getLogin());
		getSession().setAttribute(Attributs.USER_CODIGO, usuario.getCodigo());
		getSession().setAttribute(Attributs.USER, usuario);
	}

	public SessionContext getSession() {
		return session;
	}

	public void setSession(SessionContext session) {
		this.session = session;
	}

}
