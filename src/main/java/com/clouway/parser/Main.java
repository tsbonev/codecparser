package com.clouway.parser;

import java.io.File;
import com.clouway.parser.JsonCodec;
import com.clouway.parser.ComplexPerson;
import com.google.gson.*;

public class Main {

    public static void main(String[] args) {

        String filePath = "src/main/resources/" + args[0] + ".json";

        MessageCodec<ComplexPerson> codec = new JsonCodec<ComplexPerson>(ComplexPerson.class);

        File file = new File(filePath);


        ComplexPerson person = codec.parseFile(file);
        System.out.println(person.name);

    }

}
