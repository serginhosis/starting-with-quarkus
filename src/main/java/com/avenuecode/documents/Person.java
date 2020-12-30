package com.avenuecode.documents;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.smallrye.common.constraint.NotNull;
import org.bson.types.ObjectId;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Person extends PanacheMongoEntity {
  //  @NotBlank
    private String name;
   // @Min(1)
    private int age;

    public Person(){}

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Person findByIdString(String id){
        return Person.findById(new ObjectId(id));
    }
}
