package net.example.backend.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import net.example.backend.repository.AngajatRepository;

public class AngajatService {
	private final AngajatRepository angajatRepository;
    private final ModelMapper modelMapper;
	
	@Autowired
    public AngajatService(AngajatRepository angajatRepository, ModelMapper modelMapper) {
        this.angajatRepository = angajatRepository;
        this.modelMapper = modelMapper;
    }
	
	public Object getAngajatById (long id){
        return angajatRepository.findById(id);
    }
}
