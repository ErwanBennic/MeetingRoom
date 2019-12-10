package meetingroom.spring.service;

import meetingroom.spring.dao.RerservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private RerservationDao rerservationDao;
}
