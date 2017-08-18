package br.com.barcadero.easymed.core.enums;

public enum EnumTpUsuario {

	ADMIN("ADMINISTRADOR"),
	COMUM("COMUM");
	
	private final String descricao;
	private EnumTpUsuario(String descricao) {
		this.descricao = descricao;
	}
}
