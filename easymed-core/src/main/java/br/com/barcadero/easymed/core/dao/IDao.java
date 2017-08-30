package br.com.barcadero.easymed.core.dao;

import java.util.List;

import javax.persistence.NoResultException;

public interface IDao <T>{

	public List<T> findAll() throws NoResultException;
}
