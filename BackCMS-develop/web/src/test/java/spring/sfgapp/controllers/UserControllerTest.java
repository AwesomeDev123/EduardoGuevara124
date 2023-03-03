package spring.sfgapp.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import spring.sfgapp.services.UserService;

import static org.mockito.ArgumentMatchers.any;

public class UserControllerTest {

    @InjectMocks
    UserController userController;
    @Mock
    UserService userService;

    @BeforeEach
    public  void init(){
//        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void userTest(){
/*        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes((request)));
        User user = new User(Long.valueOf(6) ,"a","b","c");
        when(userService.save(any(User.class))).thenReturn(new ResponseEntity<UserResponseRest>(HttpStatus.OK));
        ResponseEntity<UserResponseRest> responseRestResponseEntity = userController.save(user);
        asserThat(responseRestResponseEntity.getStatusCodeValue()).isEqualto(200);*/




    }
    



}
