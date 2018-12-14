package annotation9.config;

import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement // 开启基于注解的事务管理功能
@EnableJpaRepositories(basePackages = {"annotation9.dao"}, 
	transactionManagerRef = "transactionManager", 
	entityManagerFactoryRef = "entityManagerFactory")
@ComponentScan("annotation9")
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

	// jpa 相关配置
	@Bean
	public HibernatePersistenceProvider hibernatePersistenceProvider() {
		HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();
		return hibernatePersistenceProvider;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPersistenceProvider(hibernatePersistenceProvider());
		bean.setPackagesToScan(new String[] { "annotation9.domain" });
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
		bean.setJpaVendorAdapter(hibernateJpaVendorAdapter);

		Map<String, Object> jpaProperties = new HashMap<String, Object>();
		jpaProperties.put("hibernate.query.substitutions", "true 1, false 0");
		jpaProperties.put("hibernate.default_batch_fetch_size", 16);
		jpaProperties.put("hibernate.max_fetch_depth", 2);
		jpaProperties.put("hibernate.generate_statistics", false);
		jpaProperties.put("hibernate.bytecode.use_reflection_optimizer", true);
		jpaProperties.put("hibernate.cache.use_query_cache", false);
		jpaProperties.put("hibernate.cache.use_second_level_cache", false);
		jpaProperties.put("hibernate.enable_lazy_load_no_trans", true);
		jpaProperties.put("hibernate.temp.use_jdbc_metadata_defaults", false);
		jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
		bean.setJpaPropertyMap(jpaProperties);
		return bean;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
}
