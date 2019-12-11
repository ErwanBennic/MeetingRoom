package meetingroom.spring.controleur;


import meetingroom.spring.modele.Reservation;
import meetingroom.spring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/scan")
    public String scan() {
        return "scan";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @GetMapping({"/reservation"})
    public String reservation() {
        return "reservation";
    }

    @PostMapping("/ajoutresa")
    public String traitement(@ModelAttribute Reservation reservation, Model model){



        reservationService.newCommande(reservation);

        return "scan";
    }
}
