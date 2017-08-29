package br.com.barcadero.easymed.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.easymed.core.dao.DaoPaciente;
import br.com.barcadero.easymed.core.exceptions.ExceptionValidation;
import br.com.barcadero.easymed.core.tables.Paciente;
@Service
public class ServicePaciente extends SuperClassService<Paciente> {

	public ServicePaciente() {
		System.out.println(ServicePaciente.class.getName() + "...............OK");
	}
	@Autowired
	private DaoPaciente daoPaciente;
	
	@Override
	public Paciente insert(Paciente entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Paciente entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paciente update(Paciente entidade) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente find(long codigo) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return null;
	}

	public DaoPaciente getDaoPaciente() {
		return daoPaciente;
	}

	public void setDaoPaciente(DaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}

}
