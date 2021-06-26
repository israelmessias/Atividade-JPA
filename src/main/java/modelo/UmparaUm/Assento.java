package modelo.UmparaUm;

import javax.persistence.*;

@Entity
@Table(name = "assentos")
public class Assento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String nome;
    @OneToOne(mappedBy = "assento")
    private Cliente cliente;


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Assento(){}

    public Assento(String nome){
        super();
        this.nome = nome;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }
}
