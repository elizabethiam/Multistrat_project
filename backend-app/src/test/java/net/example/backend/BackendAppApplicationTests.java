package net.example.backend;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.example.backend.model.Angajat;
import net.example.backend.model.Beneficiu;
import net.example.backend.model.Intern;
import net.example.backend.model.Internship;
import net.example.backend.model.Task;
import net.example.backend.repository.AngajatRepository;
import net.example.backend.repository.BeneficiuRepository;
import net.example.backend.repository.InternRepository;
import net.example.backend.repository.InternshipRepository;
import net.example.backend.repository.TaskRepository;
import net.example.backend.service.AngajatService;
import net.example.backend.service.BeneficiuService;
import net.example.backend.service.InternService;
import net.example.backend.service.InternshipService;
import net.example.backend.service.TaskService;

@SpringBootTest
@RunWith(SpringRunner.class)
class BackendAppApplicationTests {

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	private InternService internService;
	@MockBean
	private AngajatService angajatService;
	@MockBean
	private TaskService taskService;
	@MockBean
	private BeneficiuService beneficiuService;
	@MockBean
	private InternshipService internshipService;
	
	@MockBean
	private InternRepository internRepository;
	@MockBean
	private AngajatRepository angajatRepository;
	@MockBean
	private TaskRepository taskRepository;
	@MockBean
	private BeneficiuRepository beneficiuRepository;
	@MockBean
	private InternshipRepository internshipRepository;
	@Test
	void retrieveIntern() throws Exception {
		Intern intern = new Intern(1, "Test", "Intern","3002005004754");
		Mockito.when(internService.getInternById(Mockito.anyLong())).
				thenReturn(intern);

		Intern found = (Intern) internService.getInternById(1);

		Intern expected = objectMapper.readValue(new File("src/test/java/net/example/backend/intern.json"), Intern.class);

		assertEquals(expected.getNumeIntern(), found.getNumeIntern());
		assertEquals(expected.getPrenumeIntern(), found.getPrenumeIntern());
		assertEquals(expected.getCnpIntern(), found.getCnpIntern());
	}
	
	@Test
	void retrieveAngajat() throws Exception {
		Angajat angajat = new Angajat(1, "Test", "Angajat","3002005564754");
		Mockito.when(angajatService.getAngajatById(Mockito.anyLong())).
				thenReturn(angajat);

		Angajat found = (Angajat) angajatService.getAngajatById(1);

		Angajat expected = objectMapper.readValue(new File("src/test/java/net/example/backend/angajat.json"), Angajat.class);

		assertEquals(expected.getNumeAngajat(), found.getNumeAngajat());
		assertEquals(expected.getPrenumeAngajat(), found.getPrenumeAngajat());
		assertEquals(expected.getCnpAngajat(), found.getCnpAngajat());
	}
	
	@Test
	void retrieveTask() throws Exception {
		Task task = new Task(1, "Test", "Task");
		Mockito.when(taskService.getTaskById(Mockito.anyLong())).
				thenReturn(task);

		Task found = (Task) taskService.getTaskById(1);

		Task expected = objectMapper.readValue(new File("src/test/java/net/example/backend/task.json"), Task.class);

		assertEquals(expected.getDenumireTask(), found.getDenumireTask());
		assertEquals(expected.getDescriereTask(), found.getDescriereTask());
	}
	
	@Test
	void retrieveBeneficiu() throws Exception {
		Beneficiu beneficiu= new Beneficiu(1, "Test", "Beneficiu");
		Mockito.when(beneficiuService.getBeneficiuById(Mockito.anyLong())).
				thenReturn(beneficiu);

		Beneficiu found = (Beneficiu) beneficiuService.getBeneficiuById(1);

		Beneficiu expected = objectMapper.readValue(new File("src/test/java/net/example/backend/beneficiu.json"), Beneficiu.class);

		assertEquals(expected.getDenumireBeneficiu(), found.getDenumireBeneficiu());
		assertEquals(expected.getDescriereBeneficiu(), found.getDescriereBeneficiu());
	}

	@Test
	void retrieveInternship() throws Exception {
		Internship internship = new Internship(1, "Test", "Internship");
		Mockito.when(internshipService.getInternshipById(Mockito.anyLong())).
				thenReturn(internship);

		Internship found = (Internship) internshipService.getInternshipById(1);

		Internship expected = objectMapper.readValue(new File("src/test/java/net/example/backend/internship.json"), Internship.class);

		assertEquals(expected.getDenumireInternship(), found.getDenumireInternship());
		assertEquals(expected.getDescriereInternship(), found.getDescriereInternship());

	}
}
