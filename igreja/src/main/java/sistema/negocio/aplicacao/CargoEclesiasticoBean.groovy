package sistema.negocio.aplicacao

import static com.forj.cirrus.util.validacao.Val.*

import javax.inject.Named

import sistema.negocio.dominio.CargoEclesiastico
import sistema.negocio.dominio.entidade.Entidade;
import sistema.negocio.dominio.membro.Membro;

import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp

/**
 * Gerenciador de processos de negócio para o domínio <b>CargoEclesiastico</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
@Named
class CargoEclesiasticoBean extends DominioBeanImp<CargoEclesiastico> {

    /**
     * Pesquisa cargos eclesiásticos.
     * @return listagem de cargo.
     * @throws NegocioException em caso de erros.
     */
    List<CargoEclesiastico> get() throws NegocioException {
        eao.get(CargoEclesiastico.TODOS)
    }
}