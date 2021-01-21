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
import net.example.backend.model.Internship;
import net.example.backend.repository.InternshipRepository;

@RestController
@RequestMapping("/api/v1/")
public class InternshipController {

	@Autowired
	private InternshipRepository internshipRepository;
	@Autowired
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/internships")
	public List<Internship> getAllInternships(){
		return internshipRepository.findAll();
	}
	

	//create  rest_api
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/internships")
	public Internship createInternship(@RequestBody Internship internship) {
		return internshipRepository.save(internship);
	}
	
	//get by id rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/internships/{id_internship}")
	public ResponseEntity<Internship> getInternshipById(@PathVariable Long id_internship) {
		Internship internship= internshipRepository.findById(id_internship)
				.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista internship cu id :" + id_internship));
		return ResponseEntity.ok(internship);
	}
	
			//update rest api
			@CrossOrigin(origins = "http://localhost:4200")
			@PutMapping("/internships/{id_internship}")
			public ResponseEntity<Internship> updateInternship(@PathVariable Long id_internship,@RequestBody Internship internshipDetalii){
				Internship internship= internshipRepository.findById(id_internship)
						.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista internship cu id :" + id_internship));			
		
				internship.setDenumireInternship(internshipDetalii.getDenumireInternship());
				internship.setDescriereInternship(internshipDetalii.getDescriereInternship());
				internship.setDataInceputInternship(internshipDetalii.getDataInceputInternship());
				internship.setDataSfarsitInternship(internshipDetalii.getDataSfarsitInternship());
				internship.setAngajat(internshipDetalii.getAngajat());
				
				Internship updatedInternship=internshipRepository.save(internship);
				return ResponseEntity.ok(updatedInternship);
		
			}
			//delete rest api
			@CrossOrigin(origins = "http://localhost:4200")
			@DeleteMapping("/internships/{id_internship}")
			public ResponseEntity<Map<String, Boolean>> deleteInternship(@PathVariable Long id_internship){
				Internship internship= internshipRepository.findById(id_internship)
						.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista internship cu id :" + id_internship));			
				internshipRepository.delete(internship);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}

}
