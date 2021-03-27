package fr.esiea.ex4A.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
        @ParameterizedTest
        @ValueSource(strings = {"{\"userEmail\":\"adil@bahou\",\"userName\":\"adil\",\"userTweeter\":\"adilbh\",\"userCountry\":\"FR\",\"userSex\":\"H\",\"userSexPref\":\"F\"}"
        })

        void user_test(String json) throws Exception {
            User user = new ObjectMapper().readValue(json, User.class);
            System.out.println(user.toString());
            assertTrue(json.contains(user.pays));
            assertTrue(json.contains(user.email));
            assertTrue(json.contains(user.name));
            assertTrue(json.contains(user.twitter));
            assertTrue(json.contains(user.sexe));
            assertTrue(json.contains(user.sexPref));
            assertThat(user.toString()).isEqualTo("User{email='"+user.email
                +"', name='"+user.name
                +"', twitter='"+user.twitter
                +"', pays='"+user.pays
                +"', sexe='"+user.sexe
                +"', sexPref='"+user.sexPref+"'}");
        }

}
