package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;

import be.vdab.dao.BrouwerDAO;
import be.vdab.entities.Brouwer;

@Service
@Transactional(readOnly = true , isolation = Isolation.READ_COMMITTED)
class BrouwerServiceImpl implements BrouwerService { 
	private final BrouwerDAO brouwerDAO;
  
	@Autowired 
	BrouwerServiceImpl(BrouwerDAO brouwerDAO) {     
		this.brouwerDAO = brouwerDAO;
	} 
  
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED) 
	public void create(Brouwer Brouwer) {
		brouwerDAO.create(Brouwer);
	}
  	
	@Override 
	public void read(long id) {
		brouwerDAO.read(id);
	}
	
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED) 
	public void update(Brouwer Brouwer) {
		brouwerDAO.update(Brouwer);
	}
	
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED) 
	public void delete(long id) {
		brouwerDAO.delete(id);
	}
	
	@Override
	public List<Brouwer> findAll() {
		return brouwerDAO.findAll();
	} 
  
	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		return brouwerDAO.findByNaam(beginNaam);
	}

} 