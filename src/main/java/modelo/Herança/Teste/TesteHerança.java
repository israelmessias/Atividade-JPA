package modelo.Herança.Teste;

import modelo.Herança.Aluno;
import modelo.Herança.AlunoBolsista;
import modelo.Infra.DAO;

public class TesteHerança {
    public static void main(String[] args) {
        DAO<Aluno> alunoDAO = new DAO<>();

        Aluno aluno1 = new Aluno(123L, "João");
        AlunoBolsista aluno2 = new AlunoBolsista(345L, "Maria", 1000);

        alunoDAO.input(aluno1);
        alunoDAO.input(aluno2).openTransi().closeTransi().close();

    }
}
