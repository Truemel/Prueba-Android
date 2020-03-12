package com.example.prueba_android.model;

import com.google.gson.annotations.SerializedName;

public class Cat {

    public String id, url;
    public int height, width;
    public Categorie[] categories;
    public Breed[] breeds;

    public Cat(){

    }

    public class Categorie{
        public int id;
        public String name;
    }

    public class Breed{
        public String id, name, temperament, origin;
        public int experimental, hairless, natural, rare, rex, hypoallergenic, adaptability, grooming, intelligence, vocalisation;

        @SerializedName("life_span")
        public String lifeSpan;

        @SerializedName("alt_names")
        public String altNames;

        @SerializedName("wikipedia_url")
        public String wikiUrl;

        @SerializedName("weight_imperial")
        public String weightImp;

        @SerializedName("country_code")
        public String countryCode;

        @SerializedName("suppress_tail")
        public int suppresTail;

        @SerializedName("short_legs")
        public int shortLegs;

        @SerializedName("affection_level")
        public int affection;

        @SerializedName("child_friendly")
        public int childFriend;

        @SerializedName("dog_friendly")
        public int demonTolerance;

        @SerializedName("energy_level")
        public int energy;

        @SerializedName("health_issues")
        public int health;

        @SerializedName("shedding_level")
        public int shedding;

        @SerializedName("social_needs")
        public int socialNeeds;

        @SerializedName("stranger_friendly")
        public int gaijinFriend;
    }
}