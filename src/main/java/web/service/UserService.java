package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void addUser(String name, String surname, int age, String login);
    List<User> getAllUsers();
    User getUserById(int id);
    void removeUserById(int id);
    void removeUser(User user);
    void removeAllUsers();
    void updateUser(int id, User user);
}
