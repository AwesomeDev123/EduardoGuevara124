package spring.sfgapp.services.springdatajpa;
import org.junit.jupiter.api.Test;
import spring.sfgapp.entity.User;


public class UserSDJpaServiceTest {
    @Test
    private void userAssertEqualTest(String s, String emailPersonal) {
        User user = new User();
        userAssertEqualTest("email@1.com",user.getEmailAddress());

    }


}
