package meetingroom.spring.service;

import meetingroom.spring.dao.RerservationDao;
import meetingroom.spring.modele.*;
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
    public void newCommande(ReservationDTO reservationDTO, String emails) throws ParseException {
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

        Reservation getReservation = rerservationDao.findReservation(reservationDTO.getNom());

        String[] stringParticipants = emails.split(";");
        List<Participant> participants = new ArrayList<Participant>();

        for (String email : stringParticipants)
        {
            Participant participant = new Participant();
            participant.setEmail(email);
            participant.setReservation(getReservation);
            participants.add(participant);
            rerservationDao.insertParticipant(participant);
        }

    }

    public List<Date> getListDateDebut() {
        return rerservationDao.getListDateDebut();
    }

    public List<Date> getListDateFin() {
        return rerservationDao.getListDateFin();
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
