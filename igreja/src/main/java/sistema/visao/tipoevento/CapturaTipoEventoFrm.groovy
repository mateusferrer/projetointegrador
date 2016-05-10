package sistema.visao.tipoevento

import javax.inject.Inject
import javax.inject.Named

import org.springframework.context.annotation.Scope

import sistema.infra.formularios.GCapturaFrm
import sistema.negocio.aplicacao.CargoEclesiasticoBean
import sistema.negocio.aplicacao.TipoEventoBean;
import sistema.negocio.dominio.CargoEclesiastico
import sistema.negocio.dominio.TipoEvento;
import sistema.visao.agenda.AgendaFrm;
import sistema.visao.membro.MembroFrm
import sistema.visao.secretaria.SecretariaFrm;

import com.forj.cirrus.infra.spring.Escopo
import com.forj.cirrus.util.Bean

/**
 * Gerenciador de formulários GUI JSF de captura de <b>TipoEvento</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@Named
@Scope(Escopo.SESSION)
class CapturaTipoEventoFrm extends GCapturaFrm<TipoEvento> {

    /** Armazena a flag de formulario de carro **/
    static final int EVENTO = 1;

    /** Armazena o serviço de negocio. **/
    @Inject
    TipoEventoBean bean;

    /** Armazena o formulario de secretaria. **/
    @Inject
    AgendaFrm agendaFrm

    /**
     * Cria um novo objeto com valores padrões.
     */
    CapturaTipoEventoFrm() {
        titulo = "Listagem de Tipos de Evento"
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
    void capturar(TipoEvento objeto) {
        if (processo == EVENTO) {
            Bean.copiarPropriedades(agendaFrm.dominio.tipoEvento, objeto)
        } else {
            throw new IllegalStateException(ERRO_NAVEGACAO)
        }
        limpar()
    }
}