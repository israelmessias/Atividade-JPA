package modelo.test;
import modelo.Infra.DAO;
import modelo.basico.Produto;


public class NovoProduto {
    public static void main(String[] args) {
        Produto produtos = new Produto("Caneta", 1.25);
        DAO<Produto> dao = new DAO<>(Produto.class);
        dao.inputAtomic(produtos).openTransi();

        System.out.println(produtos.getNome()+" incluida com Sucesso!");

    }
}
