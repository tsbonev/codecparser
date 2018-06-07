package com.clouway.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonCodec<T> implements MessageCodec<T> {

    private final Class<T> type;

    public JsonCodec(Class<T> type){
        this.type = type;
    }

    public Class<T> getMyType(){
        return this.type;
    }

    public T parseFile(File file)
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

    public File parseObject(T obj)
    {

        try{
            File file = new File("/home/clouway/workspaces/idea/codecparser/src/test/resources/json3.json");
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
