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
public interface ActionBanqueLocal {
    
    public int getId();

    public void setId(int id);

    public String getNomAction();

    public void setNomAction(String nomAction);
    
    public ArrayList<ActionBanque> getAllActionBanque();
}
