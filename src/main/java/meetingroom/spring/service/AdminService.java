package meetingroom.spring.service;

import meetingroom.spring.dao.AdminDao;
import meetingroom.spring.modele.Salle;
import meetingroom.spring.modele.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public List<Salle> getListSalle() {
        return adminDao.getListSalle();
    }
}
