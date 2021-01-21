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

import net.example.backend.model.Beneficiu;
import net.example.backend.repository.BeneficiuRepository;

@RestController
@RequestMapping("/api/v1/")
public class BeneficiuController {
	@Autowired
	private BeneficiuRepository beneficiuRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/beneficii")
	public List<Beneficiu> getAllBeneficii(){
		return beneficiuRepository.findAll();
	}

	//create  rest_api
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/beneficii")
	public Beneficiu createBeneficiu(@RequestBody Beneficiu beneficiu) {
		return beneficiuRepository.save(beneficiu);
	}
	
	//get by id rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/beneficii/{id_beneficiu}")
	public ResponseEntity<Beneficiu> getBeneficiuById(@PathVariable Long id_beneficiu) {
		Beneficiu beneficiu= beneficiuRepository.findById(id_beneficiu)
				.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista beneficiu cu id :" + id_beneficiu));
		return ResponseEntity.ok(beneficiu);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/beneficii/{id_beneficiu}")
	public ResponseEntity<Beneficiu> updateBeneficiu(@PathVariable Long id_beneficiu, @RequestBody Beneficiu beneficiuDetalii){
		Beneficiu beneficiu= beneficiuRepository.findById(id_beneficiu)
				.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista beneficiu cu id :" + id_beneficiu));
	
		beneficiu.setDenumireBeneficiu(beneficiuDetalii.getDenumireBeneficiu());
		beneficiu.setDescriereBeneficiu(beneficiuDetalii.getDescriereBeneficiu());
		beneficiu.setIntern(beneficiuDetalii.getIntern());
		beneficiu.setAngajat(beneficiuDetalii.getAngajat());
		Beneficiu updatedBeneficiu=beneficiuRepository.save(beneficiu);
		return ResponseEntity.ok(updatedBeneficiu);

	}
	//delete rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/beneficii/{id_beneficiu}")
	public ResponseEntity<Map<String, Boolean>> deleteBeneficiu(@PathVariable Long id_beneficiu){
		Beneficiu beneficiu= beneficiuRepository.findById(id_beneficiu)
				.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista beneficiu cu id :" + id_beneficiu));			
		beneficiuRepository.delete(beneficiu);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
