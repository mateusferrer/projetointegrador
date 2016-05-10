package sistema.negocio.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;

/**
 * Gerenciador das regras de neg�cio para o dom�nio <b>Estado</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 04/05/2016
 * @since 04/05/2016
 */
@Entity
@Table(name = "estado")
@NamedQueries({ @NamedQuery(name = Estado.TODOS, query = "select e from Estado e"),
        @NamedQuery(name = Estado.POR_SIGLA, query = "select e from Estado e where e.sigla = ?") })
public class Estado extends AbstractDominio {

    /** Armazena a vers�o da classe. **/
    private static final long serialVersionUID = -424718442955207299L;

    /** Armazena o oql que busca todos. **/
    public static final String TODOS = "estado.todos";

    /** Armazena o oql que busca todos. **/
    public static final String POR_SIGLA = "estado.porSigla";

    /** Armazena o id do banco de dados. **/
    @Id
    @Column(name = "cod_estado")
    private Long id;

    /** Armazena a descri��o. **/
    @Column(name = "sgl_estado")
    private String sigla;

    /** Armazena a descri��o. **/
    @Column(name = "nom_estado")
    private String nome;

    public Long getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }
}