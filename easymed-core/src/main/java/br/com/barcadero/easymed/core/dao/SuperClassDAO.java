package br.com.barcadero.easymed.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.barcadero.easymed.core.tables.Entidade;


/*
 * --------------------------------------------------------------------------
 * Spring recommends that you only annotate concrete classes (and methods of concrete classes) 
 * with the @Transactional annotation, as opposed to annotating interfaces. You certainly can 
 * place the @Transactional annotation on an interface (or an interface method), but this works 
 * only as you would expect it to if you are using interface-based proxies.
 * --------------------------------------------------------------------------
 * 
 */

public  abstract class SuperClassDAO<T extends Entidade>  implements IDao<T>{
	
	
	
	@PersistenceContext
	protected EntityManager manager;
	
	
	public SuperClassDAO() {
		
	}

	public T insert(T entidade){
		manager.persist(entidade);
		return entidade;
			
	}


	public void delete(T entidade) {
		manager.remove(manager.merge(entidade));
		
	}

	public T update(T entidade){
		manager.merge(entidade);
		return entidade;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

}
