/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import uses.ConnectBase;

/**
 *
 * @author ASUS
 */
@Stateless
public class Devise implements DeviseLocal {

    public int iddevise;
    public String nomDevise;
    public int idcoursdevise;
    public double somme;
    public Date datedevise;
    public double tauxvente;

    public double getTauxvente() {
        return tauxvente;
    }

    public void setTauxvente(double tauxvente) {
        this.tauxvente = tauxvente;
    }

    

    public int getIddevise() {
        return iddevise;
    }

    public void setIddevise(int iddevise) {
        this.iddevise = iddevise;
    }

    public String getNomDevise() {
        return nomDevise;
    }

    public void setNomDevise(String nomDevise) {
        this.nomDevise = nomDevise;
    }

    public int getIdcoursdevise() {
        return idcoursdevise;
    }

    public void setIdcoursdevise(int idcoursdevise) {
        this.idcoursdevise = idcoursdevise;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public Date getDatedevise() {
        return datedevise;
    }

    public void setDatedevise(Date datedevise) {
        this.datedevise = datedevise;
    }

    public Devise() {}

    public Devise(int iddevise, String nomDevise) {
        this.iddevise = iddevise;
        this.nomDevise = nomDevise;
    }

    public Devise(String nomDevise, double somme,double tauxvente, Date datedevise) {
        this.nomDevise = nomDevise;
        this.somme = somme;
        this.tauxvente = tauxvente;
        this.datedevise = datedevise;
    }
    

    public Devise(int iddevise, int idcoursdevise, double somme,double tauxvente, Date datedevise) {
        this.iddevise = iddevise;
        this.idcoursdevise = idcoursdevise;
        this.somme = somme;
        this.tauxvente = tauxvente;
        this.datedevise = datedevise;
    }

    public Devise(double somme) {
        this.somme = somme;
    }
    
    
    
    public ArrayList<Devise> getAllDevise(){
        ArrayList<Devise> lists = new ArrayList<Devise>();
        ConnectBase cb = new ConnectBase();
        Connection c = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from devise;";
            try{
                c = cb.connectToDataBase();
                st = c.createStatement();
                rs = st.executeQuery(sql);
                while(rs.next()){
                    Devise d = new Devise();
                    d.setIddevise(rs.getInt("id"));
                    d.setNomDevise(rs.getString("nomdevise"));
                    somme = d.getSomme();
                    lists.add(d);
                }
            }
            catch(Exception e){e.printStackTrace();}
            finally{
            if(rs!=null)try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Devise.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(st!=null)try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Devise.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(c!=null)try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Devise.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return lists;
    }
    
    public double getDeviseByDate(int iddevise){
        double somme = 0;
        ConnectBase cb = new ConnectBase();
        Connection c = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select devise.nomdevise,cours_devise.somme,cours_devise.datedevise,cours_devise.tauxvente from cours_devise join devise on devise.id=cours_devise.iddevise where devise.id="+iddevise+" order by cours_devise.datedevise limit 1;";
        try{
            c = cb.connectToDataBase();
            st = c.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Devise d = new Devise();
                d.setNomDevise(rs.getString("nomdevise"));
                d.setSomme(Double.valueOf(rs.getString("somme")));
                d.setTauxvente(Double.valueOf(rs.getString("tauxvente")));
                d.setDatedevise(rs.getDate("datedevise"));
                somme = d.getTauxvente();
            }
        }
        catch(Exception e){e.printStackTrace();}
        finally{
            if(rs!=null)try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Devise.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(st!=null)try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Devise.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(c!=null)try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Devise.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return somme;
    }
    
    public double changeDeviseEnAr(int iddevise,double sommeAlefa){
        double sommeTransfert = 0;
        double tauxDevise = this.getDeviseByDate(iddevise);
        System.out.println(tauxDevise);
        sommeTransfert = tauxDevise * sommeAlefa;
        return sommeTransfert;
    }
    
    public void AjoutDevise(String somme,String tauxvente,int devise,String date) throws Exception{
       
        double sommeDevise = Double.parseDouble(somme);
        double tv = Double.parseDouble(tauxvente);
        Date dt = Date.valueOf(date);
        
        ConnectBase cb = new ConnectBase();
        Connection c = null;
        Statement st = null;
        String sql1 = "Insert into cours_devise(id,iddevise,somme,datedevise,tauxvente) values(default,"+devise+","+ sommeDevise+",'"+ dt+"',"+tv+");";
        try{
            c = cb.connectToDataBase();
            st = c.createStatement();
            st.execute(sql1);
        }
        catch(Exception e){
            
            e.printStackTrace();
        }
        finally{
            if(st!=null)try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Devise.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(c!=null)try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Devise.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }
    
    
    public double sommeToTauxAchat(int devise,Date date,double sommeAlefa) throws SQLException{
        double somme = 0;
        
        ConnectBase cb = new ConnectBase();
        Connection c = null;
        Statement st = null;
        String sql1 = "select somme from cours_devise where iddevise='"+devise+"' and dateDevise='"+date+"';";
        try{
            Devise d = new Devise();
            c = cb.connectToDataBase();
            st = c.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql1);
            while(rs.next()){
                 d.setSomme(Double.valueOf(rs.getString("somme")));
            somme = sommeAlefa * d.getSomme();
            }
        }
        catch(Exception e){
            c.rollback();
            e.printStackTrace();
        }
        finally{
            if(st!=null)try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Devise.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(c!=null)try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Devise.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
        
        return somme;
    }

    public double sommeToTauxVente(int devise,Date date,double sommeAlefa) throws SQLException{
        double somme = 0;
        
        ConnectBase cb = new ConnectBase();
        Connection c = null;
        Statement st = null;
        String sql1 = "select tauxvente from cours_devise where iddevise='"+devise+"' and dateDevise='"+date+"';";
        try{
            Devise d = new Devise();
            c = cb.connectToDataBase();
            st = c.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql1);
            while(rs.next()){
                 d.setSomme(Double.valueOf(rs.getString("somme")));
            somme = sommeAlefa * d.getSomme();
            }
           return somme;
        }
        catch(Exception e){
            c.rollback();
            e.printStackTrace();
        }
        finally{
            if(st!=null)try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Devise.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(c!=null)try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Devise.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
        
        return somme;
    }
    
    public static void main(String[] args){
        Devise d = new Devise();
         
    }
    
    
}
