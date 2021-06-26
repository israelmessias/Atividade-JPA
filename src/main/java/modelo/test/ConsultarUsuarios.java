package modelo.test;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ConsultarUsuarios {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Atividade-JPA");
        /*Conexão e Persistir dados(inserir, deletar, alterar...)*/
        EntityManager em = emf.createEntityManager();

        //Ele é usado para criar consultas contra entidades para armazenar em um banco de dados relacional.
        /*String jpql = "select u from Usuario u";*/
        //Interface usada para controlar a execução de consultas digitadas.
        /*TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);*/
        /*query.setMaxResults(5);*/ // limita a quantidade de resultados

        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u")
                .setMaxResults(5).getResultList();

        for(Usuario usuario: usuarios){
            System.out.println("ID: " + usuario.getId()+
                    " E-mail: " + usuario.getEmail());
        }

        em.close();
        emf.close();
    }
}
