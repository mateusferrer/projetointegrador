package sistema.negocio.dominio

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio

/**
 * Gerenciador das regras de negócio para o domínio <b>Tipo Evento</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@ToString
@EqualsAndHashCode(includes="id")
@Entity
@Table(name = "tipo_evento")
@NamedQueries([@NamedQuery(name = TipoEvento.TODOS, query = "select c from TipoEvento c")])
class TipoEvento extends AbstractDominio {

    /** Armazena o oql que busca todos. **/
    static final String TODOS = "tipoevento.todos"

    /** Armazena o id do banco de dados. **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_tipo")
    Integer id

    /** Armazena a descrição. **/
    @Obrigatorio(rotulo="Descrição")
    @TamanhoMaximo(rotulo="Descrição", maximo = 50)
    @Column(name = "tx_descricao")
    String descricao
}