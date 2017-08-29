package br.com.barcadero.web.beans;

import br.com.barcadero.easymed.core.tables.Entidade;

public interface IBeanClass<T extends Entidade> {

	abstract public String salvar()throws Exception;
	abstract public String alterar()throws Exception;
	abstract public String deletar(T entidade)throws Exception;
	abstract public String deletar()throws Exception;
	abstract public String novo()throws Exception;
	abstract public String imprimir()throws Exception;
	public boolean validar(T entidade)throws Exception;
}
