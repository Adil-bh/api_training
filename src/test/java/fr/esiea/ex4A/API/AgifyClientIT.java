package fr.esiea.ex4A.API;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class AgifyClientIT {

    @ParameterizedTest
    @CsvSource({
        "Adil,FR",
        "Bélinda,FR",
        "Maxence,FR"
    })
    void Test_Agify_Client(String name, String country) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.agify.io/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

        AgifyClient agifyClient = retrofit.create(AgifyClient.class);

        Response<AgifyForm> response = agifyClient.defineAge(name, country).execute();
        AgifyForm agifyForm = response.body();
        assertEquals(agifyForm.name, name);
        assertEquals(agifyForm.country, country);
        assertThat(agifyForm.toString()).isEqualTo("AgifyForm{name='"+agifyForm.name
            +"', age="+agifyForm.age
            +", count="+agifyForm.count
            +", country='"+agifyForm.country+"'}");
    }


}
