package fr.esiea.ex4A.API;

import org.springframework.web.bind.annotation.*;
import retrofit2.Response;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class APIController {

    public HashMap<String,AgifyForm> agifyMap = new HashMap<>();
    public final AgifyClient agifyClient;
    public final HashMap<String,User> userMap = new HashMap<>();

    public APIController(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
    }


    @GetMapping("/api/matches")
    public List<User> userListMatches() {
        final List<User> userList = new ArrayList<>();
        for(User user: userMap.values()){
            userList.add(user);
        }
        return userList;
    }

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody User user) throws IOException {
        Response<AgifyForm> response = agifyClient.defineAge(user.name, user.pays).execute();
        AgifyForm agifyForm = response.body();

        agifyMap.put(agifyForm.name,agifyForm);
        System.out.println(agifyMap);
        userMap.put(user.name,user);
    }

}
