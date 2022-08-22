package com.example.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Person;
import com.example.repositories.PersonRepository;
import com.example.responses.NotFoundResponseStatus;

@Service
public class PersonService {

	private final AtomicLong  counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	private PersonRepository personRepository;
	
	public Person FindById(Long id)
	{
		logger.info("Buscando uma pessoa pelo id: " + id);

		return personRepository.findById(id).orElseThrow(() -> new NotFoundResponseStatus("pessoa não encontrada") );
	}
	
	
	public Person Create(Person person) {
		logger.info("Criando uma nova pessoa");;
		return personRepository.save(person);
	}
	
	public Person Update (Person person) {
		logger.info("Atualizando uma pessoa");
		
		Person p = FindById(person.getId());
		p.setFirstName(person.getFirstName());
		p.setAddress(person.getAddress());
		p.setGender(p.getGender());
		p.setLastName(p.getLastName());
		
		return personRepository.save(p);
	}
	
	public Long Delete (Long id) {
		logger.info("deletando pessoa com id " + id);
		
		Person p = FindById(id);
		
		personRepository.delete(p);
		return id;
		
	}
	
	
	public List<Person> FindAll()
	{
		logger.info("Buscando uma lista de pessoas");
				
		return personRepository.findAll();
		
	}
}
