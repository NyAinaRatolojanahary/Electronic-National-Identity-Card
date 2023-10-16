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
import uses.ConnectBase;

/**
 *
 * @author ASUS
 */
@Stateless
public class Mombamoomba implements MombamoombaLocal {

    Personne pr;
    Commune cm;
    Cin cn;

    public Personne getPr() {
        return pr;
    }

    public void setPr(Personne pr) {
        this.pr = pr;
    }

    public Commune getCm() {
        return cm;
    }

    public void setCm(Commune cm) {
        this.cm = cm;
    }

    public Cin getCn() {
        return cn;
    }

    public void setCn(Cin cn) {
        this.cn = cn;
    }
    
    public Mombamoomba getInfoPersonneByCIN(String cin){
        
        
        Mombamoomba mb = new Mombamoomba();
        ConnectBase cb = new ConnectBase();
        Connection c = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select cin.id,person.family_name,person.first_name,person.birthday,commune.commune_name,person.gender,person.location,cin.profession from person join cin on cin.idperson=person.id join commune on commune.id=person.idcommune_birth where cin.id='"+cin+"';";
        System.out.print(sql);
        try{
            c = cb.connectToDataBase();
            st = c.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Personne pr = new Personne();
                Commune cm = new Commune();
                Cin cni = new Cin(); 
                pr.setFamilyName(rs.getString("family_name"));
                pr.setFirstName(rs.getString("first_name"));
                pr.setBirthday(rs.getDate("birthday"));
                pr.setCommune("idcommune_birth");
                pr.setAddresse(rs.getString("location"));
                pr.setGenre(rs.getInt("gender"));
                cm.setNomCommune(rs.getString("commune_name"));
                cni.setId(rs.getString("id"));
                cni.setProfession(rs.getString("profession"));
                mb.setPr(pr);
                mb.setCm(cm);
                mb.setCn(cni);
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
        
        return mb;
    }
    
    public static void main(String[] args){
        
        Mombamoomba mb = new Mombamoomba().getInfoPersonneByCIN("Cin10");
        System.out.println(mb.getPr().getFamilyName());
        
    }
    
}
