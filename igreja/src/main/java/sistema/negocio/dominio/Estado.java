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
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 04/05/2016
 * @since 04/05/2016
 */
@Entity
@Table(name = "estado")
@NamedQueries({ @NamedQuery(name = Estado.TODOS, query = "select e from Estado e") })
public class Estado extends AbstractDominio {

	/** Armazena a versão da classe. **/
	private static final long serialVersionUID = -424718442955207299L;

	/** Armazena o oql que busca todos. **/
	public static final String TODOS = "estado.todos";

	/** Armazena o id do banco de dados. **/
	@Id
	@Column(name = "cod_estado")
	private Integer id;

	/** Armazena a descrição. **/
	@Column(name = "sgl_estado")
	private String sigla;

	/** Armazena a descrição. **/
	@Column(name = "nm_estado")
	private String nome;

	public Integer getId() {
		return id;
	}

	public String getSigla() {
		return sigla;
	}

	public String getNome() {
		return nome;
	}
}