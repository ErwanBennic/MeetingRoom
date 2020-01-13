package meetingroom.spring.controleur;

import meetingroom.spring.modele.Reservation;
import meetingroom.spring.modele.Salle;
import meetingroom.spring.modele.User;
import meetingroom.spring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/roomlist")
    public String roomlist(Model model) {
        List<Salle> salles = adminService.getListSalle();
        model.addAttribute("salles", salles);
        return "roomlist";
    }

    @PostMapping("/reservation")
    public String reservation(Model model, @RequestParam("id") String id, @RequestParam("dateFrom") String dateFrom) throws ParseException {
        Date userDate = new Date();
        if (dateFrom != ""){
            userDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateUser = formatter.format(userDate);
        List<Reservation> reservations = adminService.getListReservation(id, userDate);
        model.addAttribute("reservations", reservations);
        model.addAttribute("salle", id);
        model.addAttribute("dateUser", dateUser);
        return "reservation";
    }

}

