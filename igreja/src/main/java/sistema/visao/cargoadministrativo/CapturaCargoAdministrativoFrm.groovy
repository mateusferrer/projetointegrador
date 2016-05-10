package sistema.visao.cargoadministrativo

import javax.inject.Inject
import javax.inject.Named

import org.springframework.context.annotation.Scope

import sistema.infra.formularios.GCapturaFrm
import sistema.negocio.aplicacao.CargoAdministrativoBean
import sistema.negocio.aplicacao.CargoEclesiasticoBean
import sistema.negocio.dominio.CargoAdministrativo;
import sistema.negocio.dominio.CargoEclesiastico
import sistema.visao.membro.MembroFrm
import sistema.visao.secretaria.SecretariaFrm

import com.forj.cirrus.infra.spring.Escopo
import com.forj.cirrus.util.Bean

/**
 * Gerenciador de formulários GUI JSF de captura de <b>CargoAdministrativo</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@Named
@Scope(Escopo.SESSION)
class CapturaCargoAdministrativoFrm extends GCapturaFrm<CargoAdministrativo> {

    /** Armazena a flag de formulario de carro **/
    static final int MEMBRO_ADM = 1;

    /** Armazena o serviço de negocio. **/
    @Inject
    CargoAdministrativoBean bean;

    /** Armazena o formulario de carro. **/
    @Inject
    SecretariaFrm secretariaFrm

    /**
     * Cria um novo objeto com valores padrões.
     */
    CapturaCargoAdministrativoFrm() {
        titulo = "Listagem de Cargos Administrativos"
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
    void capturar(CargoAdministrativo objeto) {
        if (processo == MEMBRO_ADM) {
            Bean.copiarPropriedades(secretariaFrm.membroAdm.cargo, objeto)
        } else {
            throw new IllegalStateException(ERRO_NAVEGACAO)
        }
        limpar()
    }
}