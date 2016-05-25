package sistema.negocio.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;

/**
 * Gerenciador das regras de negócio para o domínio <b>Usuario</b>.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
		@NamedQuery(name = Usuario.TODOS, query = "select u from Usuario u"),
		@NamedQuery(name = Usuario.POR_LOGIN, query = "select u from Usuario u where u.nome = ? and u.senha = ?") })
public class Usuario extends AbstractDominio {

	/** Armazena o oql que busca todos. **/
	public static final String TODOS = "usuario.todos";

	/** Armazena o oql que busca todos. **/
	public static final String POR_LOGIN = "usuario.porLogin";

	/** Armazena o id do banco de dados. **/
	@Id
	@Column(name = "cd_usuario")
	@Obrigatorio(rotulo = "Nome")
	@TamanhoMaximo(rotulo = "Nome", maximo = 10)
	private String nome;

	/** Armazena a senha. **/
	@Column(name = "ds_senha")
	@Obrigatorio(rotulo = "Senha")
	@TamanhoMaximo(rotulo = "Senha", maximo = 4)
	private String senha;

	@Column(name = "in_tipo_usuario")
	@Obrigatorio(rotulo = "Tipo Usuário")
	private String tipo;

	@Column(name = "in_situacao")
	@Obrigatorio(rotulo = "Status")
	private String situacao;

	/** Cria um novo objeto com valores padrões. */
	public Usuario() {
	}

	/* Cria um novo objeto com valores definidos. */
	public Usuario(String nome, String senha, String tipo, String situacao) {
		this.nome = nome;
		this.senha = senha;
		this.tipo = tipo;
		this.situacao = situacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", senha=" + senha + ", tipo=" + tipo
				+ ", situacao=" + situacao + "]";
	}

}