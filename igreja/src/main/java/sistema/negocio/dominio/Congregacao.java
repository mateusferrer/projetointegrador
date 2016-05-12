package sistema.negocio.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;
import com.forj.cirrus.util.validacao.MsgErro;
import com.forj.cirrus.util.validacao.Val;

/**
 * Gerenciador das regras de negócio para o domínio <b >Igreja</b>.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
@Entity
@Table(name = "congregacao")
@NamedQueries({
		@NamedQuery(name = Congregacao.TODOS, query = "select c from Congregacao c"),
		@NamedQuery(name = Congregacao.POR_CODIGO, query = "select c from Congregacao c where c.id = ?") })
public class Congregacao extends AbstractDominio {

	/** Versão da classe. **/
	private static final long serialVersionUID = -7179268262691485857L;

	/** Armazena o oql que busca todos. **/
	public static final String TODOS = "igreja.todos";

	/** Armazena o oql que busca todos. **/
	public static final String POR_CODIGO = "igreja.porCodigo";

	/** Armazena o id do banco de dados. **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_congregacao")
	private Integer id;

	/** Armazena a razão social. **/
	@Obrigatorio(rotulo = "Razão Social")
	@TamanhoMaximo(rotulo = "Razão Social", maximo = 100)
	@Column(name = "tx_razao")
	private String razao;

	/** Armazena o nome fantasia. **/
	@Obrigatorio(rotulo = "Nome Fantasia")
	@TamanhoMaximo(rotulo = "Nome Fantasia", maximo = 100)
	@Column(name = "tx_fantasia")
	private String fantasia;

	/** Armazena o cnpj. **/
	@Obrigatorio(rotulo = "Cnpj")
	@TamanhoMaximo(rotulo = "Cnpj", maximo = 14)
	@Column(name = "tx_cnpj")
	private String cnpj;

	/** Armazena o cep. **/
	@Obrigatorio(rotulo = "Cep")
	@TamanhoMaximo(rotulo = "Cep", maximo = 8)
	@Column(name = "tx_cep")
	private Long cep;

	/** Armazena o endereço. **/
	@Obrigatorio(rotulo = "Endereço")
	@TamanhoMaximo(rotulo = "Endereço", maximo = 100)
	@Column(name = "tx_logradouro")
	private String logradouro;

	/** Armazena o número do logradouro. **/
	@Obrigatorio(rotulo = "Nº Endereço")
	@TamanhoMaximo(rotulo = "Nº Endereço", maximo = 5)
	@Column(name = "nr_logradouro")
	private Integer numLogradouro;

	/** Armazena o estado. **/
	@Obrigatorio(rotulo = "Estado")
	@Column(name = "tx_estado")
	private Estado estado;

	/** Armazena a cidade. **/
	@Obrigatorio(rotulo = "Cidade")
	@Column(name = "tx_cidade")
	private Cidade cidade;

	/** Armazena o email. **/
	@TamanhoMaximo(rotulo = "Email", maximo = 100)
	@Column(name = "tx_email")
	private String email;

	/** Armazena o telefone. **/
	@Obrigatorio(rotulo = "Telefone")
	@TamanhoMaximo(rotulo = "Telefone", maximo = 11)
	@Column(name = "tx_telefone")
	private String telefone;

	/** Armazena o tipo da igreja (Filial ou Matriz). **/
	@Obrigatorio(rotulo = "Tipo Igreja")
	@Column(name = "tx_tipo")
	private TipoIgreja tipo;

	/** Armazena a igreja matriz. **/
	@Column(name = "cd_igreja_matriz")
	private Congregacao igreja;

	/** Cria um novo objeto com valores padrões. */
	public Congregacao() {
	}

	/**
	 * Cria um novo objeto com valores padrões.
	 * @param razao a ser informada.
	 * @param fantasia a ser informada.
	 * @param cnpj a ser informado.
	 * @param cep a ser informado.
	 * @param logradouro a ser informado.
	 * @param numLogradouro a ser informado.
	 * @param estado a ser informado.
	 * @param cidade a ser informada.
	 * @param email a ser informado.
	 * @param telefone a ser informado.
	 * @param tipo a ser informado.
	 * @param igreja a ser informada.
	 */
	public Congregacao(String razao, String fantasia, String cnpj, Long cep,
			String logradouro, Integer numLogradouro, Estado estado,
			Cidade cidade, String email, String telefone, TipoIgreja tipo,
			Congregacao igreja) {
		this.razao = razao;
		this.fantasia = fantasia;
		this.cnpj = cnpj;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numLogradouro = numLogradouro;
		this.estado = estado;
		this.cidade = cidade;
		this.email = email;
		this.telefone = telefone;
		this.tipo = tipo;
		this.igreja = igreja;
	}

	/**
	 * Recupera o texto referente à flag informada para o tipo de igreja.
	 * 
	 * @return descrição do tipo da igreja.
	 */
	public String getDescricaoTipoIgreja() {
		return TipoIgreja.getInstance(tipo);
	}

	/** {@inheritDoc} */
	@Override
	public void validar() throws NegocioException {
		super.validar();
		MsgErro erros = new MsgErro();
		if (tipo.equals(TipoIgreja.FILIAL)) {
			if (Val.vazio(igreja)) {
				erros.campoObrigatorio("Igreja Matriz");
			}
		}
		erros.gerarErrosNegocio();
	}

	/** {@inheritDoc} */
	@Override
	public void limpar() {
		super.limpar();
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumLogradouro() {
		return numLogradouro;
	}

	public void setNumLogradouro(Integer numLogradouro) {
		this.numLogradouro = numLogradouro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public TipoIgreja getTipo() {
		return tipo;
	}

	public void setTipo(TipoIgreja tipo) {
		this.tipo = tipo;
	}

	public Congregacao getIgreja() {
		return igreja;
	}

	public void setIgreja(Congregacao igreja) {
		this.igreja = igreja;
	}

	public Integer getId() {
		return id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}