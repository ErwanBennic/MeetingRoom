package meetingroom.spring.service;

import meetingroom.spring.dao.ConnectionDao;
import meetingroom.spring.modele.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ConnectionService {
    @Autowired
    private ConnectionDao connectionDao;

    @Transactional
    public User findUser(String login, String password) {
        return connectionDao.findUser(login, password);
    }
}
