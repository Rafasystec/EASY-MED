package br.com.barcadero.easymed.core.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import br.com.barcadero.easymed.core.tables.Usuario;

@Repository
public class DaoUsuario extends SuperClassDAO<Usuario> {

	public DaoUsuario() {
		System.out.println(DaoUsuario.class.getName() + " ..................OK");
	}
	@Override
	public Usuario find(long codigo, Class<Usuario> type) throws NoResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll() throws NoResultException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario findUsuarioByLogin(String login, String senha) throws NoResultException{
		try{
			return getManager().createNamedQuery(Usuario.FIND_POR_NOME_LOGIN, Usuario.class)
					.setParameter("login", login)
					.setParameter("senha", senha)
					.getSingleResult();
		} catch (NoResultException e) {
			throw new NoResultException("Usuário ou senha inválidos");
		}
	}

	
}
