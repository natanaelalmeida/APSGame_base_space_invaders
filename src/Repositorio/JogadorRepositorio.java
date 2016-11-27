package Repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Jogador;

public class JogadorRepositorio {
    
    private EntityManagerFactory entityFactory;
    private EntityManager entityManager;

            
    public Jogador Inserir(Jogador jogador){
        
        entityFactory = Persistence.createEntityManagerFactory("ApsGamePU");
        entityManager = entityFactory.createEntityManager();
        
        if(jogador != null){
            entityManager.getTransaction().begin();
            entityManager.persist(jogador);
            entityManager.getTransaction().commit();
        }        
        
        return null;
    }
    
}
