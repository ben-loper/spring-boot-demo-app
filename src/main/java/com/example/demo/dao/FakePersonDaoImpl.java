package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDaoImpl implements PersonDao{

    private static List<Person> DB = new ArrayList<Person>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public Person getPersonById(UUID id) {
        return findPerson(new Person(id, ""));
    }

    @Override
    public List<Person> getPersons() {

        List<Person> copiedList = new ArrayList<>();

        for(Person person : DB){
            copiedList.add(new Person(person.getId(), person.getName()));
        }

        return copiedList;
    }

    @Override
    public int updatePerson(Person person) {
        int result = 0;

        if(person.getId() != null){

            Person dbPerson = findPerson(person);

            if(dbPerson != null){
                dbPerson.setName(person.getName());
                result = 1;
            }
        }

        return result;
    }

    @Override
    public int deletePersonById(UUID id) {
        int result = 0;

        if(id != null){
            result  = DB.removeIf(person -> person.getId().equals(id)) ? 1 : 0;
        }

        return result;
    }


    private Person findPerson(Person person){
        return DB.stream()
                .filter(person::equals)
                .findAny()
                .orElse(null);
    }
}
