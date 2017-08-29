package br.com.barcadero.easymed.core.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.easymed.core.dao.DaoUsuario;
import br.com.barcadero.easymed.core.exceptions.ExceptionValidation;
import br.com.barcadero.easymed.core.tables.Usuario;

@Service
public class ServiceUsuario extends SuperClassService<Usuario>{

	@Autowired
	private DaoUsuario daoUsuario;
	
	public ServiceUsuario() {
		System.out.println(ServiceUsuario.class.getName() + "................OK");
	}
	
	@Override
	public Usuario insert(Usuario entidade) throws ExceptionValidation {
		return daoUsuario.insert(entidade);
	}

	@Override
	public Usuario update(Usuario entidade) throws ExceptionValidation {
		return daoUsuario.update(entidade);
	}

	@Override
	public Usuario find(long codigo) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return null;
	}

	public DaoUsuario getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(DaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	@Override
	public void delete(Usuario entidade) throws ExceptionValidation {
		daoUsuario.delete(entidade);
		
	}
	
	public Usuario findUsuarioByLoginSenha(String login, String senha) throws Exception{
		return daoUsuario.findUsuarioByLogin(login, senha);
	}

}
