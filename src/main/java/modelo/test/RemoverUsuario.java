package modelo.test;
import modelo.basico.Usuario;
import javax.persistence.*;

public class RemoverUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Atividade-JPA");
        /*Conexão e Persistir dados(inserir, deletar, alterar...)*/
        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class, 6L);
        if(usuario != null){
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        }else if(usuario == null){
            System.out.println("Usuario Inexistente!");
        }

        em.close();
        emf.close();
    }
}
