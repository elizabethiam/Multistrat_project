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

import net.example.backend.model.Angajat;
import net.example.backend.repository.AngajatRepository;


@RestController
@RequestMapping("/api/v1/")

public class AngajatController {

	@Autowired
	private AngajatRepository angajatRepository;
	
	//get all angajati
	
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/angajati")
		public List<Angajat> getAllAngajati(){
			return angajatRepository.findAll();
		}
		

		//create employee rest_api
		@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping("/angajati")
		public Angajat createAngajat(@RequestBody Angajat angajat) {
			return angajatRepository.save(angajat);
		}
		
		//get employee by id rest api
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/angajati/{id_angajat}")
		public ResponseEntity<Angajat> getAngajatById(@PathVariable Long id_angajat) {
			Angajat angajat= angajatRepository.findById(id_angajat)
					.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista angajat cu id :" + id_angajat));
			return ResponseEntity.ok(angajat);
		}
		
		//update employee rest api
		@CrossOrigin(origins = "http://localhost:4200")
		@PutMapping("/angajati/{id_angajat}")
		public ResponseEntity<Angajat> updateAngajat(@PathVariable Long id_angajat,@RequestBody Angajat angajatDetalii){
			Angajat angajat= angajatRepository.findById(id_angajat)
					.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista angajat cu id :" + id_angajat));
			angajat.setNumeAngajat(angajatDetalii.getNumeAngajat());
			angajat.setPrenumeAngajat(angajatDetalii.getPrenumeAngajat());
			angajat.setCnpAngajat(angajatDetalii.getCnpAngajat());
			angajat.setEmailAngajat(angajatDetalii.getEmailAngajat());
			angajat.setTelefonAngajat(angajatDetalii.getTelefonAngajat());
			angajat.setDepartamentAngajat(angajatDetalii.getDepartamentAngajat());
			angajat.setIntern(angajatDetalii.getIntern());
			angajat.setBeneficiu(angajatDetalii.getBeneficiu());
			angajat.setInternship(angajatDetalii.getInternship());
			
			Angajat updatedAngajat=angajatRepository.save(angajat);
			return ResponseEntity.ok(updatedAngajat);
			
		}
		
		//delete employee rest api
		@CrossOrigin(origins = "http://localhost:4200")
		@DeleteMapping("/angajati/{id_angajat}")
		public ResponseEntity<Map<String, Boolean>> deleteAngajat(@PathVariable Long id_angajat){
			Angajat angajat= angajatRepository.findById(id_angajat)
					.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista angajat cu id :" + id_angajat));			
			angajatRepository.delete(angajat);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
