package net.example.backend.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import net.example.backend.repository.InternRepository;
import net.example.backend.repository.InternshipRepository;

public class InternshipService {
	private final InternshipRepository internshipRepository;
    private final ModelMapper modelMapper;
	
	@Autowired
    public InternshipService(InternshipRepository internshipRepository, ModelMapper modelMapper) {
        this.internshipRepository = internshipRepository;
        this.modelMapper = modelMapper;
    }
	
	public Object getInternshipById (long id){
        return internshipRepository.findById(id);
    }

}
