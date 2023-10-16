/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Connection;
import java.sql.Date;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface PersonneLocal {
    
    public String getId();
    public void setId(String id);
    public String getFamilyName();

    public void setFamilyName(String familyName);

    public String getFirstName();

    public void setFirstName(String firstName);

    public Date getBirthday();

    public void setBirthday(Date birthday);

    public String getCommune();

    public void setCommune(String commune);

    public String getAddresse();

    public void setAddresse(String addresse);

    public int getGenre();

    public void setGenre(int genre);
    
    
    public String getNom();
    
    public Personne getPersonneByCIN(String cin);
    
    public void addPersonne(String nom,String prenom,Date birth,String commune,String addr,int genre);
    
}
