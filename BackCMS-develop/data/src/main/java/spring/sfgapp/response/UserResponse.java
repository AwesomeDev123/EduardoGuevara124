package spring.sfgapp.response;

import spring.sfgapp.entity.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class  UserResponse {
    private Set<User> user;
    public Set<User> getUser() {
        return user;
    }
    public void setUser(Set<User> user) {
        this.user = user;
    }
}
