package modelo.Infra;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class DAO <E> {
    private static EntityManagerFactory emf;
    private final EntityManager em;
    private Class<E> classe;

    static {
        try{
            emf = Persistence.createEntityManagerFactory("Atividade-JPA");
        }catch (Exception e){
        }
    }

    public DAO(){
        this(null);
    }
    public DAO(Class<E> classe ){
        super();
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAO<E> openTransi(){
        //Metodo para abrir Transação
        em.getTransaction().begin();
        return this;
    }
    public DAO<E> closeTransi(){
        em.getTransaction().commit();
        return this;
    }
    public DAO<E> input(E entidade){
        em.persist(entidade);
        return this;//retorna a instância do objeto atual
    }
    //Abrir, fechar e incluir
    public DAO<E> inputAtomic(E entidade){
        return this.openTransi().input(entidade).closeTransi();//retorna a instância do objeto atual
    }
    //Abrir, fechar e incluir
    public DAO<E> inputAtomicTwo(E entidade, E entidade2){
        return this.openTransi().input(entidade).input(entidade2).closeTransi();//retorna a instância do objeto atual
    }
    public E ConsultId(Object id){
        return em.find(classe, id);
    }
    public List<E> consultAll(int quantidade, int deslocamento){
        if(classe == null){
            throw new UnsupportedOperationException("Classe Nula, tente novamente.");
        }
        String jpql = "select e from " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(quantidade);
        query.setFirstResult(deslocamento);
        return query.getResultList();
    }
        public List<E> consultAll(){
        return this.consultAll(10,0);
    }

    //nomeConsulta = anotação dentro do consultas.xml, Object... paramets parametros para pesquisa
    public List<E> Consult(String nomeConsulta, Object... params){
        TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
        for (int i = 0; i < params.length; i += 2){
            //Primeiro parametro coluna nota por isso o to string
           query.setParameter(params[i].toString(), params[i + 1]);
        }
        return query.getResultList();
    }

    public E ConsultOne(String nomeConsulta, Object... params){
        List<E> lista = Consult(nomeConsulta, params);
        //Se a lista for nula  retorna null, caso contrario primeiro indice da lista
        return lista.isEmpty() ? null : lista.get(0);
    }
       public void close(){
        em.close();
    }


}
