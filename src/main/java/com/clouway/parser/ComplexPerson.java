package com.clouway.parser;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ComplexPerson{

    public String name;
    public int age;

    public List<phoneNumber> phoneNumber = new ArrayList<phoneNumber>();
    public address address;

    public static class phoneNumber {
        public String type;
        public String number;
    }

    public static class address {
        public String city;
        public String streetAddress;
    }

}
