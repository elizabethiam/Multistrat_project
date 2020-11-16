package org.app.domain.services;

import java.util.List;

import org.app.domain.entities.Proiect;
import org.app.domain.entities.Task;


public interface IProiectDomainService {
	public List<Task> getProiectTaskuri(Proiect proiect);
	public Integer getProiectTaskuriCount(Proiect proiect);
	
	public List<Task> getProiectTaskuri(Integer proiectID);
	public Integer getProiectTaskuriCount(Integer proiectID);
	
	public Task getProiectTask(Proiect proiect, String TaskName);
	
	// Dependencies to get IDs
	public void setProiectEntityRepository(IProiectEntityRepository repository);
}
