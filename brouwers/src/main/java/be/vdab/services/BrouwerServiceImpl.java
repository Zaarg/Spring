package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasAuthority('administrator')")
	public void create(Brouwer Brouwer) {
		brouwerDAO.save(Brouwer);
	}
  	
	@Override 
	public void read(long id) {
		brouwerDAO.findOne(id);
	}
	
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED) 
	@PreAuthorize("hasAuthority('administrator')")
	public void update(Brouwer Brouwer) {
		brouwerDAO.save(Brouwer);
	}
	
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED) 
	@PreAuthorize("hasAuthority('administrator')")
	public void delete(long id) {
		Brouwer brouwer  = brouwerDAO.findOne(id);
		if (brouwer != null) {
		  brouwerDAO.delete(id);
		}
	}
	
	@Override
	public Page<Brouwer> findAll(Pageable pageable) {
		return brouwerDAO.findAll(pageable);
	} 
  
	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		return brouwerDAO.findByNaamStartingWith(beginNaam);
	}

} 