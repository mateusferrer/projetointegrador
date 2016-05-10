package sistema.infra.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import sistema.negocio.aplicacao.IgrejaBean;
import sistema.negocio.dominio.Igreja;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * {Descrita resumida sobre a classe}.
 * 
 * @version 1.0 - 04/05/2016
 * @since 04/05/2016
 */
@FacesConverter("igrejaConverter")
public class IgrejaConverter implements Converter {

	@Inject
	protected IgrejaBean bean;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Igreja retorno = null;
		if (value != null) {
			try {
				retorno = bean.getPorCodigo(new Integer(value));
			} catch (NumberFormatException | NegocioException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Integer codigo = ((Igreja) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}
		return "";
	}

}
