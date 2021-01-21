package net.example.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.example.backend.model.Intern;
import net.example.backend.model.Internship;
import net.example.backend.repository.InternRepository;

@RestController
@RequestMapping("/api/v1/")

public class InternController {
	@Autowired
	private InternRepository internRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/interni")
	public List<Intern> getAllInterni(){
		return internRepository.findAll();
	}
	

	//create  rest_api
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/interni")
	public Intern createIntern(@RequestBody Intern intern) {
		return internRepository.save(intern);
	}
	
	//get  by id rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/interni/{id_intern}")
	public ResponseEntity<Intern> getInternById(@PathVariable Long id_intern) {
		Intern intern= internRepository.findById(id_intern)
				.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista intern cu id :" + id_intern));
		return ResponseEntity.ok(intern);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/interni/{id_intern}")
	public ResponseEntity<Intern> updateIntern(@PathVariable Long id_intern,@RequestBody Intern internDetalii){
		Intern intern= internRepository.findById(id_intern)
				.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista intern cu id :" + id_intern));			

		intern.setNumeIntern(internDetalii.getNumeIntern());
		intern.setPrenumeIntern(internDetalii.getPrenumeIntern());
		intern.setCnpIntern(internDetalii.getCnpIntern());
		intern.setEmailIntern(internDetalii.getEmailIntern());
		intern.setTelefonIntern(internDetalii.getTelefonIntern());
		intern.setAngajat(internDetalii.getAngajat());
		intern.setInternship(internDetalii.getInternship());
		
		Intern updatedIntern=internRepository.save(intern);
		return ResponseEntity.ok(updatedIntern);

	}
	
	//delete rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/interni/{id_intern}")
	public ResponseEntity<Map<String, Boolean>> deleteIntern(@PathVariable Long id_intern){
		Intern intern= internRepository.findById(id_intern)
				.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista intern cu id :" + id_intern));			
		internRepository.delete(intern);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
