package net.example.backend.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import net.example.backend.repository.BeneficiuRepository;

public class BeneficiuService {
	private final BeneficiuRepository beneficiuRepository;
    private final ModelMapper modelMapper;
	
	@Autowired
    public BeneficiuService(BeneficiuRepository beneficiuRepository, ModelMapper modelMapper) {
        this.beneficiuRepository = beneficiuRepository;
        this.modelMapper = modelMapper;
    }
	
	public Object getBeneficiuById (long id){
        return beneficiuRepository.findById(id);
    }

}
