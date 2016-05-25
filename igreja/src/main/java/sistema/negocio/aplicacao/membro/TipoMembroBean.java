package sistema.negocio.aplicacao.membro;

import java.io.Serializable;
import java.util.List;

import sistema.negocio.dominio.membro.TipoMembro;

import com.forj.cirrus.infra.exceptions.NegocioException;

/**
 * Contrato de operações do caso de uso de manutenção de <b>TipoMembro</b>.
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
public interface TipoMembroBean extends Serializable {

    /**
     * Pesquisa o todos os tipos de membro.
     * @param descricao a ser iformada para pesquisa do tipo de membro.
     * @return listagem de tipos de membro.
     * @throws NegocioException em caso de erros.
     */
    public List<TipoMembro> get(String descricao) throws NegocioException;

    /**
     * Pesquisa um tipo de membro específico pelo código informado.
     * @return tipo de membro encontrado com o código.
     * @param codigo a ser informado para pesuisa de uma entidade específica.
     * @throws NegocioException em caso de erros.
     */
    public TipoMembro getPorCodigo(Long codigo) throws NegocioException;

    /**
     * Insere um Tipo de Membro no banco de dados.
     * @param tipoMembro a ser inserido.
     * @throws NegocioException em caso de erros.
     */
    public void inserir(TipoMembro tipoMembro) throws NegocioException;

    /**
     * Altera um Tipo de Membro no banco de dados.
     * @param entidade a ser alterada.
     * @throws NegocioException em caso de erros.
     */
    public void alterar(TipoMembro tipoMembro) throws NegocioException;

    /**
     * Exclui um Tipo de Membro do banco de dados.
     * @param tipoMembro a ser excluido.
     * @throws NegocioException em caso de erros.
     */
    public void excluir(TipoMembro tipoMembro) throws NegocioException;

}
