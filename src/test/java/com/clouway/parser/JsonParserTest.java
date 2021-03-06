package com.clouway.parser;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;

public class JsonParserTest {


    ComplexPerson complexPerson;
    Person person;
    MessageCodec codec;

    @Before
    public void init(){

        codec = new JsonCodec(Person.class);

        person = new Person();
        person.name = "John";
        person.age = 20;

        complexPerson = new ComplexPerson();
        person.name = "Ann";
        person.age = 20;

        ComplexPerson.phoneNumber phoneNumber = new ComplexPerson.phoneNumber();
        phoneNumber.type = "home";
        phoneNumber.number = "555-555";

        ComplexPerson.address address = new ComplexPerson.address();

        address.city = "New York";
        address.streetAddress = "Main str";

        complexPerson.phoneNumber.add(phoneNumber);
        complexPerson.address = address;

    }

    @Test
    public void parseJsonFile(){

        File file = new File("src/test/resources/json2.json");

        person = (Person) codec.parseFile(file);

        assertThat(person.name, is("John"));
        assertThat(person.age, is(20));

    }

    @Test
    public void parseObjectToFile() {

        codec.parseObject(person);

        File file = new File("src/test/resources/parsedJson.json");

        Person parsedPerson = (Person) codec.parseFile(file);

        assertThat(file, is(notNullValue()));
        assertThat(parsedPerson.age, is(20));
        assertThat(parsedPerson.name, is("Ann"));
    }

    @Test
    public void parseComplexFromFile(){


        codec = new JsonCodec(ComplexPerson.class);

        File file = new File("src/main/resources/json1.json");

        ComplexPerson person = (ComplexPerson) codec.parseFile(file);

        assertThat(person.phoneNumber.get(0).type, is("home"));


    }

    @Test
    public void parseComplexJsonToObject(){

        MessageCodec codec = new JsonCodec(ComplexPerson.class);

        File file = codec.parseObject(complexPerson);

        assertThat(file.exists(), is(true));

    }

    @Test
    public void flipFileToObjectAndBack(){

        MessageCodec codec = new JsonCodec(ComplexPerson.class);



        codec.parseObject(complexPerson);

        File file = new File("src/test/resources/parsedJson.json");

        ComplexPerson secondPerson = (ComplexPerson) codec.parseFile(file);

        assertThat(complexPerson.name, is(secondPerson.name));
        assertThat(complexPerson.phoneNumber.get(0).number, is(secondPerson.phoneNumber.get(0).number));

    }

    @Test
    public void bigJsonFileToObj(){

        People people;

        MessageCodec codec = new JsonCodec(People.class);

        File file = new File("src/main/resources/json2.json");

        people = (People) codec.parseFile(file);

        assertThat(people.people.size(), is(80));

    }

    public class People{
        List<ComplexPerson> people = new ArrayList<ComplexPerson>();
    }


    public class Person{
        public String name;
        public int age;
    }

}
