package sistema.negocio.dominio.campanha;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sistema.negocio.dominio.entidade.Entidade;
import sistema.negocio.dominio.membro.Membro;
import sistema.negocio.enums.StatusCampanha;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;
import com.forj.cirrus.util.facades.FacadeData;
import com.forj.cirrus.util.validacao.MsgErro;
import com.forj.cirrus.util.validacao.Param;
import com.forj.cirrus.util.validacao.Val;

/**
 * Gerenciador das regras de negócio para o domínio <b>Campanha</b>.
 * 
 * @version 1.0 - 11/05/2016
 * @since 11/05/2016
 */
@Entity
@Table(name = "campanha")
@NamedQueries({
		@NamedQuery(name = Campanha.TODOS, query = "select c from Campanha c"),
		@NamedQuery(name = Campanha.POR_DESCRICAO, query = "select c from Campanha c where c.descricao like ?"),
		@NamedQuery(name = Campanha.POR_CODIGO, query = "select c from Campanha c where c.id = ?") })
public class Campanha extends AbstractDominio {

	/** Armazena o oql que busca todos. **/
	public static final String TODOS = "campanha.todos";

	/** Armazena o oql que busca por descrição. **/
	public static final String POR_DESCRICAO = "campanha.porDescricao";

	/** Armazena o oql que busca por código. **/
	public static final String POR_CODIGO = "campanha.porCodigo";

	/** Armazena o código da campanha. **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_campanha")
	private Long id;

	/** Armazena o código da campanha. **/
	@Column(name = "ds_campanha")
	@Obrigatorio(rotulo = "Descrição")
	@TamanhoMaximo(rotulo = "Descrição", maximo = 50)
	private String descricao;

	/** Armazena o valor da campanha. **/
	@Obrigatorio(rotulo = "Valor")
	@Column(name = "vl_campanha")
	@TamanhoMaximo(rotulo = "Valor", maximo = 12)
	private BigDecimal valor;

	/** Armazena a quantidade de parcelas. **/
	@Obrigatorio(rotulo = "Qtde Parcelas")
	@TamanhoMaximo(rotulo = "Qtde Parcelas", maximo = 2)
	@Column(name = "nr_parcelas")
	private Integer numParcelas;

	/** Armazena a data inicial da campanha. **/
	@Obrigatorio(rotulo = "Data Inicial")
	@Column(name = "dt_inicial")
	@Temporal(TemporalType.DATE)
	private Date dataInicial;

	/** Armazena a data final da campanha. **/
	@Obrigatorio(rotulo = "Data Final")
	@Column(name = "dt_final")
	@Temporal(TemporalType.DATE)
	private Date dataFinal;

	/** Armazena o status da campanha. **/
	@Obrigatorio(rotulo = "Status")
	@Column(name = "in_status")
	@Enumerated(EnumType.STRING)
	private StatusCampanha status;

	/** Armazena a entidade que realiza a campanha. **/
	@Obrigatorio(rotulo = "Entidade")
	@JoinColumn(name = "cd_entidade")
	@ManyToOne
	private Entidade entidade;

	/** Armazena a data de cadastro. **/
	@Column(name = "dt_inclusao")
	@Temporal(TemporalType.TIMESTAMP)
	@Obrigatorio(rotulo = "Data Inclusão")
	private Date dataInclusao;

	/** Armazena a data de alteração. **/
	@Column(name = "dt_alteracao")
	@Obrigatorio(rotulo = "Data Alteração")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;

	/** Armazena o nome usuário de alteração/inclusão. **/
	@Column(name = "cd_usuario")
	@TamanhoMaximo(rotulo = "Usuário", maximo = 10)
	@Obrigatorio(rotulo = "Usuário")
	private String usuario;

	/** Armazena a listagem de contribuintes. **/
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_contribuinte")
	private List<Contribuinte> contribuintes;

	/** Cria um novo objeto com valores padrões. */
	public Campanha() {
		limpar();
	}

	/** Cria um novo objeto com valores padrões. */
	public Campanha(Long id, String descricao, BigDecimal valor,
			Integer numParcelas, Date dataInicial, StatusCampanha status,
			Entidade entidade, String usuario) {
		limpar();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.numParcelas = numParcelas;
		this.dataInicial = dataInicial;
		this.dataFinal = FacadeData.adicionarMeses(this.dataInicial,
				this.numParcelas - 1);
		this.status = status;
		this.entidade = entidade;
		this.usuario = usuario;
	}

	/**
	 * Valida atributos básicos, apenas para inclusão dos contribuintes.
	 * 
	 * @throws NegocioException
	 *             em caso de erros.
	 */
	public void validarBasico() throws NegocioException {
		MsgErro erros = new MsgErro();
		if (Val.vazio(this.dataInicial)) {
			erros.campoObrigatorio("Data Inicial");
		}
		if (Val.vazio(this.dataFinal)) {
			erros.campoObrigatorio("Data Final");
		}
		if (Val.vazio(this.valor)) {
			erros.campoObrigatorio("Valor");
		}
		if (Val.vazio(this.descricao)) {
			erros.campoObrigatorio("Descrição");
		}
		if (Val.vazio(this.numParcelas)) {
			erros.campoObrigatorio("Número de Parcelas");
		}
		erros.gerarErrosNegocio();
	}

	/**
	 * Valida a quantidade de contribuintes da campanha.
	 * 
	 * @throws NegocioException
	 *             em caso de erros.
	 */
	public void validarContribuintes() throws NegocioException {
		MsgErro erros = new MsgErro();
		if (Val.vazio(this.contribuintes)) {
			erros.adicionar("A campanha deve possuir ao menos 1 contribuinte associado");
		}
		erros.gerarErrosNegocio();
	}

