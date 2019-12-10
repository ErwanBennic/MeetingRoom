package pizza.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pizza.spring.dao.PizzaDao;
import pizza.spring.modele.Commande;
import pizza.spring.modele.Pizza;
import pizza.spring.modele.TraitementDTO;

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
