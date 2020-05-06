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
            for(Person savedPerson : DB){
                if(savedPerson.equals(person)){
                    savedPerson.setName(person.getName());
                    result = 1;
                    break;
                }
            }
        }

        return result;
    }
}
