package sistema.visao

import javax.inject.Named

import org.springframework.context.annotation.Scope

import com.forj.cirrus.infra.spring.Escopo
import com.forj.cirrus.jsf.util.JSFUtils
import com.forj.cirrus.util.WebUtils

/**
 * Gerenciador de formulários GUI JSF de manutenção do <b>Menu</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 01/12/2015
 * @since 01/12/2015
 */
@Named
@Scope(Escopo.SESSION)
class MenuFrm implements Serializable {

    /**
     * Navega dinamicamente para um item de menu. Utilizado para disparar
     * dinamicamente um método de entrada em ManagedBean e retornar para um
     * endereço de navegação JSF.
     * @return endereço de navegação JSF.
     */
    String navegar() {
        Object bean = JSFUtils.getRequestParameterAttribute("bean")
        Object navegacao = JSFUtils.getRequestParameterAttribute("navegacao")
        if (!bean) {
            throw new IllegalArgumentException(
            "Parâmetro de request 'bean' é obrigatório.")
        }
        if (!navegacao) {
            throw new IllegalArgumentException(
            "Parâmetro de request 'navegacao' é obrigatório")
        }
        JSFUtils.executarMetodoBean(bean.toString())
        navegacao.toString()
    }

    /**
     * Desloga o usuario corrente e redireciona para pagina de login.
     * @return texto da navegação JSF.
     */
    String sair() {
        WebUtils.getSession().invalidate()
        return "login"
    }
}