package sistema.visao;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.forj.cirrus.infra.spring.Escopo;
import com.forj.cirrus.jsf.util.JSFUtils;
import com.forj.cirrus.util.WebUtils;
import com.forj.cirrus.util.validacao.Val;

/**
 * Gerenciador de formul�rios GUI JSF de manuten��o do <b>Menu</b>.
 * 
 * @version 1.0 - 18/05/2016
 * @since 18/05/2016
 */
@Named
@Scope(Escopo.SESSION)
public class MenuFrm implements Serializable {

	/**
	 * Navega dinamicamente para um item de menu. Utilizado para disparar
	 * dinamicamente um m�todo de entrada em ManagedBean e retornar para um
	 * endere�o de navega��o JSF.
	 * 
	 * @return endere�o de navega��o JSF.
	 */
	public String navegar() {
		Object bean = JSFUtils.getRequestParameterAttribute("bean");
		Object navegacao = JSFUtils.getRequestParameterAttribute("navegacao");
		if (Val.vazio(bean)) {
			throw new IllegalArgumentException(
					"Par�metro de request 'bean' � obrigat�rio.");
		}
		if (Val.vazio(navegacao)) {
			throw new IllegalArgumentException(
					"Par�metro de request 'navegacao' � obrigat�rio");
		}
		JSFUtils.executarMetodoBean(bean.toString());
		return navegacao.toString();
	}

	/**
	 * Desloga o usuario corrente e redireciona para pagina de login.
	 * 
	 * @return texto da navega��o JSF.
	 */
	public String sair() {
		WebUtils.getSession().invalidate();
		return "index.faces";
	}

}