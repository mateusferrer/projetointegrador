package sistema.negocio.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;

/**
 * Gerenciador das regras de negócio para o domínio <b>Estado</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 04/05/2016
 * @since 04/05/2016
 */
@Entity
@Table(name = "estado")
@NamedQueries({ @NamedQuery(name = Estado.TODOS, query = "select e from Estado e"),
        @NamedQuery(name = Estado.POR_ID, query = "select e from Estado e where e.id = ?"),
        @NamedQuery(name = Estado.POR_TEXTO, query = "select e from Estado e where e.nome like '?%'") })
public class Estado extends AbstractDominio {

    /** Armazena o oql que busca todos. **/
    public static final String TODOS = "estado.todos";

    /** Armazena o oql que busca todos. **/
    public static final String POR_ID = "estado.porID";

    /** Armazena o oql que busca todos. **/
    public static final String POR_TEXTO = "estado.porTexto";

    /** Armazena o id do banco de dados. **/
    @Id
    @Column(name = "cod_estado")
    private Long id;

    /** Armazena a descrição. **/
    @Column(name = "sgl_estado")
    private String sigla;

    /** Armazena a descrição. **/
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

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return sigla + " - " + nome;
    }
}