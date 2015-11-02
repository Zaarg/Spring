package be.vdab.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;

@Repository 
class BrouwerDAOImpl implements BrouwerDAO { 
	
	private EntityManager entityManager;
	  
	@PersistenceContext 
	void setEntityManager(EntityManager entityManager) {
	    this.entityManager = entityManager;
	}
	
	@Override
	public void create(Brouwer brouwer) {
		entityManager.persist(brouwer); 
	}
	
	@Override 
	public Brouwer read(long id) {
		return entityManager.find(Brouwer.class, id);
	}   
  
	@Override
	public void update(Brouwer brouwer) {
		entityManager.merge(brouwer);
	}  
  
	@Override 
	public void delete(long id) {
		entityManager.remove(read(id));
	}
	
	@Override
	public List<Brouwer> findAll() {
		return entityManager.createNamedQuery("Brouwer.findAll", Brouwer.class)
				.getResultList();
	}
	
	@Override
	public List<Brouwer> findByNaam(String begin) {
		return entityManager.createNamedQuery("Brouwer.findByNaam", Brouwer.class)
				.setParameter("begin", begin+"%")
			    .getResultList();
	}
		
}