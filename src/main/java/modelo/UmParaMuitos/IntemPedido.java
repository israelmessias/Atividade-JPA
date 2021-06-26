package modelo.UmParaMuitos;
import modelo.basico.Produto;

import javax.persistence.*;

@Entity
public class IntemPedido {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //PEDIDO
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Pedido pedido;
    //PRODUTO
    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Produto produto;
    //QUNATIDADE E PREÇO
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = false)
    private Double preço;

    public IntemPedido(){}

    public IntemPedido( Produto produto, Pedido pedido, int quantidade) {
        super();
        this.setPedido(pedido);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
    }
    /*
    * Getters e Setters
    * */
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Pedido getPedido() { return pedido; }

    public void setPedido(Pedido pedido) { this.pedido = pedido; }

    public Produto getProduto() { return produto; }

    public void setProduto(Produto produto) {
        this.produto = produto;
        //if(produto != null & this.preço == null)
          //  this.setPreço(produto.getPreço());
    }

    public int getQuantidade() { return quantidade; }

    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public Double getPreço() { return preço; }

    public void setPreço(Double preço) { this.preço = preço; }

}
