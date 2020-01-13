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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
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
    public String ajoutresa(@ModelAttribute ReservationDTO reservationDTO, Model model, @RequestParam("emails") String emails, @RequestParam("date_debut") String dateDebut, HttpServletRequest httpRequest) throws ParseException {
        String username = httpRequest.getUserPrincipal().getName();

        reservationDTO.setUsername(username);

        Date dateDeDebut = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(dateDebut);

        ArrayList<ArrayList<Date>> listDates = new ArrayList<ArrayList<Date>>();
        List<Date> listDateDebut = reservationService.getListDateDebut();
        List<Date> listDateFin = reservationService.getListDateFin();

        for (int i=0; i < listDateDebut.size(); i++)
        {
            ArrayList<Date> newListDate = new ArrayList<Date>();
            newListDate.add(listDateDebut.get(i));
            newListDate.add(listDateFin.get(i));
            listDates.add(newListDate);
        }

        for (List<Date> dates : listDates){
            if (dateDeDebut.compareTo(dates.get(0)) > 0 && dateDeDebut.compareTo(dates.get(1)) < 0){
                return "roomlist";
            }
        }


        reservationService.newCommande(reservationDTO, emails);

        return "scan";
    }



}
