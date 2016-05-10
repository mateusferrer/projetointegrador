package sistema.negocio.dominio

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio

/**
 * Gerenciador das regras para o filtro de pesquisa do dom�nio <b>Lan�amento</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 01/12/2015
 * @since 01/12/2015
 */
class FiltroLancamento extends AbstractDominio {

	/** Armazena o filtro de status do lan�amento. **/
	@Obrigatorio(rotulo = "Status")
	String status

	/** Armazena o filtro de tipo de lan�amento. **/
	@Obrigatorio(rotulo = "Tipo Lan�amento")
	String tipoLancamento
}
