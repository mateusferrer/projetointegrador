package sistema.infra.formularios

import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.jsf.gui.AbstractListaDetalheFrm
import com.forj.cirrus.negocio.dominio.servicos.Dominio
import com.forj.cirrus.util.Bean

/**
 * Gerenciador de formulários GUI JSF.
 * @author Lucas Francisquini
 * @version 1.0 - 01/12/2015
 * @since 01/12/2015
 */class GListaDetalheFrm<T extends Dominio> extends AbstractListaDetalheFrm<T> {

	/** Armazena a navegação JSF . **/
	static String LISTA = "lista.xhtml"

	/** Armazena a navegação JSF . **/
	static String DETALHE = "detalhe.xhtml"

	protected Object dominio;

	/** {@inheritDoc} */
	@Override
	void entrar() {
		colecao.clear()
		dominio.limpar()
	}

	/** {@inheritDoc} */
	@Override
	String novo() {
		dominio.limpar()
		alterar = false
		DETALHE
	}

	/** {@inheritDoc} */
	@Override
	String alterar(T objeto) {
		Bean.copiarPropriedades(dominio, objeto)
		alterar = true
		DETALHE
	}

	/** {@inheritDoc} */
	@Override
	String cancelar() {
		dominio.limpar()
		LISTA
	}

	/** {@inheritDoc} */
	@Override
	void deletar(T objeto) {
		try {
			bean.excluir(objeto)
			colecao.remove(objeto)
		} catch (ex) {
			gerarErrosRia(ex)
		}
	}

	/** {@inheritDoc} */
	@Override
	String gravar() {
		try {
			if (alterar) {
				bean.alterar(dominio)
				alterar = false
				atualizarLista(dominio)
				dominio.limpar()
			} else {
				bean.inserir(dominio)
				dominio.limpar()				gerarMensagemRia("Cadastro realizado com sucesso.")
			}
		} catch (ex) {
			gerarErrosRia(ex)
		}
		DETALHE
	}
}