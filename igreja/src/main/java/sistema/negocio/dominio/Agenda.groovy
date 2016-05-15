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
import javax.persistence.Temporal
import javax.persistence.TemporalType

import sistema.negocio.dominio.evento.TipoEvento;

import com.forj.cirrus.infra.exceptions.NegocioException
import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio
import com.forj.cirrus.util.facades.FacadeData
import com.forj.cirrus.util.validacao.MsgErro
import com.forj.cirrus.util.validacao.Param;
import com.forj.cirrus.util.validacao.Val

/**
 * Gerenciador das regras de negócio para o domínio <b>Agenda</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 27/11/2015
 * @since 27/11/2015
 */
@ToString
@EqualsAndHashCode(includes="id")
@Entity
@Table(name = "agenda")
@NamedQueries([@NamedQuery(name = Agenda.TODOS, query = "select c from Agenda c where c.tipo = ?1")])
class Agenda extends AbstractDominio {

    /** Armazena o oql que busca todos. **/
    static final String TODOS = "agenda.todos"

    /** Armazena o id do banco de dados. **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_agenda")
    Integer id

    /** Armazena o tipo. **/
    @Obrigatorio(rotulo="Tipo Agenda")
    @Column(name = "tx_tipo")
    String tipo

    /** Armazena o tipo do evento, caso o tipo da agenda seja Evento. **/
    @ManyToOne
    @JoinColumn(name = "cd_tipo_evento")
    TipoEvento tipoEvento

    /** Armazena o nome. **/
    @Obrigatorio(rotulo="Nome")
    @Column(name = "tx_nome")
    @TamanhoMaximo(rotulo="Nome", maximo = 100)
    String nome

    /** Armazena o local. **/
    @Obrigatorio(rotulo="Local")
    @Column(name = "tx_local")
    @TamanhoMaximo(rotulo="Local", maximo = 100)
    String local

    /** Armazena a data e hora da agenda. **/
    @Obrigatorio(rotulo="Data")
    @Column(name = "dt_agenda")
    @Temporal(TemporalType.TIMESTAMP)
    Date data

    /** Armazena o status. **/
    @Obrigatorio(rotulo="Status")
    @Column(name = "tx_status")
    String status

    /** Armazena a descrição. **/
    @Column(name = "tx_descricao")
    @TamanhoMaximo(rotulo="Descrição", maximo = 500)
    String descricao

    /**
     * Cria um novo objeto com valores padrõees.
     */
    Agenda() {
        this.limpar()
    }

    /**
     * Mostra o texto referente à  flag informada para o tipo de agenda.
     * @return descrição do tipo da agenda.
     */
    String getDescricaoTipo() {
        tipo == "E" ? "Evento" : "Reunião"
    }

    /**
     * Verifica se o tipo da agenda é igual a evento.
     * @return verdadeiro se sim, senão falso.
     */
    boolean isAgendaEvento() {
        tipo == "E"
    }

    /**
     * Mostra o texto referente à  flag informada para o tipo de agenda.
     * @return descrição do tipo da agenda.
     */
    String getDescricaoStatus() {
        if (status == "A") {
            return "Aguardando Confirmação"
        } else if (status == "C") {
            return "Confirmado"
        } else if (status == "D") {
            return "Cancelado"
        } else if(status == "F") {
            return "Finalizado"
        }
    }

    /**
     * Recupera a data e formata em String.
     * @return data formatada.
     */
    String getDataFormatada() {
        return FacadeData.formatarCompleto(data);
    }

    /** {@inheritDoc} */
    @Override
    void validar() throws NegocioException {
        super.validar()
        MsgErro erros = new MsgErro()
        if (tipo == "E") {
            if (Val.vazio(tipoEvento)) {
                erros.campoObrigatorio("Tipo Evento")
            }
            Param.validar(tipoEvento, "Tipo Evento")
        }
        erros.gerarErrosNegocio();
    }

    /** {@inheritDoc} */
    @Override
    public void limpar() {
        super.limpar();
        tipoEvento = new TipoEvento()
    }
}