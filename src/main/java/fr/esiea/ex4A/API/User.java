package fr.esiea.ex4A.API;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    public final String email;
    public final String name;
    public final String twitter;
    public final String pays;
    public final String sexe;
    public final String sexPref;

    public User(@JsonProperty("userEmail") String email,
                @JsonProperty("userName") String name,
                @JsonProperty("userTweeter") String twitter,
                @JsonProperty("userCountry") String pays,
                @JsonProperty("userSex") String sexe,
                @JsonProperty("userSexPref") String sexPref) {
        this.email = email;
        this.name = name;
        this.twitter = twitter;
        this.pays = pays;
        this.sexe = sexe;
        this.sexPref = sexPref;
    }

    @Override
    public String toString() {
        return "User{" +
            "email='" + email + '\'' +
            ", name='" + name + '\'' +
            ", twitter='" + twitter + '\'' +
            ", pays='" + pays + '\'' +
            ", sexe='" + sexe + '\'' +
            ", sexPref='" + sexPref + '\'' +
            '}';
    }
}
