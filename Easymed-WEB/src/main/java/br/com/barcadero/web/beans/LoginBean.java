package br.com.barcadero.web.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.barcadero.commons.security.HandleEncrypt;
import br.com.barcadero.easymed.core.service.ServiceUsuario;
import br.com.barcadero.easymed.core.tables.Usuario;
import br.com.barcadero.web.util.Attributs;
import br.com.barcadero.web.util.MessagesBeanUtil;




@ManagedBean
@ViewScoped
public class LoginBean {
	public LoginBean (){
		super();
	}

	private String focusProperty = "";
	private SessionContext session;
	private String usuario;
	private String senha;

	@ManagedProperty(value="#{serviceUsuario}")
	private ServiceUsuario serviceUsuario;
	
	public String login() {
		System.out.println("entrou login");
		String validate = validate();
		if(validate.trim().isEmpty()){
			Usuario usuario = null;
			try {
				usuario = serviceUsuario.findUsuarioByLoginSenha(getUsuario(), getSenha());
				if(usuario != null && usuario.getCodigo() > 0){
					autorizarLogin(usuario);
					return "sucessoLogin";
				}
			} catch (Exception e) {
				
			}
			
			MessagesBeanUtil.erroMessage("Usuário ou senha inválido! Por favor tente novamente");
			return null;
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
		try {
			getSession().encerrarSessao();
			return "../index.xhtml";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
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
	
	public boolean isLogado() {
		if(getSession() != null){
			return getSession().getAttribute(Attributs.USER) != null;
		}else{
			return false;
		}
		
	}
	
	public String getUserName() {
		if(getSession() != null){
			if(getSession().getAttribute(Attributs.USER) != null){
				Usuario usuario = (Usuario) getSession().getAttribute(Attributs.USER);
				return usuario.getNome();
			}
			return "";
		}else{
			return "";
		}
	}

	public SessionContext getSession() {
		return session;
	}

	public void setSession(SessionContext session) {
		this.session = session;
	}

	public ServiceUsuario getServiceUsuario() {
		return serviceUsuario;
	}

	public void setServiceUsuario(ServiceUsuario serviceUsuario) {
		this.serviceUsuario = serviceUsuario;
	}

}
