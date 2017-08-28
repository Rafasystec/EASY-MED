package br.com.barcadero.web.beans;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.barcadero.easymed.core.tables.Clinica;
import br.com.barcadero.easymed.core.tables.Usuario;
import br.com.barcadero.web.util.Attributs;

public class SessionContext { 
	private static SessionContext instance; 
	public static SessionContext getInstance(){ 
		if (instance == null){ 
			instance = new SessionContext(); 
		} return instance; 
	} 
	
	private SessionContext(){ 
		
	} 
	private ExternalContext currentExternalContext(){ 
		if (FacesContext.getCurrentInstance() == null){ 
			throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP"); 
		}else{ 
			return FacesContext.getCurrentInstance().getExternalContext(); 
		} 
	} 
	
	public Usuario getUsuarioLogado(){ 
		return (Usuario) getAttribute(Attributs.USER); 
	} 
	public void setUsuarioLogado(Usuario usuario){ 
		setAttribute(Attributs.USER, usuario); 
	} 
	public void encerrarSessao(){ 
		currentExternalContext().invalidateSession(); 
	} 
	public Object getAttribute(String nome){ 
		return currentExternalContext().getSessionMap().get(nome); 
	} 
	public void setAttribute(String nome, Object valor){ 
		currentExternalContext().getSessionMap().put(nome, valor); 
	} 
	
	/**
	 * Obtem a clinica logada da sessao
	 * @return
	 */
	public Clinica getClinicaLogada() {
		Clinica clinica;
		if(getAttribute(Attributs.CLINICA_LOGADA) != null){
			clinica = (Clinica)getAttribute(Attributs.CLINICA_LOGADA);
		}else{
			clinica = new Clinica();
		}
		return clinica;
	}
	
	/**
	 * Coloca um objeto clinica na sessao
	 * @param clinica
	 */
	public void setClinicaLogada(Clinica clinica) {
		setAttribute(Attributs.CLINICA_LOGADA, clinica);
	}
	
	public void redirectToLogin() throws IOException {
		redirect("/public/PagLogin.xhtml");
	}
	
	public static void failed() {
		FacesContext.getCurrentInstance().validationFailed();
	}
	
	private void redirect(String page) throws IOException {
		String contextPath = currentExternalContext().getRequestContextPath();
		System.out.println("Context path: " + contextPath); 
		currentExternalContext().redirect(contextPath + page);
	}
	
	
	public void setTempCodEmp(long codEmp) {
		setAttribute(Attributs.TEMP_COD_EMP, codEmp);
	}
	
	public long getTempCodEmp() {
		if(getAttribute(Attributs.TEMP_COD_EMP) != null){
			return Long.parseLong(getAttribute(Attributs.TEMP_COD_EMP).toString());
		}else{
			return 0;
		}
	}
	
	public void setIpAddress(String ipAddress) {
		setAttribute(Attributs.IP_ADDRESS, ipAddress);
	}
	
}

