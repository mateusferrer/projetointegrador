package sistema.negocio.dominio

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.NamedQueries
import javax.persistence.NamedQuery
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio
import com.forj.cirrus.util.validacao.Param

/**
 * Gerenciador das regras de neócio para o domnio <b>Tipo Evento</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@ToString
@EqualsAndHashCode(includes="id")
@Entity
@Table(name = "secretaria")
@NamedQueries([@NamedQuery(name = Secretaria.TODOS, query = "select c from Secretaria c")])
class Secretaria extends AbstractDominio {

    /** Armazena o oql que busca todos. **/
    static final String TODOS = "secretaria.todos"

    /** Armazena o id do banco de dados. **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_secretaria")
    Integer id

    /** Armazena a igreja responsável. **/
    @Obrigatorio(rotulo="Igreja Responsável")
    @OneToOne
    @JoinColumn(name = "cd_igreja_responsavel")
    Igreja igrejaResponsavel

    /** Armazena o membro/pastor responsável. **/
    @Obrigatorio(rotulo="Pastor Responsável")
    @OneToOne
    @JoinColumn(name = "cd_membro_responsavel")
    Membro pastorResponsavel

    /** Armazena a data de batismo do membro. **/
    @Obrigatorio(rotulo="Data de Início Atividades")
    @Column(name = "dt_inicio")
    @Temporal(TemporalType.DATE)
    Date dataInicio

    /** Armazen a lista de membros administrativos**/
    @OneToMany(cascade=[CascadeType.ALL], mappedBy="secretaria", fetch=FetchType.EAGER)
    List<MembroAdministrativo> membros = []

    /**
     * Adiciona um novo membro administrativo.
     * @param membro a ser adicionado
     * @throws NegocioException em caso de erros..
     */
    void adicionar(MembroAdministrativo membro) throws NegocioException {
        Param.validar(membro, "Membro")
        membro.validar()
        membros.add(membro);
        membro.secretaria = this
    }

    /**
     * Deleta um membro administrativo.
     * @param membro a ser deletado.
     * @throws NegocioException em caso de erros.
     */
    void deletar(MembroAdministrativo membro) throws NegocioException {
        Param.validar(membro, "Membro")
        membro.validar()
        if (membro.id) {
            membros.remove(membro)
        } else {
            membro = membros.findAll {
                it.cargo != membro.cargo && it.membro != membro.membro &&
                        it.posicao != membro.posicao
            }
        }
    }

    /**
     * Retorna o valor read only existente na propriedade <b>membros</b>.
     * @return valor existente na <b>membros</b>.
     */
    List<MembroAdministrativo> getMembrosAdministrativos() {
        // impede alteração da coleção por fora.
        membros.asImmutable()
    }

    /**
     * Informa um novo valor na propriedade <b>membros</b>.
     * @param membros novo valor a ser informado.
     */
    void setMembrosAdministrativos(List<MembroAdministrativo> membros) {
        // impede alteração da coleção por fora
    }

    /** {@inheritDoc} */
    @Override
    public void limpar() {
        super.limpar();
        igrejaResponsavel = new Igreja()
        pastorResponsavel = new Membro()
        membros.clear()
    }
}