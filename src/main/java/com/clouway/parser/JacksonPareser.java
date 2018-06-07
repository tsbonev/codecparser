package com.clouway.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JacksonPareser {


    public static void main(String[] args){

        parseJSON(new File("/home/clouway/workspaces/idea/codecparser/src/main/resources/json1.json"));

    }

    public static void parsePOJO(Object pojo){

        ObjectMapper mapper = new ObjectMapper();

    }

    public static void parseJSON(File json){

        ObjectMapper mapper = new ObjectMapper();

        try{
            JsonNode rootNode = mapper.readTree(json);
            Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.fields();

            while (fieldsIterator.hasNext()){
                Map.Entry<String, JsonNode> field = fieldsIterator.next();
                System.out.println(field.getKey() + "\n" + field.getValue());
            }

        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }



}
