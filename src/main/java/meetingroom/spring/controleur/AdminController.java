package meetingroom.spring.controleur;

import meetingroom.spring.modele.Salle;
import meetingroom.spring.modele.User;
import meetingroom.spring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/roomlist")
    public String roomlist(Model model) {
        List<Salle> salles = adminService.getListSalle();
        model.addAttribute("salles", salles);
        return "roomlist";
    }

}
