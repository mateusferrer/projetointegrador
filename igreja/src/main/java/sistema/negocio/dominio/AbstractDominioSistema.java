package sistema.negocio.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;

/**
 * {Descrita resumida sobre a classe}.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 12/05/2016
 * @since 12/05/2016
 */
public abstract class AbstractDominioSistema extends AbstractDominio {

	/** Armazena a data de inclus�o do registro. **/
	@Obrigatorio(rotulo = "Data Inclus�o")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inclusao")
	protected Date dataInclusao;

	/** Armazena a data de inclus�o do registro. **/
	@Obrigatorio(rotulo = "Data Altera��o")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_alteracao")
	protected Date dataAlteracao;

	/** Armazena o usu�rio de inclus�o/altera��o. **/
	@Obrigatorio(rotulo = "Usu�rio Inclus�o")
	@TamanhoMaximo(rotulo = "Usu�rio Inclus�o", maximo = 10)
	@Column(name = "nm_usuario_inc_alt")
	protected String usuario;

	/**
	 * Cria um novo objeto com valores padr�es.
	 * 
	 * @param dataInclusao
	 * @param dataAlteracao
	 * @param usuario
	 */
	public AbstractDominioSistema(Date dataInclusao, Date dataAlteracao,
			String usuario) {
		super();
		this.dataInclusao = dataInclusao;
		this.dataAlteracao = dataAlteracao;
		this.usuario = usuario;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
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

}
