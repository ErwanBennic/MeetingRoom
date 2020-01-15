package meetingroom.spring.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import org.springframework.stereotype.Service;

@Service
public class InviteService {

    /* Evenement WIP */
    private static BodyPart buildHtmlTextPart() throws MessagingException {

        MimeBodyPart descriptionPart = new MimeBodyPart();

        //Note: even if the content is spcified as being text/html, outlook won't read correctly tables at all
        // and only some properties from div:s. Thus, try to avoid too fancy content
        String content = "<font size=\"2\">simple meeting invitation</font>";
        descriptionPart.setContent(content, "text/html; charset=utf-8");

        return descriptionPart;
    }

    //define somewhere the icalendar date format
    private static SimpleDateFormat iCalendarDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmm'00'");

    private static BodyPart buildCalendarPart() throws Exception {

        BodyPart calendarPart = new MimeBodyPart();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date start = cal.getTime();
        cal.add(Calendar.HOUR_OF_DAY, 3);
        Date end = cal.getTime();

        //check the icalendar spec in order to build a more complicated meeting request
        String calendarContent =
                "BEGIN:VCALENDAR\n" +
                        "METHOD:REQUEST\n" +
                        "PRODID: BCP - Meeting\n" +
                        "VERSION:2.0\n" +
                        "BEGIN:VEVENT\n" +
                        "DTSTAMP:" + iCalendarDateFormat.format(start) + "\n" +
                        "DTSTART:" + iCalendarDateFormat.format(start)+ "\n" +
                        "DTEND:"  + iCalendarDateFormat.format(end)+ "\n" +
                        "SUMMARY:test request\n" +
                        "UID:324\n" +
                        "ATTENDEE;ROLE=REQ-PARTICIPANT;PARTSTAT=NEEDS-ACTION;RSVP=TRUE:MAILTO:organizer@yahoo.com\n" +
                        "ORGANIZER:MAILTO:organizer@yahoo.com\n" +
                        "LOCATION:on the net\n" +
                        "DESCRIPTION:learn some stuff\n" +
                        "SEQUENCE:0\n" +
                        "PRIORITY:5\n" +
                        "CLASS:PUBLIC\n" +
                        "STATUS:CONFIRMED\n" +
                        "TRANSP:OPAQUE\n" +
                        "BEGIN:VALARM\n" +
                        "ACTION:DISPLAY\n" +
                        "DESCRIPTION:REMINDER\n" +
                        "TRIGGER;RELATED=START:-PT00H15M00S\n" +
                        "END:VALARM\n" +
                        "END:VEVENT\n" +
                        "END:VCALENDAR";

        calendarPart.addHeader("Content-Class", "urn:content-classes:calendarmessage");
        calendarPart.setContent(calendarContent, "text/calendar;method=CANCEL");

        return calendarPart;
    }

    public static void main(String[] args) throws Exception {
        final String username = "erwanb04@gmail.com";
        final String password = "fsmcsktsddzgqccm"; /* Mot de passe d'application généré sur mon compte perso gmail */
        /* Voir https://support.google.com/accounts/answer/185833 pour générer un mot de passe d'application */

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("erwanb04@gmail.com")  /* Destinataires : Utiliser "," pour séparer les destinataires */
            );
            message.setSubject("Invitation à l'événement : {evenement}"); /* Titre du mail */
            message.setText("Vous recevez ce mail car vous avez été invité à participer à l'événement : {evenement},"
                    + "\n\nMerci de ne pas répondre à cet email." + buildHtmlTextPart() + buildCalendarPart()); /* Texte du mail */

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
