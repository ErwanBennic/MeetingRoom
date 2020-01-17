package meetingroom.spring.service;

import javax.activation.DataHandler;
import javax.activation.MailcapCommandMap;
import javax.activation.MimetypesFileTypeMap;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class InviteService {
    public static void main(String[] args) throws Exception {
        List<String> emails = new ArrayList<>();
        emails.add("erwanb04@gmail.com");
        emails.add("damien.genevee@epsi.fr");
        eventRequest(emails, "Ehhh mercé", "TITRE");
    }
        /**
         * method to send mail request along with calendar intergration for interview
         * @author simbu
         * @param emails
         * @param string
         * @param subject
         * @throws Exception
         */
        public static void eventRequest(List<String> emails, String string, String subject) throws Exception {
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
            for (String email : emails) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            }

            Multipart multipart = new MimeMultipart("alternative");

            BodyPart messageBodyPart = buildCalendarPart(string);
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
        private static BodyPart buildHtmlTextPart() throws MessagingException {

            MimeBodyPart descriptionPart = new MimeBodyPart();

            // Note: even if the content is specified as being text/html, outlook
            // won't read correctly tables at all
            // and only some properties from div:s. Thus, try to avoid too fancy
            // content
            String content = "<h1 >simple meeting invitation</h1>";
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
}
