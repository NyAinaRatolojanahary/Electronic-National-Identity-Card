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
public interface TransfertArgentLocal {
    
    public int getId();

    public void setId(int id);

    public int getActionBanque();

    public void setActionBanque(int actionBanque);

    public int getDevise();

    public void setDevise(int devise);

    public double getSomme();

    public void setSomme(double somme);

    public Date getDateAction();

    public void setDateAction(Date dateAction);

    public String getSender();

    public void setSender(String sender);

    public String getRecepient();

    public void setRecepient(String recepient);
    
    public boolean checkCount(String cin1, double sommeAlefa);
    
    public void transfererArgent(String cin1, String cin2,int action,int devise, double somme)throws Exception;
}
