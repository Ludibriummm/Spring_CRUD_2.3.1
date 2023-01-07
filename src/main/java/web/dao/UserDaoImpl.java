package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
@EnableTransactionManagement
public class UserDaoImpl implements UserDao{
    @PersistenceContext
//    private SessionFactory sessionFactory;
    private EntityManager entityManager;
    @Override
    public void add(User user){
        entityManager.persist(user);
    }
    @Override
    public void add(String name, String surname, int age, String login){
        User user = new User(name, surname, age, login);
        entityManager.persist(user);
    }
//    @Override
//    public List<User> getUserList(int count) {
//        if (count <= 0) getAllUsers();
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList().stream().limit(count).toList();
//    }
    public List<User> getAllUsers(){
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    public void removeUser(User user) {
        entityManager.remove(user);
    }

    public void removeUserById(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
    public void removeAllUsers(){
        entityManager.createQuery("DELETE from User ")
                .executeUpdate();
    }
    public void update(int id, User updatedUser){
        User userToBeUpdated = getUserById(id);
        if(updatedUser.getName() != null) userToBeUpdated.setName(updatedUser.getName());
        if(updatedUser.getSurname() != null) userToBeUpdated.setSurname(updatedUser.getSurname());
        if(updatedUser.getAge() > 0) userToBeUpdated.setAge(updatedUser.getAge());
        if(updatedUser.getLogin() != null) userToBeUpdated.setLogin(updatedUser.getLogin());
//        entityManager.merge(updatedUser);
    }

}
