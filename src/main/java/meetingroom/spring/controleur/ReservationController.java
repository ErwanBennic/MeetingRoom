package meetingroom.spring.controleur;


import meetingroom.spring.modele.Reservation;
import meetingroom.spring.modele.ReservationDTO;
import meetingroom.spring.modele.Salle;
import meetingroom.spring.modele.User;
import meetingroom.spring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/scan")
    public String scan() {
        return "scan";
    }

    @GetMapping("/form/{salle}")
    public String form(@PathVariable String salle, Model model) {
        model.addAttribute("salle", salle);
        return "form";
    }

    @GetMapping({"/reservation"})
    public String reservation() {
        return "reservation";
    }

    @PostMapping("/ajoutresa")
    public String ajoutresa(@ModelAttribute ReservationDTO reservationDTO, Model model, @RequestParam("salle") String salle, HttpServletRequest httpRequest) throws ParseException {
        String username = httpRequest.getUserPrincipal().getName();

        reservationDTO.setUsername(username);

        reservationService.newCommande(reservationDTO);

        return "scan";
    }



}
