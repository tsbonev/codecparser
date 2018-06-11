package com.clouway.parser;

import java.io.File;
import com.clouway.parser.JsonCodec;
import com.clouway.parser.ComplexPerson;
import com.google.gson.*;

public class Main {

    public static void main(String[] args) {

        String filePath = "src/main/resources/" + "json1" + ".json";

        MessageCodec codec = new JsonCodec(ComplexPerson.class);

        File file = new File(filePath);


        ComplexPerson person = (ComplexPerson) codec.parseFile(file);

        System.out.println(person.name);

    }

}
