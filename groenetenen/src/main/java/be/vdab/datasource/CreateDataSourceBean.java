package be.vdab.datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/dao.properties")
public class CreateDataSourceBean {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Autowired
	private Environment environment;

	@Bean
	DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(environment.getProperty("local.driverClassName"));
		dataSource.setJdbcUrl(environment.getProperty("local.jdbcURL"));
		dataSource.setUsername(environment.getProperty("local.userName"));
		dataSource.setPassword(environment.getProperty("local.password"));
		return dataSource;
	}
}