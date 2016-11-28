package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Jogador.class)
public abstract class Jogador_ {

	public static volatile SingularAttribute<Jogador, String> senha;
	public static volatile SingularAttribute<Jogador, Boolean> fg_ativo;
	public static volatile SingularAttribute<Jogador, Boolean> fg_logado;
	public static volatile SingularAttribute<Jogador, Integer> id_jogador;
	public static volatile CollectionAttribute<Jogador, Pontuacao> lstPontuacaoCollection;
	public static volatile SingularAttribute<Jogador, String> usuario;
	public static volatile SingularAttribute<Jogador, String> email;

}

