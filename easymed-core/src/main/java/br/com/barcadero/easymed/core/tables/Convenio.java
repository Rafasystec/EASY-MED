package br.com.barcadero.easymed.core.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.barcadero.easymed.core.enums.EnumTpConvenio;
import br.com.barcadero.easymed.core.enums.EnumTpPreco;
/**
 * Para a tabela de convenios
 * @author Rafael Rocha
 * @since 29/08/2017 as 10:24
 */

@NamedQueries({
	@NamedQuery(name=Convenio.FIND_ALL_BY_USER,query="FROM Convenio WHERE usuario = :usuario")
})

@Entity
@Table(name="T_CNV")
public class Convenio extends EntidadeComUsuario {
	
	public Convenio() {
	}
	
	public Convenio(Usuario usuario) {
		this.setUsuario(usuario);
	}
	
	public final static String FIND_ALL_BY_USER = "br.com.barcadero.easymed.core.tables.Convenio.findAllByUser";
	
	private static final long serialVersionUID = 3888840312855118416L;
	@Column(name="NM_CNV",nullable=false,length=20)
	private String convenio = "";
	@Column(name="TP_CNV_ATV",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumTpConvenio tpConvenio = EnumTpConvenio.OUTRO;
	@Column(name="NR_MAX_CONS_MES",nullable=false)
	private int maxConsultasMes = 0;
	@Column(name="TP_PRECO",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumTpPreco tpPreco = EnumTpPreco.PORTE;
	@Column(name="FL_ATIVO")
	private boolean flAtivo = true;
	
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		if(convenio != null){
			convenio = convenio.toUpperCase();
		}
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
	public boolean isFlAtivo() {
		return flAtivo;
	}
	public void setFlAtivo(boolean flAtivo) {
		this.flAtivo = flAtivo;
	}
	
	

}
