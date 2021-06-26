package modelo.test;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Atividade-JPA");
        /*Conexão e Persistir dados(inserir, deletar, alterar...)*/
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 3L);
        em.detach(usuario);//Tira do modo gerenciado
        usuario.setEmail("sandra@lanche.com.br");

        em.merge(usuario);// Faz update

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
