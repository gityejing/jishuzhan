package annotation7.config;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement // 开启基于注解的事务管理功能
@ComponentScan("annotation7")
public class AppConfig {

	@Bean("dataSource")
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("881213");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	/**
	 * 配置事务管理器，进行具体的事务管理
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		String rootPath = getClass().getResource("/").getPath();
		File file = new File(rootPath + "/hibernate.cfg.properties");
		Properties hbtProperties = new Properties();
		try {
			hbtProperties.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan("annotation7.domain");
		localSessionFactoryBean.setHibernateProperties(hbtProperties);
		return localSessionFactoryBean;
	}

	@Bean
	SessionFactory sessionFactory() {
		return localSessionFactoryBean().getObject();
	}

	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(localSessionFactoryBean().getObject());
		return hibernateTemplate;
	}

	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		PlatformTransactionManager transactionManager = new HibernateTransactionManager(
				localSessionFactoryBean().getObject());
		return transactionManager;
	}
	
}
