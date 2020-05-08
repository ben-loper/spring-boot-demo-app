package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person  person){
        personService.addPerson(person);
    }

    // api/v1/person/list
    @RequestMapping("list")
    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping
    public Person getPersonById(@RequestParam UUID id, HttpServletResponse response){
        Person person = personService.getPersonById(id);

        if(person == null){
            response.setStatus(404);
        }

        return person;
    }

    @PutMapping
    public void updatePerson(@RequestBody Person  person, HttpServletResponse response){
        int result = personService.updatePerson(person);

        if(result == 0){
            response.setStatus(404);
        }
    }

    @DeleteMapping
    public void deletePerson(@RequestParam UUID id, HttpServletResponse response){
        int result = personService.deletePerson(id);

        if(result == 0){
            response.setStatus(404);
        }
    }
}
