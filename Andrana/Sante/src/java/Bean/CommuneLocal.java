/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface CommuneLocal {
    
    public String getId();

    public void setId(String id);

    public String getNomCommune();

    public void setNomCommune(String nomCommune);

    public String getDistrict();

    public void setDistrict(String district);
    
    public ArrayList<Commune> getAllCommune();
}
