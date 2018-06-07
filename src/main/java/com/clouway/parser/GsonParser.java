package com.clouway.parser;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GsonParser {


    public static void main(String[] args){
        Albums albums = new Albums();
        albums.title = "Free Music Archive - Albums";
        albums.message = "";
        albums.total = "11259";
        albums.total_pages = 2252;
        albums.page = 1;
        albums.limit = "5";


        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting().serializeNulls();
        builder.setFieldNamingStrategy(new FieldNamingStrategy() {
            public String translateName(Field f) {
                if (f.getName().equals("albumId"))
                    return "album_id";
                else
                    return f.getName();
            }
        });

        Gson gson = builder.create();

        AlbumImages image = new AlbumImages();
        image.image_id = "1";
        System.out.println(gson.toJson(image));

        System.out.println("---------");

        Dataset dataset = new Dataset();
        dataset.albumId = "7596";
        dataset.album_title = "Album 1";
        System.out.println(gson.toJson(dataset));

        dataset.images.add(image);
        albums.dataset.add(dataset);

        System.out.println("---------");

        System.out.println(gson.toJson(albums));

    }

    static class Albums {
        public String title;
        public String message;
        public List<String> errors = new ArrayList<String>();
        public String total;
        public int total_pages;
        public int page;
        public String limit;
        List<Dataset> dataset  = new ArrayList<Dataset>();
    }

    static class Dataset {
        public String albumId;
        public String album_title;
        @SerializedName("album_images")
        List<AlbumImages> images = new ArrayList<AlbumImages>();
    }

    static class AlbumImages {
        public String image_id;
        public String user_id;
    }

}
