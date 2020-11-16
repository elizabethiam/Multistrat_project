package org.app.domain.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.app.domain.entities.Cerinta;
import org.app.domain.entities.Echipa;
import org.app.domain.entities.Intern;
import org.app.domain.entities.Proiect;
import org.app.domain.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ProiectEntityFactoryImpl")
@Scope("singleton") 	//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProiectEntityFactoryImpl implements IProiectEntityFactory{
	
	private static Logger logger = Logger.getLogger(ProiectEntityFactoryImpl.class.getName());
	
	public ProiectEntityFactoryImpl() {
		logger.info(">>> BEAN: ProjectEntityFactoryCDI instantiated!");
	}
	
	@Override
	public Proiect buildSimpleProject(String numeProiect) {
		// TODO Auto-generated method stub
		Integer nextID = this.entityRepository.getNextID();
		LocalDateTime startLocalDate = LocalDateTime.now();
		Proiect proiectNou = new Proiect(nextID, numeProiect, DateUtils4J8API.asDate(startLocalDate));
		
		Echipa echipa1 = new Echipa(1, "Echipa_1");
		List<Intern> interni = new ArrayList<>();
		 
		interni.add(new Intern(1, "Intern_1", echipa1));
		interni.add(new Intern(2, "Intern_2", echipa1));
		
		echipa1.setInterni(interni);
		
		List<Cerinta> listaCerinte = new ArrayList<>();
		
		Cerinta cerintaNoua = new Cerinta(1, "C: " + proiectNou.getIdProiect() + "." + 1, proiectNou);
		
		List<Task> taskuri = new ArrayList<>();
		
		taskuri.add(new Task(1, "T: " + cerintaNoua.getIdCerinta() + "." + 1, interni.get(0), 10, cerintaNoua));
		taskuri.add(new Task(2, "T: " + cerintaNoua.getIdCerinta() + "." + 2, interni.get(1), 18, cerintaNoua));
		
		cerintaNoua.setTaskuri(taskuri);
		
		listaCerinte.add(cerintaNoua);
		proiectNou.setCerinte(listaCerinte);
		
		logger.info("NEW PROJECT:: " + proiectNou);
		
		return proiectNou;
	}

	@Autowired
	private IProiectEntityRepository entityRepository;
	
	@Override
	public void setProiectEntityRepository(IProiectEntityRepository repository) {
		// TODO Auto-generated method stub
		this.entityRepository = repository;
	}

	@Override
	public IProiectEntityRepository getProiectEntityRepository() {
		// TODO Auto-generated method stub
		return entityRepository;
	}
	
	public ProiectEntityFactoryImpl(IProiectEntityRepository entityRepository) {
		super();
		this.entityRepository = entityRepository;
	}
	
	@PostConstruct
	private void initDomainServiceEntities() {
		logger.info(">> PostConstruct :: initDomainServiceEntities");
		for(int i=1; i<=3; i++) {
			entityRepository.add(
					buildSimpleProject("Proiect_" + i)
			);
		}
	}

}
