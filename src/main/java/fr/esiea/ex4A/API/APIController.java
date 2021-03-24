package fr.esiea.ex4A.API;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class APIController {

    public final HashMap<String,User> userMap = new HashMap<>();

    @GetMapping("/api/matches")
    public List<User> userListMatches() {
        final List<User> userList = new ArrayList<>();
        for(User user: userMap.values()){
            userList.add(user);
        }
        return userList;
    }

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody User user){
        userMap.put(user.name,user);
    }

}
