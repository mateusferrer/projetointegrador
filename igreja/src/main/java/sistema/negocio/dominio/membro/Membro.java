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
import sistema.negocio.enums.Sexo;
import sistema.negocio.enums.Status;

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;

/**
 * Gerenciador das regras de negócio para o domínio <b>Membro</b>
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
@Entity
@Table(name = "membro")
@NamedQueries({ @NamedQuery(name = Membro.TODOS, query = "select c from Membro c"),
        @NamedQuery(name = Membro.POR_NOME, query = "select c from Membro c where c.nome like ?"),
        @NamedQuery(name = Membro.POR_CODIGO, query = "select c from Membro c where c.id = ?") })
public class Membro extends AbstractDominio {

    /** Armazena o oql que busca todos. **/
    public static final String TODOS = "membro.todos";

    /** Armazena o oql que busca por nome. **/
    public static final String POR_NOME = "membro.porNome";

    /** Armazena o oql que busca por código. **/
    public static final String POR_CODIGO = "membro.porCodigo";

    /** Armazena o id do banco de dados. **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_membro")
    private Long id;

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

    /** Armazena o nome da rua. **/
    @Obrigatorio(rotulo = "Rua")
    @TamanhoMaximo(rotulo = "Rua", maximo = 50)
    @Column(name = "ds_rua")
    private String rua;

    /** Armazena o número da rua. **/
    @Obrigatorio(rotulo = "Número")
    @TamanhoMaximo(rotulo = "Número", maximo = 5)
    @Column(name = "nr_rua")
    private Integer numero;

    /** Armazena o nome do bairro. **/
    @Obrigatorio(rotulo = "Bairro")
    @Column(name = "ds_bairro")
    @TamanhoMaximo(rotulo = "Bairro", maximo = 50)
    private String bairro;

    /** Armazena o estado. **/
    @Obrigatorio(rotulo = "Estado")
    @Column(name = "in_estado")
    @TamanhoMaximo(rotulo = "Estado", maximo = 2)
    private String estado;

    /** Armazena o nome da cidade. **/
    @Obrigatorio(rotulo = "Cidade")
    @Column(name = "nm_cidade")
    @TamanhoMaximo(rotulo = "Cidade", maximo = 50)
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
    @TamanhoMaximo(rotulo = "Motivo", maximo = 150)
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
    @Obrigatorio(rotulo = "Sexo")
    @Column(name = "in_sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

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

    /**
     * Cria um novo objeto com valores definidos.
     */
    public Membro(
            Long id, String nome, String rg, String cpf, Long cep, String rua, Integer numero, String bairro,
            String estado, String cidade, String email, String telefone, String celular, String motivo,
            Entidade entidade, TipoMembro tipo, Sexo sexo, Status status) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.motivo = motivo;
        this.entidade = entidade;
        this.tipo = tipo;
        this.sexo = sexo;
        this.status = status;
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

    /**
     * Retorna o valor existente na propriedade <b>id</b>.
     * @return valor existente na <b>id</b>.
     */
    public Long getId() {
        return id;
    }

    /**
     * Informa um novo valor na propriedade <b>id</b>.
     * @param id novo valor a ser informado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o valor existente na propriedade <b>nome</b>.
     * @return valor existente na <b>nome</b>.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Informa um novo valor na propriedade <b>nome</b>.
     * @param nome novo valor a ser informado.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o valor existente na propriedade <b>rg</b>.
     * @return valor existente na <b>rg</b>.
     */
    public String getRg() {
        return rg;
    }

    /**
     * Informa um novo valor na propriedade <b>rg</b>.
     * @param rg novo valor a ser informado.
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Retorna o valor existente na propriedade <b>cpf</b>.
     * @return valor existente na <b>cpf</b>.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Informa um novo valor na propriedade <b>cpf</b>.
     * @param cpf novo valor a ser informado.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o valor existente na propriedade <b>cep</b>.
     * @return valor existente na <b>cep</b>.
     */
    public Long getCep() {
        return cep;
    }

    /**
     * Informa um novo valor na propriedade <b>cep</b>.
     * @param cep novo valor a ser informado.
     */
    public void setCep(Long cep) {
        this.cep = cep;
    }

    /**
     * Retorna o valor existente na propriedade <b>rua</b>.
     * @return valor existente na <b>rua</b>.
     */
    public String getRua() {
        return rua;
    }

    /**
     * Informa um novo valor na propriedade <b>rua</b>.
     * @param rua novo valor a ser informado.
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Retorna o valor existente na propriedade <b>numero</b>.
     * @return valor existente na <b>numero</b>.
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Informa um novo valor na propriedade <b>numero</b>.
     * @param numero novo valor a ser informado.
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Retorna o valor existente na propriedade <b>bairro</b>.
     * @return valor existente na <b>bairro</b>.
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Informa um novo valor na propriedade <b>bairro</b>.
     * @param bairro novo valor a ser informado.
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Retorna o valor existente na propriedade <b>estado</b>.
     * @return valor existente na <b>estado</b>.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Informa um novo valor na propriedade <b>estado</b>.
     * @param estado novo valor a ser informado.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Retorna o valor existente na propriedade <b>cidade</b>.
     * @return valor existente na <b>cidade</b>.
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Informa um novo valor na propriedade <b>cidade</b>.
     * @param cidade novo valor a ser informado.
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Retorna o valor existente na propriedade <b>email</b>.
     * @return valor existente na <b>email</b>.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Informa um novo valor na propriedade <b>email</b>.
     * @param email novo valor a ser informado.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna o valor existente na propriedade <b>telefone</b>.
     * @return valor existente na <b>telefone</b>.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Informa um novo valor na propriedade <b>telefone</b>.
     * @param telefone novo valor a ser informado.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o valor existente na propriedade <b>celular</b>.
     * @return valor existente na <b>celular</b>.
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Informa um novo valor na propriedade <b>celular</b>.
     * @param celular novo valor a ser informado.
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Retorna o valor existente na propriedade <b>status</b>.
     * @return valor existente na <b>status</b>.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Informa um novo valor na propriedade <b>status</b>.
     * @param status novo valor a ser informado.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Retorna o valor existente na propriedade <b>motivo</b>.
     * @return valor existente na <b>motivo</b>.
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Informa um novo valor na propriedade <b>motivo</b>.
     * @param motivo novo valor a ser informado.
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Retorna o valor existente na propriedade <b>entidade</b>.
     * @return valor existente na <b>entidade</b>.
     */
    public Entidade getEntidade() {
        return entidade;
    }

    /**
     * Informa um novo valor na propriedade <b>entidade</b>.
     * @param entidade novo valor a ser informado.
     */
    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    /**
     * Retorna o valor existente na propriedade <b>tipo</b>.
     * @return valor existente na <b>tipo</b>.
     */
    public TipoMembro getTipo() {
        return tipo;
    }

    /**
     * Informa um novo valor na propriedade <b>tipo</b>.
     * @param tipo novo valor a ser informado.
     */
    public void setTipo(TipoMembro tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o valor existente na propriedade <b>sexo</b>.
     * @return valor existente na <b>sexo</b>.
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * Informa um novo valor na propriedade <b>sexo</b>.
     * @param sexo novo valor a ser informado.
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * Retorna o valor existente na propriedade <b>dataInclusao</b>.
     * @return valor existente na <b>dataInclusao</b>.
     */
    public Date getDataInclusao() {
        return dataInclusao;
    }

    /**
     * Informa um novo valor na propriedade <b>dataInclusao</b>.
     * @param dataInclusao novo valor a ser informado.
     */
    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    /**
     * Retorna o valor existente na propriedade <b>dataAlteracao</b>.
     * @return valor existente na <b>dataAlteracao</b>.
     */
    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    /**
     * Informa um novo valor na propriedade <b>dataAlteracao</b>.
     * @param dataAlteracao novo valor a ser informado.
     */
    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    /**
     * Retorna o valor existente na propriedade <b>usuario</b>.
     * @return valor existente na <b>usuario</b>.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Informa um novo valor na propriedade <b>usuario</b>.
     * @param usuario novo valor a ser informado.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Membro [id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", cep=" + cep
            + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", estado=" + estado
            + ", cidade=" + cidade + ", email=" + email + ", telefone=" + telefone + ", celular=" + celular
            + ", status=" + status + ", motivo=" + motivo + ", entidade=" + entidade + ", tipo=" + tipo
            + ", sexo=" + sexo + ", dataInclusao=" + dataInclusao + ", dataAlteracao=" + dataAlteracao
            + ", usuario=" + usuario + "]";
    }

}