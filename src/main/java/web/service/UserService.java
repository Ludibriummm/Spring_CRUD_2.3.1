package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void add(String name, String surname, int age, String login);
    List<User> getAllUsers();
//    List<User> getUserList(int count);
    User getUserById(int id);
    void removeUserById(int id);
    void removeUser(User user);
    void removeAllUsers();
    void update(int id, User user);
}
