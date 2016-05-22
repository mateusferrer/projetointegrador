package sistema.negocio.dominio;

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio

/**
 * Gerenciador das regras de negócio para o domínio <b>Tipo Evento</b>.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@ToString
@EqualsAndHashCode(includes = "pk")
@Entity
@Table(name = "usuario")
@NamedQueries([@NamedQuery(name = Usuario.TODOS, query = "select u from Usuario u"),
	@NamedQuery(name = Usuario.POR_LOGIN, query = "select u from Usuario u where u.pk = ?")])
class Usuario extends AbstractDominio {

	/** Armazena o oql que busca todos. **/
	public static final String TODOS = "usuario.todos"

	/** Armazena o oql que busca todos. **/
	public static final String POR_LOGIN = "usuario.porLogin"

	/** Armazena o id do banco de dados. **/
	@Id
	@EmbeddedId
	UsuarioPk pk

	@Column(name = "in_tipo_usuario")
	@Obrigatorio(rotulo = "Tipo Usuário")
	String tipo

	@Column(name = "in_situcao")
	@Obrigatorio(rotulo = "Status")
	String situacao
}