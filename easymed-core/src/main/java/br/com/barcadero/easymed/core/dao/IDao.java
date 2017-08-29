package br.com.barcadero.easymed.core.dao;

import java.util.List;

import javax.persistence.NoResultException;

public interface IDao <T>{

	public T find(long codigo, Class<T> type) throws NoResultException;
	public List<T> findAll() throws NoResultException;
}
