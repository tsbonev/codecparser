package com.clouway.parser;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        String filePath = "src/main/resources/" + args[0] + ".json";

        MessageCodec codec = new JsonCodec(ComplexPerson.class);

        File file = new File(filePath);


        ComplexPerson person = (ComplexPerson) codec.parseFile(file);

        System.out.println(person.name);

    }

}
