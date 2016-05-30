package sistema.negocio.aplicacao.membro;

import java.io.Serializable;
import java.util.List;

import sistema.negocio.dominio.membro.Membro;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Contrato de operações do caso de uso de manutenção de <b>Membro</b>.
 * 
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public interface MembroBean extends Serializable {

    /**
     * Pesquisa todas os membros ou um membro específico indicado pelo nome.
     * @return listagem de todos os membros ou um membro específico.
     * @param nome a ser informado para pesuisa de um membro específico.
     * @throws NegocioException em caso de erros.
     */
    public List<Membro> get(String nome) throws NegocioException;

    /**
     * Pesquisa um membo específico pelo código informado.
     * @return membro relacionado ao código informado.
     * @param codigo a ser informado para pesuisa de um membro específico.
     * @throws NegocioException em caso de erros.
     */
    public Membro getPorCodigo(Long codigo) throws NegocioException;

    /**
     * Insere um Membro no banco de dados.
     * @param membro a ser inserido.
     * @throws NegocioException em caso de erros.
     */
    public void inserir(Membro membro) throws NegocioException;

    /**
     * Altera um Membro no banco de dados.
     * @param membro a ser alterado.
     * @throws NegocioException em caso de erros.
     */
    public void alterar(Membro membro) throws NegocioException;

    /**
     * Exlui um Membro do banco de dados.
     * @param membro a ser excluido.
     * @throws NegocioException em caso de erros.
     */
    public void excluir(Membro membro) throws NegocioException;

}
