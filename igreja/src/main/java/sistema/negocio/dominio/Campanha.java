package sistema.negocio.dominio;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio;
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio;

/**
 * Gerenciador das regras de negócio para o domínio <b>Campanha</b>.
 * 
 * @version 1.0 - 11/05/2016
 * @since 11/05/2016
 */
@Entity
@Table(name = "campanha")
@NamedQueries({ @NamedQuery(name = Campanha.TODOS, query = "select c from Campanha c") })
public class Campanha extends AbstractDominio {

	/** Armazena o oql que busca todos. **/
	public static final String TODOS = "campanha.todos";

	/** Armazena o código da campanha. **/
	@Id
	@Column(name = "cd_campanha")
	private Long id;

	/** Armazena o código da campanha. **/
	@Obrigatorio(rotulo = "Descrição")
	@Column(name = "ds_campanha")
	private String descricao;

	/** Armazena o valor da campanha. **/
	@Obrigatorio(rotulo = "Valor")
	@Column(name = "vl_campanha")
	private BigDecimal valor;

	/** Armazena a quantidade de parcelas. **/
	@Obrigatorio(rotulo = "Quantidade de Parcelas")
	@Column(name = "nr_parcelas")
	private String numParcelas;

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

	/** Armazena o status da campanha. **/
	@Obrigatorio(rotulo = "Status")
	@Column(name = "in_status")
	private String status;

	/** Armazena a igreja que realiza a campanha. **/
	@Obrigatorio(rotulo = "Igreja")
	@JoinColumn(name = "cd_igreja")
	@OneToOne
	private Igreja igreja;

	/** Armazena a data de cadastro. **/
	@Obrigatorio(rotulo = "Data de Cadastro")
	@Column(name = "dt_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;

	/** Armazena a data de alteração. **/
	@Obrigatorio(rotulo = "Data de Alteração")
	@Column(name = "dt_alteracao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;

	/** Armazena o nome usuário de alteração/inclusão. **/
	@Obrigatorio(rotulo = "Usuario")
	@Column(name = "cd_usuario")
	private String nomeUsuario;

}