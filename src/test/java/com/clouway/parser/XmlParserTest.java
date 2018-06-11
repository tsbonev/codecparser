package com.clouway.parser;

import org.junit.Before;
import org.junit.Test;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class XmlParserTest {

    MessageCodec codec;

    ComplexPerson person;

    @Before
    public void init(){

        codec = new XmlCodec(ComplexPerson.class);

        person = new ComplexPerson();
        person.name = "Ann";
        person.age = 20;

        ComplexPerson.phoneNumber phoneNumber = new ComplexPerson.phoneNumber();
        phoneNumber.type = "home";
        phoneNumber.number = "555-555";

        ComplexPerson.address address = new ComplexPerson.address();

        address.city = "New York";
        address.streetAddress = "Main str";

        person.phoneNumber.add(phoneNumber);
        person.address = address;
    }

    @Test
    public void passObjectToXml(){

        File file = codec.parseObject(person);

        assertThat(file.exists(), is(true));

    }

    @Test
    public void passXmlToObject(){

        File file = codec.parseObject(person);

        ComplexPerson parsedPerson = (ComplexPerson) codec.parseFile(file);

        assertThat(parsedPerson.name, is("Ann"));
    }

    @Test
    public void parseBigPOJOToXMLAndViceVersa(){

        codec = new XmlCodec(ComplexPersonList.class);

        ComplexPersonList list = new ComplexPersonList();


        for(int i = 0; i < 500; i++){
            list.ComplexPerson.add(person);
        }

        File file = codec.parseObject(list);

        ComplexPersonList newList = (ComplexPersonList) codec.parseFile(file);


        assertThat(newList.ComplexPerson.size(), is(500));

    }


    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class ComplexPersonList{
        List<ComplexPerson> ComplexPerson = new ArrayList<>();
    }

}
