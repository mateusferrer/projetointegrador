package sistema.negocio.aplicacao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import sistema.negocio.dominio.Usuario;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.infra.spring.Escopo;
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp;
import com.forj.cirrus.util.WebUtils;
import com.forj.cirrus.util.validacao.Param;

/**
 * Contrato de operações do caso de uso de manutenção de <b>Login</b>.
 * 
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
@Named
@Scope(Escopo.SESSION)
public class LoginBean extends DominioBeanImp<Usuario> implements Serializable {

	/**
	 * Verifica se efetuou login no sistema.
	 * 
	 * @return verdadeiro se sim, senão falso;
	 * @throws NegocioException
	 *             em caso de erros.
	 */
	public String logar(String user, String pass) throws NegocioException {
		Param.validar(user, "Usuário", pass, "Senha");
		List<Usuario> usuarios = eao.get(Usuario.TODOS);
		Usuario usuario = new Usuario();
		for (Usuario u : usuarios) {
			if (u.getNome().equals(user.toUpperCase())
					&& u.getSenha().equals(pass)) {
				usuario = u;
				WebUtils.getSession().setAttribute("usuarioLogado", usuario);
				return "home.faces";
			}
		}
		throw new NegocioException("Usuário e/ou senha inválidos");
	}

}
