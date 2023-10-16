/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import uses.BddAccess;
import uses.ConnectBaseBank;

/**
 *
 * @author ASUS
 */
@Stateless
public class Banque extends BddAccess implements BanqueLocal {

    public String id; 
    public String bank_name;
    public String bank_location;
    public String commune;
    public String count_name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_location() {
        return bank_location;
    }

    public void setBank_location(String bank_location) {
        this.bank_location = bank_location;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getCount_name() {
        return count_name;
    }

    public void setCount_name(String count_name) {
        this.count_name = count_name;
    }
    
    
    

    public Banque() {
        super("Bk", 15);
    }

    
    public Banque(String id, String bank_name, String bank_location, String commune, String count_name) {
        super("Bk", 15);
        this.id = id;
        this.bank_name = bank_name;
        this.bank_location = bank_location;
        this.commune = commune;
        this.count_name = count_name;
    }
    
    
    public Banque getBanqueInfoByCIN(String cin){
        
        Banque p = new Banque();
        ConnectBaseBank cb = new ConnectBaseBank();
        Connection c = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = " select * from bank_count join count_type on count_type.id=bank_count.idcount_type join bank on bank.id=bank_count.idbank where bank_count.cin='"+cin+"';";
        try{
            c = cb.connectToDataBase();
            st = c.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Banque pr = new Banque();
                pr.setId(rs.getString("id"));
                pr.setBank_name(rs.getString("bank_name"));
                pr.setBank_location(rs.getString("bank_location"));
                pr.setCommune(rs.getString("idCommune_location"));
                pr.setCount_name(rs.getString("count_name"));
                p = pr;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null)try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Banque.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(st!=null)try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Banque.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(c!=null)try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Banque.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
        return p;
    }
    
    public static void main(String[] args){
        Banque b= new Banque();
        try{
        Banque r = b.getBanqueInfoByCIN("Cin2");
        System.out.print(r.getBank_name());}
        catch(Exception e){e.printStackTrace();}
        
    }
    
}
