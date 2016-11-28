package DAO;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Pontuacao;

public class PontuacaoDao {
    
    private String msgErro;
    private EntityManagerFactory entityFactory;
    private EntityManager entityManager;
    
    public PontuacaoDao(){
        entityFactory = Persistence.createEntityManagerFactory("ApsGamePU");
        entityManager = entityFactory.createEntityManager();
    }
    
    public boolean Insert(Pontuacao pontuacao){
        try {
          if(pontuacao != null){
                entityManager.getTransaction().begin();
                entityManager.persist(pontuacao);
                entityManager.getTransaction().commit();
            }

            entityManager.close();
            entityFactory.close(); 
             return true;
        } catch (Exception e) {
            msgErro = e.getMessage();
        }    
        
        return false;
    }
    
    public Pontuacao Selecionar(long id_pontuacao){
        Pontuacao pontuacao = entityManager.find(Pontuacao.class, id_pontuacao);
        entityManager.close();
        entityFactory.close();
        return pontuacao;
    }
    
    public Collection<Pontuacao> ListaTodas(){
        Query query = entityManager.createQuery("Select p From tb_pontuacao p");
        Collection<Pontuacao> pontuacao = query.getResultList();
        entityManager.close();
        entityFactory.close();
        return pontuacao;
    }
    
    public String getMsgErro() {
        return msgErro;
    }
}
