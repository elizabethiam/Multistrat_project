package net.example.backend.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import net.example.backend.repository.TaskRepository;

public class TaskService {
	private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
	
	@Autowired
    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }
	
	public Object getTaskById (long id){
        return taskRepository.findById(id);
    }
}
