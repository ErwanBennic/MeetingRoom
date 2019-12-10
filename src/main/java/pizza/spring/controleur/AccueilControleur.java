package pizza.spring.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pizza.spring.modele.Commande;
import pizza.spring.modele.Pizza;
import pizza.spring.modele.TraitementDTO;
import pizza.spring.service.PizzaService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AccueilControleur {

	@Autowired
	private PizzaService pizzaService;

	@GetMapping({"/", "/accueil"})
	public String accueil(Model model) {
		List<Commande> result = pizzaService.getListeCommande();
		model.addAttribute("result", result);
		return "accueil";
	}

	@PostMapping("/traitement")
	public String traitement(@RequestParam("listId") List<String> idPizzas, @Validated @ModelAttribute TraitementDTO traitementDTO, Model model){

	    pizzaService.newCommande(traitementDTO);

	    List<Commande> pizzas = pizzaService.getListeCommande();
		model.addAttribute("pizzas", pizzas);
		return "accueil";
	}

    @PostMapping("/valideCommande")
    public String valideCommande(@RequestParam("id") long id){

	    pizzaService.saveResult(id);

        return "accueil";
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
