package sistema.visao.cargoeclesiasticoimport javax.annotation.Resourceimport javax.faces.model.SelectItem;import javax.inject.Namedimport org.springframework.context.annotation.Scopeimport sistema.infra.formularios.GListaDetalheFrmimport sistema.negocio.dominio.CargoEclesiasticoimport sistema.negocio.dominio.entidade.Entidade;import com.forj.cirrus.infra.spring.Escopo;import com.forj.cirrus.negocio.aplicativo.DominioBeanimport com.forj.cirrus.util.Cirrus;/** * Gerenciador de formul�rios GUI JSF de manuten��o <b>CargoEclesiastico</b>. * @author Lucas Francisquini * @version 1.0 - 27/11/2015 * @since 27/11/2015 */@Named
@Scope(Escopo.SESSION)
class CargoEclesiasticoFrm extends GListaDetalheFrm<CargoEclesiastico> {    /** Armazena o servi�o de negocio. **/    @Resource(name = Cirrus.FACADE)    DominioBean<CargoEclesiastico> bean    /** Contrutor padr�o. **/    CargoEclesiasticoFrm() {        titulo = "Manuten��o de Cargo Eclesi�stico"        dominio = new CargoEclesiastico()    }    /** {@inheritDoc} */    @Override    public void pesquisar() {        try {            colecao = bean.get(CargoEclesiastico.TODOS)        } catch (ex) {            gerarErrosRia(ex)        }    }}