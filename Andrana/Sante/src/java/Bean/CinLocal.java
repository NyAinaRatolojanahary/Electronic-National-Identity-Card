/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Date;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface CinLocal {
    
    public void addCin(String nom,String prenom,Date delivery,String profession,String commune);
}
