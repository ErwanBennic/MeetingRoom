package meetingroom.spring.dao;

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
public class AdminDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Salle> getListSalle() {
        return em.createQuery("select s from Salle s", Salle.class)
                .getResultList();
    }

    @Transactional
    public List<Reservation> getListReservation(String id) {
        List<Reservation> reservations;

        reservations = em.createQuery("select r from Reservation r where r.salle.lib = :id", Reservation.class).setParameter("id", id)
                .getResultList();

        if (reservations.size() < 1){
            return null;
        } else {
            return reservations;
        }
    }

    @Transactional
    public List<Reservation> getListReservation(String id, Date userDate) {
        List<Reservation> reservations;

        reservations = em.createQuery("select r from Reservation r where r.salle.lib = :id and r.date_debut = :userDate", Reservation.class)
                .setParameter("userDate", userDate)
                .setParameter("id", id)
                .getResultList();

        if (reservations.size() < 1){
            return null;
        } else {
            return reservations;
        }
    }
}
