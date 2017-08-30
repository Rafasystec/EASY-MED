package br.com.barcadero.easymed.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.easymed.core.dao.DaoPaciente;
import br.com.barcadero.easymed.core.exceptions.ExceptionValidation;
import br.com.barcadero.easymed.core.tables.Paciente;
import br.com.barcadero.easymed.core.tables.Usuario;
@Service
public class ServicePaciente extends SuperClassService<Paciente> {

	public ServicePaciente() {
		System.out.println(ServicePaciente.class.getName() + "...............OK");
	}
	@Autowired
	private DaoPaciente daoPaciente;
	
	@Override
	public Paciente insert(Paciente entidade) throws ExceptionValidation {
		return daoPaciente.insert(entidade);
	}

	@Override
	public void delete(Paciente entidade) throws ExceptionValidation {
		daoPaciente.delete(entidade);
		
	}

	@Override
	public Paciente update(Paciente paciente) throws ExceptionValidation {
		return daoPaciente.update(paciente);
	}

	@Override
	public Paciente find(long codigo) throws ExceptionValidation {
		return daoPaciente.find(codigo, Paciente.class);
	}

	public DaoPaciente getDaoPaciente() {
		return daoPaciente;
	}

	public void setDaoPaciente(DaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}
	
	public List<Paciente> findAll(Usuario usuario) {
		return daoPaciente.findAll(usuario);
	}
}
