package meetingroom.spring.controleur;


import meetingroom.spring.modele.Salle;
import meetingroom.spring.modele.User;
import meetingroom.spring.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ConnectionController {

        @Autowired
        private ConnectionService connectionService;

        @GetMapping({"/connection"})
        @PostMapping("/admin/j_security_check")
        public String connection() {
            return "connection";
        }

        @GetMapping({"/"})
        public String accueil(Model model) {
                List<Salle> salles = connectionService.getListSalle();
                model.addAttribute("salles", salles);
                return "accueil";
        }

}
