package com.avenuecode.services;

import com.avenuecode.documents.Person;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PersonService {

    public String save(Person p){
        p.persist();
        return p.id.toString();
    }

    public List<Person> allPersons(){
       return Person.listAll();
    }

    public Person findById(String id){
        return Person.findByIdString(id);
    }
}
