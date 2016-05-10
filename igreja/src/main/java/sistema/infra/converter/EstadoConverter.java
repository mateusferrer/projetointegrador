package sistema.infra.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import sistema.negocio.dominio.Estado;

/**
 * {Descrita resumida sobre a classe}.
 * @version 1.0 - 04/05/2016
 * @since 04/05/2016
 */
@FacesConverter("estadoConverter")
@Named
public class EstadoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Estado retorno = null;
        if (value != null) {
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String retorno = (value == null ? null : value.toString());
        return retorno;
    }

}
