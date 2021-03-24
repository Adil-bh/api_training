package fr.esiea.ex4A.API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserMatch {
    public List<User> getMatches(HashMap<String,User> userMap, HashMap<String,AgifyForm> agifyMap, String name) {
        final AgifyForm userAgify = agifyMap.get(name); final User userInfo = userMap.get(name); final List<User> matches = new ArrayList<>();
        for(AgifyForm i : agifyMap.values()){
            if(i.age<= userAgify.age+4 || i.age>= userAgify.age-4){
                User potentialMatch = userMap.get(i.name);
                if(potentialMatch.sexe.equals(userInfo.sexPref) && userInfo.twitter!= potentialMatch.twitter){
                    matches.add(userMap.get(i.name));
                }
            }
        } return matches;
    }
}