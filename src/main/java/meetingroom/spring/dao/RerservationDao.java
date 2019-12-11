package meetingroom.spring.dao;

import meetingroom.spring.modele.Reservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RerservationDao {
    @PersistenceContext
    private EntityManager em;

    public void insertResult(Reservation reservation){
        em.persist(reservation);
    }
}
