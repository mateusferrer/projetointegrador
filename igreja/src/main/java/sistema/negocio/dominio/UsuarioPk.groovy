package sistema.negocio.dominio

import groovy.transform.EqualsAndHashCode;

import javax.persistence.Column

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio

/**
 * Gerenciador das regras de negócio para o domínio <b>Tipo Evento</b>.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
class UsuarioPk extends AbstractDominio {

	/** Armazena o nome. **/
	@Column(name = "nm_usuario")
	@Obrigatorio(rotulo = "Nome")
	@TamanhoMaximo(rotulo = "Nome", maximo = 10)
	String nome

	/** Armazena a senha. **/
	@Column(name = "ds_senha")
	@Obrigatorio(rotulo = "Senha")
	@TamanhoMaximo(rotulo = "Senha", maximo = 4)
	String senha
}