package DAO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import static javafx.scene.input.KeyCode.L;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Jogador;
import model.Pontuacao;
import static model.Pontuacao_.id_pontuacao;

public class PontuacaoDao {
    
    private String msgErro;
    private EntityManagerFactory entityFactory;
    private EntityManager entityManager;
    
    public PontuacaoDao(){
        entityFactory = Persistence.createEntityManagerFactory("ApsGamePU");
        entityManager = entityFactory.createEntityManager();
    }
    
    public boolean Insert(Pontuacao pontuacao){
        
        entityFactory = Persistence.createEntityManagerFactory("ApsGamePU");
        entityManager = entityFactory.createEntityManager();
        
        Pontuacao p = null;
        if(pontuacao.getIdPontuacao() != null && pontuacao.getIdPontuacao() > 0){
            p = entityManager.find(Pontuacao.class, pontuacao.getIdPontuacao());
            p.setPontuacao(pontuacao.getPontuacao());
        }
        else {
            p = pontuacao;
        }
        
        try {
          if(pontuacao != null){
                entityManager.getTransaction().begin();
                entityManager.persist(p);
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
    
    public Pontuacao SelecionarPorJogador(Jogador jogador){
        entityFactory = Persistence.createEntityManagerFactory("ApsGamePU");
        entityManager = entityFactory.createEntityManager();   
        
        Query query = entityManager.createQuery("SELECT p FROM Pontuacao p where p.id_jogador = :id_jogador");

        query.setParameter("id_jogador", jogador);
        
        List<Pontuacao> lst = (List<Pontuacao>)query.getResultList();
        Optional<Pontuacao> op = lst.stream().filter(e -> e != null ).findFirst();
        
        Pontuacao pontuacao = null;
        if(op.isPresent())
            pontuacao = op.get();
        
        entityManager.close();
        entityFactory.close();
        return pontuacao;
    }
    
    public List<Pontuacao> ListaTodas(){
         entityFactory = Persistence.createEntityManagerFactory("ApsGamePU");
        entityManager = entityFactory.createEntityManager();   
        
        Query query = entityManager.createQuery("Select p From Pontuacao p order by p.pontuacao desc");
        List<Pontuacao> pontuacao = (List<Pontuacao>)query.getResultList();
        
        entityManager.close();
        entityFactory.close();
        return pontuacao;
    }
    
    public String getMsgErro() {
        return msgErro;
    }
}
