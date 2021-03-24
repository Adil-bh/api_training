package fr.esiea.ex4A.API;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AgifyForm {

    public final String name;
    public final int age;
    public final int count;
    public final String country;

    public AgifyForm(@JsonProperty("name") String name,
                     @JsonProperty("age") int age,
                     @JsonProperty("count") int count,
                     @JsonProperty("country_id") String country_id) {
        this.name = name;
        this.age = age;
        this.count = count;
        this.country = country_id;
    }

    @Override
    public String toString() {
        return "AgifyForm{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", count=" + count +
            ", country='" + country + '\'' +
            '}';
    }
}
