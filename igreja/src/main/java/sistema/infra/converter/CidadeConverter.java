package sistema.infra.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import sistema.negocio.dominio.Cidade;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBean;

/**
 * {Descrita resumida sobre a classe}.
 * @version 1.0 - 04/05/2016
 * @since 04/05/2016
 */
@FacesConverter("cidadeConverter")
@Named
public class CidadeConverter implements Converter {

    /** Armazena o gerenciador dos processos de persistência. **/
    @Inject
    private DominioBean<Cidade> bean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cidade retorno = new Cidade();
        try {
            retorno = (Cidade) bean.get(Cidade.POR_ID, value);
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
