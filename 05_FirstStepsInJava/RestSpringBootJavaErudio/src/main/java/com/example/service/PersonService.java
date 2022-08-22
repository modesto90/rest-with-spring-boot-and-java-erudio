package com.example.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.model.Person;

@Service
public class PersonService {

	private final AtomicLong  counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	public Person FindById(Long id)
	{
		logger.info("Buscando uma pessoa pelo id: " + id);

		Person person = new Person() {};
		
		person.setAddress("Rua andré rocha 1001");
		person.setId(counter.incrementAndGet());
		person.setFirstName("Anderson Modesto");
		person.setLastName("da Luz");
		person.setGender("Masculino");
		
		return person;
	}
	
	
	public Person Create(Person person) {
		logger.info("Criando uma nova pessoa");;
		return person;
	}
	
	public Person Update (Person person) {
		logger.info("Atualizando uma pessoa");;
		return person;
	}
	
	public Long Delete (Long id) {
		logger.info("deletando pessoa com id " + id);;
		return id;
	}
	
	
	public List<Person> FindAll()
	{
		logger.info("Buscando uma lista de pessoas");
		
		List<Person> persons = new ArrayList<Person>();
		
		for (int i = 1; i <= 10; i++) {
			Person person = new Person() {};
			
			person.setAddress("Rua "+ i);
			person.setId(counter.incrementAndGet());
			person.setFirstName("Anderson Modesto" + i);
			person.setLastName("da Luz");
			person.setGender("Masculino");
			persons.add(person);
		}
		return persons;
	}
}
