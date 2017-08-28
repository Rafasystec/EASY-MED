package br.com.barcadero.web.beans;

import java.io.Serializable;
import java.net.UnknownHostException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import br.com.barcadero.easymed.core.tables.Clinica;
import br.com.barcadero.easymed.core.tables.Entidade;
import br.com.barcadero.easymed.core.tables.Usuario;
import br.com.barcadero.web.util.Attributs;


public abstract class SuperBean<T extends Entidade>  implements Serializable, IBeanClass<T>{
	
	private static final long serialVersionUID = -7940750516142819573L;
	
	abstract public String salvar()throws Exception;
	abstract public String alterar()throws Exception;
	abstract public String deletar()throws Exception;
	abstract public String novo()throws Exception;
	
	public String validar() {
		return "";
	}
	
	private SessionContext session;
	@SuppressWarnings("unused")
	private HttpSession httpSession;
	public SuperBean() {
		this.session = SessionContext.getInstance();
	}
	
	public SessionContext getSession() {
		return session;
	}
	
	protected HttpServletRequest getCurrentRequest() {
		FacesContext context = FacesContext.getCurrentInstance();
		this.httpSession = (HttpSession)context.getExternalContext().getSession(true);
		return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	public void failed() {
		SessionContext.failed();
	}
	
	protected void exibirErroGrave(Exception e) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,null,"Erro ao tentar logar: " + e.getMessage()));
	}
	
	protected void exibirErroGrave(String msgErro) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,null,msgErro));
	}
	
	protected void exibirMensagem(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,null,mensagem));
	}
	
	protected void exibirMsgAlerta(String msgAlert) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,null,msgAlert));
	}
	
	protected Clinica getClinicaLogada() {
		return getSession().getClinicaLogada();
	}
	
	protected Usuario getUsuarioLogado() {
		return getSession().getUsuarioLogado();
	}
	
	protected void mensagemInfor(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
	
	protected void autorizarLogin(Usuario usuario) {
		getSession().setAttribute("autorizado", true);
		getSession().setAttribute(Attributs.USER_NOME,   usuario.getNome());
		getSession().setAttribute(Attributs.USER_LOGIN,  usuario.getLogin());
		getSession().setAttribute(Attributs.USER_CODIGO, usuario.getCodigo());
		getSession().setAttribute(Attributs.USER, usuario);
	}
	
}
