package meetingroom.spring.controleur;

import meetingroom.spring.dao.GeneratePdfDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PdfController {

    @GetMapping("/pdf/{salle}")
    public void pdf(HttpServletResponse response, @PathVariable String salle) throws IOException {
        response.setContentType("application/pdf");
        GeneratePdfDao.create(response.getOutputStream(), salle);
    }
}
