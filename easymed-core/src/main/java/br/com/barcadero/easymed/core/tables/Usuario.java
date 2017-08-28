package br.com.barcadero.easymed.core.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.barcadero.easymed.core.enums.EnumUF;





/**
 * 
 * @author Rafael Rocha
 * @since Gsind 1.0 beta dia 25/10/2013 as 21:12

@NamedQueries(
		{
			@NamedQuery(name=Usuario.FIND_ALL		,query="FROM Usuario"),
			@NamedQuery(name=Usuario.FIND_BY_CODE	,query="FROM Usuario u WHERE u.codigo = :codigo"),
			@NamedQuery(name=Usuario.FIND_BY_LOGIN	,query="FROM Usuario u WHERE u.email = :email AND u.passWord = :senha"),
			@NamedQuery(name=Usuario.FIND_BY		,query="FROM Usuario u WHERE  u.nome LIKE :nome OR u.email LIKE :email "),
			@NamedQuery(name=Usuario.FIND_BY_EMAIL	,query="FROM Usuario u WHERE u.email = :email")
		}
)

 */


@NamedQueries({ 
	@NamedQuery(name = Usuario.FIND_POR_NOME_LOGIN, query = "FROM Usuario usu WHERE usu.nmLogin = :nmLogin") 
})

@Entity
@Table(name="T_USU")
public class Usuario extends Entidade 
{

	private static final long serialVersionUID = 8937600656781400155L;
	public static final String ANONYMOUS_USER = "anonymousUser";

	public Usuario() {

	}
	public static final String FIND_POR_NOME_LOGIN 	= "Usuario.porNomeLogin";
	public static final String FIND_POR_NM_ANIMAL 	= "Usuario.porNMouAnimal";
	public static final String IDX_POR_FACEBOOK 	= "UsuarioFacebook"; 

	@Column(name="FOTO_PERFIL" , length=10485760)
	private String foto = "";
	@Column(name="NM_USU",length=30)
	private String nome;
	@Column(name="LOGIN",length=30)
	private String login;
	@Column(name="DS_USU_CRM",length=8)
	private String crm;
	@Column(name="DS_USU_SEN",length=25)
	private String senha;
	@Column(name="DS_USU_END",length=25)
	private String endereco;
	@Column(name="DS_USU_CID",length=25)
	private String cidade;
	@Column(name="DS_USU_UF",length=2)
	@Enumerated(EnumType.STRING)
	private EnumUF uf;
	@Column(name="DS_USU_BAI",length=25)
	private String bairro;

	@Column(name="NR_USU_CEP",length=20)
	private int nrCep;

	@Column(name="CNPJ_CPF")
	private String cnpjCpf;

	@Column(name="NR_USU_TEL_RES",length=20)
	private String telefone;

	@Column(name="NR_USU_TEL_CEL",length=20)
	private String celular;

	@Column(name="TP_USU_ATV")
	private boolean flAtivo;
	@Column(name="EMAIL",nullable=false,length=60)
	private String email = "";

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNrCep() {
		return nrCep;
	}

	public void setNrCep(int nrCep) {
		this.nrCep = nrCep;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public boolean isFlAtivo() {
		return flAtivo;
	}

	public void setFlAtivo(boolean flAtivo) {
		this.flAtivo = flAtivo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	
}
