package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Jogador;

public class JogadorDao {

    private String msgErro;    
    private EntityManagerFactory entityFactory;
    private EntityManager entityManager;
    private Query query;

    public JogadorDao() {
        entityFactory = Persistence.createEntityManagerFactory("ApsGamePU");
        entityManager = entityFactory.createEntityManager();
    }

    public boolean Inserir(Jogador jogador) {

        try {
            if (jogador != null) {
                entityManager.getTransaction().begin();
                entityManager.persist(jogador);
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

    public Jogador Selecionar(long id_jogador) {
        Jogador jogador = entityManager.find(Jogador.class, id_jogador);
        entityManager.close();
        entityFactory.close();
        return jogador;
    }
    
    public Jogador Login(Jogador jogador){
        entityFactory = Persistence.createEntityManagerFactory("ApsGamePU");
        entityManager = entityFactory.createEntityManager();
        
        query = entityManager.createQuery("SELECT j FROM Jogador j "
                + "where j.usuario = :usuario and j.senha = :senha "
                + "and j.fg_ativo = 't' and j.fg_logado = 'f'");
        
        query.setParameter("usuario", jogador.getUsuario());
        query.setParameter("senha", jogador.getSenha());
        
        Jogador j = (Jogador)query.getSingleResult();
        entityManager.close();
        entityFactory.close();
        return j;
    }

    public String getMsgErro() {
        return msgErro;
    }    
}
