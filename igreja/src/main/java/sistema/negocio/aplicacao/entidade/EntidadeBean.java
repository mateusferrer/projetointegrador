package sistema.negocio.aplicacao.entidade;

import java.io.Serializable;
import java.util.List;

import sistema.negocio.dominio.entidade.Entidade;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Contrato de operações do caso de uso de manutenção de <b>Entidade</b>.
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
public interface EntidadeBean extends Serializable {

    /**
     * Pesquisa todas as entidades.
     * @return listagem de todas as entidades.
     * @param nome a ser informado para pesuisa de entidades.
     * @throws NegocioException em caso de erros.
     */
    public List<Entidade> get(String nome) throws NegocioException;

    /**
     * Pesquisa uma entidade específica pelo código informado.
     * @return listagem de todas as entidades.
     * @param codigo a ser informado para pesuisa de uma entidade específica.
     * @throws NegocioException em caso de erros.
     */
    public Entidade getPorCodigo(Long codigo) throws NegocioException;

    /**
     * Insere uma Entidade no banco de dados.
     * @param entidade a ser inserida.
     * @throws NegocioException em caso de erros.
     */
    public void inserir(Entidade entidade) throws NegocioException;

    /**
     * Altera uma Entidade no banco de dados.
     * @param entidade a ser alterada.
     * @throws NegocioException em caso de erros.
     */
    public void alterar(Entidade entidade) throws NegocioException;

    /**
     * Exlui uma Entidade do banco de dados.
     * @param entidade a ser excluida.
     * @throws NegocioException em caso de erros.
     */
    public void excluir(Entidade entidade) throws NegocioException;

}
