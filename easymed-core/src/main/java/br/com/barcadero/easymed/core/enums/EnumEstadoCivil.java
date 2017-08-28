package br.com.barcadero.easymed.core.enums;

public enum EnumEstadoCivil {

	CASADO("CASADO(A)"),
	SOLTEIRO("SOLTEIRO(A)"),
	DIVORCIADO("DIVORCIADO(A)"),
	VIUVO("VIUVO(A)"),
	OUTROS("OUTRO");
	
	private final String nome;
	EnumEstadoCivil(String nome){
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
}
