package br.com.barcadero.easymed.core.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.barcadero.easymed.core.enums.EnumTpConvenio;
import br.com.barcadero.easymed.core.enums.EnumTpPreco;

@Entity
@Table(name="T_CNV")
public class Convenio extends Entidade {
	
	private static final long serialVersionUID = 3888840312855118416L;
	@Column(name="NM_CNV",nullable=false,length=20)
	private String convenio;
	@Column(name="TP_CNV_ATV",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumTpConvenio tpConvenio;
	@Column(name="NR_MAX_CONS_MES",nullable=false)
	@Enumerated(EnumType.STRING)
	private int maxConsultasMes = 0;
	@Column(name="TP_PRECO",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumTpPreco tpPreco;
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	public EnumTpConvenio getTpConvenio() {
		return tpConvenio;
	}
	public void setTpConvenio(EnumTpConvenio tpConvenio) {
		this.tpConvenio = tpConvenio;
	}
	public int getMaxConsultasMes() {
		return maxConsultasMes;
	}
	public void setMaxConsultasMes(int maxConsultasMes) {
		this.maxConsultasMes = maxConsultasMes;
	}
	public EnumTpPreco getTpPreco() {
		return tpPreco;
	}
	public void setTpPreco(EnumTpPreco tpPreco) {
		this.tpPreco = tpPreco;
	}
	
	

}
