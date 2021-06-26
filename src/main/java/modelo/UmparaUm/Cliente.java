package modelo.UmparaUm;
import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    /*
    * Este relacionamento informa que há apenas um registro da entidade relacionado com um registro de outra entidade.
      cascade = As operações que precisam ser refletidas no alvo da associação.*/
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="assento_id", unique = true)
    private Assento assento;

    public Cliente(){}

    public Cliente(String nome, Assento assento){
        super();
        this.nome = nome;
        this.assento = assento;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Assento getAssento() { return assento; }

    public void setAssento(Assento assento) { this.assento = assento; }
}
