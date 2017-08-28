package br.com.barcadero.easymed.core.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.easymed.core.enums.EnumEstadoCivil;
import br.com.barcadero.easymed.core.enums.EnumRaca;
import br.com.barcadero.easymed.core.enums.EnumSexo;
import br.com.barcadero.easymed.core.enums.EnumUF;

@Entity
@Table(name="T_PAC")
public class Paciente extends Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5014920796244100307L;
	@Column(name="NM_PAC",nullable=false,length=0)
	private String nome = "";
	@Column(name="NR_PAC_SEX",nullable=false,length=0)
	@Enumerated(EnumType.ORDINAL)
	private EnumSexo sexo = EnumSexo.MASCULINO;
	@Column(name="TP_PAC_EST_CIV",nullable=false,length=0)
	@Enumerated(EnumType.ORDINAL)
	private EnumEstadoCivil estadoCivil = EnumEstadoCivil.CASADO;
	@Column(name="DT_PAC_NAS",nullable=false,length=0) 
	private Date dtNascimento = new Date();
	@Column(name="DS_PAC_MAT",nullable=false,length=25)
	private String matricula = "";
	@Column(name="DS_PAC_END",nullable=false,length=60)
	private String endereco = "";
	@Column(name="DS_PAC_BAI",nullable=false,length=60)
	private String bairro = "";
	@Column(name="DS_PAC_CID",nullable=false,length=60)
	private String cidade = "";
	@Column(name="DS_PAC_UF",nullable=false,length=4)
	private EnumUF uf = EnumUF.CE;
	@Column(name="DS_PAC_CEP",nullable=false,length=20)
	private String cep = "";
	@Column(name="DS_PAC_TEL_RES",nullable=false,length=15)
	private String telefone = "";
	@Column(name="DS_PAC_TEL_COM",nullable=false,length=15)
	private String telComercial = "";
	@Column(name="DS_PAC_TEL_CEL",nullable=false,length=15)
	private String celular = "";
	@Column(name="DS_PAC_COR",nullable=false,length=20)
	@Enumerated(EnumType.STRING)
	private EnumRaca raca = EnumRaca.BRANCA;
	@Column(name="DS_PAC_PRO",nullable=false,length=0)
	private String profissao = "";
	@Column(name="DT_PAC_PRI_CON",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtPrimeiraConsulta = new Date();
	@Column(name="DT_PAC_ULT_CON",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtUltimaConsulta = new Date();
	@Column(name="DS_PAC_OBS",nullable=false,length=485760)
	private String observacoes = "";
	
	@Column(name="TP_PAC_ATV",nullable=false)
	private boolean flAtivo = true;
	@Column(name="DS_PAC_ANT_PES",nullable=false,length=255)
	private String antPes = "";
	@Column(name="DS_PAC_ANT_FAM",nullable=false,length=255)
	private String antFam = "";
	@Column(name="DS_PAC_FOT",nullable=false,length=10485760)//foto
	private String foto = "";
	@Column(name="DS_PAC_LEM",nullable=false,length=255)
	private String lem = "";
	@Column(name="DS_PAC_APE",nullable=false,length=10)
	private String pacienteApe = "";
	@Column(name="CD_PAC",nullable=false,length=10)
	private String cdPaciente = "";
	@Column(name="DS_PAC_OBS_001",nullable=false,length=255)
	private String obs1 = "";
	@Column(name="DS_PAC_OBS_002",nullable=false,length=255)
	private String obs2 = "";
	@Column(name="DS_PAC_OBS_003",nullable=false,length=255)
	private String obs3 = "";
	@Column(name="DS_PAC_OBS_004",nullable=false,length=255)
	private String obs4 = "";
	@Column(name="NM_PAC_ANT",nullable=false,length=70)
	private String nomeAnterior = "";
	@Column(name="EMAIL",nullable=false,length=60)
	private String email = "";

	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IS_USU",referencedColumnName="CODIGO")
	private Usuario usuario;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IS_CNV",referencedColumnName="CODIGO")
	private Convenio convenio;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public EnumEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EnumEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public EnumUF getUf() {
		return uf;
	}

	public void setUf(EnumUF uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelComercial() {
		return telComercial;
	}

	public void setTelComercial(String telComercial) {
		this.telComercial = telComercial;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public EnumRaca getRaca() {
		return raca;
	}

	public void setRaca(EnumRaca raca) {
		this.raca = raca;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Date getDtPrimeiraConsulta() {
		return dtPrimeiraConsulta;
	}

	public void setDtPrimeiraConsulta(Date dtPrimeiraConsulta) {
		this.dtPrimeiraConsulta = dtPrimeiraConsulta;
	}

	public Date getDtUltimaConsulta() {
		return dtUltimaConsulta;
	}

	public void setDtUltimaConsulta(Date dtUltimaConsulta) {
		this.dtUltimaConsulta = dtUltimaConsulta;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public boolean isFlAtivo() {
		return flAtivo;
	}

	public void setFlAtivo(boolean flAtivo) {
		this.flAtivo = flAtivo;
	}

	public String getAntPes() {
		return antPes;
	}

	public void setAntPes(String antPes) {
		this.antPes = antPes;
	}

	public String getAntFam() {
		return antFam;
	}

	public void setAntFam(String antFam) {
		this.antFam = antFam;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getLem() {
		return lem;
	}

	public void setLem(String lem) {
		this.lem = lem;
	}

	public String getPacienteApe() {
		return pacienteApe;
	}

	public void setPacienteApe(String pacienteApe) {
		this.pacienteApe = pacienteApe;
	}

	public String getCdPaciente() {
		return cdPaciente;
	}

	public void setCdPaciente(String cdPaciente) {
		this.cdPaciente = cdPaciente;
	}

	public String getObs1() {
		return obs1;
	}

	public void setObs1(String obs1) {
		this.obs1 = obs1;
	}

	public String getObs2() {
		return obs2;
	}

	public void setObs2(String obs2) {
		this.obs2 = obs2;
	}

	public String getObs3() {
		return obs3;
	}

	public void setObs3(String obs3) {
		this.obs3 = obs3;
	}

	public String getObs4() {
		return obs4;
	}

	public void setObs4(String obs4) {
		this.obs4 = obs4;
	}

	public String getNomeAnterior() {
		return nomeAnterior;
	}

	public void setNomeAnterior(String nomeAnterior) {
		this.nomeAnterior = nomeAnterior;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
