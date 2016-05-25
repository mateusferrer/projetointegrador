package sistema.negocio.aplicacao.membro;

import java.util.Date;
import java.util.List;

import javax.inject.Named;

import sistema.negocio.dominio.membro.TipoMembro;

import com.forj.cirrus.infra.exceptions.NegocioException;
import com.forj.cirrus.negocio.aplicativo.DominioBeanImp;
import com.forj.cirrus.util.validacao.Param;
import com.forj.cirrus.util.validacao.Val;

/**
 * Gerenciador de processos de negócio para o domínio <b>TipoMembro</b>.
 * @version 1.0 - 15/05/2016
 * @since 15/05/2016
 */
@Named
public class TipoMembroBeanImp extends DominioBeanImp<TipoMembro> implements TipoMembroBean {

    /** {@inheritDoc} */
    @Override
    public List<TipoMembro> get(String descricao) throws NegocioException {
        if (Val.vazio(descricao)) {
            return eao.get(TipoMembro.TODOS);
        } else {
            return eao.get(TipoMembro.POR_DESCRICAO, descricao);
        }
    }

    /** {@inheritDoc} */
    @Override
    public TipoMembro getPorCodigo(Long codigo) throws NegocioException {
        return eao.getPorId(TipoMembro.class, codigo);
    }

    /** {@inheritDoc} */
    @Override
    public void inserir(TipoMembro m) throws NegocioException {
        Param.validar(m, "Tipo Membro");
        m.setDataInclusao(new Date());
        m.setDataAlteracao(new Date());
        super.inserir(m);
    }

}