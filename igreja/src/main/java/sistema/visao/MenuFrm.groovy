package sistema.visao

import javax.inject.Named

import org.springframework.context.annotation.Scope

import com.forj.cirrus.infra.spring.Escopo
import com.forj.cirrus.jsf.util.JSFUtils
import com.forj.cirrus.util.WebUtils

/**
 * Gerenciador de formul�rios GUI JSF de manuten��o do <b>Menu</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 01/12/2015
 * @since 01/12/2015
 */
@Named
@Scope(Escopo.SESSION)
class MenuFrm implements Serializable {

    /**
     * Navega dinamicamente para um item de menu. Utilizado para disparar
     * dinamicamente um m�todo de entrada em ManagedBean e retornar para um
     * endere�o de navega��o JSF.
     * @return endere�o de navega��o JSF.
     */
    String navegar() {
        Object bean = JSFUtils.getRequestParameterAttribute("bean")
        Object navegacao = JSFUtils.getRequestParameterAttribute("navegacao")
        if (!bean) {
            throw new IllegalArgumentException(
            "Par�metro de request 'bean' � obrigat�rio.")
        }
        if (!navegacao) {
            throw new IllegalArgumentException(
            "Par�metro de request 'navegacao' � obrigat�rio")
        }
        JSFUtils.executarMetodoBean(bean.toString())
        navegacao.toString()
    }

    /**
     * Desloga o usuario corrente e redireciona para pagina de login.
     * @return texto da navega��o JSF.
     */
    String sair() {
        WebUtils.getSession().invalidate()
        return "login"
    }
}