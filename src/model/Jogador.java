package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tb_jogador")
@NamedQueries({
    @NamedQuery(name = "TbJogador.findAll", query = "SELECT t FROM TbJogador t")
    , @NamedQuery(name = "TbJogador.findByIdJogador", query = "SELECT t FROM TbJogador t WHERE t.idJogador = :idJogador")
    , @NamedQuery(name = "TbJogador.findByUsuario", query = "SELECT t FROM TbJogador t WHERE t.usuario = :usuario")
    , @NamedQuery(name = "TbJogador.findByEmail", query = "SELECT t FROM TbJogador t WHERE t.email = :email")
    , @NamedQuery(name = "TbJogador.findByFgLogado", query = "SELECT t FROM TbJogador t WHERE t.fgLogado = :fgLogado")}
)
public class Jogador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jogador")
    private Integer id_jogador;

    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "senha")
    private String senha;
       
    @Column(name = "email")
    private String email;
    
    @Column(name = "fg_ativo")
    private Boolean fg_ativo;
    
    @Column(name = "fg_logado")
    private Boolean fg_logado;
    
    @OneToMany(mappedBy = "id_jogador")
    private Collection<Pontuacao> lstPontuacaoCollection;

    public Jogador() {
    }

    public Jogador(Integer idJogador) {
        this.id_jogador = idJogador;
    }        

    public Jogador(String usuario, String senha, String email) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
    }

    public Integer getIdJogador() {
        return id_jogador;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getFgAtivo() {
        return fg_ativo;
    }

    public Boolean getFgLogado() {
        return fg_logado;
    }
    
    public boolean Criar(){
        return (!usuario.equals("") ? true : false) 
                &&(!senha.equals("")? true : false)
                &&(!email.equals("")? true : false);
    }

    @XmlTransient
    public Collection<Pontuacao> getlstPontuacaoCollection() {
        return lstPontuacaoCollection;
    }

    public void setlstPontuacaoCollection(Collection<Pontuacao> tbPontuacaoCollection) {
        this.lstPontuacaoCollection = tbPontuacaoCollection;
    }
    
}
