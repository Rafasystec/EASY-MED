package br.com.barcadero.easymed.core.tables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.barcadero.easymed.core.enums.EnumTpUsuario;





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
@Table(name="USUARIO")
public class Usuario extends Entidade  implements UserDetails// comentar implementacao
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

	@Column(name="CIDADE")
	private String cidade;

	@Column(name="ESTADO")
	private String estado;

	@Column(name="PAIS")
	private String pais;

	@Column(name="RUA")
	private String rua;

	@Column(name="BAIRRO")
	private String bairro;

	@Column(name="COMPLEMENTO")
	private String complemento;

	@Column(name="NR_ENDERECO")
	private int nrEndereco;

	@Column(name="NR_CEP")
	private int nrCep;

	@Column(name="CNPJ_CPF")
	private String cnpjCpf;

	@Column(name="RAZAO_SOCIAL")
	private String razaoSocial;

	@Column(name="TF_USUARIO")
	private int telefone;

	@Column(name="DDD_USUARIO")
	private int ddd;


	@Column(name="TF_USUARIO2")
	private int telefone2;

	@Column(name="DDD_USUARIO2")
	private int ddd2;


	@Column(name="EMAIL",nullable=false)
	private String email;

	@Column(name="SENHA",nullable=false)
	private String password;

	@Column(name="NM_USUARIO")
	private String nome;

	@Column(name="TP_USER")
	private EnumTpUsuario tipoUser = EnumTpUsuario.COMUM;


	@Column(name="NM_LOGIN",nullable=false)
	private String nmLogin;

	//	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Acesso> acessos;


	@Column(name="URL_FACEBOOK")
	private String URLFacebook;
	@Column(name="FL_VALIDATED",nullable=false)
	private boolean validated = false;



	public String getURLFacebook() {
		return URLFacebook;
	}

	public void setURLFacebook(String uRLFacebook) {
		URLFacebook = uRLFacebook;
	}

	public int getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(int telefone2) {
		this.telefone2 = telefone2;
	}

	public int getDdd2() {
		return ddd2;
	}

	public void setDdd2(int ddd2) {
		this.ddd2 = ddd2;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNmLogin() {
		return nmLogin;
	}

	public void setNmLogin(String nmLogin) {
		this.nmLogin = nmLogin;
	}

	public String getPassword() {
		return password;
	}





	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNrEndereco() {
		return nrEndereco;
	}
	public void setNrEndereco(int nrEndereco) {
		this.nrEndereco = nrEndereco;
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

	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> result = new ArrayList<SimpleGrantedAuthority>();
		if(acessos != null){
			for (Acesso acesso : acessos) {
				result.add(new SimpleGrantedAuthority(acesso.getNmAcesso()));
			}
		}
		return result;
	} 

	@JsonIgnore
	public String getUsername() {
		return getNmLogin();
	}

	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}

	public List<Acesso> getAcessos() {
		return acessos;
	}

	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
	}



	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

}
