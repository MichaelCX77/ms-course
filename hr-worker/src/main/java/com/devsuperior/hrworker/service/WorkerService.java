package com.devsuperior.hrworker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;
	
	
	public List<Worker> findAll(){
		
		return repository.findAll();
		
	}
	
	public Worker findById(long id){
		
		return repository.findById(id).get();
		
	}
	
}
