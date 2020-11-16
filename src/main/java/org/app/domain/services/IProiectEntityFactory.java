package org.app.domain.services;

import org.app.domain.entities.Proiect;



public interface IProiectEntityFactory {

	public Proiect buildSimpleProject (String numeProiect);
	
	public void setProiectEntityRepository(IProiectEntityRepository repository);
	
	public IProiectEntityRepository getProiectEntityRepository();
}
