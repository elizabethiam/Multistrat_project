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
import net.example.backend.model.Task;
import net.example.backend.repository.TaskRepository;

@RestController
@RequestMapping("/api/v1/")

public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/tasks")
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	

	//create  rest_api
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/tasks")
	public Task createTask(@RequestBody Task task) {
		return taskRepository.save(task);
	}
	
	//get by id rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/tasks/{id_task}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long id_task) {
		Task task= taskRepository.findById(id_task)
				.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista task cu id :" + id_task));
		return ResponseEntity.ok(task);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/tasks/{id_task}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id_task, @RequestBody Task taskDetalii){
		Task task= taskRepository.findById(id_task)
				.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista intern cu id :" + id_task));			

		task.setDenumireTask(taskDetalii.getDenumireTask());
		task.setDescriereTask(taskDetalii.getDescriereTask());
		task.setIntern(taskDetalii.getIntern());
		
		Task updatedTask=taskRepository.save(task);
		return ResponseEntity.ok(updatedTask);

	}
	
	//delete rest api
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/tasks/{id_task}")
	public ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable Long id_task){
		Task task= taskRepository.findById(id_task)
				.orElseThrow(() -> new net.example.backend.exception.ResourceNotFoundException("Nu exista task cu id :" + id_task));			
		taskRepository.delete(task);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
