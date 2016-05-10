package sistema.negocio.aplicacao;

import static com.forj.cirrus.util.validacao.Val.*

import java.util.List;

import javax.inject.Named

import sistema.negocio.dominio.Agenda
import sistema.negocio.dominio.FiltroAgenda;
import sistema.negocio.dominio.FiltroLancamento;
import sistema.negocio.dominio.Lancamento;

import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp
import com.forj.cirrus.util.validacao.Param;

/**
 * Gerenciador de processos de negócio para o domínio <b>Agenda</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@Named
class AgendaBean extends DominioBeanImp<Agenda> {

	/**
	 * Pesquisa agendas.
	 * @return listagem de agenda.
	 * @throws NegocioException em caso de erros.
	 */
	List<Agenda> get() throws NegocioException {
		eao.get(Agenda.TODOS)
	}

	/**
	 * Pesquisa de lançamento de receitas.
	 * @return listagem de receitas.
	 * @throws NegocioException em caso de erros.
	 */
	List<Lancamento> get(FiltroAgenda filtro) throws NegocioException {
		Param.validar(filtro, "Filtro Agenda")
		filtro.validar()
		eao.get(Agenda.TODOS, filtro.tipo)
	}
}