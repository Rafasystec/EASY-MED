package br.com.barcadero.easymed.core.dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.barcadero.easymed.core.tables.Paciente;
import br.com.barcadero.easymed.core.tables.Usuario;

@Repository
public class DaoPaciente extends SuperClassDAO<Paciente> {

	public DaoPaciente() {
		System.out.println(DaoPaciente.class.getName() +"...............OK");
	}
	@Override
	public Paciente find(long codigo, Class<Paciente> type) throws NoResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> findAll() throws NoResultException {
		// TODO Auto-generated method stub
		return null;
	}
	

	public List<Paciente> findAll(Usuario usuario) throws NoResultException {
		TypedQuery<Paciente> qry = getManager().createNamedQuery(Paciente.FIND_ALL_BY_USER, Paciente.class)
				.setParameter("usuario", usuario);
		return qry.getResultList();
	}

}
