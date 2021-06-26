package modelo.test.MuitoParaMuitos;
import modelo.Infra.DAO;
import modelo.MuitosParaMuitos.Ator;
import modelo.MuitosParaMuitos.Filme;
import java.util.List;

public class ObterFilmes {
    public static void main(String[] args) {
        DAO<Filme> dao =  new DAO<>(Filme.class);
        List<Filme> filmes =
                dao.Consult("obterFilmesNotaMaiorQue", "nota", 8.5);

        System.out.println("\n\n"+filmes.size());
        for(Filme filme: filmes){
            System.out.println(filme.getNome()+" => "+ filme.getNota());

            for(Ator ator: filme.getAtores()){
                System.out.println(ator.getNome());
            }
        }
    }
}
