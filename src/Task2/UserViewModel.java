package Task2;


import java.util.ArrayList;
import java.util.List;

public class UserViewModel {
    private List<UserModel> users;

    public UserViewModel() {
        users = new ArrayList<>();
    }

    public void addUser(String name) {
        UserModel user = new UserModel(name);
        users.add(user);
    }

    public List<UserModel> getUsers() {
        return users;
    }
}
