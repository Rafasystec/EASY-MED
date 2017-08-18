package br.com.barcadero.easymed.core.dao;

import javax.persistence.NoResultException;

public interface IDao <T>{

	public T find(long codigo, Class<T> type) throws NoResultException;
	public T findAll() throws NoResultException;
}
