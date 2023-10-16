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
public class Personne extends BddAccess implements PersonneLocal {
    
    public String id;
    public String familyName;
    public String firstName;
    public Date birthday;
    public String commune;
    public String addresse;
    public int genre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }
    
    public Personne(){super("prs",15);}
    
    public Personne(String familyName, String firstName, Date birthday, String commune, String addresse, int genre) throws Exception {
        super("prs",15);
        this.familyName = familyName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.commune = commune;
        this.addresse = addresse;
        this.genre = genre;
    }
    
    

    public Personne(String id, String familyName, String firstName, Date birthday, String commune, String addresse, int genre, String PK, int lgthPK) throws Exception {
        super("prs",15);
        this.id = id;
        this.familyName = familyName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.commune = commune;
        this.addresse = addresse;
        this.genre = genre;
    }
    
    public Personne(String familyName, String firstName, Date birthday, String commune, String addresse, int genre, String PK, int lgthPK) throws Exception {
        super("prs",15);
        this.familyName = familyName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.commune = commune;
        this.addresse = addresse;
        this.genre = genre;
    }

    @Override
    public String getNom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Personne getPersonneByCIN(String cin){
        
        Personne p = new Personne();
        ConnectBase cb = new ConnectBase();
        Connection c = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select person.id,person.family_name,person.first_name,person.birthday,person.idcommune_birth,person.gender,person.location from person join cin on cin.idperson=person.id where cin.id='"+cin+"';";
        try{
            c = cb.connectToDataBase();
            st = c.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Personne pr = new Personne();
                System.out.println(rs.getString("id"));
                pr.setId(rs.getString("id"));
                pr.setFamilyName(rs.getString("family_name"));
                pr.setFirstName(rs.getString("first_name"));
                pr.setBirthday(rs.getDate("birthday"));
                pr.setCommune("idcommune_birth");
                pr.setAddresse(rs.getString("location"));
                pr.setGenre(rs.getInt("gender"));
                p = pr;
                System.out.println(p.getBirthday());
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
        
        return p;
    }
    
    public void addPersonne(String nom,String prenom,Date birth,String commune,String addr,int genre){
        
        ConnectBase cb = new ConnectBase();
        Connection c = null;
        Statement st = null;
        try{
            c = cb.connectToDataBase();
            st = c.createStatement();
            Personne pr = new Personne(nom,prenom,birth,commune,addr,genre);
            String id = pr.construirePK(c);
            String sql = "Insert into personne(id,family_name,first_name,birthday,idcommune_birth,location,gender) values("+id+",'"+ pr.getFamilyName()+"'"+ pr.getFirstName()+"','"+ pr.getBirthday()+"','"+ pr.getCommune()+"','"+ pr.getAddresse()+"','"+ pr.getGenre()+"');";
            System.out.print(sql);
            st.executeQuery(sql);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(c!=null)try {
                c.commit();
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(st!=null)try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        }
        
    }
    
    
    public static void main(String[] args){
        Personne p = new Personne();
        try{
        Personne r = p.getPersonneByCIN("Cin1");
        System.out.print(r.getAddresse());}
        catch(Exception e){e.printStackTrace();}
        
    }

}
