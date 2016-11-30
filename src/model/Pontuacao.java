package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pontuacao")
public class Pontuacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pontuacao")
    private Integer id_pontuacao;
    
    @Column(name = "pontuacao")
    private int pontuacao;
    
    @JoinColumn(name = "id_jogador", referencedColumnName = "id_jogador")
    @ManyToOne
    private Jogador id_jogador;

    public Pontuacao() {
    }

    public Pontuacao(Integer idPontuacao) {
        this.id_pontuacao = idPontuacao;
    }

    public Pontuacao(Jogador id_jogador, int pontuacao) {
        this.id_jogador = id_jogador;
        this.pontuacao = pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }   
    
    public Integer getIdPontuacao() {
        return id_pontuacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Jogador getIdJogador() {
        return id_jogador;
    }
    
}
