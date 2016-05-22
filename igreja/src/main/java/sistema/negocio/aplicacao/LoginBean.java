package sistema.negocio.aplicacao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import sistema.negocio.dominio.Usuario;
import sistema.negocio.dominio.UsuarioPk;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp;
import com.forj.cirrus.util.validacao.Param;
import com.forj.cirrus.util.validacao.Val;

/**
 * Contrato de operações do caso de uso de manutenção de <b>Login</b>.
 * 
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
@Named
public class LoginBean extends DominioBeanImp<Usuario> implements Serializable {

	/**
	 * Verifica se efetuou login no sistema.
	 * 
	 * @return verdadeiro se sim, senão falso;
	 * @throws NegocioException
	 *             em caso de erros.
	 */
	public boolean entrou(String user, String pass) throws NegocioException {
		Param.validar(user, "Usuário", pass, "Password");
		UsuarioPk pk = new UsuarioPk();
		pk.setNome(user);
		pk.setSenha(pass);
		List<Usuario> res = eao.get(Usuario.POR_LOGIN, pk);
		if (Val.vazio(res)) {
			return false;
		} else {
			return true;
		}
	}

}
