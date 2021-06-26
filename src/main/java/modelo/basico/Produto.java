package modelo.basico;

import javax.persistence.*;

@Entity
@Table(name = "produtos", schema = "curso_java")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //length = quantidade de caracteres
    @Column(name = "prod_nome", length = 150, nullable = false)
    private String nome;
    // name=Nome da tabela | nullable=Vazio | precision = quantidade de numeros || scale = cassas decimais
    @Column(name = "prod_preco", nullable = false, precision = 11, scale = 2)
    private Double preço;

    public Produto(){}
    public Produto(String nome, Double preço) {
        super();
        this.nome = nome;
        this.preço = preço;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public Double getPreço() {return preço;}

    public void setPreço(Double preço) {this.preço = preço;}


}
