package sistema.infra.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import sistema.negocio.aplicacao.entidade.EntidadeBean;
import sistema.negocio.dominio.entidade.Entidade;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.util.validacao.Val;

/**
 * {Descrita resumida sobre a classe}.
 * @version 1.0 - 04/05/2016
 * @since 04/05/2016
 */
@FacesConverter("entidadeConverter")
public class EntidadeConverter implements Converter {

    @Inject
    protected EntidadeBean bean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Entidade retorno = null;
        if (!Val.vazio(value)) {
            try {
                retorno = bean.getPorCodigo(new Long(value));
            } catch (NumberFormatException | NegocioException e) {
                e.printStackTrace();
            }
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!Val.vazio(value)) {
            Long codigo = ((Entidade) value).getId();
            String retorno = (codigo == null ? null : codigo.toString());
            return retorno;
        }
        return "";
    }

}
