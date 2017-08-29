package br.com.barcadero.web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.easymed.core.enums.EnumTpPreco;
import br.com.barcadero.easymed.core.service.ServiceConvenio;
import br.com.barcadero.easymed.core.tables.Convenio;

@ManagedBean
@ViewScoped
public class BeanConvenio extends SuperBean<Convenio> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2992475341537429377L;
	private Convenio convenio;
	private List<Convenio> convenios;
	@ManagedProperty("#{serviceConvenio}")
	private ServiceConvenio serviceConvenio;
	
	@PostConstruct
	public void init() {
		setConvenio(new Convenio(getUsuarioLogado()));
		setConvenios(serviceConvenio.findAll(getUsuarioLogado()));
	}
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar(Convenio entidade) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String salvar() throws Exception {
		if(validar(getConvenio())){
			serviceConvenio.insert(getConvenio());
		}
		exibirMensagem("Convênio Salvo com sucesso!");
		return null;
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Convenio> getConvenios() {
		return convenios;
	}
	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}

	public ServiceConvenio getServiceConvenio() {
		return serviceConvenio;
	}

	public void setServiceConvenio(ServiceConvenio serviceConvenio) {
		this.serviceConvenio = serviceConvenio;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
	public void selecionar(Convenio convenio) {
		setConvenio(convenio);
	}

	@Override
	public String deletar(Convenio entidade) throws Exception {
		if(entidade != null && entidade.getCodigo() > 0){
			serviceConvenio.delete(entidade);
		}else{
			exibirErroGrave("Esse convenio não é válidao para a exclusão");
		}
		return null;
	}
	
	public EnumTpPreco[] getTipoPreco() {
		return EnumTpPreco.values();
	}
	
	public void ativar(Convenio convenio,boolean flAtivo) {
		convenio.setFlAtivo(flAtivo);
		convenio = serviceConvenio.update(convenio);
	}

}
