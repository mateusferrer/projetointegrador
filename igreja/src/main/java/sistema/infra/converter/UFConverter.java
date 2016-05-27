package sistema.infra.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import sistema.negocio.enums.UF;

/**
 * Conversor do Enum de UF.
 * @version 1.0 - 26/05/2016
 * @since 26/05/2016
 */
public class UFConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null) {
			return UF.valueOf(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null && value instanceof UF) {
			return ((UF) value).toString();
		}
		return null;
	}
}
