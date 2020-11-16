package org.app.spring;


import org.app.domain.services.IProiectEntityFactory;
import org.app.domain.services.IProiectEntityRepository;
import org.app.domain.services.ProiectEntityFactoryImpl;
import org.app.domain.services.ProiectEntityRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeanConfig {
	
	@Bean
	public IProiectEntityRepository getProiectEntityRepositoryImpl() {
		return new ProiectEntityRepositoryImpl();
	}
	
//	public IProiectDomainService getIProiectDomainService() {
//		return new ProiectDomainServiceImpl(getProiectEntityRepositoryImpl);
//	}
	@Bean
	public IProiectEntityFactory getIProiectEntityFactory() {
		return new ProiectEntityFactoryImpl();
	} 
	
}
