package org.app.domain.services;





import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.app.domain.services.IProiectEntityFactory;
import org.app.domain.services.IProiectEntityRepository;
import org.app.spring.AppScanConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppScanConfig.class)
public class TestProiectDomainService {

	private static Logger logger = Logger.getLogger(TestProiectDomainService.class.getName());
	
	@Autowired
	private IProiectDomainService service;
	 
	@Autowired
	private IProiectEntityRepository repository;
	
	@Autowired
	private IProiectEntityFactory factory;
	
	@Test
	public void test() {
		logger.info("Repository implementation object:: " + repository);
		logger.info("Repository implementation class:: " + repository.getClass().getName());
		
		logger.info("Factory implementation object:: " + factory);
		logger.info("Factory implementation class:: " + factory.getClass().getName());
		
		logger.info("Service implementation object:: " + service);
		logger.info("Service implementation class:: " + service.getClass().getName());
		
		Integer taskCount = service.getProiectTaskuriCount(1);
		assertTrue("Tasks not counting...", taskCount > 0);
		logger.info("Task count autowired xml:: " + taskCount);
	}
	
	@Autowired @Qualifier("ProiectEntityFactoryImpl")
	private IProiectEntityFactory proiectFactory;
	
	@Test
	public void testProjectEntityFactory() {
		// CDI -> AppContextConfig -> @Produces IProjectEntityFactory :: initDomainServiceEntities -- Repository
		Integer projectCounts = proiectFactory.getProiectEntityRepository().size();
		assertTrue("Projects not counting...", projectCounts > 0);
		logger.info("Project count:: " + projectCounts);
	}
	
}
