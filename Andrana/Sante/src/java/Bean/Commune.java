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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import uses.BddAccess;
import uses.ConnectBase;

/**
 *
 * @author ASUS
 */
@Stateless
public class Commune extends BddAccess implements CommuneLocal {

    public String id;
    public String nomCommune;
    public String district;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    
    public Commune(){super("Com",15);}

    public Commune(String nomCommune) {
        super("Com",15);
        this.nomCommune = nomCommune;
    }
    
    

    public Commune(String id, String nomCommune, String district, String PK, int lgthPK) {
        super("Com",15);
        this.id = id;
        this.nomCommune = nomCommune;
        this.district = district;
    }
    
    public ArrayList<Commune> getAllCommune(){
    
        ArrayList<Commune> cmn = new ArrayList<Commune>();
        ConnectBase cb = new ConnectBase();
        Connection c = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select * from commune;";
        try{
            c = cb.connectToDataBase();
            st = c.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Commune cm = new Commune();
                cm.setId(rs.getString("id"));
                cm.setNomCommune(rs.getString("commune_name"));
                cm.setDistrict(rs.getString("iddistrict"));
                cmn.add(cm);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null)try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(st!=null)try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(c!=null)try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
        return cmn;
    }
}