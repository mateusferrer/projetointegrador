package sistema.visao.cargoeclesiastico

import javax.inject.Inject
import javax.inject.Named

import org.springframework.context.annotation.Scope

import sistema.infra.formularios.GCapturaFrm
import sistema.negocio.aplicacao.CargoEclesiasticoBean
import sistema.negocio.dominio.CargoEclesiastico
import sistema.visao.membro.MembroFrm

import com.forj.cirrus.infra.spring.Escopo
import com.forj.cirrus.util.Bean

/**
 * Gerenciador de formulários GUI JSF de captura de <b>Igreja</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
@Named
@Scope(Escopo.SESSION)
class CapturaCargoEclesiasticoFrm extends GCapturaFrm<CargoEclesiastico> {

    /** Armazena a flag de formulario de carro **/
    static final int MEMBRO = 1;

    /** Armazena o serviço de negocio. **/
    @Inject
    CargoEclesiasticoBean bean;

    /** Armazena o formulario de membro. **/
    @Inject
    MembroFrm membroFrm

    /**
     * Cria um novo objeto com valores padrões.
     */
    CapturaCargoEclesiasticoFrm() {
        titulo = "Listagem de Cargos Eclesiásticos"
    }

    /** {@inheritDoc} */
    @Override
    void pesquisar() {
        try {
            colecao = bean.get();
        } catch (ex) {
            gerarErrosRia(ex)
        }
    }

    /** {@inheritDoc} */
    @Override
    void capturar(CargoEclesiastico objeto) {
        if (processo == MEMBRO) {
            Bean.copiarPropriedades(membroFrm.dominio.cargo, objeto)
        } else {
            throw new IllegalStateException(ERRO_NAVEGACAO)
        }
        limpar()
    }
}