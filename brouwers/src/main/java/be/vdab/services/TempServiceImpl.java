package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.vdab.restclients.TemperatuurClient;

@Service
public class TempServiceImpl implements TempService{
	
	private final TemperatuurClient temperatuurClient;
	
	@Autowired
	TempServiceImpl(TemperatuurClient temperatuurClient) {
		this.temperatuurClient = temperatuurClient;
	}
	
	@Override
	public double geefTemp(String gemeente) {
		return temperatuurClient.getTemperatuur(gemeente);
	}

}
