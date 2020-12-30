package com.avenuecode;

import com.avenuecode.documents.Person;
import com.avenuecode.services.PersonService;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

import org.hamcrest.Matchers;
import org.mockito.Mockito;

@QuarkusTest
@TestHTTPEndpoint(PersonResource.class)
public class PersonResourceTest {

	@InjectMock
	private PersonService personService;
        
    //@Test
    public void shouldCreateAPerson() {
    	String createdId = "5fec8854a746104b65c8db43";
		when(personService.save(any(Person.class))).thenReturn(createdId);

        given()
        	.body("{\n" + 
        			"	\"name\":\"Tito\",\n" +
        			"	\"age\":2\n" +
        		  "}")
        	.when()
				.post("/person")
        	.then()
				.statusCode(201)
             	.header("location", "aaa")
             	.body(is("Hello RESTEasy"));
    }

}