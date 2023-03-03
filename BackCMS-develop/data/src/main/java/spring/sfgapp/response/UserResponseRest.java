package spring.sfgapp.response;
import spring.sfgapp.entity.User;

import java.util.Set;
public abstract class UserResponseRest extends ResponseRest implements Set<User> {
    private UserResponse userResponse = new UserResponse();
    public UserResponse getUserResponse() {
        return userResponse;
    }
    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
