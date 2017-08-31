package br.com.barcadero.easymed.core.tables;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.barcadero.easymed.core.enums.EnumTpSituacaoAgendamento;

@Entity
@Table(name="T_AGE")
public class Agendamento extends EntidadeComUsuario {

	
	
	private Date dtAgendamento = new Date();
	private Date hrAgendamento = new Date();
	private Date dtAgendMarcada= new Date();
	private String nomePaciente ="";
	private String telefone = "";
	private int diasAvisarAntecedencia = 1;
	private EnumTpSituacaoAgendamento tpSituacaoAngendamento;
	
	private Paciente paciente;
	private Convenio convenio;
	private Amb amb;
	
}
