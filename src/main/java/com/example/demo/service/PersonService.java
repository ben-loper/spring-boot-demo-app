package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao")PersonDao personDao){
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.addPerson(person);
    }

    public List<Person> getAllPersons(){
        return personDao.getPersons();
    }

    public int updatePerson(Person person){
        return personDao.updatePerson(person);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public Person getPersonById(UUID id){
        return personDao.getPersonById(id);
    }
}
