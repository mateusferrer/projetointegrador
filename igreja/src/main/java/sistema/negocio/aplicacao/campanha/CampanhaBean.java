package sistema.negocio.aplicacao.campanha;

import java.io.Serializable;
import java.util.List;

import sistema.negocio.dominio.Campanha;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Contrato de operações do caso de uso de manutenção de <b>Campanha</b>.
 * @version 1.0 - 18/05/2016
 * @since 18/05/2016
 */
public interface CampanhaBean extends Serializable {

    /**
     * Pesquisa a campanha pela descrição.
     * @return campanhas com os parâmetros informados.
     * @throws NegocioException em caso de erros.
     */
    public List<Campanha> get(String descricao) throws NegocioException;

    /**
     * Insere uma campanha no DB.
     * @throws NegocioException em caso de erros.
     */
    public void inserir(Campanha campanha) throws NegocioException;

    /**
     * Altera uma campanha no DB.
     * @throws NegocioException em caso de erros.
     */
    public void alterar(Campanha campanha) throws NegocioException;

    /**
     * Exclui uma campanha no DB.
     * @throws NegocioException em caso de erros.
     */
    public void excluir(Campanha campanha) throws NegocioException;

}
