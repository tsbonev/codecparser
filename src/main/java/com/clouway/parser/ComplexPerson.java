package com.clouway.parser;

import com.google.gson.annotations.SerializedName;

import java.util.*;

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
