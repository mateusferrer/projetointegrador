package sistema.negocio.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import sistema.negocio.enums.TipoEntidade;

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
@Table(name = "entidade")
@NamedQueries({
		@NamedQuery(name = Entidade.TODOS, query = "select c from Entidade c"),
		@NamedQuery(name = Entidade.POR_CODIGO, query = "select c from Entidade c where c.id = ?") })
public class Entidade extends AbstractDominio {

	/** Armazena o oql que busca todos. **/
	public static final String TODOS = "entidade.todos";

	/** Armazena o oql que busca todos. **/
	public static final String POR_CODIGO = "entidade.porCodigo";

	/** Armazena o id do banco de dados. **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_entidade")
	private Integer id;

	/** Armazena a razão social. **/
	@Obrigatorio(rotulo = "Razão Social")
	@TamanhoMaximo(rotulo = "Razão Social", maximo = 100)
	@Column(name = "tx_razao_social")
	private String razao;

	/** Armazena o nome fantasia. **/
	@Obrigatorio(rotulo = "Nome Fantasia")
	@TamanhoMaximo(rotulo = "Nome Fantasia", maximo = 100)
	@Column(name = "tx_nome_fantasia")
	private String fantasia;

	/** Armazena o cnpj. **/
	@Obrigatorio(rotulo = "Cnpj")
	@TamanhoMaximo(rotulo = "Cnpj", maximo = 14)
	@Column(name = "sq_cnpj")
	private String cnpj;

	/** Armazena o cep. **/
	@Obrigatorio(rotulo = "Cep")
	@TamanhoMaximo(rotulo = "Cep", maximo = 8)
	@Column(name = "sq_cep")
	private Long cep;

	/** Armazena o endereço. **/
	@Obrigatorio(rotulo = "Endereço")
	@TamanhoMaximo(rotulo = "Endereço", maximo = 100)
	@Column(name = "tx_endereco")
	private String endereco;

	/** Armazena o número do logradouro. **/
	@Obrigatorio(rotulo = "Nº Endereço")
	@TamanhoMaximo(rotulo = "Nº Endereço", maximo = 5)
	@Column(name = "nr_endereco")
	private Integer numero;

	/** Armazena o estado. **/
	@Obrigatorio(rotulo = "Estado")
	@Column(name = "in_estado")
	@TamanhoMaximo(rotulo = "Estado", maximo = 2)
	private String estado;

	/** Armazena a cidade. **/
	@Obrigatorio(rotulo = "Cidade")
	@Column(name = "nm_cidade")
	@TamanhoMaximo(rotulo = "Cidade", maximo = 50)
	private String cidade;

	/** Armazena o email. **/
	@TamanhoMaximo(rotulo = "Email", maximo = 100)
	@Column(name = "tx_email")
	private String email;

	/** Armazena o telefone. **/
	@Obrigatorio(rotulo = "Telefone")
	@TamanhoMaximo(rotulo = "Telefone", maximo = 11)
	@Column(name = "sq_telefone")
	private String telefone;

	/** Armazena o tipo da igreja (Filial ou Matriz). **/
	@Obrigatorio(rotulo = "Tipo Congregação")
	@Enumerated(EnumType.STRING)
	@Column(name = "tp_entidade")
	private TipoEntidade tipo;

	/** Armazena a igreja matriz. **/
	@Column(name = "cd_matriz")
	private Entidade matriz;

	/** Cria um novo objeto com valores padrões. */
	public Entidade() {
	}

	/** Cria um novo objeto com valores definidos. */
	public Entidade(String razao, String fantasia, String cnpj, Long cep,
			String endereco, Integer numero, String estado, String cidade,
			String email, String telefone, TipoEntidade tipo, Entidade matriz) {
		super();
		this.razao = razao;
		this.fantasia = fantasia;
		this.cnpj = cnpj;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.estado = estado;
		this.cidade = cidade;
		this.email = email;
		this.telefone = telefone;
		this.tipo = tipo;
		this.matriz = matriz;
	}

	/**
	 * Recupera o texto referente à flag informada para o tipo de igreja.
	 * @return descrição do tipo da igreja.
	 */
	public String getDescricaoTipoIgreja() {
		return TipoEntidade.getInstance(this.tipo);
	}

	/** {@inheritDoc} */
	@Override
	public void validar() throws NegocioException {
		super.validar();
		MsgErro erros = new MsgErro();
		if (tipo.equals(TipoEntidade.F)) {
			if (Val.vazio(this.matriz)) {
				erros.campoObrigatorio(TipoEntidade.getInstance(this.tipo));
			}
		}
		erros.gerarErrosNegocio();
	}

	/** {@inheritDoc} */
	@Override
	public void limpar() {
		super.limpar();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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

	public TipoEntidade getTipo() {
		return tipo;
	}

	public void setTipo(TipoEntidade tipo) {
		this.tipo = tipo;
	}

	public Entidade getMatriz() {
		return matriz;
	}

	public void setMatriz(Entidade matriz) {
		this.matriz = matriz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Entidade other = (Entidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entidade [id=" + id + ", razao=" + razao + ", fantasia="
				+ fantasia + ", cnpj=" + cnpj + ", cep=" + cep + ", endereco="
				+ endereco + ", numero=" + numero + ", estado=" + estado
				+ ", cidade=" + cidade + ", email=" + email + ", telefone="
				+ telefone + ", tipo=" + tipo + ", matriz=" + matriz + "]";
	}

}