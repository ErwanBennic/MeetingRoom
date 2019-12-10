package meetingroom.spring.service;

import meetingroom.spring.dao.ConnectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionService {
    @Autowired
    private ConnectionDao connectionDao;
}
