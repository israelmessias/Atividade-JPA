package modelo.UmParaMuitos;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date data;

    public Pedido(){
        this(new Date());
    }
    public Pedido(Long id, Date data) {
        super();
        this.id = id;
        this.data = data;
    }
    public Pedido(Date date) {
        super();
        this.data = data;
    }

    public void setId(Long id){this.id = id;}

    public void setData(Date data){this.data = data;}

    public Long getId() { return id; }

    public Date getData() { return data; }
}
