package org.app.spring;

import java.util.logging.Logger;

import org.app.domain.services.IProiectEntityFactory;
import org.app.domain.services.ProiectEntityFactoryImpl;
import org.app.domain.services.ProiectEntityRepositoryImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages ="org.app.domain.services")
public class AppScanConfig {

	private static Logger logger = Logger.getLogger(AppScanConfig.class.getName());

	public IProiectEntityFactory proiectEntityFactory() {
		ProiectEntityRepositoryImpl entityRepositoryBaseCDI = new ProiectEntityRepositoryImpl();
		ProiectEntityFactoryImpl proiectEntityFactoryBaseCDI = new ProiectEntityFactoryImpl(entityRepositoryBaseCDI);
		
		initDomainServiceEntities(entityRepositoryBaseCDI, proiectEntityFactoryBaseCDI);
		
		return proiectEntityFactoryBaseCDI;
	}
	
	private void initDomainServiceEntities (ProiectEntityRepositoryImpl entityRepository, 
				ProiectEntityFactoryImpl proiectEntityFactory) {
		logger.info(">> AppContextConfig :: initDomainServiceEntities");
		for(int i=1; i<=3; i++) {
			entityRepository.add(
					proiectEntityFactory.buildSimpleProject("Proiect_ " + i) ); 
		}
		logger.info(">> AppContextConfig.EntityRepository project.count :: " + entityRepository.size());
	}
}
