package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.VO.PersonVO;
import com.example.model.Person;
import com.example.service.PersonService;

@RestController
@RequestMapping("/person/")
public class PersonController {


	@Autowired
	private PersonService personService;

	@GetMapping(value = "{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO findById(
			@PathVariable(value = "id") Long id)
	{
		return personService.findById(id);
	}


	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll()
	{
		return personService.findAll();
	}
	

	@PostMapping(value = "Create", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonVO> create(
			@RequestBody PersonVO personVO
			)
	{
		var p = personService.create(personVO);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "Upate", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonVO> update(
			@RequestBody PersonVO personVO
			)
	{
		var entity = personService.update(personVO);
		return new ResponseEntity<>(entity, HttpStatus.CREATED);

	}
	
	@DeleteMapping(value = "Delete/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> delete(
			@PathVariable(value = "id") Long id 
			)
	{
		personService.delete(id);
	    return ResponseEntity
	    		.noContent()
	    		.build();
	}
}

