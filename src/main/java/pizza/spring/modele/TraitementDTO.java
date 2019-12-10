package pizza.spring.modele;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;


public class TraitementDTO {
    private String nom;
    private String telephone;
    private List<String> listId = new ArrayList<>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<String> getListId() {
        return listId;
    }

    public void setListId(List<String> listId) {
        this.listId = listId;
    }
}
