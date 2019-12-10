package meetingroom.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import meetingroom.spring.modele.Commande;
import meetingroom.spring.modele.Pizza;

@Repository
public class PizzaDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public List<Pizza> getListePizza() {
		return em.createQuery("select p from Pizza p", Pizza.class)
				.getResultList();
	}

	@Transactional
	public List<Commande> getListeCommande() {
		return em.createQuery("select c from Commande c where c.enAttente = true", Commande.class)
				 .getResultList();
	}

	@Transactional
	public Commande getFistCommande() {

		List<Commande> commandes;

		commandes = em.createQuery("select c from Commande c left join fetch c.pizzasList where c.enAttente = true", Commande.class)
				.getResultList();

		if (commandes.size() < 1){
			return null;
		} else {
			Commande commande = commandes.get(0);
			return commande;
		}
	}

	public void insertResult(Commande commande){
		em.persist(commande);
	}


	public Pizza findPizza(long id) {
		List<Pizza> pizzas;
		pizzas = em.createQuery("select p from Pizza p where p.id = :id", Pizza.class)
				.setParameter("id", id).getResultList();
		if (pizzas.size() < 1){
			return null;
		} else {
			Pizza pizza = pizzas.get(0);
			return pizza;
		}
	}

	public Commande findCommande(long id) {
		List<Commande> commandes;
		commandes = em.createQuery("select c from Commande c where c.id = :id", Commande.class)
				.setParameter("id", id).getResultList();
		if (commandes.size() < 1){
			return null;
		} else {
			Commande commande = commandes.get(0);
			return commande;
		}
	}

	
}
