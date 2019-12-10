package meetingroom.spring.controleur;

import meetingroom.spring.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping({"/roomlist"})
    public String roomlist() {
        return "roomlist";
    }

}
