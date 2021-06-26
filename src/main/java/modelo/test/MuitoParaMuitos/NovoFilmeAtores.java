package modelo.test.MuitoParaMuitos;
import modelo.Infra.DAO;
import modelo.MuitosParaMuitos.Ator;
import modelo.MuitosParaMuitos.Filme;

public class NovoFilmeAtores {
    public static void main(String[] args) {
        Filme filmeA = new Filme("Star Wars Ep 4", 8.9);
        Filme filmeB = new Filme("O Fugitivo", 8.1);
        Filme filmeC = new Filme("Blade Runner - O Caçador de Androides", 8.7);

        Ator atorA = new Ator("Harrison Ford");
        Ator atrizB = new Ator("Carrie Fisher");

        filmeA.addAtor(atorA);
        filmeA.addAtor(atrizB);

        filmeB.addAtor(atorA);

        DAO<Filme> dao = new DAO<>();
        dao.inputAtomic(filmeC);
    }
}
