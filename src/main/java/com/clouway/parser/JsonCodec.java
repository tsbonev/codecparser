package com.clouway.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonCodec implements MessageCodec {

    private final Class type;

    public JsonCodec(Class type){
        this.type = type;
    }

    private Class getMyType(){
        return this.type;
    }

    @Override
    public Object parseFile(File file)
    {
        GsonBuilder builder = new GsonBuilder();

        Gson gson = builder.create();

        try{
            return gson.fromJson(new FileReader(file), getMyType());
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public File parseObject(Object obj)
    {

        try{
            File file = new File("src/test/resources/parsedJson.json");
            FileWriter writer = new FileWriter(file);
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            gson.toJson(obj, getMyType(), writer);
            writer.flush();
            return file;
        }
        catch (IOException e ){
            e.printStackTrace();
            return null;
        }

    }
}
