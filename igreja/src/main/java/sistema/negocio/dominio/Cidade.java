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
@Table(name = "cidade")
@NamedQueries({ @NamedQuery(name = Cidade.POR_ESTADO, query = "select c from Cidade c where c.idEstado = ?") })
public class Cidade extends AbstractDominio {

    /** Armazena o oql que busca todos. **/
    public static final String POR_ESTADO = "cidade.porEstado";

    /** Armazena o oql que busca todos. **/
    public static final String POR_ID = "cidade.porID";

    /** Armazena o código da cidade. **/
    @Id
    @Column(name = "cod_cidade")
    private Long id;

    /** Armazena o código do estado. **/
    @Column(name = "cod_estado")
    private Long idEstado;

    /** Armazena a descrição. **/
    @Column(name = "nom_cidade")
    private String nome;

    public Long getId() {
        return id;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getNome() {
        return nome;
    }
}