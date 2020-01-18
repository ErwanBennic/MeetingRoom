package meetingroom.spring.service;

import meetingroom.spring.dao.RerservationDao;
import meetingroom.spring.modele.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.activation.MailcapCommandMap;
import javax.activation.MimetypesFileTypeMap;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public void eventRequest(String emails, ReservationDTO reservationDTO) throws Exception {

        Date dateDeDebut = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(reservationDTO.getDate_debut());
        Date dateDeFin = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(reservationDTO.getDate_fin());
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm '-' dd/MM/yyyy");
        String debut = sdf.format(dateDeDebut);
        String fin = sdf.format(dateDeFin);
        String salle = reservationDTO.getSalle();
        String nom = reservationDTO.getNom();

        String[] stringParticipants = emails.split(";");
        String body =  "Bonjour, " + nom + " vous à invité à participer à une réunion en salle " + salle + " de " + debut + " à " + fin;
        String subject = "Invitation à une réunion";


        final MimetypesFileTypeMap mimetypes = (MimetypesFileTypeMap) MimetypesFileTypeMap.getDefaultFileTypeMap();
        mimetypes.addMimeTypes("text/calendar ics ICS");
        final MailcapCommandMap mailcap = (MailcapCommandMap) MailcapCommandMap.getDefaultCommandMap();
        mailcap.addMailcap("text/calendar;; x-java-content-handler=com.sun.mail.handlers.text_plain");

        // **************//
        // Provide SMTP Details
        final String username = "erwanb04@gmail.com";
        final String password = "fsmcsktsddzgqccm"; // your password

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // ************//

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(username));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        message.setSubject(subject);	// Subject of the event

        //adding emails to internetaddres
        for (String email : stringParticipants) {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        }

        Multipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = buildCalendarPart(body);
        multipart.addBodyPart(buildHtmlTextPart(body));
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);

        // send the message
        Transport transport = session.getTransport("smtp");
        transport.connect();
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    /**
     * @author simbu
     * @return description part along with design
     * @throws MessagingException
     */
    private static BodyPart buildHtmlTextPart(String body) throws MessagingException {

        MimeBodyPart descriptionPart = new MimeBodyPart();

        // Note: even if the content is specified as being text/html, outlook
        // won't read correctly tables at all
        // won't read correctly tables at all
        // and only some properties from div:s. Thus, try to avoid too fancy
        // content
        String content = "<b>"+ body +"</b>";
        descriptionPart.setContent(content, "text/html; charset=utf-8");

        return descriptionPart;
    }

    /**
     * @author simbu
     * @param bodyMsg
     * @return calendardata along with design
     * @throws Exception
     */
    private static BodyPart buildCalendarPart(String bodyMsg) throws Exception {

        BodyPart calendarPart = new MimeBodyPart();

        // TODO: DATE AND TIME OF EVENT
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date start = cal.getTime();
        cal.add(Calendar.HOUR_OF_DAY, 3);
        final Date end = cal.getTime();

        // check the icalendar spec in order to build a more complicated meeting
        // request
        final String calendarContent = "BEGIN:VCALENDAR\n" + "METHOD:REQUEST\n" + "PRODID: BCP - Meeting\n" +  "VERSION:2.0\n" + "BEGIN:VEVENT\n" + "UID:324\n" + "ATTENDEE;ROLE=REQ-PARTICIPANT;PARTSTAT=NEEDS-ACTION;RSVP=TRUE:MAILTO:rajeshwright@gmail.com\n" + "ORGANIZER:MAILTO:rajeshwright@gmail.com\n"
                + "LOCATION:Company\n" + "DESCRIPTION:" + bodyMsg + "\n" + "SEQUENCE:0\n" + "PRIORITY:5\n" + "CLASS:PUBLIC\n" + "STATUS:CONFIRMED\n" + "TRANSP:OPAQUE\n" + "BEGIN:VALARM\n" + "ACTION:DISPLAY\n" + "DESCRIPTION:REMINDER\n" + "END:VALARM\n" + "TRIGGER;RELATED=START:-PT00H15M00S\n" + "END:VEVENT\n" + "END:VCALENDAR";

        calendarPart.addHeader("Content-Class", "urn:content-classes:calendarmessage");
        calendarPart.setContent(calendarContent, "text/calendar;method=CANCEL");

        System.out.println("Done");
        return calendarPart;
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
