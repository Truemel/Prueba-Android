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

    @Override
    public String toString() {
        return "Breed{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", temperament='" + temperament + '\'' +
                ", origin='" + origin + '\'' +
                ", description='" + description + '\'' +
                ", experimental=" + experimental +
                ", hairless=" + hairless +
                ", natural=" + natural +
                ", rare=" + rare +
                ", rex=" + rex +
                ", hypoallergenic=" + hypoallergenic +
                ", adaptability=" + adaptability +
                ", grooming=" + grooming +
                ", intelligence=" + intelligence +
                ", vocalisation=" + vocalisation +
                ", lap=" + lap +
                ", indoor=" + indoor +
                ", vCAUrl='" + vCAUrl + '\'' +
                ", vetUrl='" + vetUrl + '\'' +
                ", cFAUrl='" + cFAUrl + '\'' +
                ", lifeSpan='" + lifeSpan + '\'' +
                ", altNames='" + altNames + '\'' +
                ", wikiUrl='" + wikiUrl + '\'' +
                ", weight=" + weight +
                ", countryCode='" + countryCode + '\'' +
                ", countryCodes='" + countryCodes + '\'' +
                ", suppresTail=" + suppresTail +
                ", shortLegs=" + shortLegs +
                ", affection=" + affection +
                ", childFriend=" + childFriend +
                ", demonTolerance=" + demonTolerance +
                ", energy=" + energy +
                ", health=" + health +
                ", shedding=" + shedding +
                ", socialNeeds=" + socialNeeds +
                ", gaijinFriend=" + gaijinFriend +
                '}';
    }
}
