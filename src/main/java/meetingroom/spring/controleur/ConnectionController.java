package meetingroom.spring.controleur;

import meetingroom.spring.modele.Commande;
import meetingroom.spring.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ConnectionController {

        @Autowired
        private PizzaService pizzaService;

        @GetMapping({"/", "/connection"})
        public String accueil() {
            return "connection";
        }
}
