package sistema.negocio.aplicacao

import static com.forj.cirrus.util.validacao.Val.*

import javax.inject.Named

import sistema.negocio.dominio.TipoEvento

import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp

/**
 * Gerenciador de processos de negócio para o domínio <b>TipoEvento</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@Named
class TipoEventoBean extends DominioBeanImp<TipoEvento> {

    /**
     * Pesquisa tipos de eventos.
     * @return listagem de tipos de evento.
     * @throws NegocioException em caso de erros.
     */
    List<TipoEvento> get() throws NegocioException {
        eao.get(TipoEvento.TODOS)
    }
}