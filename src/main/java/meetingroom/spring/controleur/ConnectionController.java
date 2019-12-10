package meetingroom.spring.controleur;


import meetingroom.spring.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConnectionController {

        @Autowired
        private ConnectionService connectionService;

        @GetMapping({"/", "/connection"})
        public String accueil() {
            return "connection";
        }
}
