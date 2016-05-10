package sistema.negocio.dominio

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio

/**
 * Gerenciador das regras para o filtro de pesquisa do domínio <b>Lançamento</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 01/12/2015
 * @since 01/12/2015
 */
class FiltroLancamento extends AbstractDominio {

	/** Armazena o filtro de status do lançamento. **/
	@Obrigatorio(rotulo = "Status")
	String status

	/** Armazena o filtro de tipo de lançamento. **/
	@Obrigatorio(rotulo = "Tipo Lançamento")
	String tipoLancamento
}
