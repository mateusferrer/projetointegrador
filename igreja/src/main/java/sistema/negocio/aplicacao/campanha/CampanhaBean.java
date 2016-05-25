package sistema.negocio.aplicacao.campanha;

import java.io.Serializable;
import java.util.List;

import sistema.negocio.dominio.campanha.Campanha;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Contrato de operações do caso de uso de manutenção de <b>Campanha</b>.
 * @version 1.0 - 18/05/2016
 * @since 18/05/2016
 */
public interface CampanhaBean extends Serializable {

    /**
     * Pesquisa todas as entidades.
     * @return listagem de todas as entidades.
     * @param nome a ser informado para pesuisa de entidades.
     * @throws NegocioException em caso de erros.
     */
    public List<Campanha> get(String nome) throws NegocioException;

    /**
     * Pesquisa uma Campanha específica pelo código informado.
     * @return listagem de todas as entidades.
     * @param codigo a ser informado para pesuisa de uma Campanha específica.
     * @throws NegocioException em caso de erros.
     */
    public Campanha getPorCodigo(Long codigo) throws NegocioException;

    /**
     * Insere uma Campanha no banco de dados.
     * @param Campanha a ser inserida.
     * @throws NegocioException em caso de erros.
     */
    public void inserir(Campanha Campanha) throws NegocioException;

    /**
     * Altera uma Campanha no banco de dados.
     * @param Campanha a ser alterada.
     * @throws NegocioException em caso de erros.
     */
    public void alterar(Campanha Campanha) throws NegocioException;

    /**
     * Exlui uma Campanha do banco de dados.
     * @param Campanha a ser excluida.
     * @throws NegocioException em caso de erros.
     */
    public void excluir(Campanha Campanha) throws NegocioException;

}
