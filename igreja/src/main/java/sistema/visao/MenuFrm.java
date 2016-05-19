package sistema.visao;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.forj.cirrus.infra.spring.Escopo;
import com.forj.cirrus.jsf.util.JSFUtils;
import com.forj.cirrus.util.WebUtils;

/**
 * Gerenciador de formulários GUI JSF de manutenção do <b>Menu</b>.
 * 
 * @version 1.0 - 18/05/2016
 * @since 18/05/2016
 */
@Named
@Scope(Escopo.SESSION)
public class MenuFrm implements Serializable {

	private String bean;
	private String navegacao;

	/**
	 * Navega dinamicamente para um item de menu. Utilizado para disparar
	 * dinamicamente um método de entrada em ManagedBean e retornar para um
	 * endereço de navegação JSF.
	 * 
	 * @return endereço de navegação JSF.
	 */
	public String navegarEntidade() {
		JSFUtils.executarMetodoBean("entidadeFrm.entrar");
		return "/sistema/entidade/lista.faces";
	}

	/**
	 * Navega dinamicamente para um item de menu. Utilizado para disparar
	 * dinamicamente um método de entrada em ManagedBean e retornar para um
	 * endereço de navegação JSF.
	 * 
	 * @return endereço de navegação JSF.
	 */
	public String navegarCampanha() {
		JSFUtils.executarMetodoBean("campanhaFrm.entrar");
		return "/sistema/campanha/lista.faces";
	}

	/**
	 * Desloga o usuario corrente e redireciona para pagina de login.
	 * 
	 * @return texto da navegação JSF.
	 */
	public String sair() {
		WebUtils.getSession().invalidate();
		return "login";
	}

	public void setBean(String bean) {
		this.bean = bean;
	}

	public void setNavegacao(String navegacao) {
		this.navegacao = navegacao;
	}
}