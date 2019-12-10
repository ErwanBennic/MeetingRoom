package meetingroom.spring.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import meetingroom.spring.modele.Commande;
import meetingroom.spring.modele.Pizza;
import meetingroom.spring.modele.TraitementDTO;
import meetingroom.spring.service.PizzaService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccueilController {

	@Autowired
	private PizzaService pizzaService;

	@GetMapping({"/accueil"})
	public String accueil(Model model) {
		List<Commande> result = pizzaService.getListeCommande();
		model.addAttribute("result", result);
		return "index";
	}

	@PostMapping("/traitement")
	public String traitement(@RequestParam("listId") List<String> idPizzas, @Validated @ModelAttribute TraitementDTO traitementDTO, Model model){

	    pizzaService.newCommande(traitementDTO);

	    List<Commande> pizzas = pizzaService.getListeCommande();
		model.addAttribute("pizzas", pizzas);
		return "index";
	}

    @PostMapping("/valideCommande")
    public String valideCommande(@RequestParam("id") long id){

	    pizzaService.saveResult(id);

        return "index";
    }

	@GetMapping("/form")
	public String form(Commande commande, Model model){

        List<Pizza> pizzas = pizzaService.getListePizza();
        model.addAttribute("pizzas", pizzas);
	    return "form";
	}

    @GetMapping("/preparation")
    public String preparation(Model model){

        Commande commande = pizzaService.getFistCommande();
        model.addAttribute("commande", commande);

        return "preparation";
    }

}
