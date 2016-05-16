package sistema.negocio.dominio.membro;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import sistema.negocio.enums.Status;

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;

/**
 * Gerenciador das regras de negócio para o domínio <b>Membro</b>.
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

	/** Armazena o número do endereço. **/
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

	/** Armazena o status Ativo ou Inativo. **/
	@Obrigatorio(rotulo = "Status")
	@Column(name = "in_status")
	@Enumerated(EnumType.STRING)
	private Status status;

	/** Armazena o motivo de inativação. **/
	@TamanhoMaximo(rotulo = "Motivo", maximo = 500)
	@Obrigatorio(rotulo = "Motivo")
	@Column(name = "tx_motivo")
	private String motivo;

	/** Armazena a entidade. **/
	@Obrigatorio(rotulo = "Entidade")
	@ManyToOne
	@JoinColumn(name = "cd_entidade")
	private Entidade entidade;

	/** Armazena o tipo de membro. **/
	@Obrigatorio(rotulo = "Tipo Membro")
	@ManyToOne
	@JoinColumn(name = "cd_tipo")
	private TipoMembro tipo;

	/** Armazena o sexo. **/
	@TamanhoMaximo(rotulo = "Sexo", maximo = 1)
	@Obrigatorio(rotulo = "Sexo")
	@Column(name = "in_sexo")
	private String sexo;

	/** Armazena o registro de batismo. **/
	// @TamanhoMaximo(rotulo = "Registro Batismo", maximo = 10)
	// @Column(name = "nr_batismo")
	// private Long registroBatismo;

	/** Armazena a data de batismo do membro. **/
	// @Obrigatorio(rotulo = "Data de Batismo")
	// @Column(name = "dt_batismo")
	// @Temporal(TemporalType.DATE)
	// private Date dataBatismo;

	/** Armazena a data de inclusão do registro. **/
	@Obrigatorio(rotulo = "Data Inclusão")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inclusao")
	public Date dataInclusao;

	/** Armazena a data de inclusão do registro. **/
	@Obrigatorio(rotulo = "Data Alteração")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_alteracao")
	public Date dataAlteracao;

	/** Armazena o usuário de inclusão/alteração. **/
	@Obrigatorio(rotulo = "Usuário Inclusão")
	@TamanhoMaximo(rotulo = "Usuário Inclusão", maximo = 10)
	@Column(name = "cd_usuario")
	public String usuario;

	/** Cria um novo objeto com valores padrões. */
	public Membro() {
		this.limpar();
	}

	/** Cria um novo objeto com valores definidos. */
	public Membro(String nome, String rg, String cpf, Long cep,
			String endereco, Integer numero, String estado, String cidade,
			String email, String telefone, String celular, Status status,
			String motivo, Entidade entidade, TipoMembro tipo, String sexo,
			Date dataInclusao, Date dataAlteracao, String usuario) {
		super();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.estado = estado;
		this.cidade = cidade;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.status = status;
		this.motivo = motivo;
		this.entidade = entidade;
		this.tipo = tipo;
		this.sexo = sexo;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usuario = usuario;
	}

	/**
	 * Recupera a descrição do status do membro..
	 * @return descricao do status.
	 */
	public String getDescricaoStatus() {
		return Status.getInstance(this.status);
	}

	/** {@inheritDoc} */
	@Override
	public void limpar() {
		super.limpar();
		this.entidade = new Entidade();
		this.tipo = new TipoMembro();
		this.dataInclusao = new Date();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public TipoMembro getTipo() {
		return tipo;
	}

	public void setTipo(TipoMembro tipo) {
		this.tipo = tipo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public Integer getId() {
		return id;
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
		Membro other = (Membro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Membro [id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf="
				+ cpf + ", cep=" + cep + ", endereco=" + endereco + ", numero="
				+ numero + ", estado=" + estado + ", cidade=" + cidade
				+ ", email=" + email + ", telefone=" + telefone + ", celular="
				+ celular + ", status=" + status + ", motivo=" + motivo
				+ ", entidade=" + entidade + ", tipo=" + tipo + ", sexo="
				+ sexo + ", dataInclusao=" + dataInclusao + ", dataAlteracao="
				+ dataAlteracao + ", usuario=" + usuario + "]";
	}
	
}