package meetingroom.spring.dao;

import meetingroom.spring.modele.Reservation;
import meetingroom.spring.modele.Salle;
import meetingroom.spring.modele.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RerservationDao {
    @PersistenceContext
    private EntityManager em;

    public void insertResult(Reservation reservation){
        em.persist(reservation);
    }

    public User findUser(String email) {
        List<User> users;
        users = em.createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email).getResultList();
        if (users.size() < 1){
            return null;
        } else {
            User user = users.get(0);
            return user;
        }
    }

    public Salle findSalle(String lib) {
        List<Salle> salles;
        salles = em.createQuery("select s from Salle s where s.lib = :lib", Salle.class)
                .setParameter("lib", lib).getResultList();
        if (salles.size() < 1){
            return null;
        } else {
            Salle salle = salles.get(0);
            return salle;
        }
    }
}
