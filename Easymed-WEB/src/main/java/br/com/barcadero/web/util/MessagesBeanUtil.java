package br.com.barcadero.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesBeanUtil {
	
	public static void erroMessage(String erro, String details) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, erro, details));
	}
	
	public static void erroMessage(String erro) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro do Sistema", erro));
	}
	
	public static void infor(String infor, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, infor,detail));
	}
	
	public static void infor(String infor) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação do Sistema",infor));
	}
	
	public static void alert(String alert) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ATENÇÃO!",alert));
	}
	public static void exception(Exception e) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Falha grave: ",e.getMessage()));
	}

}
