package br.com.barcadero.web.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.barcadero.easymed.core.exceptions.ExceptionErroCallRest;
import br.com.barcadero.easymed.core.exceptions.ExceptionValidation;
import br.com.barcadero.easymed.core.tables.Usuario;
import br.com.barcadero.web.rest.CallUsuarioRest;





@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {//,AuthenticationManager {

	public UserDetailsServiceImpl() {
		
	}
	public UserDetails loadUserByUsername(String nmLogin) throws UsernameNotFoundException {
		try {
			return getUserByREST(nmLogin);
		} catch (ExceptionErroCallRest | ExceptionValidation e) {
			// TODO Auto-generated catch block
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

	private Usuario getUserByREST(String nmLogin) throws ExceptionErroCallRest, ExceptionValidation  {
		return new CallUsuarioRest().getUserByLoginName(nmLogin);
	}
	
}
