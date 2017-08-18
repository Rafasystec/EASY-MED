package br.com.barcadero.easymed.core.service;

import br.com.barcadero.easymed.core.exceptions.ExceptionValidation;

public interface IService<T> {
	public T insert(T entidade)  throws ExceptionValidation ;
	public void delete(long codigo) throws ExceptionValidation  ;
	public T update(T entidade)  throws ExceptionValidation ;
	public T find(long codigo) throws ExceptionValidation  ;
}
