package com.example.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.VO.PersonVO;
import com.example.mapper.DozerMapper;
import com.example.model.Person;
import com.example.repositories.PersonRepository;
import com.example.responses.NotFoundResponseStatus;

@Service
public class PersonService {

	private final AtomicLong  counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonService.class.getName());

	@Autowired
	private PersonRepository personRepository;

	public PersonVO findById(Long id)
	{
		logger.info("Buscando uma pessoa pelo id: " + id);

		Person person = personRepository.findById(id).
				orElseThrow(() ->
				new NotFoundResponseStatus("pessoa não encontrada") );

		return DozerMapper.parseObject(person, PersonVO.class);
	}


	public PersonVO create(PersonVO personVO) {
		logger.info("Criando uma nova pessoa");
		var person = DozerMapper.parseObject(personVO, Person.class);
		return DozerMapper.parseObject(personRepository.save(person), PersonVO.class);
	}

	public PersonVO update (PersonVO personVO) {
		logger.info("Atualizando uma pessoa");

		Person p = personRepository.findById(personVO.getId()).
				orElseThrow(() ->
				new NotFoundResponseStatus("pessoa não encontrada"));

		p.setFirstName(personVO.getFirstName());
		p.setAddress(personVO.getAddress());
		p.setGender(personVO.getGender());
		p.setLastName(personVO.getLastName());

		return DozerMapper.parseObject(personRepository.save(p), PersonVO.class);
	}

	public void delete (Long id) {
		logger.info("deletando pessoa com id " + id);
		
		Person p = personRepository.findById(id).
				orElseThrow(() ->
				new NotFoundResponseStatus("pessoa não encontrada"));
		
				personRepository.delete(p);

	}


	public List<PersonVO> findAll()
	{
		logger.info("Buscando uma lista de pessoas");
		List<Person> persons = personRepository.findAll();
		return DozerMapper.parseListObject(persons, PersonVO.class);
	}
}
