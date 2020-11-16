package org.app.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.app.domain.entities.Cerinta;
import org.app.domain.entities.Proiect;
import org.app.domain.entities.Task;
import org.springframework.stereotype.Component;

//SDI Bean Component  
@Component
public class ProiectDomainServiceImpl implements IProiectDomainService {
	
	@Override
	public List<Task> getProiectTaskuri(Proiect proiect) {
		List<Task> proiectTaskuri = new ArrayList<>();
		for (Cerinta c : proiect.getCerinte())
			proiectTaskuri.addAll(c.getTaskuri());
		return proiectTaskuri;
	}
	
	
	@Override
	public Integer getProiectTaskuriCount(Proiect proiect) {
		List<Task> proiectTaskuri = getProiectTaskuri(proiect);
		return proiectTaskuri.size();
	}

	@Override
	public List<Task> getProiectTaskuri(Integer proiectID) {
		Proiect proiect = entityRepository.getById(proiectID);
		return getProiectTaskuri(proiect);
	}

	@Override
	public Integer getProiectTaskuriCount(Integer proiectID) {
		Proiect proiect = entityRepository.getById(proiectID);
		return getProiectTaskuriCount(proiect);
	}
	
	// Dependency
//	@Autowired
	private IProiectEntityRepository entityRepository;

	@Override
	public void setProiectEntityRepository(IProiectEntityRepository repository) {
		this.entityRepository = repository;
		
	}
	
	public ProiectDomainServiceImpl() {
		super();
	}
//	@Autowired
	public ProiectDomainServiceImpl(IProiectEntityRepository entityRepository) {
		super();
		this.entityRepository = entityRepository;
	}

	
	@Override
	public Task getProiectTask(Proiect proiect, String TaskName) {
		List<Task> proiectTaskuri = getProiectTaskuri(proiect);
		List<Task> taskuri = proiectTaskuri.stream().filter(f -> f.getDenumireTask().equals(TaskName)).collect(Collectors.toList());
		if (taskuri.size() > 0)
			return taskuri.get(0);
		
		return null;
	}
}
