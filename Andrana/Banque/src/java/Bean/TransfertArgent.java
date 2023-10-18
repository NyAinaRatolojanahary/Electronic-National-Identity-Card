/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Connection;
import javax.ejb.Stateless;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import uses.ConnectBaseBank;


/**
 *
 * @author ASUS
 */
@Stateless
public class TransfertArgent implements TransfertArgentLocal {

    public int id;
    public int actionBanque;
    public int devise;
    public double somme;
    public Date dateAction;
    public String sender;
    public String recepient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActionBanque() {
        return actionBanque;
    }

    public void setActionBanque(int actionBanque) {
        this.actionBanque = actionBanque;
    }

    public int getDevise() {
        return devise;
    }

    public void setDevise(int devise) {
        this.devise = devise;
    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

    public Date getDateAction() {
        return dateAction;
    }

    public void setDateAction(Date dateAction) {
        this.dateAction = dateAction;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecepient() {
        return recepient;
    }

    public void setRecepient(String recepient) {
        this.recepient = recepient;
    }

    public TransfertArgent() {
    }

    public TransfertArgent(double somme) {
        this.somme = somme;
    }

    public TransfertArgent(int id, int actionBanque, int devise, double somme, Date dateAction, String sender, String recepient) {
        this.id = id;
        this.actionBanque = actionBanque;
        this.devise = devise;
        this.somme = somme;
        this.dateAction = dateAction;
        this.sender = sender;
        this.recepient = recepient;
    }

    public TransfertArgent(int actionBanque, int devise, double somme, String sender, String recepient) {
        this.actionBanque = actionBanque;
        this.devise = devise;
        this.somme = somme;
        this.sender = sender;
        this.recepient = recepient;
    }
    

    public TransfertArgent(int actionBanque, int devise, double somme, Date dateAction, String sender, String recepient) {
        this.actionBanque = actionBanque;
        this.devise = devise;
        this.somme = somme;
        this.dateAction = dateAction;
        this.sender = sender;
        this.recepient = recepient;
    }

    public boolean checkCount(String cin1, double sommeAlefa) {
        double solde = 0;
        

        ConnectBaseBank cb = new ConnectBaseBank();
        Connection c = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select sum(somme) as solde from bank_count_history where idsender='" + cin1 + "';";
        try {
            c = cb.connectToDataBase();
            st = c.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                TransfertArgent t = new TransfertArgent();
                t.setSomme(rs.getDouble("solde"));
                solde = t.getSomme();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(st!=null)try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransfertArgent.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(c!=null)try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransfertArgent.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }

        if (solde > sommeAlefa) {
            return true;
        } else {
            return false;
        }
    }
    
    

    public void transfererArgent(String cin1, String cin2,int action,int devise, double somme) throws Exception{
       
        TransfertArgent compte1 = new TransfertArgent(action,devise,somme,cin1,cin2);
        TransfertArgent compte2 = new TransfertArgent(4,devise,somme,cin2,cin1);
        
        ConnectBaseBank cb = new ConnectBaseBank();
        Connection c = null;
        Statement st = null;
        String sql1 = "Insert into bank_count_history(id,idbank_action_type,iddevise,somme,dateAction,idsender,idrecipient) values(default,"+compte1.getActionBanque()+","+ compte1.getDevise()+","+ (-1)*compte1.getSomme()+",now()::date,'"+ compte1.getSender()+"','"+ compte1.getRecepient()+"');";
        String sql2 = "Insert into bank_count_history(id,idbank_action_type,iddevise,somme,dateAction,idsender,idrecipient) values(default,"+compte2.getActionBanque()+","+ compte2.getDevise()+","+ compte2.getSomme()+",now()::date,'"+ compte2.getSender()+"','"+ compte2.getRecepient()+"');";
        try{
            c = cb.connectToDataBase();
            st = c.createStatement();
            st.execute(sql1);
            st.execute(sql2);
        }
        catch(Exception e){
            c.rollback();
            e.printStackTrace();
        }
        finally{
            if(st!=null)try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransfertArgent.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(c!=null)try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransfertArgent.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
            
       
    }
    
    public void tauxAchatAction(String cin1,int action,int devise, double somme) throws Exception{
       
        TransfertArgent compte1 = new TransfertArgent(action,devise,somme,cin1,cin1);
        TransfertArgent compte2 = new TransfertArgent(4,devise,somme,cin1,cin1);
        
        ConnectBaseBank cb = new ConnectBaseBank();
        Connection c = null;
        Statement st = null;
        String sql1 = "Insert into bank_count_history(id,idbank_action_type,iddevise,somme,dateAction,idsender,idrecipient) values(default,"+compte1.getActionBanque()+","+ compte1.getDevise()+","+ (-1)*compte1.getSomme()+",now()::date,'"+ compte1.getSender()+"','"+ compte1.getRecepient()+"');";
        String sql2 = "Insert into bank_count_history(id,idbank_action_type,iddevise,somme,dateAction,idsender,idrecipient) values(default,"+compte2.getActionBanque()+","+ compte2.getDevise()+","+ compte2.getSomme()+",now()::date,'"+ compte2.getSender()+"','"+ compte2.getRecepient()+"');";
        try{
            c = cb.connectToDataBase();
            st = c.createStatement();
            st.execute(sql1);
            st.execute(sql2);
        }
        catch(Exception e){
            c.rollback();
            e.printStackTrace();
        }
        finally{
            if(st!=null)try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransfertArgent.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(c!=null)try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(TransfertArgent.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
            
       
    }

    public static void main(String[] args) {

        TransfertArgent t = new TransfertArgent();
        try {
            t.transfererArgent("Cin1", "Cin2", 1, 1, 300.0);
        } catch (Exception ex) {
            Logger.getLogger(TransfertArgent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
