package com.clouway.parser;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;

public class JsonParserTest {

    @Test
    public void parseJsonFile(){

        MessageCodec<Person> codec = new JsonCodec<Person>(Person.class);
        File file = new File("/home/clouway/workspaces/idea/codecparser/src/test/resources/json2.json");

        assertThat(codec.parseFile(file).name, is("John"));
        assertThat(codec.parseFile(file).age, is(20));

    }

    @Test
    public void parseObjectToFile() {

        MessageCodec<Person> codec = new JsonCodec<Person>(Person.class);

        Person person = new Person();
        person.name = "John";
        person.age = 20;

        codec.parseObject(person);

        File file = new File("/home/clouway/workspaces/idea/codecparser/src/test/resources/json3.json");

        assertThat(file, is(notNullValue()));
        assertThat(codec.parseFile(file).age, is(20));
        assertThat(codec.parseFile(file).name, is("John"));
    }

    public class Person{
        public String name;
        public int age;
    }

}
