package sistema.negocio.dominio;

import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;
import com.forj.cirrus.util.facades.FacadeData;
import com.forj.cirrus.util.validacao.MsgErro;
import com.forj.cirrus.util.validacao.Val;

/**
 * Gerenciador das regras de neg�cio para o dom�nio <b>Lancamento</b>.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 29/11/2015
 * @since 29/11/2015
 */
@ToString
@EqualsAndHashCode(includes = "id")
@Entity
@Table(name = "caixa")
@NamedQueries({
		@NamedQuery(name = Lancamento.LANCAMENTOS, query = "select c from Lancamento c where c.status = ?1 and c.tipoLancamento = ?2"),
		@NamedQuery(name = Lancamento.SALDO, query = "select SUM(c.valor) from Lancamento c where c.status = ?1 and c.tipoLancamento = ?2") })
public class Lancamento extends AbstractDominio {

	/** Armazena o status ativo de lan�amento. **/
	public static final String ATIVO = "A";

	/** Armazena o status inativo de lan�amento. **/
	public static final String INATIVO = "I";

	/** Armazena o lan�amento do tipo receita. **/
	public static final String LANC_RECEITA = "R";

	/** Armazena o lan�amento do tipo despesa. **/
	public static final String LANC_DESPESA = "D";

	/** Armazena o oql que busca os lan�amentos ativos. **/
	public static final String LANCAMENTOS = "lancamento.lancamentos";

	/** Armazena o oql que busca o saldo de lan�amentos ativos. **/
	public static final String SALDO = "lancamento.saldo";

	/** Armazena o id do banco de dados. **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_lancamento")
	private Integer id;

	/** Armazena o tipo de lan�amento. **/
	@Obrigatorio(rotulo = "Tipo Lan�amento")
	@Column(name = "tx_tipo_lancamento")
	private String tipoLancamento;

	/** Armazena o n�mero de registro do membro. **/
	@Column(name = "nr_membro")
	@TamanhoMaximo(rotulo = "Registro Membro", maximo = 10)
	private Long registroMembro;

	/** Armazena a descri��o. **/
	@Obrigatorio(rotulo = "Descri��o")
	@Column(name = "tx_descricao")
	@TamanhoMaximo(rotulo = "Descri��o", maximo = 50)
	private String descricao;

	/** Armazena o valor do lan�amento. **/
	@Obrigatorio(rotulo = "Valor")
	@Column(name = "vl_lancamento")
	@TamanhoMaximo(rotulo = "Valor", maximo = 10)
	private BigDecimal valor;

	/** Armazena a data de inclus�o do lan�amento. **/
	@Obrigatorio(rotulo = "Data de Inclus�o")
	@Column(name = "dt_inclusao")
	@Temporal(TemporalType.DATE)
	private Date dataInclusao;

	/** Armazena a observa��o. **/
	@Column(name = "tx_observacao")
	@TamanhoMaximo(rotulo = "Observa��o", maximo = 500)
	private String observacao;

	/** Armazena o tipo da receita. **/
	@Column(name = "tx_tipo_receita")
	private String tipoReceita;

	/** Armazena o tipo da despesa. **/
	@Column(name = "tx_tipo_despesa")
	private String tipoDespesa;

	/** Armazena se � estorno ou n�o. **/
	@Obrigatorio(rotulo = "Status")
	@Column(name = "tf_estorno")
	private String status;

	/** Armazena se � estorno ou n�o. **/
	@Obrigatorio(rotulo = "Contribuinte")
	@JoinColumn(name = "cd_contribuinte")
	@ManyToOne
	private Contribuinte contribuinte;

	/**
	 * Transforma a data no formato padr�o indicado.
	 * 
	 * @return data em texto.
	 */
	public String getDataString() {
		return FacadeData.formatar(dataInclusao);
	}

	/**
	 * Informa um novo valor na propriedade <b>status</b>.
	 * 
	 * @param status
	 *            novo valor a ser informado.
	 */
	public void alterarStatus() {
		if (status == ATIVO) {
			status = INATIVO;
			return;
		}
		if (status == INATIVO) {
			status = ATIVO;
		}
	}

	/**
	 * Verifica se o lan�amento � do tipo receita.
	 * 
	 * @return verdadeiro se sim, sen�o falso.
	 */
	public boolean isReceita() {
		return tipoLancamento.equals("R");
	}

	/**
	 * Verifica se o lan�amento � do tipo despesa.
	 * 
	 * @return verdadeiro se sim, sen�o falso.
	 */
	public boolean isDespesa() {
		return tipoLancamento.equals("D");
	}

	/**
	 * Verifica se o tipo da receita � d�zimo.
	 * 
	 * @return verdadeiro se sim, sen�o falso.
	 */
	public boolean isReceitaDizimo() {
		return tipoReceita.equals("D");
	}

	/**
	 * Recupera a descri��o do tipo de receita.
	 * 
	 * @return descricao do tipo da receita
	 */
	public String getDescricaoTipoReceita() {
		if (tipoReceita == "D") {
			return "D�zimo";
		} else if (tipoReceita == "O") {
			return "Oferta";
		} else if (tipoReceita == "P") {
			return "Promo��o";
		} else if (tipoReceita == "T") {
			return "Outros";
		} else {
			return "";
		}
	}

	/**
	 * Recupera a descri��o do tipo de despesa.
	 * 
	 * @return descricao do tipo da despesa
	 */
	public String getDescricaoTipoDespesa() {
		if (tipoDespesa == "A") {
			return "Administrativa";
		} else if (tipoDespesa == "S") {
			return "Sa�de";
		} else if (tipoDespesa == "D") {
			return "Dimens�o Religiosa";
		} else if (tipoDespesa == "T") {
			return "Outros";
		} else {
			return "";
		}
	}

	/**
	 * Recupera a descri��o do tipo de receita ou despesa.
	 * 
	 * @return descri��o do tipo de receita ou despesa.
	 */
	public String getDescricaoLancamento() {
		if (tipoLancamento == "R") {
			return getDescricaoTipoReceita();
		} else {
			return getDescricaoTipoDespesa();
		}
	}

	/**
	 * Recupera a descri��o do tipo de lan�amento.
	 * 
	 * @return descri��o do tipo de lan�amento.
	 */
	public String getDescricaoTipoLancamento() {
		if (tipoLancamento == "R") {
			return "Receita";
		} else {
			return "Despesa";
		}
	}

	/** {@inheritDoc} */
	@Override
	public void validar() throws NegocioException {
		super.validar();
		MsgErro erros = new MsgErro();
		if (tipoLancamento == "R") {
			if (Val.vazio(tipoReceita)) {
				erros.campoObrigatorio("Tipo Receita");
			}
		}
		if (tipoLancamento == "D") {
			if (Val.vazio(tipoDespesa)) {
				erros.campoObrigatorio("Tipo Despesa");
			}
		}
		if (tipoReceita == "D") {
			if (Val.vazio(registroMembro)) {
				erros.campoObrigatorio("Registro Membro");
			}
		}
		erros.gerarErrosNegocio();
	}

	/** {@inheritDoc} */
	@Override
	public void limpar() {
		super.limpar();
		dataInclusao = new Date();
		status = ATIVO;
	}
}