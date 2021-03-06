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
import com.forj.cirrus.util.validacao.Val;

/**
 * Gerenciador das regras de neg�cio para o dom�nio <b>Campanha</b>.
 * @version 1.0 - 11/05/2016
 * @since 11/05/2016
 */
@Entity
@Table(name = "campanha")
@NamedQueries({
        @NamedQuery(name = Campanha.TODOS, query = "select c from Campanha c"),
        @NamedQuery(name = Campanha.POR_DESCRICAO,
                query = "select c from Campanha c where c.descricao like ?"),
        @NamedQuery(name = Campanha.POR_CODIGO, query = "select c from Campanha c where c.id = ?") })
public class Campanha extends AbstractDominio {

    /** Armazena o oql que busca todos. **/
    public static final String TODOS = "campanha.todos";

    /** Armazena o oql que busca por descri��o. **/
    public static final String POR_DESCRICAO = "campanha.porDescricao";

    /** Armazena o oql que busca por c�digo. **/
    public static final String POR_CODIGO = "campanha.porCodigo";

    /** Armazena o c�digo da campanha. **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_campanha")
    private Long id;

    /** Armazena o c�digo da campanha. **/
    @Column(name = "ds_campanha")
    @Obrigatorio(rotulo = "Descri��o")
    @TamanhoMaximo(rotulo = "Descri��o", maximo = 50)
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
    @Obrigatorio(rotulo = "Data Inclus�o")
    private Date dataInclusao;

    /** Armazena a data de altera��o. **/
    @Column(name = "dt_alteracao")
    @Obrigatorio(rotulo = "Data Altera��o")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    /** Armazena o nome usu�rio de altera��o/inclus�o. **/
    @Column(name = "cd_usuario")
    @TamanhoMaximo(rotulo = "Usu�rio", maximo = 10)
    @Obrigatorio(rotulo = "Usu�rio")
    private String usuario;

    /** Armazena a listagem de contribuintes. **/
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cd_contribuinte")
    private List<Contribuinte> contribuintes;

    /** Cria um novo objeto com valores padr�es. */
    public Campanha() {
        limpar();
    }

    /** Cria um novo objeto com valores padr�es. */
    public Campanha(
            Long id, String descricao, BigDecimal valor, Integer numParcelas, Date dataInicial,
            StatusCampanha status, Entidade entidade, Date dataInclusao, Date dataAlteracao, String usuario) {
        limpar();
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.numParcelas = numParcelas;
        this.dataInicial = dataInicial;
        this.dataFinal = FacadeData.adicionarMeses(this.dataInicial, this.numParcelas - 1);
        this.status = status;
        this.entidade = entidade;
        this.usuario = usuario;
        this.dataInclusao = dataInclusao;
        this.dataAlteracao = dataAlteracao;
    }

    /**
     * Valida atributos b�sicos, apenas para inclus�o dos contribuintes.
     * @throws NegocioException em caso de erros.
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
            erros.campoObrigatorio("Descri��o");
        }
        if (Val.vazio(this.numParcelas)) {
            erros.campoObrigatorio("N�mero de Parcelas");
        }
        if (Val.vazio(this.entidade)) {
            erros.campoObrigatorio("Entidade");
        }
        erros.gerarErrosNegocio();
    }

    /**
     * Verifica se o contribuinte j� foi adicionado na campanha.
     * @throws NegocioException em caso de erros.
     */
    public void validarContribuinte(Contribuinte contribuinte) throws NegocioException {
        MsgErro erros = new MsgErro();
        this.contribuintes.stream().forEach(c -> {
            if (c.equals(contribuinte)) {
                erros.adicionar("Este contribuinte j� foi adicionado nesta campanha");
            }
        });
        erros.gerarErrosNegocio();
    }

    /**
     * Adiciona um contribuinte � campanha.
     * @param contribuinte a ser inclu�do.
     * @throws NegocioException em caso de erros.
     */
    public void addContribuinte(Membro membro) throws NegocioException {
        validarBasico();
        Contribuinte contribuinte = new Contribuinte();
        contribuinte.setMembro(membro);
        contribuinte.setCampanha(this);
        validarContribuinte(contribuinte);
        contribuintes.add(contribuinte);
    }

    /** Distribui o valor da a cada contribuinte com base no n�mero de parcelas. */
    public void aplicarValorPorContribuinte() {
        int conSize = this.contribuintes.size();
        BigDecimal valorUnitario = this.valor.divide(new BigDecimal(conSize), 2);
        this.contribuintes.stream().forEach(c -> c.setValor(valorUnitario));
        this.contribuintes.stream().forEach(c -> System.out.println(c.getValor()));
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

    public void setContribuintes(List<Contribuinte> contribuintes) {
        this.contribuintes = contribuintes;
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
        return "Campanha [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", numParcelas="
            + numParcelas + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", status="
            + status + ", entidade=" + entidade + ", dataInclusao=" + dataInclusao + ", dataAlteracao="
            + dataAlteracao + ", usuario=" + usuario + "]";
    }

}