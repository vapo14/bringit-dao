package cs.vapo.bringit.core.dao.user;

import cs.vapo.bringit.core.dao.model.UserDM;
import cs.vapo.bringit.core.dao.model.UserForLoginDM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class UserDataServiceTests {

    @Autowired
    private UserDataService dataService;

    @Test
    void findByUsernameForLogin() {
        final String username = "vapo";
        final String expectedPassword = "test123.";

        final UserForLoginDM user = dataService.findUserByUsernameForLogin(username);
        Assertions.assertEquals(expectedPassword, user.getPassword());
    }

    @Test
    void findById() {
        final long userId = 1234;
        final String expectedUsername = "vapo";

        final UserDM user = dataService.findUserById(userId);
        Assertions.assertEquals(expectedUsername, user.getUsername());
    }
}
