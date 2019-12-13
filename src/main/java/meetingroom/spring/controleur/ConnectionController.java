package meetingroom.spring.controleur;


import meetingroom.spring.modele.User;
import meetingroom.spring.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConnectionController {

        @Autowired
        private ConnectionService connectionService;

        @GetMapping({"/", "/connection"})
        @PostMapping("/private/j_security_check")
        public String connection() {
            return "connection";
        }

}
