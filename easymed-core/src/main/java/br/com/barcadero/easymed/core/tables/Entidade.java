package br.com.barcadero.easymed.core.tables;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.easymed.core.util.IDUtil;

@MappedSuperclass
public abstract class Entidade implements Serializable {
	
	//private static final long serialVersionUID = -4937210358058008264L;

	/**
	 * 
	 */
	private static final long serialVersionUID = 8535860641291662663L;

	public Entidade() {
		
	}
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=IDUtil.ID, nullable=false)
	private long id;
	@Column(name="DT_CADATRO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtCadastro = new Date();
	@Column(name="HR_CADATRO", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hrCadastro = new Date();

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public Date getHrCadastro() {
		return hrCadastro;
	}
	public void setHrCadastro(Date hrCadastro) {
		this.hrCadastro = hrCadastro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entidade other = (Entidade) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
