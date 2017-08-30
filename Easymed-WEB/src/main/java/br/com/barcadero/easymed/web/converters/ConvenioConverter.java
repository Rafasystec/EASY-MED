package br.com.barcadero.easymed.web.converters;

import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.barcadero.easymed.core.service.ServiceConvenio;
import br.com.barcadero.easymed.core.tables.Convenio;

@Component("convenioConverter")
public class ConvenioConverter extends SuperConverter implements Converter,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4925746908684476485L;
	@Autowired
	private ServiceConvenio serviceConvenio;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return serviceConvenio.find(getValueAsLong(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value==null){
			return "0";
		}
		if(value instanceof Convenio){
			return  ""+((Convenio) value).getCodigo();
		}
		return String.valueOf(value);	}

	public ServiceConvenio getServiceConvenio() {
		return serviceConvenio;
	}

	public void setServiceConvenio(ServiceConvenio serviceConvenio) {
		this.serviceConvenio = serviceConvenio;
	}

}
