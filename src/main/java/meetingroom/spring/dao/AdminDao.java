package meetingroom.spring.dao;

import meetingroom.spring.modele.Salle;
import meetingroom.spring.modele.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
}
