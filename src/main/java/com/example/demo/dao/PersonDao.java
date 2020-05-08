package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int addPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    Person getPersonById(UUID id);

    List<Person> getPersons();

    int updatePerson(Person person);

    int deletePersonById(UUID id);
}
