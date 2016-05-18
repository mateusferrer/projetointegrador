package sistema.negocio.aplicacao.campanha;

import java.util.List;

import javax.inject.Named;

import sistema.negocio.dominio.Campanha;
import sistema.negocio.dominio.entidade.Entidade;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp;
import com.forj.cirrus.util.validacao.Val;

/**
 * Gerenciador de processos de negócio para o domínio <b>Campanha</b>.
 * @version 1.0 - 18/05/2016
 * @since 18/05/2016
 */
@Named
public class CampanhaBeanImp extends DominioBeanImp<Campanha> implements CampanhaBean {

    /** {@inheritDoc} */
    @Override
    public List<Campanha> get(String descricao) throws NegocioException {
        if (Val.vazio(descricao)) {
            return eao.get(Entidade.TODOS);
        } else {
            return eao.get(Campanha.POR_DESCRICAO, descricao);
        }

    }
}