package fr.esiea.ex4A.API;

import org.springframework.web.bind.annotation.*;
import retrofit2.Response;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
public class APIController {

    public final HashMap<String,AgifyForm> agifyMap = new HashMap<>();
    public final AgifyClient agifyClient;
    public final HashMap<String,User> userMap = new HashMap<>();
    public final UserMatch userMatch;

    public APIController(AgifyClient agifyClient, UserMatch userMatch) {
        this.agifyClient = agifyClient;
        this.userMatch = userMatch;
    }


    @GetMapping("/api/matches")
    public List<User> userListMatches(@RequestParam(value="userName") String name) {
        final List<User> userList = userMatch.getMatches(userMap, agifyMap,name);
        return userList;
    }

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody User user) throws IOException {
        if (!agifyMap.containsKey(user.name)) {
            Response<AgifyForm> response = agifyClient.defineAge(user.name, user.pays).execute();
            AgifyForm agifyForm = response.body();
            agifyMap.put(agifyForm.name, agifyForm);
            userMap.put(user.name, user);
            System.out.println(agifyMap);
        }
    }

}
