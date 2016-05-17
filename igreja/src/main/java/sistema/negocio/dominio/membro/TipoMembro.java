package sistema.negocio.dominio.membro;

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
 * Gerenciador das regras de negócio para o domínio <b>Tipo Membro</b>.
 * 
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
@Entity
@Table(name = "tipo_membro")
@NamedQueries({
		@NamedQuery(name = TipoMembro.TODOS, query = "select c from TipoMembro c"),
		@NamedQuery(name = TipoMembro.POR_DESCRICAO, query = "select c from TipoMembro c where c.descricao like ?") })
public class TipoMembro extends AbstractDominio {

	/** Armazena o oql que busca todos. **/
	public static final String TODOS = "tipomembro.todos";

	/** Armazena o oql que busca por descrição. **/
	public static final String POR_DESCRICAO = "tipomembro.porDescricao";

	/** Armazena o id do banco de dados. **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_tipo")
	public Integer id;

	/** Armazena a descrição. **/
	@Obrigatorio(rotulo = "Descrição")
	@TamanhoMaximo(rotulo = "Descrição", maximo = 50)
	@Column(name = "ds_tipo_membro")
	public String descricao;

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
	public TipoMembro() {
	}

	/** Cria um novo objeto com valores definidos. */
	public TipoMembro(String descricao, Date dataInclusao, Date dataAlteracao,
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
		TipoMembro other = (TipoMembro) obj;
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
		return "TipoEvento [id=" + id + ", descricao=" + descricao
				+ ", dataInclusao=" + dataInclusao + ", dataAlteracao="
				+ dataAlteracao + ", usuario=" + usuario + "]";
	}

}