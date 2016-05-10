package sistema.visao.igreja;import java.util.ArrayList;import java.util.List;import javax.faces.model.SelectItem;import javax.inject.Inject;import javax.inject.Named;import org.springframework.context.annotation.Scope;import sistema.infra.formularios.GListaDetalheFrm;import sistema.negocio.aplicacao.IgrejaBean;import sistema.negocio.dominio.Cidade;import sistema.negocio.dominio.Estado;import sistema.negocio.dominio.Igreja;import sistema.negocio.dominio.TipoIgreja;import com.forj.cirrus.infra.exceptions.NegocioException;import com.forj.cirrus.infra.spring.Escopo;import com.forj.cirrus.negocio.aplicativo.DominioBean;/** * Gerenciador de formul�rios GUI JSF de manuten��o <b>Igreja</b>. * @author Lucas Francisquini * @version 1.0 - 26/11/2015 * @since 26/11/2015 */@Named@Scope(Escopo.SESSION)public class IgrejaFrm extends GListaDetalheFrm<Igreja> {    /** Armazena uma cole��o de estados. **/    private List<Estado> estados;    /** Armazena uma cole��o de cidades. **/    private List<Cidade> cidades;    /** Armazena o estado selecionado. **/    private Estado estadoSelecionado;    /** Armazena a cidade selecionada. **/    private Cidade cidadeSelecionada;    /** Armazena o gerenciador dos processos de neg�cio. **/    @Inject    private IgrejaBean bean;    /** Armazena o gerenciador dos processos de neg�cio. **/    @Inject    private DominioBean<Estado> estadoBean;    /** Armazena o gerenciador dos processos de neg�cio. **/    @Inject    private DominioBean<Cidade> cidadeBean;    /** Listagem do combo de sele��o do status. **/    private List<SelectItem> cmboTipoIgreja;    /** Contrutor padr�o. **/    public IgrejaFrm() {        titulo = "Manuten��o de Igreja";        dominio = new Igreja();    }    /** {@inheritDoc} */    @Override    public String novo() {        prepararNovo();        return super.novo();    }    /** Entra no detalhe executando as opera��es indicadas. */    private void prepararNovo() {        try {            cmboTipoIgreja = new ArrayList<>();            preencherCmboTipoIgreja();            estados = estadoBean.get(Estado.TODOS);            cidades = new ArrayList<>();            estadoSelecionado = new Estado();        } catch (NegocioException e) {            gerarErrosRia(e);        }    }    /** Preenche a combo de tipos de igreja. */    private void preencherCmboTipoIgreja() {        cmboTipoIgreja.add(new SelectItem(TipoIgreja.MATRIZ, TipoIgreja.getInstance(TipoIgreja.MATRIZ)));        cmboTipoIgreja.add(new SelectItem(TipoIgreja.FILIAL, TipoIgreja.getInstance(TipoIgreja.FILIAL)));    }    /** {@inheritDoc} */    @Override    public void pesquisar() {        try {            colecao = bean.get();        } catch (NegocioException e) {            gerarErrosRia(e);        }    }    /** Busca as cidades com base no id do estado selecionado. */    public void buscarCidades() {        try {            cidades = cidadeBean.get(Cidade.POR_ESTADO, estadoSelecionado.getId());        } catch (NegocioException e) {            gerarErrosRia(e);        }    }    public DominioBean<Estado> getEstadoBean() {        return estadoBean;    }    public DominioBean<Cidade> getCidadeBean() {        return cidadeBean;    }    public Estado getEstadoSelecionado() {        return estadoSelecionado;    }    public List<Estado> getEstados() {        return estados;    }    public List<Cidade> getCidades() {        return cidades;    }    public Cidade getCidadeSelecionada() {        return cidadeSelecionada;    }    public List<SelectItem> getCmboTipoIgreja() {        return cmboTipoIgreja;    }    public void setCmboTipoIgreja(List<SelectItem> cmboTipoIgreja) {        this.cmboTipoIgreja = cmboTipoIgreja;    }    public void setEstadoSelecionado(Estado estadoSelecionado) {        this.estadoSelecionado = estadoSelecionado;    }}