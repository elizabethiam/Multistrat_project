package org.app.domain.services;

import java.util.Collection;

import org.app.domain.entities.Proiect;



public interface IProiectEntityRepository {

	public Integer getNextID();
	
	public Proiect getById(Integer id);
	public Proiect get(Proiect sample);
	
	public Collection<Proiect> toCollection(); // getAll
	 
	//
	public Proiect add(Proiect entity);
	public Collection<Proiect> addAll(Collection<Proiect> entities);
	public boolean remove(Proiect entity);
	public boolean removeAll(Collection<Proiect> entities);	
	
	//
	public int size();
}
