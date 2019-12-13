package meetingroom.spring.service;

import meetingroom.spring.dao.RerservationDao;
import meetingroom.spring.modele.Reservation;
import meetingroom.spring.modele.ReservationDTO;
import meetingroom.spring.modele.Salle;
import meetingroom.spring.modele.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private RerservationDao rerservationDao;

    @Transactional
    public void newCommande(ReservationDTO reservationDTO) throws ParseException {
        Salle sallee = rerservationDao.findSalle(reservationDTO.getSalle());
        User user = rerservationDao.findUser(reservationDTO.getUsername());

        Reservation reservation = new Reservation();
        Date date_debut = new SimpleDateFormat("yyyy-MM-dd").parse(reservationDTO.getDate_debut());
        Date date_fin = new SimpleDateFormat("yyyy-MM-dd").parse(reservationDTO.getDate_fin());
        reservation.setDate_debut(date_debut);
        reservation.setDate_fin(date_fin);
        reservation.setNom(reservationDTO.getNom());
        reservation.setDescription(reservationDTO.getDescription());
        reservation.setSalle(sallee);
        reservation.setUser(user);

        rerservationDao.insertResult(reservation);
    }

    @Transactional
    public Salle findSalle(String salle){
        return  rerservationDao.findSalle(salle);
    }

    @Transactional
    public User findUser(String username){
        return rerservationDao.findUser(username);
    }

}
