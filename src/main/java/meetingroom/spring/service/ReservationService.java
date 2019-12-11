package meetingroom.spring.service;

import meetingroom.spring.dao.RerservationDao;
import meetingroom.spring.modele.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private RerservationDao rerservationDao;

    @Transactional
    public void newCommande(Reservation reservation){
        rerservationDao.insertResult(reservation);
    }

}
