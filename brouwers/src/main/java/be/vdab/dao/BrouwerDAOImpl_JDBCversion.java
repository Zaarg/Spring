/*package be.vdab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository 
class BrouwerDAOImpl_JDBCversion implements BrouwerDAO { 
	
	private static final String BEGIN_SQL = "select id, naam, postcode, gemeente, omzet, straat, huisNr from brouwers";
	private static final String SQL_READ = BEGIN_SQL + " where id = :id";
	private static final String SQL_UPDATE = "update brouwers set naam=:naam, postcode=:postcode, gemeente=:gemeente, omzet=:omzet, straat=:straat, huisnr=:huisnr where id = :id";
	private static final String SQL_DELETE = "delete from brouwers where id = ?";
	private static final String SQL_FIND_ALL = BEGIN_SQL + " order by naam";
	private static final String SQL_FIND_BY_NAAM = BEGIN_SQL + " where naam like :begin order by naam";  
			
	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final BrouwerRowMapper rowMapper = new BrouwerRowMapper();
	private final SimpleJdbcInsert simpleJdbcInsert;
  
	@Autowired
	BrouwerDAOImpl_JDBCversion(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		  this.jdbcTemplate = jdbcTemplate;
		  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		  simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate); 
		  simpleJdbcInsert.withTableName("brouwers"); 
		  simpleJdbcInsert.usingGeneratedKeyColumns("id"); 
	}
	
	@Override
	public void create(Brouwer brouwer) {
	  Map<String, Object> kolomWaarden = new HashMap<>();   
	  kolomWaarden.put("naam", brouwer.getNaam());   
	  kolomWaarden.put("postcode", brouwer.getAdres().getPostcode());
	  kolomWaarden.put("gemeente", brouwer.getAdres().getGemeente());
	  kolomWaarden.put("omzet", brouwer.getOmzet());
	  kolomWaarden.put("straat", brouwer.getAdres().getStraat());
	  kolomWaarden.put("huisNr", brouwer.getAdres().getHuisNr());
	  Number id = simpleJdbcInsert.executeAndReturnKey(kolomWaarden);   
	  brouwer.setBrouwerNr(id.longValue()); 
	}
	
	@Override 
	public Brouwer read(long id) {
	  Map<String, Long> parameters = Collections.singletonMap("id", id);   
	  try {
	    return namedParameterJdbcTemplate.queryForObject(SQL_READ, parameters, rowMapper);   
	  } catch (IncorrectResultSizeDataAccessException ex) { 
	    return null;
	  }
	}   
  
	@Override
	public void update(Brouwer brouwer) {
	  Map<String, Object> parameters = new HashMap<>();
	  parameters.put("id", brouwer.getBrouwerNr());
	  parameters.put("naam", brouwer.getNaam());   
	  parameters.put("postcode", brouwer.getAdres().getPostcode());
	  parameters.put("gemeente", brouwer.getAdres().getGemeente());
	  parameters.put("omzet", brouwer.getOmzet());
	  parameters.put("straat", brouwer.getAdres().getStraat());
	  parameters.put("huisNr", brouwer.getAdres().getHuisNr());
	  namedParameterJdbcTemplate.update(SQL_UPDATE, parameters);
	}  
  
	@Override 
	public void delete(long id) {
	  jdbcTemplate.update(SQL_DELETE, id);
	}
	
	@Override
	public List<Brouwer> findAll() {
	  return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
	}
	
	@Override
	public List<Brouwer> findByNaam(String begin) {
		Map<String, String> parameter = Collections.singletonMap("begin", begin+"%");  
		return namedParameterJdbcTemplate.query(SQL_FIND_BY_NAAM, parameter, rowMapper);
	}
	
	private static class BrouwerRowMapper implements RowMapper<Brouwer> { 
		@Override 
		public Brouwer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			return new Brouwer(resultSet.getLong("id"), resultSet.getString("naam"), resultSet.getInt("omzet") ,new Adres(resultSet.getString("straat"),
					resultSet.getString("huisnr"), resultSet.getInt("postcode"), resultSet.getString("gemeente")));
		}
	} 
	
}*/