package modelo.test;
import modelo.Infra.ProdutoDAO;
import modelo.basico.Produto;
import java.util.List;

public class Consult {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> list_produtos = dao.consultAll();

        for(Produto produto: list_produtos){
            System.out.println("ID: "+ produto.getId()+" -> "+
                    produto.getNome()+"\n\t"+produto.getPreço());
        }
        dao.close();
    }
}
