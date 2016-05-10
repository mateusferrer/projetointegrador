package sistema.negocio.aplicacao;

import static com.forj.cirrus.util.validacao.Val.*

import javax.inject.Named

import sistema.negocio.dominio.FiltroLancamento
import sistema.negocio.dominio.Lancamento

import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp
import com.forj.cirrus.util.validacao.Param

/**
 * Gerenciador de processos de negócio para o domínio <b>Lancamento</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 30/11/2015
 * @since 30/11/2015
 */
@Named
class LancamentoBean extends DominioBeanImp<Lancamento> {

    /**
     * Pesquisa de lançamento de receitas.
     * @return listagem de receitas.
     * @throws NegocioException em caso de erros.
     */
    List<Lancamento> get(FiltroLancamento filtro) throws NegocioException {
        Param.validar(filtro, "Filtro Lançamentos")
        filtro.validar()
        eao.get(Lancamento.LANCAMENTOS, filtro.status, filtro.tipoLancamento)
    }

    /**
     * Pesquisa de saldo das receitas.
     * @return saldo de receitas.
     * @throws NegocioException em caso de erros.
     */
    BigDecimal getSaldo() throws NegocioException {
        eao.get(Lancamento.SALDO, Lancamento.ATIVO, Lancamento.LANC_RECEITA).get(0)
    }
}