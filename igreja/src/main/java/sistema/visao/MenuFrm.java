package sistema.visao;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.forj.cirrus.infra.spring.Escopo;
import com.forj.cirrus.jsf.util.JSFUtils;
import com.forj.cirrus.util.WebUtils;
import com.forj.cirrus.util.validacao.Val;

/**
 * Gerenciador de formulários GUI JSF de manutenção do <b>Menu</b>.
 * 
 * @version 1.0 - 18/05/2016
 * @since 18/05/2016
 */
@Named
@Scope(Escopo.SESSION)
public class MenuFrm implements Serializable {

	/**
	 * Navega dinamicamente para um item de menu. Utilizado para disparar
	 * dinamicamente um método de entrada em ManagedBean e retornar para um
	 * endereço de navegação JSF.
	 * 
	 * @return endereço de navegação JSF.
	 */
	public String navegar() {
		Object bean = JSFUtils.getRequestParameterAttribute("bean");
		Object navegacao = JSFUtils.getRequestParameterAttribute("navegacao");
		if (Val.vazio(bean)) {
			throw new IllegalArgumentException(
					"Parâmetro de request 'bean' é obrigatório.");
		}
		if (Val.vazio(navegacao)) {
			throw new IllegalArgumentException(
					"Parâmetro de request 'navegacao' é obrigatório");
		}
		JSFUtils.executarMetodoBean(bean.toString());
		return navegacao.toString();
	}

	/**
	 * Desloga o usuario corrente e redireciona para pagina de login.
	 * 
	 * @return texto da navegação JSF.
	 */
	public String sair() {
		WebUtils.getSession().invalidate();
		return "index.faces";
	}

}