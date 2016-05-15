package sistema.negocio.dominio.membro;

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

import sistema.negocio.dominio.entidade.Entidade;

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;

/**
 * Gerenciador das regras de negócio para o domínio <b>Membro</b>.
 * 
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
@Entity
@Table(name = "membro")
@NamedQueries({
		@NamedQuery(name = Membro.TODOS, query = "select c from Membro c"),
		@NamedQuery(name = Membro.TODOS, query = "select c from Membro c") })
public class Membro extends AbstractDominio {

	/** Armazena o oql que busca todos. **/
	public static final String TODOS = "membro.todos";

	/** Armazena o oql que busca por nome. **/
	public static final String POR_NOME = "membro.porNome";

	/** Armazena o id do banco de dados. **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_membro")
	private Integer id;

	/** Armazena o nome. **/
	@Obrigatorio(rotulo = "Nome")
	@TamanhoMaximo(rotulo = "Nome", maximo = 100)
	@Column(name = "nm_membro")
	private String nome;

	/** Armazena o rg. **/
	@TamanhoMaximo(rotulo = "Rg", maximo = 9)
	@Column(name = "sq_rg")
	private String rg;

	/** Armazena o cnpj. **/
	@Obrigatorio(rotulo = "Cpf")
	@TamanhoMaximo(rotulo = "Cpf", maximo = 11)
	@Column(name = "sq_cpf")
	private String cpf;

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
	@TamanhoMaximo(rotulo = "Estado", maximo = 50)
	@Column(name = "in_estado")
	private String estado;

	/** Armazena a cidade. **/
	@Obrigatorio(rotulo = "Cidade")
	@TamanhoMaximo(rotulo = "Cidade", maximo = 50)
	@Column(name = "nm_cidade")
	private String cidade;

	/** Armazena o email. **/
	@TamanhoMaximo(rotulo = "Email", maximo = 100)
	@Column(name = "tx_email")
	private String email;

	/** Armazena o telefone. **/
	@TamanhoMaximo(rotulo = "Telefone", maximo = 11)
	@Column(name = "sq_telefone")
	private String telefone;

	/** Armazena o celular. **/
	@TamanhoMaximo(rotulo = "Celular", maximo = 11)
	@Column(name = "sq_celular")
	private String celular;

	/** Armazena a igreja matriz. **/
	@Obrigatorio(rotulo = "Entidade")
	@ManyToOne
	@JoinColumn(name = "cd_entidade")
	private Entidade entidade;

	/** Armazena a entidade. **/
	@Obrigatorio(rotulo = "Tipo Membro")
	@ManyToOne
	@JoinColumn(name = "cd_tipo")
	private TipoMembro tipo;

	/** Armazena o sexo Masculino ou Feminino. **/
	@TamanhoMaximo(rotulo = "Sexo", maximo = 1)
	@Obrigatorio(rotulo = "Sexo")
	@Column(name = "in_sexo")
	private String sexo;

	/** Armazena o status Ativo ou Inativo. **/
	@TamanhoMaximo(rotulo = "Status", maximo = 1)
	@Obrigatorio(rotulo = "Status")
	@Column(name = "in_status")
	private String status;

	/** Armazena o registro de batismo. **/
	@TamanhoMaximo(rotulo = "Registro Batismo", maximo = 10)
	@Obrigatorio(rotulo = "Registro Batismo")
	@Column(name = "nr_batismo")
	private Long registroBatismo;

	/** Armazena a data de batismo do membro. **/
	@Obrigatorio(rotulo = "Data de Nascimento")
	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	/** Armazena a data de batismo do membro. **/
	@Obrigatorio(rotulo = "Data de Batismo")
	@Column(name = "dt_batismo")
	@Temporal(TemporalType.DATE)
	private Date dataBatismo;

	/** Armazena a data de cadastro do membro. **/
	@Obrigatorio(rotulo = "Data de Cadastro")
	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	/**
	 * Recupera a descrição do status do membro..
	 * 
	 * @return descricao do status.
	 */
	public String getDescricaoStatus() {
		return status.equals("A") ? "Ativo" : "Inativo";
	}

	/**
	 * Cria um novo objeto com valores padrões.
	 */
	public Membro() {
		this.limpar();
	}

	/** {@inheritDoc} */
	@Override
	public void limpar() {
		super.limpar();
		entidade = new Entidade();
		tipo = new TipoMembro();
		dataCadastro = new Date();
	}
}