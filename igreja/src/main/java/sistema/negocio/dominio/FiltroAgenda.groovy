package sistema.negocio.dominio

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio

/**
 * Gerenciador das regras para o filtro de pesquisa do dom�nio <b>Agenda</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 05/12/2015
 * @since 05/12/2015
 */
class FiltroAgenda extends AbstractDominio {

	/** Armazena o filtro de tipo de agenda. **/
	@Obrigatorio(rotulo = "Tipo Agenda")
	String tipo
}
