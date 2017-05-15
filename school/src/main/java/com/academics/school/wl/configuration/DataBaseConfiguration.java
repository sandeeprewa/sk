package com.academics.school.wl.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.academics.school.pl.controller.registration.dto.Address;
import com.academics.school.pl.controller.registration.dto.Category;
import com.academics.school.pl.controller.registration.dto.CurrentClass;
import com.academics.school.pl.controller.registration.dto.Disability;
import com.academics.school.pl.controller.registration.dto.EducationDetail;
import com.academics.school.pl.controller.registration.dto.Gender;
import com.academics.school.pl.controller.registration.dto.Nation;
import com.academics.school.pl.controller.registration.dto.ParentDetail;
import com.academics.school.pl.controller.registration.dto.Student;
import com.academics.school.pl.controller.registration.dto.RegistrationStatus;
import com.academics.school.pl.controller.registration.dto.Religion;
import com.academics.school.pl.controller.registration.dto.State;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.pl.controller.registration.dto.Subject;
import com.academics.school.sl.credential.Credential;
import com.academics.school.sl.credential.model.StudentLoginModel;

@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration {
		

	/*
	 *  Adding DB configuation
	 */
	
	@Autowired
	Environment environment;
	
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
    	// instead of using 3rd api, we can use jndi
   
        System.out.println("Count Wired DATA source");
    	 
    	BasicDataSource dataSource = new BasicDataSource();
    	 dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
         dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
         dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
         dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
         System.out.println("Wired DATA source");
         return dataSource;	    	
    }

    private Properties getHibernateProperties() {
    	Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }
    
/*
 *  @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.scanPackages("com.iexp.sl.domain.*");
    	markHibernateClass(sessionBuilder);
    	return sessionBuilder.buildSessionFactory();
    }
*/
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(LocalSessionFactoryBuilder sessionFactoryBuilder) {
    	markHibernateClass(sessionFactoryBuilder);
    	System.out.println("Mark SEssionFactory Class");
    	
    	return sessionFactoryBuilder.buildSessionFactory();
    }
    
    
    @Autowired
    @Bean(name = "sessionFactoryBuilder")    
    public LocalSessionFactoryBuilder getLocalSessionFactoryBuilder(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	return sessionBuilder;
    }
    
    private void markHibernateClass(LocalSessionFactoryBuilder sessionBuilder){
    	//all classes should be registered

    	System.out.println("Mark Hibernate Class");
    	sessionBuilder.addAnnotatedClass(StudentRegistrationRecord.class);
    	sessionBuilder.addAnnotatedClass(CurrentClass.class);
    	sessionBuilder.addAnnotatedClass(Student.class);
    	sessionBuilder.addAnnotatedClass(ParentDetail.class);
    	sessionBuilder.addAnnotatedClass(EducationDetail.class);
    	sessionBuilder.addAnnotatedClass(RegistrationStatus.class);
    	sessionBuilder.addAnnotatedClass(Category.class);
    	sessionBuilder.addAnnotatedClass(Nation.class);
    	sessionBuilder.addAnnotatedClass(Gender.class);
    	sessionBuilder.addAnnotatedClass(Disability.class);
    	sessionBuilder.addAnnotatedClass(State.class);
    	sessionBuilder.addAnnotatedClass(Subject.class);
    	sessionBuilder.addAnnotatedClass(Religion.class);
    	sessionBuilder.addAnnotatedClass(Address.class);
    	sessionBuilder.addAnnotatedClass(StudentLoginModel.class);
    	sessionBuilder.addAnnotatedClass(Credential.class);
    	System.out.println("END :Mark Hibernate Class");

    }
    
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);
		return transactionManager;
	}


}
