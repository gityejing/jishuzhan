package annotation4.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import annotation4.domain.ConInfo;

//@Profile("dev")
@Configuration
@ComponentScan(value="annotation4")
@PropertySource(value = {"jdbc.properties"},encoding="UTF-8",ignoreResourceNotFound=true)
public class AppConfig {
	 
	@Autowired
	@Qualifier("coon")
	private ConInfo coon;
	
	@Profile("prod")
	@Bean("prodDataSource")
	public DataSource dataSourceProd() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl(coon.getUrl());
		dataSource.setUser(coon.getUsername());
		dataSource.setPassword(coon.getPassword());
		dataSource.setDriverClass(coon.getDriverClassName());
		return dataSource;
	}
    
	@Profile("dev")
	@Bean("devDataSource")
	public DataSource dataSourceDev() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test1");
		dataSource.setUser("root");
		dataSource.setPassword("881213");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		return dataSource;
	}
	
	@Profile("local")
	@Bean("localDataSource")
	public DataSource dataSourceLocal() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test2");
		dataSource.setUser("root");
		dataSource.setPassword("881213");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		return dataSource;
	}
	
	
}
