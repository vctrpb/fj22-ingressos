package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

@Repository
public class SessaoDao {

	@PersistenceContext
	private EntityManager manager;
	
	
	public void save(Sessao sessao){
		manager.persist(sessao);
	}
	
	public List<Sessao> buscaSessoesDaSala(Sala sala){
		String query = "select s from Sessao s where s.sala = :sala";
		
		TypedQuery<Sessao> typedQuery = manager.createQuery(query, Sessao.class);
		
		typedQuery.setParameter("sala", sala);
		
		return typedQuery.getResultList();
	}
}
