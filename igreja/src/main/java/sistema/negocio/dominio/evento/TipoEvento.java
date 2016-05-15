package sistema.negocio.dominio.evento;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;

/**
 * Gerenciador das regras de neg�cio para o dom�nio <b>Tipo Evento</b>.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@Entity
@Table(name = "tipo_evento")
@NamedQueries({
		@NamedQuery(name = TipoEvento.TODOS, query = "select c from TipoEvento c"),
		@NamedQuery(name = TipoEvento.POR_DESCRICAO, query = "select c from TipoEvento c where c.descricao like ?") })
public class TipoEvento extends AbstractDominio {

	/** Armazena o oql que busca todos. **/
	public static final String TODOS = "tipoevento.todos";

	/** Armazena o oql que busca por descri��o. **/
	public static final String POR_DESCRICAO = "tipoevento.porDescricao";

	/** Armazena o id do banco de dados. **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_tipo")
	public Integer id;

	/** Armazena a descri��o. **/
	@Obrigatorio(rotulo = "Descri��o")
	@TamanhoMaximo(rotulo = "Descri��o", maximo = 50)
	@Column(name = "ds_tipo_evento")
	public String descricao;

	/** Armazena a data de inclus�o do registro. **/
	@Obrigatorio(rotulo = "Data Inclus�o")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inclusao")
	public Date dataInclusao;

	/** Armazena a data de inclus�o do registro. **/
	@Obrigatorio(rotulo = "Data Altera��o")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_alteracao")
	public Date dataAlteracao;

	/** Armazena o usu�rio de inclus�o/altera��o. **/
	@Obrigatorio(rotulo = "Usu�rio Inclus�o")
	@TamanhoMaximo(rotulo = "Usu�rio Inclus�o", maximo = 10)
	@Column(name = "cd_usuario")
	public String usuario;

	/** Cria um novo objeto com valores padr�es. */
	public TipoEvento() {
	}

	/**
	 * Cria um novo objeto com valores padr�es.
	 * 
	 * @param descricao
	 *            a ser informada.
	 * @param dataInclusao
	 *            a der informada.
	 * @param dataAlteracao
	 *            a ser informada.
	 * @param usuario
	 *            a ser informado.
	 */
	public TipoEvento(String descricao, Date dataInclusao, Date dataAlteracao,
			String usuario) {
		this.descricao = descricao;
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Integer getId() {
		return id;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "TipoEvento [id=" + id + ", descricao=" + descricao
				+ ", dataInclusao=" + dataInclusao + ", dataAlteracao="
				+ dataAlteracao + ", usuario=" + usuario + "]";
	}

}