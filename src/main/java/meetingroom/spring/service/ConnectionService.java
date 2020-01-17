package meetingroom.spring.service;

import meetingroom.spring.dao.ConnectionDao;
import meetingroom.spring.modele.Salle;
import meetingroom.spring.modele.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ConnectionService {
    @Autowired
    private ConnectionDao connectionDao;

    public List<Salle> getListSalle() {
        return connectionDao.getListSalle();
    }

    @Transactional
    public User findUser(String login, String password) {
        return connectionDao.findUser(login, password);
    }
}