	/**
	 * Adiciona um contribuinte à campanha.
	 * 
	 * @param contribuinte
	 *            a ser incluído.
	 * @throws NegocioException
	 *             em caso de erros.
	 */
	public void addContribuinte(Membro membro) throws NegocioException {
		Param.validar(membro, "Membro");
		this.validarBasico();
		int listSize = this.contribuintes.size();
		BigDecimal valorUnitario = this.valor.divide(BigDecimal
				.valueOf(listSize + 1));
		Contribuinte contribuinte = new Contribuinte(null, this, membro,
				valorUnitario, this.dataInicial, this.dataFinal);
		if (listSize > 0) {
			this.contribuintes.stream().forEach(c -> c.setValor(valorUnitario));
		}
		contribuinte.validar();
		contribuintes.add(contribuinte);
	}

	/** {@inheritDoc} */
	@Override
	public void limpar() {
		super.limpar();
		this.contribuintes = new ArrayList<>();
		this.entidade = new Entidade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(Integer numParcelas) {
		this.numParcelas = numParcelas;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public StatusCampanha getStatus() {
		return status;
	}

	public void setStatus(StatusCampanha status) {
		this.status = status;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Contribuinte> getContribuintes() {
		return contribuintes;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Campanha)) {
			return false;
		}
		Campanha other = (Campanha) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Campanha [id=" + id + ", descricao=" + descricao + ", valor="
				+ valor + ", numParcelas=" + numParcelas + ", dataInicial="
				+ dataInicial + ", dataFinal=" + dataFinal + ", status="
				+ status + ", entidade=" + entidade + ", dataInclusao="
				+ dataInclusao + ", dataAlteracao=" + dataAlteracao
				+ ", usuario=" + usuario + "]";
	}

	/**
	 * Gerenciador das regras de negócio para o domínio <b>Contribuinte</b>.
	 * 
	 * @version 1.0 - 28/05/2016
	 * @since 28/05/2016
	 */
	@Entity
	@Table(name = "contribuinte")
	@NamedQueries({
			@NamedQuery(name = Contribuinte.TODOS, query = "select c from Contribuinte c"),
			@NamedQuery(name = Contribuinte.POR_CAMPANHA, query = "select c from Contribuinte c where c.campanha.id = ?"),
			@NamedQuery(name = Contribuinte.POR_MEMBRO, query = "select c from Contribuinte c where c.membro.id = ?") })
	public class Contribuinte extends AbstractDominio {

		/** Armazena o oql que busca todos. **/
		public static final String TODOS = "contribuinte.todos";

		/** Armazena o oql que busca por campanha. **/
		public static final String POR_CAMPANHA = "contribuinte.porCampanha";

		/** Armazena o oql que busca por membro. **/
		public static final String POR_MEMBRO = "contribuinte.porMembro";

		/** Armazena o código da campanha. **/
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "cd_contribuinte")
		private Long id;

		/** Armazena a campanha. **/
		@ManyToOne
		@JoinColumn(name = "cd_campanha")
		@Obrigatorio(rotulo = "Campanha")
		private Campanha campanha;

		/** Armazena o membro contribuinte. **/
		@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
		@JoinColumn(name = "cd_membro")
		@Obrigatorio(rotulo = "Membro")
		private Membro membro;

		/** Armazena o valor da campanha. **/
		@Column(name = "vl_contribuido")
		@Obrigatorio(rotulo = "Valor Contribuído")
		private BigDecimal valor;

		/** Armazena a data inicial da campanha. **/
		@Column(name = "dt_inicial")
		@Temporal(TemporalType.DATE)
		@Obrigatorio(rotulo = "Data Inicial")
		private Date dataInicial;

		/** Armazena a data final da campanha. **/
		@Column(name = "dt_final")
		@Temporal(TemporalType.DATE)
		@Obrigatorio(rotulo = "Data Final")
		private Date dataFinal;

		/** Cria um novo objeto com valores padrões. */
		public Contribuinte() {
		}

		/** Cria um novo objeto com valores definidos. */
		public Contribuinte(Long id, Campanha campanha, Membro membro,
				BigDecimal valor, Date dataInicial, Date dataFinal) {
			this.id = id;
			this.campanha = campanha;
			this.membro = membro;
			this.valor = valor;
			this.dataInicial = dataInicial;
			this.dataFinal = dataFinal;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Campanha getCampanha() {
			return campanha;
		}

		public void setCampanha(Campanha campanha) {
			this.campanha = campanha;
		}

		public Membro getMembro() {
			return membro;
		}

		public void setMembro(Membro membro) {
			this.membro = membro;
		}

		public BigDecimal getValor() {
			return valor;
		}

		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}

		public Date getDataInicial() {
			return dataInicial;
		}

		public void setDataInicial(Date dataInicial) {
			this.dataInicial = dataInicial;
		}

		public Date getDataFinal() {
			return dataFinal;
		}

		public void setDataFinal(Date dataFinal) {
			this.dataFinal = dataFinal;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((campanha == null) ? 0 : campanha.hashCode());
			result = prime * result
					+ ((membro == null) ? 0 : membro.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Contribuinte other = (Contribuinte) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (campanha == null) {
				if (other.campanha != null)
					return false;
			} else if (!campanha.equals(other.campanha))
				return false;
			if (membro == null) {
				if (other.membro != null)
					return false;
			} else if (!membro.equals(other.membro))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Contribuinte [id=" + id + ", campanha=" + campanha
					+ ", membro=" + membro + ", valor=" + valor
					+ ", dataInicial=" + dataInicial + ", dataFinal="
					+ dataFinal + "]";
		}

		private Campanha getOuterType() {
			return Campanha.this;
		}

	}
}