package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user){
        userDao.addUser(user);
    }
    public void addUser(String name, String surname, int age, String login){
        userDao.addUser(name, surname, age, login);
    }
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public void removeUserById(int id){
        userDao.removeUserById(id);

    }
    public void removeUser(User user){
        userDao.removeUser(user);
    }
    public void removeAllUsers(){
        userDao.removeAllUsers();
    }
    @Override
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);
    }
}
