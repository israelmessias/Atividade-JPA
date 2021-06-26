package modelo.Herança;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue("AB")
public class AlunoBolsista extends Aluno{
    private double valor;
    public AlunoBolsista(){}

    public AlunoBolsista(Long matricula, String nome, double valor) {
        super(matricula, nome);
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
