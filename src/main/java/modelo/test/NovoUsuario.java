package modelo.test;
import modelo.basico.Usuario;

import javax.persistence.*;


public class NovoUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Atividade-JPA");
        /*Conexão e Persistir dados(inserir, deletar, alterar...)*/
        EntityManager em = emf.createEntityManager();

        Usuario novoUsuario =  new Usuario("Patricia", "patricia@lanche.com.br");


        em.getTransaction().begin(); 
        em.persist(novoUsuario);
        em.getTransaction().commit();

        System.out.println("O id gerado foi:" + novoUsuario.getId());

        em.close();
        emf.close();
    }

	
}
    

