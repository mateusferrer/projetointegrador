package sistema.negocio.dominio;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;

/**
 * Gerenciador das regras de neg�cio para o dom�nio <b>Campanha</b>.
 * @version 1.0 - 11/05/2016
 * @since 11/05/2016
 */
@Entity
@Table(name = "contribuinte")
@NamedQueries({ @NamedQuery(name = Contribuinte.TODOS, query = "select c from Contribuinte c") })
public class Contribuinte extends AbstractDominio {

    /** Armazena o oql que busca todos. **/
    public static final String TODOS = "campanha.todos";

    /** Armazena o c�digo da campanha. **/
    @Id
    @Column(name = "cd_contribuinte")
    private Long id;

    /** Armazena a campanha. **/
    @ManyToOne
    @Obrigatorio(rotulo = "Campanha")
    @JoinColumn(name = "cd_campanha")
    private Campanha campanha;

    /** Armazena o membro contribuinte. **/
    @ManyToOne
    @Obrigatorio(rotulo = "Membro")
    @JoinColumn(name = "cd_membro")
    private Membro membro;

    /** Armazena o valor da campanha. **/
    @Obrigatorio(rotulo = "Valor Contribu�do")
    @Column(name = "vl_contribuido")
    private BigDecimal valor;

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

    /** Armazena a data de cadastro. **/
    @Obrigatorio(rotulo = "Data de Cadastro")
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    /** Armazena a data de altera��o. **/
    @Obrigatorio(rotulo = "Data de Altera��o")
    @Column(name = "dt_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    /** Armazena o nome usu�rio de altera��o/inclus�o. **/
    @Obrigatorio(rotulo = "Usuario")
    @Column(name = "cd_usuario")
    private String nomeUsuario;

}