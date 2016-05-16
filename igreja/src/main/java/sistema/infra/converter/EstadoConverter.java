package sistema.infra.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import sistema.negocio.dominio.Estado;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBean;

/**
 * {Descrita resumida sobre a classe}.
 * @version 1.0 - 04/05/2016
 * @since 04/05/2016
 */
@FacesConverter("estadoConverter")
@Named
public class EstadoConverter implements Converter {

    /** Armazena o gerenciador dos processos de persist�ncia. **/
    @Inject
    private DominioBean<Estado> bean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Long id = Long.parseLong(value);
        Estado retorno = new Estado();
        try {
            retorno = (Estado) bean.get(Estado.POR_ID, id);
        } catch (NegocioException e) {
            e.printStackTrace();
        }
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