package quest.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("quest.dao") // On active des annotations @Component, @Repository, @Autowired, ... et on
							// précise le(s) package(s) à scanner
@EnableTransactionManagement // On active les annotations @Transactional avec transactionManager
public class ApplicationConfig {
	// On crée le DataSource
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/quest_jpa");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		dataSource.setMaxTotal(10);

		return dataSource;
	}

	// On crée un entityManagerFactory local à partir de la dataSource
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("quest.model");
		emf.setJpaVendorAdapter(vendorAdapter); // On précise le provider

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		jpaProperties.setProperty("hibernate.show_sql", "true");

		emf.setJpaProperties(jpaProperties); // On précise les propriétés

		return emf;
	}

	// On crée le transactionManager pour JPA avec entityManagerFactory
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	// On active la translation d'exception
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
