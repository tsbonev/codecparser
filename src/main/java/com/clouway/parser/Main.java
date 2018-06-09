package com.clouway.parser;

import com.google.gson.Gson;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        MessageCodec<ComplexPerson> codec = new JsonCodec<ComplexPerson>(ComplexPerson.class);

        File file;

        if(args.length == 0){
            file = new File("/home/clouway/workspaces/idea/codecparser/src/main/resources/json1.json");
        }
        else {

            file = new File("/home/clouway/workspaces/idea/codecparser/src/main/resources/" + args[0]);
        }


        ComplexPerson person = codec.parseFile(file);
        System.out.println(person.name);

    }

}
