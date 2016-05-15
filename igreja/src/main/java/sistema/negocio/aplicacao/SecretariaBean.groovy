package sistema.negocio.aplicacao

import static com.forj.cirrus.util.validacao.Val.*

import javax.inject.Named

import sistema.negocio.dominio.Secretaria
import sistema.negocio.dominio.entidade.Entidade;

import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp

/**
 * Gerenciador de processos de negócio para o domínio <b>Secretaria</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@Named
class SecretariaBean extends DominioBeanImp<Secretaria> {

    /**
     * Pesquisa secretarias.
     * @return listagem de secretaria.
     * @throws NegocioException em caso de erros.
     */
    List<Secretaria> get() throws NegocioException {
        eao.get(Secretaria.TODOS)
    }
}