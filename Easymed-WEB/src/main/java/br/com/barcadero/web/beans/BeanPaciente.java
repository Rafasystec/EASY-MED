package br.com.barcadero.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.easymed.core.service.ServicePaciente;
import br.com.barcadero.easymed.core.tables.Paciente;

@ManagedBean
@ViewScoped
public class BeanPaciente extends SuperBean<Paciente> {

	
	private Paciente paciente;
	@ManagedProperty("#{servicePaciente}")
	private ServicePaciente servicePaciente;
	
	@PostConstruct
	public void init() {
		
	}
	@Override
	public String deletar(Paciente paciente) throws Exception {
		if(paciente != null && paciente.getCodigo() > 0){
			long codigo = paciente.getCodigo();
			servicePaciente.delete(paciente);
			exibirMensagem("Paciente "+codigo+ " Excluido com sucesso!");
		}else{
			exibirErroGrave("Paciente não é válido para exclusão");
		}
		return null;
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar(Paciente entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public ServicePaciente getServicePaciente() {
		return servicePaciente;
	}
	public void setServicePaciente(ServicePaciente servicePaciente) {
		this.servicePaciente = servicePaciente;
	}

}
