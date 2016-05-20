package sistema.negocio.dominio.entidade;

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

import sistema.negocio.enums.TipoEntidade;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;
import com.forj.cirrus.util.validacao.MsgErro;
import com.forj.cirrus.util.validacao.Val;

/**
 * Gerenciador das regras de negócio para o domínio <b >Igreja</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
@Entity
@Table(name = "entidade")
@NamedQueries({ @NamedQuery(name = Entidade.TODOS, query = "select c from Entidade c"),
        @NamedQuery(name = Entidade.POR_NOME, query = "select c from Entidade c where c.id = ?") })
public class Entidade extends AbstractDominio {

    /** Armazena o oql que busca todos. **/
    public static final String TODOS = "entidade.todos";

    /** Armazena o oql que busca todos. **/
    public static final String POR_NOME = "entidade.porNome";

    /** Armazena o id do banco de dados. **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_entidade")
    @Obrigatorio(rotulo = "Id")
    private Long id;

    /** Armazena o nome fantasia. **/
    @Obrigatorio(rotulo = "Nome")
    @TamanhoMaximo(rotulo = "Nome", maximo = 50)
    @Column(name = "nm_entidade")
    private String nome;

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
    @JoinColumn(name = "cd_matriz", referencedColumnName = "cd_entidade")
    @ManyToOne
    private Entidade matriz;

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
    public Entidade() {
    }

    /**
     * Cria um novo objeto com valores definidos.
     */
    public Entidade(
            Long id, String nome, String cnpj, Long cep, String rua, Integer numero, String bairro,
            String estado, String cidade, String email, String telefone, TipoEntidade tipo, Entidade matriz) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
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
    public String getDescricaoTipoEntidade() {
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
     * Retorna o valor existente na propriedade <b>razao</b>.
     * @return valor existente na <b>razao</b>.
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
     * Retorna o valor existente na propriedade <b>cnpj</b>.
     * @return valor existente na <b>cnpj</b>.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Informa um novo valor na propriedade <b>cnpj</b>.
     * @param cnpj novo valor a ser informado.
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
     * Retorna o valor existente na propriedade <b>tipo</b>.
     * @return valor existente na <b>tipo</b>.
     */
    public TipoEntidade getTipo() {
        return tipo;
    }

    /**
     * Informa um novo valor na propriedade <b>tipo</b>.
     * @param tipo novo valor a ser informado.
     */
    public void setTipo(TipoEntidade tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o valor existente na propriedade <b>matriz</b>.
     * @return valor existente na <b>matriz</b>.
     */
    public Entidade getMatriz() {
        return matriz;
    }

    /**
     * Informa um novo valor na propriedade <b>matriz</b>.
     * @param matriz novo valor a ser informado.
     */
    public void setMatriz(Entidade matriz) {
        this.matriz = matriz;
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
        Entidade other = (Entidade) obj;
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
        return "Entidade [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", cep=" + cep + ", rua=" + rua
            + ", numero=" + numero + ", bairro=" + bairro + ", estado=" + estado + ", cidade=" + cidade
            + ", email=" + email + ", telefone=" + telefone + ", tipo=" + tipo + ", matriz=" + matriz
            + ", dataInclusao=" + dataInclusao + ", dataAlteracao=" + dataAlteracao + ", usuario=" + usuario
            + "]";
    }

}