package br.com.barcadero.web.beans;

import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.CaptureEvent;
import org.primefaces.event.TabChangeEvent;
import br.com.barcadero.easymed.core.enums.EnumEstadoCivil;
import br.com.barcadero.easymed.core.enums.EnumRaca;
import br.com.barcadero.easymed.core.enums.EnumSexo;
import br.com.barcadero.easymed.core.enums.EnumUF;
import br.com.barcadero.easymed.core.service.ServiceConvenio;
import br.com.barcadero.easymed.core.service.ServicePaciente;
import br.com.barcadero.easymed.core.tables.Convenio;
import br.com.barcadero.easymed.core.tables.Paciente;

@ManagedBean
@ViewScoped
public class BeanPaciente extends SuperBean<Paciente> {

	private static final long serialVersionUID = -6030256170513399153L;
	private Paciente paciente;
	private Paciente selectedPaciente;
	private List<Paciente> pacientes;
	private List<Convenio> convenios;
	@ManagedProperty("#{servicePaciente}")
	private ServicePaciente servicePaciente;
	@ManagedProperty("#{serviceConvenio}")
	private ServiceConvenio serviceConvenio;
	
	
	private boolean requiredDadosGerais = false;
	private boolean requiredHistorico 	= false;
	private boolean requiredPesquisa 	= false;
	
	@PostConstruct
	public void init() {
		setConvenios(serviceConvenio.findAll(getUsuarioLogado()));
		
		setPaciente(new Paciente(getUsuarioLogado()));
	}
	@Override
	public String deletar(Paciente paciente) throws Exception {
		if(paciente != null && paciente.getCodigo() > 0){
			long codigo = paciente.getCodigo();
			servicePaciente.delete(paciente);
			exibirMensagem("Paciente "+codigo+ " Excluido com sucesso!");
		}else{
			exibirErroGrave("Paciente não é válido para exclusão");
		}
		return null;
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar(Paciente entidade) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String salvar() throws Exception {
		if(validar(getPaciente())){
			if(paciente.getCodigo() > 0){
				paciente = servicePaciente.update(getPaciente());
				exibirMensagem("Paciente " + paciente.getCodigo() + " alterado com sucesso!");
				
			}else{
				paciente = servicePaciente.insert(paciente);
			}
			exibirMensagem("Paciente cadastrado com sucesso! Código " + paciente.getCodigo());
		}
		return null;
	}

	@Override
	public String alterar() throws Exception {
		servicePaciente.update(getPaciente());
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
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public ServicePaciente getServicePaciente() {
		return servicePaciente;
	}
	public void setServicePaciente(ServicePaciente servicePaciente) {
		this.servicePaciente = servicePaciente;
	}
	
	public EnumSexo[] getSexo() {
		return EnumSexo.values();
	}
	
	public EnumEstadoCivil[] getEstadoCivil() {
		return EnumEstadoCivil.values();
	}
	
	public void onTabChange(TabChangeEvent event) {
		String tabId = event.getTab().getId();
		if(tabId.equalsIgnoreCase("tabDadosGerais")){
			setRequiredDadosGerais(true);
			setRequiredHistorico(false);
			setRequiredPesquisa(false);
		}else if(tabId.equalsIgnoreCase("tabPesquisa")){
			setRequiredDadosGerais(false);
			setRequiredHistorico(false);
			setRequiredPesquisa(true);
		}
		
	}
	public boolean isRequiredDadosGerais() {
		return requiredDadosGerais;
	}
	public void setRequiredDadosGerais(boolean requiredDadosGerais) {
		this.requiredDadosGerais = requiredDadosGerais;
	}
	public boolean isRequiredHistorico() {
		return requiredHistorico;
	}
	public void setRequiredHistorico(boolean requiredHistorico) {
		this.requiredHistorico = requiredHistorico;
	}
	public boolean isRequiredPesquisa() {
		return requiredPesquisa;
	}
	public void setRequiredPesquisa(boolean requiredPesquisa) {
		this.requiredPesquisa = requiredPesquisa;
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
	
	public EnumUF[] getUfs() {
		return EnumUF.values();
	}

	public EnumRaca[] getRaca() {
		return EnumRaca.values();
	}

	public void oncapture(CaptureEvent captureEvent) {
        byte[] data = captureEvent.getData();
        String base64Encoded = Base64.getEncoder().encodeToString(data);
        System.out.println(base64Encoded);
        getPaciente().setFoto(base64Encoded);
    }
	
	public boolean isHasPhoto() {
		if(paciente != null){
			if(paciente.getFoto() != null && !paciente.getFoto().isEmpty()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	public List<Paciente> getPacientes() {
		pacientes = servicePaciente.findAll(getUsuarioLogado());
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public void selecionar(Paciente paciente) {
		setPaciente(paciente);
	}
	public Paciente getSelectedPaciente() {
		return selectedPaciente;
	}
	public void setSelectedPaciente(Paciente selectedPaciente) {
		this.selectedPaciente = selectedPaciente;
	}
	
}
