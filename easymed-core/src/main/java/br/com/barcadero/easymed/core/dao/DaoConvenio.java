package br.com.barcadero.easymed.core.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.barcadero.easymed.core.tables.Convenio;
import br.com.barcadero.easymed.core.tables.Usuario;
@Repository
public class DaoConvenio extends SuperClassDAO<Convenio> {

	public DaoConvenio() {
	}
	

	@Override
	public List<Convenio> findAll() throws NoResultException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<Convenio> findAll(Usuario usuario) throws NoResultException {
		TypedQuery<Convenio> qry = getManager().createNamedQuery(Convenio.FIND_ALL_BY_USER, Convenio.class);
		qry.setParameter("usuario", usuario);
		return qry.getResultList();
	}

}
