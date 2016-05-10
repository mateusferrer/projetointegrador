package sistema.negocio.aplicacao

import static com.forj.cirrus.util.validacao.Val.*

import javax.inject.Named

import sistema.negocio.dominio.Igreja
import sistema.negocio.dominio.Membro

import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp

/**
 * Gerenciador de processos de negócio para o domínio <b>Membro</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
@Named
class MembroBean extends DominioBeanImp<Membro> {

    /**
     * Pesquisa membros.
     * @return listagem de membro.
     * @throws NegocioException em caso de erros.
     */
    List<Membro> get() throws NegocioException {
        eao.get(Membro.TODOS)
    }
}