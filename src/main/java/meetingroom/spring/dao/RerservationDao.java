package meetingroom.spring.dao;

import meetingroom.spring.modele.Participant;
import meetingroom.spring.modele.Reservation;
import meetingroom.spring.modele.Salle;
import meetingroom.spring.modele.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public class RerservationDao {
    @PersistenceContext
    private EntityManager em;

    public void insertResult(Reservation reservation){
        em.persist(reservation);
    }

    public void insertParticipant(Participant participant){
        em.persist(participant);
    }

    @Transactional
    public List<Date> getListDateDebut() {
        return em.createQuery("select r.date_debut from Reservation r", Date.class)
                .getResultList();
    }

    @Transactional
    public List<Date> getListDateFin() {
        return em.createQuery("select r.date_fin from Reservation r", Date.class)
                .getResultList();
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

    public Reservation findReservation(String nom) {
        List<Reservation> reservations;
        reservations = em.createQuery("select r from Reservation r where r.nom = :nom", Reservation.class)
                .setParameter("nom", nom).getResultList();
        if (reservations.size() < 1){
            return null;
        } else {
            Reservation reservation = reservations.get(0);
            return reservation;
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
