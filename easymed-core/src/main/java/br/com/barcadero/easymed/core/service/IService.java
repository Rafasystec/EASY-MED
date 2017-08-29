package br.com.barcadero.easymed.core.service;

import br.com.barcadero.easymed.core.exceptions.ExceptionValidation;
import br.com.barcadero.easymed.core.tables.Entidade;

public interface IService<T extends Entidade> {
	public T insert(T entidade)  throws ExceptionValidation ;
	public void delete(T entidade) throws ExceptionValidation  ;
	public T update(T entidade)  throws ExceptionValidation ;
	public T find(long codigo) throws ExceptionValidation  ;
}
