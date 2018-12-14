package annotation7.conf;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import annotation7.domain.Persion;

@EnableTransactionManagement
@Configuration
@ComponentScan("annotation7")
public class AppConfig {

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("881213");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		return dataSource;
	}
	
	/**
	 * 配置事务管理器，进行具体的事务管理
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
		PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		return transactionManager;
	}

	@Bean
	public SessionFactory localSessionFactoryBean(DataSource dataSource) {
		SessionFactory bean = new LocalSessionFactoryBuilder(dataSource)
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
				.setProperty("hibernate.show_sql", "true")
				.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false")
				.setProperty("hibernate.hbm2ddl.auto", "update")
				.addAnnotatedClass(Persion.class)
				.buildSessionFactory();
		return bean;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}
}
