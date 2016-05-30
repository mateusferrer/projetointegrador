package sistema.negocio.dominio.campanha;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import sistema.negocio.dominio.membro.Membro;

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;

/**
 * Gerenciador das regras de negócio para o domínio <b>Contribuinte</b>.
 * @version 1.0 - 28/05/2016
 * @since 28/05/2016
 */
@Entity
@Table(name = "contribuinte")
@NamedQueries({
        @NamedQuery(name = Contribuinte.TODOS, query = "select c from Contribuinte c"),
        @NamedQuery(name = Contribuinte.POR_CAMPANHA,
                query = "select c from Contribuinte c where c.campanha.id = ?"),
        @NamedQuery(name = Contribuinte.POR_MEMBRO,
                query = "select c from Contribuinte c where c.membro.id = ?") })
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    /**
     * Informa a campanha e também os valores referentes às datas inicial e final.
     * @param campanha a ser informada.
     */
    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
        this.dataInicial = this.campanha.getDataInicial();
        this.dataFinal = this.campanha.getDataFinal();
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

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((campanha == null) ? 0 : campanha.hashCode());
        result = prime * result + ((membro == null) ? 0 : membro.hashCode());
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
        if (!(obj instanceof Contribuinte)) {
            return false;
        }
        Contribuinte other = (Contribuinte) obj;
        if (campanha == null) {
            if (other.campanha != null) {
                return false;
            }
        } else if (!campanha.equals(other.campanha)) {
            return false;
        }
        if (membro == null) {
            if (other.membro != null) {
                return false;
            }
        } else if (!membro.equals(other.membro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contribuinte [id=" + id + ", campanha=" + campanha + ", membro=" + membro + ", valor="
            + valor + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + "]";
    }

}
