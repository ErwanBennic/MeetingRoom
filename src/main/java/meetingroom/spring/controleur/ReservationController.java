package meetingroom.spring.controleur;


import meetingroom.spring.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping({"/scan"})
    public String scan() {
        return "scan";
    }

    @GetMapping({"/form"})
    public String form() {
        return "form";
    }

    @GetMapping({"/reservation"})
    public String reservation() {
        return "reservation";
    }
}
