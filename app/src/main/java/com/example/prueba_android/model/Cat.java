package com.example.prueba_android.model;


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
}