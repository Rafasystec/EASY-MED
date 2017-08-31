package br.com.barcadero.easymed.core.tables;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;
//TODO ainda por fazer
@Entity
@Table(name="T_AMB")
public class Amb extends Entidade {
	
	private String nmAmb 		= "";
	private BigDecimal qtAmbCh 	= new BigDecimal("0.00");
	

}
