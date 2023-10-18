/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface DeviseLocal {
    
    public int getIddevise();

    public void setIddevise(int iddevise);

    public String getNomDevise();

    public void setNomDevise(String nomDevise);

    public int getIdcoursdevise();

    public void setIdcoursdevise(int idcoursdevise);

    public double getSomme();

    public void setSomme(double somme);

    public Date getDatedevise();

    public void setDatedevise(Date datedevise);
    
    public double getTauxvente();

    public void setTauxvente(double tauxvente);
    
    public ArrayList<Devise> getAllDevise();
    
    public double getDeviseByDate(int iddevise);
     
    public double changeDeviseEnAr(int iddevise,double sommeAlefa);
    
    public void AjoutDevise(String somme,String tauxvente,int devise,String date) throws Exception;
    
    public double sommeToTauxAchat(int devise,Date date,double sommeAlefa) throws SQLException;
    
    public double sommeToTauxVente(int devise,Date date,double sommeAlefa) throws SQLException;
    
}
