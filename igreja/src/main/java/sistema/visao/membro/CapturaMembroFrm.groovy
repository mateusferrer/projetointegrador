package sistema.visao.membro

import javax.inject.Inject
import javax.inject.Named

import org.springframework.context.annotation.Scope

import sistema.infra.formularios.GCapturaFrm
import sistema.negocio.aplicacao.MembroBean
import sistema.negocio.dominio.membro.Membro;
import sistema.visao.lancamento.LancamentoFrm
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
class CapturaMembroFrm extends GCapturaFrm<Membro> {

    /** Armazena a flag de formulario de membro responsável a ser utilizado no form da secretaria.**/
    static final int MEMBRO_RESPONSAVEL = 1;

    /** Armazena a flag de formulario de membro administrativo a ser utilizado no form da secretaria. **/
    static final int MEMBRO_ADMINISTRATIVO = 2;

    /** Armazena a flag de formulario de membro a ser utilizado no form da tesouraria. **/
    static final int MEMBRO_DIZIMO = 3;

    /** Armazena o serviço de negócio. **/
    @Inject
    MembroBean bean;

    /** Armazena o formulario de secretaria. **/
    @Inject
    SecretariaFrm secretariaFrm

    /** Armazena o formulario de tesouraria. **/
    @Inject
    LancamentoFrm lancamentoFrm

    /**
     * Cria um novo objeto com valores padrões.
     */
    CapturaMembroFrm() {
        titulo = "Listagem de Membros"
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
    void capturar(Membro objeto) {
        if (processo == MEMBRO_RESPONSAVEL) {
            Bean.copiarPropriedades(secretariaFrm.dominio.pastorResponsavel, objeto)
        } else if (processo == MEMBRO_ADMINISTRATIVO) {
            Bean.copiarPropriedades(secretariaFrm.membroAdm.membro, objeto)
        } else if (processo == MEMBRO_DIZIMO) {
            lancamentoFrm.dominio.membro = new Membro()
            Bean.copiarPropriedades(lancamentoFrm.dominio.membro, objeto)
        } else {
            throw new IllegalStateException(ERRO_NAVEGACAO)
        }
        limpar()
    }
}