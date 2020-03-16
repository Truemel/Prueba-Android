package com.example.prueba_android.model;


import java.util.Arrays;

public class Cat {

    public String id, url;
    public int height, width;
    public Categorie[] categories;
    public Breed[] breeds;

    public Cat(){

    }

    public static class Categorie{
        public int id;
        public String name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", categories=" + Arrays.toString(categories) +
                ", breeds=" + Arrays.toString(breeds) +
                '}';
    }
}