package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.service.PersonService;

@RestController
@RequestMapping("/person/")
public class PersonController {


	@Autowired
	private PersonService personService;

	@RequestMapping(value = "{id}", 
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(
			@PathVariable(value = "id") Long id) throws Exception
	{
		return personService.FindById(id);
	}


	@RequestMapping(value = "FindAll", 
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> FindAll() throws Exception
	{
		return personService.FindAll();
	}
	
	@RequestMapping(value = "Create", 
			method=RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person Create(
			@RequestBody Person person
			) throws Exception
	{
		return personService.Create(person);
	}
	
	@RequestMapping(value = "Upate", 
			method=RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person Update(
			@RequestBody Person person
			) throws Exception
	{
		return personService.Update(person);
	}
	
	@RequestMapping(value = "Delete/{id}", 
			method=RequestMethod.DELETE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Long Delete(
			@PathVariable(value = "id") Long id 
			) throws Exception
	{
	    return personService.Delete(id);
	}
}

