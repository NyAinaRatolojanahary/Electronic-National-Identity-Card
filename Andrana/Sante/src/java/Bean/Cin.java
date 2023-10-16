/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Date;
import javax.ejb.Stateless;
import uses.BddAccess;

/**
 *
 * @author ASUS
 */
@Stateless
public class Cin extends BddAccess implements CinLocal {

    public String id;
    public String idPersonne;
    public Date delivery;
    public String commune;
    public String profession;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(String idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Date getDelivery() {
        return delivery;
    }

    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    public Cin() {
    }


    public Cin(String PK, int lgthPK) {
        super("Cin", 15);
    }

    public Cin(String id, String profession) {
        super("Cin", 15);
        this.id = id;
        this.profession = profession;
    }
    

    public Cin(String id, String idPersonne, Date delivery, String commune, String profession, String PK, int lgthPK) {
        super("Cin", 15);
        this.id = id;
        this.idPersonne = idPersonne;
        this.delivery = delivery;
        this.commune = commune;
        this.profession = profession;
    }
    
    
    
    
    public void addCin(String nom,String prenom,Date delivery,String profession,String commune){
        
    }
}
