package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    @JsonProperty("id")
    private final UUID Id;

    @JsonProperty("name")
    private String Name;

    public Person(UUID id, String name) {
        Id = id;
        Name = name;
    }

    public UUID getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public boolean equals(Object o){
        boolean result = false;

        if(o instanceof Person){
            Person person = (Person) o;
            result = this.getId().equals(person.getId());
        }

        return result;
    }
}
