package net.example.backend.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import net.example.backend.repository.InternRepository;

public class InternService {
	private final InternRepository internRepository;
    private final ModelMapper modelMapper;
	
	@Autowired
    public InternService(InternRepository internRepository, ModelMapper modelMapper) {
        this.internRepository = internRepository;
        this.modelMapper = modelMapper;
    }
	
	public Object getInternById (long id){
        return internRepository.findById(id);
    }
}
