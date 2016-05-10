package sistema.negocio.dominio

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.OneToOne;
import javax.persistence.Table

import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio
import com.forj.cirrus.util.validacao.MsgErro
import com.forj.cirrus.util.validacao.Val

/**
 * Gerenciador das regras de negócio para o domínio <b>Cargo Eclesiástico</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
@ToString
@EqualsAndHashCode(includes="id")
@Entity
@Table(name = "cargo_eclesiastico")
@NamedQueries([@NamedQuery(name = CargoEclesiastico.TODOS, query = "select c from CargoEclesiastico c")])
class CargoEclesiastico extends AbstractDominio {

    /** Armazena o oql que busca todos. **/
    static final String TODOS = "cargoeclesiastico.todos"

    /** Armazena o id do banco de dados. **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_cargo")
    Integer id

    /** Armazena a razão social. **/
    @Obrigatorio(rotulo="Descrição")
    @TamanhoMaximo(rotulo="Descrição", maximo = 50)
    @Column(name = "tx_descricao")
    String descricao
}