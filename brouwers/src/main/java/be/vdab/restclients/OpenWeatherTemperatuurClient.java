package be.vdab.restclients;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import be.vdab.exceptions.KanTemperatuurNietLezenException;

@Component
class OpenWeatherTemperatuurClient implements TemperatuurClient {
	
	private final static Logger logger = Logger.getLogger(OpenWeatherTemperatuurClient.class.getName());
	private final String openWeatherURL;
	private final RestTemplate restTemplate;
	
	@Autowired
	OpenWeatherTemperatuurClient(@Value("${openWeatherURL}") String openWeatherURL, RestTemplate restTemplate) {
		this.openWeatherURL = openWeatherURL;
		this.restTemplate = restTemplate;
	}
	
	@Override
	public double getTemperatuur(String gemeente) {
		try {
			Current current = restTemplate.getForObject(openWeatherURL, Current.class, gemeente);
			return current.temperature.getValue();
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "kan temperatuur niet lezen", ex);
			throw new KanTemperatuurNietLezenException();
		}
	}

	
} 