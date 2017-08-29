package br.com.barcadero.easymed.core.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.easymed.core.dao.DaoConvenio;
import br.com.barcadero.easymed.core.exceptions.ExceptionValidation;
import br.com.barcadero.easymed.core.tables.Convenio;
import br.com.barcadero.easymed.core.tables.Usuario;

@Service
public class ServiceConvenio extends SuperClassService<Convenio>{

	@Autowired
	private DaoConvenio daoConvenio;
	@Override
	public Convenio insert(Convenio convenio) throws ExceptionValidation {
		return daoConvenio.insert(convenio);
	}

	@Override
	public void delete(Convenio entidade) throws ExceptionValidation {
		daoConvenio.delete(entidade);
		
	}

	@Override
	public Convenio update(Convenio convenio) throws ExceptionValidation {
		return daoConvenio.update(convenio);
	}

	@Override
	public Convenio find(long codigo) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Convenio> findAll(Usuario usuario) throws NoResultException {
		return daoConvenio.findAll(usuario);
	}

	public DaoConvenio getDaoConvenio() {
		return daoConvenio;
	}

	public void setDaoConvenio(DaoConvenio daoConvenio) {
		this.daoConvenio = daoConvenio;
	}

}
