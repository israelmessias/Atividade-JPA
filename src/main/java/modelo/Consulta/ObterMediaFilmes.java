package modelo.Consulta;
import modelo.Infra.DAO;
import modelo.MuitosParaMuitos.Filme;

public class ObterMediaFilmes {
    public static void main(String[] args) {
        DAO<Filme> dao = new DAO<>(Filme.class);
        NotaFilme nota = dao.ConsultOne("obterMediaGeralDosFilmes");

        System.out.println(nota.getMedia());
        dao.close();
    }
}
