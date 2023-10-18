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
import uses.ConnectBaseBank;

/**
 *
 * @author ASUS
 */
@Stateless
public class ActionBanque implements ActionBanqueLocal {

    public int id;
    public String nomAction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomAction() {
        return nomAction;
    }

    public void setNomAction(String nomAction) {
        this.nomAction = nomAction;
    }

    public ActionBanque() {}

    public ActionBanque(int id, String nomAction) {
        this.id = id;
        this.nomAction = nomAction;
    }
    
    public ArrayList<ActionBanque> getAllActionBanque(){
        ArrayList<ActionBanque> lists = new ArrayList<ActionBanque>();
        ConnectBaseBank cb = new ConnectBaseBank();
        Connection c = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from bank_action_type;";
            try{
                c = cb.connectToDataBase();
                st = c.createStatement();
                rs = st.executeQuery(sql);
                while(rs.next()){
                    ActionBanque ac = new ActionBanque();
                    ac.setId(rs.getInt("id"));
                    ac.setNomAction(rs.getString("nomAction"));
                    lists.add(ac);
                }
            }
            catch(Exception e){e.printStackTrace();}
            finally{
            if(rs!=null)try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ActionBanque.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(st!=null)try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ActionBanque.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(c!=null)try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(ActionBanque.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return lists;
    }
    
    public static void main(String[] args){
        ActionBanque d = new ActionBanque();
        ArrayList<ActionBanque> ls = d.getAllActionBanque();
//        for(int i=0; i<ls.size(); i++){
            System.out.println(ls.size());
//        }
//        
    }
}
