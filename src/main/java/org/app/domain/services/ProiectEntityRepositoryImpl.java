package org.app.domain.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.app.domain.entities.Proiect;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("singleton") 	//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ProiectEntityRepositoryImpl implements IProiectEntityRepository {

	private static Logger logger = Logger.getLogger(ProiectEntityRepositoryImpl.class.getName());
	
	public ProiectEntityRepositoryImpl() {
		logger.info(">>> BEAN: ProjectEntityRepositoryCDI instantiated!");
	}
	//
	private Map<Integer, Proiect> entities = new HashMap<>();
	private Integer nextID = 0;
	
	@Override
	public Integer getNextID() {
		nextID++;
		return nextID;
	}

	@Override
	public Proiect getById(Integer id) {
		// TODO Auto-generated method stub
		return entities.get(id);
	}

	@Override
	public Proiect get(Proiect sample) {
		// TODO Auto-generated method stub
		return getById(sample.getIdProiect()); 
	}

	@Override
	public Collection<Proiect> toCollection() {
		// TODO Auto-generated method stub
		List<Proiect> listaProiecte = new ArrayList<>();
		listaProiecte.addAll(this.entities.values());
		return null;
	}

	@Override
	public Proiect add(Proiect entity) {
		// TODO Auto-generated method stub
		if(entity.getIdProiect() == null) {
			nextID++;
			entity.setIdProiect(nextID);
		}
		entities.put(entity.getIdProiect(), entity);
		return entity;
	}

	@Override 
	public Collection<Proiect> addAll(Collection<Proiect> entities) {
		// TODO Auto-generated method stub
		for(Proiect entity: entities) {
			this.add(entity);
		}
		return entities; 
	}

	@Override
	public boolean remove(Proiect entity) {
		// TODO Auto-generated method stub
		if(this.entities.containsValue(entity)) {
			this.entities.remove(entity.getIdProiect());
			return true; 
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<Proiect> entities) {
		// TODO Auto-generated method stub
		Boolean flag = true;
		for(Proiect entity: entities) {
			if(!this.remove(entity))
				flag = false;
		}
		return flag; 
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.entities.values().size();
	}

}
