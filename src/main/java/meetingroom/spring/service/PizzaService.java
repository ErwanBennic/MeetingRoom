package meetingroom.spring.service;

import java.util.ArrayList;
import java.util.List;

import meetingroom.spring.dao.PizzaDao;
import meetingroom.spring.modele.TraitementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import meetingroom.spring.modele.Commande;
import meetingroom.spring.modele.Pizza;

import javax.transaction.Transactional;

@Service
public class PizzaService {

	@Autowired
	private PizzaDao pizzaDao;

	public List<Commande> getListeCommande() {
			return pizzaDao.getListeCommande();
	}

	public List<Pizza> getListePizza() {
		return pizzaDao.getListePizza();
	}

	public Pizza findPizza(long id) {
		return pizzaDao.findPizza(id);
	}

	public Commande getFistCommande() {
		return pizzaDao.getFistCommande();
	}


	@Transactional
	public void newCommande(TraitementDTO traitementDTO){
		List<Pizza> pizzaList = new ArrayList<>();
		Commande commande = new Commande(traitementDTO.getNom(), traitementDTO.getTelephone());
		for (String id: traitementDTO.getListId()) {
			long theid = Long.parseLong(id);
			Pizza pizza = findPizza(theid);
			pizzaList.add(pizza);
		}
		commande.setPizzasList(pizzaList);
		pizzaDao.insertResult(commande);
	}

    @Transactional
    public void saveResult(long id){
		Commande commande = pizzaDao.findCommande(id);
		commande.setEnAttente(false);
        pizzaDao.insertResult(commande);
    }
	
}
