package modelo.MuitosParaMuitos;
import modelo.Consulta.NotaFilme;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filmes")
public class Filme extends NotaFilme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double nota;

    /*
    * @JoinColumn(name = nome da coluna , referencedColumnName = coluna referenciada
    * inverseJoinColumns = a outra coluna...*/
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "atores_filmes",
            joinColumns =  @JoinColumn(name = "filme_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "atores_id", referencedColumnName  = "id"))
    private List<Ator> atores;

    public Filme(){
        super();
    }

    public Filme(String nome, Double nota){
        this.nome = nome;
        this.nota = nota;
    }


    public void addAtor(Ator ator){
        if(ator != null && !getAtores().contains(ator)){
            getAtores().add(ator);
            if(!ator.getFilmes().contains(this))
              ator.getFilmes().add(this);
        }
    }
   //
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public List<Ator> getAtores() {
        if(atores == null){
            atores = new ArrayList<>();
        }
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

}
