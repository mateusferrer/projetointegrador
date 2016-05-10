package sistema.infra.formularios

import com.forj.cirrus.jsf.gui.AbstractNavegacaoFrm
import com.forj.cirrus.negocio.dominio.servicos.Dominio

/**
 * Gerenciador de formulários GUI JSF de captura de domínios.
 * @author Lucas Francisquini
 * @version 1.0 - 06/08/2015
 * @since 06/08/2015
 */
abstract class GCapturaFrm<T extends Dominio> extends AbstractNavegacaoFrm<T> {

    /** Armazena o processo chamado da captura. **/
    int processo

    /** {@inheritDoc} */
    @Override
    protected void limpar() {
        processo = 0
        colecao.clear()
    }

    /** {@inheritDoc} */
    @Override
    void entrar(int processo) {
        limpar()
        this.processo = processo
    }

    /** {@inheritDoc} */
    @Override
    void cancelar() {
        limpar()
    }
}