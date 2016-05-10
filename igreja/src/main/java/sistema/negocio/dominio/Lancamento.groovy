package sistema.negocio.dominio

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio
import com.forj.cirrus.util.facades.FacadeData
import com.forj.cirrus.util.validacao.MsgErro
import com.forj.cirrus.util.validacao.Val

/**
 * Gerenciador das regras de negócio para o domínio <b>Lancamento</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 29/11/2015
 * @since 29/11/2015
 */
@ToString
@EqualsAndHashCode(includes="id")
@Entity
@Table(name = "caixa")
@NamedQueries(
[@NamedQuery(name = Lancamento.LANCAMENTOS,
	query = "select c from Lancamento c where c.status = ?1 and c.tipoLancamento = ?2"),
	@NamedQuery(name = Lancamento.SALDO,
	query = "select SUM(c.valor) from Lancamento c where c.status = ?1 and c.tipoLancamento = ?2")
])
class Lancamento extends AbstractDominio {

	/** Armazena o status ativo de lançamento. **/
	static final String ATIVO = "A"

	/** Armazena o status inativo de lançamento. **/
	static final String INATIVO = "I"

	/** Armazena o lançamento do tipo receita. **/
	static final String LANC_RECEITA = "R"

	/** Armazena o lançamento do tipo despesa. **/
	static final String LANC_DESPESA = "D"

	/** Armazena o oql que busca os lançamentos ativos. **/
	static final String LANCAMENTOS = "lancamento.lancamentos"

	/** Armazena o oql que busca o saldo de lançamentos ativos. **/
	static final String SALDO = "lancamento.saldo"

	/** Armazena o id do banco de dados. **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_lancamento")
	Integer id

	/** Armazena o tipo de lançamento. **/
	@Obrigatorio(rotulo="Tipo Lançamento")
	@Column(name = "tx_tipo_lancamento")
	String tipoLancamento

	/** Armazena o número de registro do membro. **/
	@Column(name = "nr_membro")
	@TamanhoMaximo(rotulo="Registro Membro", maximo = 10)
	Long registroMembro

	/** Armazena a descrição. **/
	@Obrigatorio(rotulo="Descrição")
	@Column(name = "tx_descricao")
	@TamanhoMaximo(rotulo="Descrição", maximo = 50)
	String descricao

	/** Armazena o valor do lançamento. **/
	@Obrigatorio(rotulo="Valor")
	@Column(name = "vl_lancamento")
	@TamanhoMaximo(rotulo="Valor", maximo = 10)
	BigDecimal valor

	/** Armazena a data de inclusão do lançamento. **/
	@Obrigatorio(rotulo="Data de Inclusão")
	@Column(name = "dt_inclusao")
	@Temporal(TemporalType.DATE)
	Date dataInclusao

	/** Armazena a observação. **/
	@Column(name = "tx_observacao")
	@TamanhoMaximo(rotulo="Observação", maximo = 500)
	String observacao

	/** Armazena o tipo da receita. **/
	@Column(name = "tx_tipo_receita")
	String tipoReceita

	/** Armazena o tipo da despesa. **/
	@Column(name = "tx_tipo_despesa")
	String tipoDespesa

	/** Armazena se é estorno ou não. **/
	@Obrigatorio(rotulo="Status")
	@Column(name = "tf_estorno")
	String status

	/**
	 * Transforma a data no formato padrão indicado.
	 * @return data em texto.
	 */
	String getDataString() {
		FacadeData.formatar(dataInclusao)
	}

	/**
	 * Informa um novo valor na propriedade <b>status</b>.
	 * @param status novo valor a ser informado.
	 */
	public void alterarStatus() {
		if (status == ATIVO) {
			status = INATIVO
			return
		}
		if (status == INATIVO) {
			status = ATIVO
		}
	}

	/**
	 * Verifica se o lançamento é do tipo receita.
	 * @return verdadeiro se sim, senão falso.
	 */
	boolean isReceita() {
		tipoLancamento == "R"
	}

	/**
	 * Verifica se o lançamento é do tipo despesa.
	 * @return verdadeiro se sim, senão falso.
	 */
	boolean isDespesa() {
		tipoLancamento == "D"
	}

	/**
	 * Verifica se o tipo da receita é dízimo.
	 * @return verdadeiro se sim, senão falso.
	 */
	boolean isReceitaDizimo() {
		tipoReceita == "D"
	}

	/**
	 * Recupera a descrição do tipo de receita.
	 * @return descricao do tipo da receita
	 */
	String getDescricaoTipoReceita() {
		if (tipoReceita == "D") {
			return "Dízimo"
		} else if (tipoReceita == "O") {
			return "Oferta"
		} else if (tipoReceita == "P") {
			return "Promoção"
		} else if (tipoReceita == "T") {
			return "Outros"
		}
	}

	/**
	 * Recupera a descrição do tipo de despesa.
	 * @return descricao do tipo da despesa
	 */
	String getDescricaoTipoDespesa() {
		if (tipoDespesa == "A") {
			return "Administrativa"
		} else if (tipoDespesa == "S") {
			return "Saúde"
		} else if (tipoDespesa == "D") {
			return "Dimensão Religiosa"
		} else if (tipoDespesa == "T") {
			return "Outros"
		}
	}

	/**
	 * Recupera a descrição do tipo de receita ou despesa.
	 * @return descrição do tipo de receita ou despesa.
	 */
	String getDescricaoLancamento() {
		if (tipoLancamento == "R") {
			return getDescricaoTipoReceita()
		} else {
			return getDescricaoTipoDespesa()
		}
	}

	/**
	 * Recupera a descrição do tipo de lançamento.
	 * @return descrição do tipo de lançamento.
	 */
	String getDescricaoTipoLancamento() {
		if (tipoLancamento == "R") {
			return "Receita"
		} else {
			return "Despesa"
		}
	}

	/** {@inheritDoc} */
	@Override
	public void validar() throws NegocioException {
		super.validar()
		MsgErro erros = new MsgErro()
		if (tipoLancamento == "R") {
			if (Val.vazio(tipoReceita)) {
				erros.campoObrigatorio("Tipo Receita")
			}
		}
		if (tipoLancamento == "D") {
			if (Val.vazio(tipoDespesa)) {
				erros.campoObrigatorio("Tipo Despesa")
			}
		}
		if (tipoReceita == "D") {
			if (Val.vazio(registroMembro)) {
				erros.campoObrigatorio("Registro Membro")
			}
		}
		erros.gerarErrosNegocio();
	}

	/** {@inheritDoc} */
	@Override
	public void limpar() {
		super.limpar();
		dataInclusao = new Date()
		status = ATIVO
	}
}