package sistema.negocio.dominio

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.Table

import sistema.negocio.dominio.membro.Membro;

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
@Table(name = "membro_administrativo")
@NamedQueries([@NamedQuery(name = MembroAdministrativo.TODOS, query = "select c from MembroAdministrativo c")])
class MembroAdministrativo extends AbstractDominio {

    /** Armazena o oql que busca todos. **/
    static final String TODOS = "membroadministrativo.todos"

    /** Armazena o id do banco de dados. **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_membro_adm")
    Integer id

    /** Armazena a descrição. **/
    @Obrigatorio(rotulo="Membro")
    @ManyToOne
    @JoinColumn(name = "cd_membro")
    Membro membro

    /** Armazena a descrição. **/
    @Obrigatorio(rotulo="Cargo Administrativo")
    @ManyToOne
    @JoinColumn(name = "cd_cargo")
    CargoAdministrativo cargo

    /** Armazena a posição. **/
    @Obrigatorio(rotulo="Posição")
    @TamanhoMaximo(rotulo="Posição", maximo = 50)
    @Column(name = "tx_posicao")
    String posicao

    /** Armazena a secretaria. **/
    @ManyToOne
    @JoinColumn(name="cd_secretaria")
    Secretaria secretaria;

    /** {@inheritDoc} */
    @Override
    public void limpar() {
        super.limpar();
        cargo = new CargoAdministrativo()
        membro = new Membro()
    }
}