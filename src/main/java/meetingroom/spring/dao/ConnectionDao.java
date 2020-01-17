package meetingroom.spring.dao;

import meetingroom.spring.modele.Salle;
import meetingroom.spring.modele.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ConnectionDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Salle> getListSalle() {
        return em.createQuery("select s from Salle s", Salle.class)
                .getResultList();
    }

    public User findUser(String login, String password) {
        List<User> users;
        users = em.createQuery("select u from User u where u.email = :login and u.password = :password", User.class).getResultList();
        if (users.size() < 1){
            return null;
        } else {
            User user = users.get(0);
            return user;
        }
    }
}
