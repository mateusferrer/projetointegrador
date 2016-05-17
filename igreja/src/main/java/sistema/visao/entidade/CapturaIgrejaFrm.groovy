package sistema.visao.entidade

import javax.inject.Inject
import javax.inject.Named

import org.springframework.context.annotation.Scope

import sistema.infra.formularios.GCapturaFrm
import sistema.negocio.aplicacao.entidade.EntidadeBeanImp;
import sistema.negocio.dominio.entidade.Entidade;
import sistema.visao.membro.MembroFrm
import sistema.visao.secretaria.SecretariaFrm

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
class CapturaIgrejaFrm extends GCapturaFrm<Entidade> {

    /** Armazena a flag de formulario de carro **/
    static final int MEMBRO = 1;

    /** Armazena a flag de formulario de carro **/
    static final int IGREJA_RESPONSAVEL = 2;

    /** Armazena o serviço de negocio. **/
    @Inject
    EntidadeBeanImp bean;

    /** Armazena o formulario de membro. **/
    @Inject
    MembroFrm membroFrm

    /** Armazena o formulario de secretaria. **/
    @Inject
    SecretariaFrm secretariaFrm

    /**
     * Cria um novo objeto com valores padrões.
     */
    CapturaIgrejaFrm() {
        titulo = "Listagem de Igrejas"
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
    void capturar(Entidade objeto) {
        if (processo == MEMBRO) {
            Bean.copiarPropriedades(membroFrm.dominio.igreja, objeto)
        } else if (processo == IGREJA_RESPONSAVEL) {
            Bean.copiarPropriedades(secretariaFrm.dominio.igrejaResponsavel, objeto)
        } else {
            throw new IllegalStateException(ERRO_NAVEGACAO)
        }
        limpar()
    }
}