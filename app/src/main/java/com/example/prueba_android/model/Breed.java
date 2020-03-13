package com.example.prueba_android.model;

import com.google.gson.annotations.SerializedName;

public class Breed {
    public String id, name, temperament, origin, description;
    public int experimental, hairless, natural, rare, rex, hypoallergenic, adaptability, grooming, intelligence, vocalisation;
    public int lap, indoor;

    @SerializedName("vcahospitals_url")
    public String vCAUrl;

    @SerializedName("vetstreet_url")
    public String vetUrl;

    @SerializedName("cfa_url")
    public String cFAUrl;

    @SerializedName("life_span")
    public String lifeSpan;

    @SerializedName("alt_names")
    public String altNames;

    @SerializedName("wikipedia_url")
    public String wikiUrl;

        /*@SerializedName("weight_imperial")
        public String weightImp;*/

    public CatWeight weight;

    public class CatWeight{
        public String imperial, metric;
    }

    @SerializedName("country_code")
    public String countryCode;

    @SerializedName("country_codes")
    public String countryCodes;

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
