package sistema.negocio.aplicacao;

import static com.forj.cirrus.util.validacao.Val.*

import javax.inject.Named

import sistema.negocio.dominio.CargoAdministrativo

import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp

/**
 * Gerenciador de processos de negócio para o domínio <b>CargoAdministrativo</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@Named
class CargoAdministrativoBean extends DominioBeanImp<CargoAdministrativo> {

    /**
     * Pesquisa cargos administrativos.
     * @return listagem de cargo.
     * @throws NegocioException em caso de erros.
     */
    List<CargoAdministrativo> get() throws NegocioException {
        eao.get(CargoAdministrativo.TODOS)
    }
}