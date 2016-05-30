package sistema.negocio.aplicacao.membro;

import java.io.Serializable;
import java.util.List;

import sistema.negocio.dominio.membro.Membro;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Contrato de opera��es do caso de uso de manuten��o de <b>Membro</b>.
 * 
 * @version 1.0 - 16/05/2016
 * @since 16/05/2016
 */
public interface MembroBean extends Serializable {

    /**
     * Pesquisa todas os membros ou um membro espec�fico indicado pelo nome.
     * @return listagem de todos os membros ou um membro espec�fico.
     * @param nome a ser informado para pesuisa de um membro espec�fico.
     * @throws NegocioException em caso de erros.
     */
    public List<Membro> get(String nome) throws NegocioException;

    /**
     * Pesquisa um membo espec�fico pelo c�digo informado.
     * @return membro relacionado ao c�digo informado.
     * @param codigo a ser informado para pesuisa de um membro espec�fico.
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
