package meetingroom.spring.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RerservationDao {
    @PersistenceContext
    private EntityManager em;
}
