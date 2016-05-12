package sistema;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.forj.cirrus.infra.spring.Escopo;

/**
 * {Descrita resumida sobre a classe}.
 * 
 * @author Lucas Francisquini
 * @version 1.0 - 04/05/2016
 * @since 04/05/2016
 */
@Named
@Scope(Escopo.SESSION)
public class SuggestionboxBean {

	private List<String> lista;

	public SuggestionboxBean() {
		lista = new ArrayList();
	}

	public List<String> complemento(Object event) {
		String prefixo = event.toString().toLowerCase();
		List<String> retorno = new ArrayList();
		for (int pos = 0; pos < lista.size(); pos++) {
			if (lista.get(pos).toLowerCase().startsWith(prefixo)) {
				retorno.add(lista.get(pos));
			}
		}
		return retorno;
	}

}
