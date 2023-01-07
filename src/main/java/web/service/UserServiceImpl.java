package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user){
        userDao.add(user);
    }
    public void add(String name, String surname, int age, String login){
        userDao.add(name, surname, age, login);
    }
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
//    public List<User> getUserList(int count) {
//        return userDao.getUserList(count);
//    }

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
    public void update(int id, User user) {
        userDao.update(id, user);
    }
}
