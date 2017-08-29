package br.com.barcadero.easymed.core.tables;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class EntidadeComUsuario extends Entidade {

	public EntidadeComUsuario() {
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -457865618462477113L;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USUARIO",referencedColumnName="CODIGO")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntidadeComUsuario other = (EntidadeComUsuario) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
}
