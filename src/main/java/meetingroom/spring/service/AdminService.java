package meetingroom.spring.service;

import meetingroom.spring.dao.AdminDao;
import meetingroom.spring.modele.Reservation;
import meetingroom.spring.modele.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public List<Salle> getListSalle() {
        return adminDao.getListSalle();
    }

    @Transactional
    public List<Reservation> getListReservation(String id) {
        return adminDao.getListReservation(id);
    }
}
