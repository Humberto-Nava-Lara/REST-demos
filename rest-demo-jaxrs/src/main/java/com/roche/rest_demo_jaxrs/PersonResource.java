package com.roche.rest_demo_jaxrs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("persons")

public class PersonResource {
	
	PersonRepository personRepository = new PersonRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Person> getPersons() {
		
		return personRepository.getPersons();
	}
	
	@GET
	@Path("person/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Person getPerson(@PathParam("id") int id) {
		
		return personRepository.getPerson(id);
	}
	
	@POST
	@Path("person")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Person createPerson(Person person) {
		System.out.println(person);
		personRepository.create(person);
		return person;
	}
	
	@PUT
	@Path("person")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Person updatePerson(Person person) {
		System.out.println(person);
		if(personRepository.getPerson(person.getId()).getId() == 0) {
			personRepository.create(person);
		}else {
			personRepository.update(person);
		}
		return person;
	}
	
	@DELETE
	@Path("person/{id}")
	public Person deletePerson(@PathParam("id") int id) {
		
		Person person = personRepository.getPerson(id);
		
		if(person.getId() != 0) {
			personRepository.delete(id);
		}
		return person;
	}
}
