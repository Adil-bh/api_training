package fr.esiea.ex4A.API;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Matches;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserMatchTest {



    public final UserMatch matches = new UserMatch();
    @Test
    void test_user_match() throws Exception {
        HashMap<String,User> userMap = new HashMap<>();
        User adilUser = new User("adil@bahou","adil","adilbh","FR","M","F");
        User belindaUser = new User("bélinda@bélinda","bélinda","belindang","FR","F","M");
        userMap.put(adilUser.name,adilUser);
        userMap.put(belindaUser.name,belindaUser);

        HashMap<String,AgifyForm> agifyMap = new HashMap<>();
        AgifyForm adilInfo = new AgifyForm("adil",21,303,"FR");
        AgifyForm belindaInfo = new AgifyForm("bélinda",15,27695,"FR");
        agifyMap.put(adilInfo.name,adilInfo);
        agifyMap.put(belindaInfo.name,belindaInfo);

        List<User> listMatch = matches.getMatches(userMap,agifyMap,adilUser.name);
        assertThat(listMatch).contains(belindaUser);
    }
}
