package fr.esiea.ex4A.API;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class APIControllerTest {

    public final MockMvc mockMvc;

    @MockBean
    private UserMatch userMatch;

    APIControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }


    @Test
    void match_user_test() throws Exception {

        HashMap<String,User> userMap = new HashMap<>();
        User adilUser = new User("adil@bahou","adil","adilbh","FR","M","F");
        User belindaUser = new User("belinda@belinda","bélinda","belindang","FR","F","M");
        userMap.put(adilUser.name,adilUser);
        userMap.put(belindaUser.name,belindaUser);

        HashMap<String,AgifyForm> agifyMap = new HashMap<>();
        AgifyForm adilInfo = new AgifyForm("adil",21,303,"FR");
        AgifyForm belindaInfo = new AgifyForm("belinda",15,27695,"FR");
        agifyMap.put(adilInfo.name,adilInfo);
        agifyMap.put(belindaInfo.name,belindaInfo);

        List<User> listMatch = userMatch.getMatches(userMap,agifyMap,adilUser.name);

        when(userMatch.getMatches(userMap,agifyMap,adilUser.name)).thenReturn(listMatch);
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/matches?userName=adil&user_country"))
            .andExpect(status().isOk());
        verify(userMatch).getMatches(userMap,agifyMap,adilUser.name);
    }
}
