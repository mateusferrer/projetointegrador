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

import com.forj.cirrus.negocio.dominio.beanvalidation.Obrigatorio
import com.forj.cirrus.negocio.dominio.beanvalidation.TamanhoMaximo
import com.forj.cirrus.negocio.dominio.modelo.AbstractDominio

/**
 * Gerenciador das regras de negócio para o domínio <b>Membro</b>.
 * @author Lucas Francisquini
 * @version 1.0 - 26/11/2015
 * @since 26/11/2015
 */
@ToString
@EqualsAndHashCode(includes="id")
@Entity
@Table(name = "membro")
@NamedQueries([@NamedQuery(name = Membro.TODOS, query = "select c from Membro c")])
class Membro extends AbstractDominio {

    /** Armazena o oql que busca todos. **/
    static final String TODOS = "membro.todos"

    /** Armazena o id do banco de dados. **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_membro")
    Integer id

    /** Armazena o nome. **/
    @Obrigatorio(rotulo="Nome")
    @TamanhoMaximo(rotulo="Nome", maximo = 100)
    @Column(name = "tx_nome")
    String nome

    /** Armazena o rg. **/
    @TamanhoMaximo(rotulo="Rg", maximo = 9)
    @Column(name = "tx_rg")
    String rg

    /** Armazena o cnpj. **/
    @Obrigatorio(rotulo="Cpf")
    @TamanhoMaximo(rotulo="Cpf", maximo = 11)
    @Column(name = "tx_cpf")
    String cpf

    /** Armazena o cep. **/
    @Obrigatorio(rotulo="Cep")
    @TamanhoMaximo(rotulo="Cep", maximo = 8)
    @Column(name = "tx_cep")
    Long cep

    /** Armazena o endereço. **/
    @Obrigatorio(rotulo="Endereço")
    @TamanhoMaximo(rotulo="Endereço", maximo = 100)
    @Column(name = "tx_logradouro")
    String logradouro

    /** Armazena o número do logradouro. **/
    @Obrigatorio(rotulo="Nº Endereço")
    @TamanhoMaximo(rotulo="Nº Endereço", maximo = 5)
    @Column(name = "nr_logradouro")
    Integer numLogradouro

    /** Armazena o estado. **/
    @Obrigatorio(rotulo="Estado")
    @TamanhoMaximo(rotulo="Estado", maximo = 50)
    @Column(name = "tx_estado")
    String estado

    /** Armazena a cidade. **/
    @Obrigatorio(rotulo="Cidade")
    @TamanhoMaximo(rotulo="Cidade", maximo = 50)
    @Column(name = "tx_cidade")
    String cidade

    /** Armazena o email. **/
    @TamanhoMaximo(rotulo="Email", maximo = 100)
    @Column(name = "tx_email")
    String email

    /** Armazena o telefone. **/
    @TamanhoMaximo(rotulo="Telefone", maximo = 11)
    @Column(name = "tx_telefone")
    String telefone

    /** Armazena o celular. **/
    @TamanhoMaximo(rotulo="Celular", maximo = 11)
    @Column(name = "tx_celular")
    String celular

    /** Armazena a igreja matriz. **/
    @Obrigatorio(rotulo = "Igreja")
    @ManyToOne
    @JoinColumn(name = "cd_igreja")
    Igreja igreja

    /** Armazena a igreja matriz. **/
    @Obrigatorio(rotulo = "Cargo Eclesiástico")
    @ManyToOne
    @JoinColumn(name = "cd_cargo")
    CargoEclesiastico cargo

    /** Armazena o sexo Masculino ou Feminino. **/
    @TamanhoMaximo(rotulo="Sexo", maximo = 1)
    @Obrigatorio(rotulo = "Sexo")
    @Column(name = "tx_sexo")
    String sexo

    /** Armazena o status Ativo ou Inativo. **/
    @TamanhoMaximo(rotulo="Status", maximo = 1)
    @Obrigatorio(rotulo = "Status")
    @Column(name = "tx_status")
    String status

    /** Armazena o registro de batismo. **/
    @TamanhoMaximo(rotulo="Registro Batismo", maximo = 10)
    @Obrigatorio(rotulo="Registro Batismo")
    @Column(name = "nr_batismo")
    Long registroBatismo

    /** Armazena a data de batismo do membro. **/
    @Obrigatorio(rotulo="Data de Nascimento")
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.DATE)
    Date dataNascimento

    /** Armazena a data de batismo do membro. **/
    @Obrigatorio(rotulo="Data de Batismo")
    @Column(name = "dt_batismo")
    @Temporal(TemporalType.DATE)
    Date dataBatismo

    /** Armazena a data de cadastro do membro. **/
    @Obrigatorio(rotulo="Data de Cadastro")
    @Column(name = "dt_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    Date dataCadastro

    /** 
     * Recupera a descrição do status do membro..
     * @return descricao do status.
     */
    String getDescricaoStatus() {
        status == "A" ? "Ativo" : "Inativo"
    }

    /**
     * Cria um novo objeto com valores padrões.
     */
    Membro() {
        this.limpar()
    }

    /** {@inheritDoc} */
    @Override
    void limpar() {
        super.limpar()
        igreja = new Igreja()
        cargo = new CargoEclesiastico()
        dataCadastro = new Date()
    }
}