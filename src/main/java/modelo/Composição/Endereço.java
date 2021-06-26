package modelo.Composição;
import javax.persistence.*;
@Embeddable
@Table(name = "endereços")
public class Endereço {
    private String logradouro;
    private String complemento;

    public Endereço(){
    }

    public Endereço(String logradouro, String complemento){
        super();
        this.setLogradouro(logradouro);
        this.setComplemento(complemento);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
