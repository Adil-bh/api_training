package fr.esiea.ex4A.API;

import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Service
public interface AgifyClient {

    @GET(".")
    Call<AgifyForm> defineAge(@Query("name")String name, @Query("country_id")String country);
}
