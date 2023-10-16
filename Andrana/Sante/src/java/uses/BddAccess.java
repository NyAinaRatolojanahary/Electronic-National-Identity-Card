/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class BddAccess {
    
    private String sgbd;
    private String user;
    private String password;
    private String prefix = "PK";
    private int PkLength = 8;
    private String sequenceName ="getSequence"+ prefix;

    public String getSgbd(){
        return sgbd;
    }

    public String getUser(){
        return user;
    }

    public String getPassword(){
        return password;
    }

    public String getPrefix(){
        return prefix;
    }

    public int getPkLength(){
        return PkLength;
    }

    public String getSequenceName(){
        return sequenceName;
    }

    public void setSgbd(String sgbd){
        this.sgbd = sgbd;
    }

    public void setUser(String usr){
        this.user = usr;
    }

    public void setPassword(String pass){
        this.password = pass;
    }

    public void setPrefix(String prfx){
        this.prefix = prfx;
    }

    public void setPkLength(int lngth){
        this.PkLength = lngth;
    }

    public void setSequenceName(String sqName){
        this.sequenceName = sqName;
    }

    public BddAccess(){}

    public BddAccess(String PK,int lgthPK){
        this.setPrefix(PK);
        this.setPkLength(lgthPK);
    }

    public BddAccess(String sgbd,String user,String pass,String PK,int lgthPK){
        this.setSgbd(sgbd);
        this.setUser(user);
        this.setPassword(pass);
        this.setPrefix(PK);
        this.setPkLength(lgthPK);
    }


    // Select generaliser

    public Object selectAll(Connection c,String tableName) throws Exception{
        ConnectBase con = null;
        if (c==null) {
            try {
                con = new ConnectBase();
                Connection cn = con.connectToDataBase();
                Statement st = cn.createStatement();
                String requete = "Select * from" + tableName;
                ResultSet res = st.executeQuery(requete);
                ArrayList<Object> lsobj = new ArrayList<Object>();
                Field[] attribut = this.getClass().getDeclaredFields();
                while(res.next()){
                    Object newObjet = this.getClass().newInstance(); // this.obje ts.getClass().newInstance();
                    for (int i = 0; i < attribut.length; i++) {
                        if (attribut[i].getType().getName() == "double") {
                            double val = res.getDouble(attribut[i].getName());
                            newObjet.getClass().getMethod("set" + attribut[i].getName(), double.class).invoke(newObjet, val);
                        }
                        if (attribut[i].getType().isInstance(new String())) {
                            String val = res.getString(attribut[i].getName());
                            newObjet.getClass().getMethod("set" + attribut[i].getName(), String.class).invoke(newObjet, val);
                        }
                        if (attribut[i].getType().isInstance(new Date())) {
                            Date val = res.getDate(attribut[i].getName());
                            newObjet.getClass().getMethod("set" + attribut[i].getName(), Date.class).invoke(newObjet, val);
                        }
                    }
                    lsobj.add(newObjet);
                }
                st.close();
                cn.close();
                return lsobj;

            } catch (Exception e) {
                System.out.println(e);
                throw e;
            }

        } else {
            try {
                Statement st = c.createStatement();
                String requete = "Select * from " + tableName;
                ResultSet res = st.executeQuery(requete);
                ArrayList<Object> lsobj = new ArrayList<Object>();
                Field[] attribut = this.getClass().getDeclaredFields();
                while(res.next()){
                    Object newObjet = this.getClass().newInstance(); // this.obje ts.getClass().newInstance();
                    for (int i = 0; i < attribut.length; i++) {
                        if (attribut[i].getType().getName() == "double") {
                            double val = res.getDouble(attribut[i].getName());
                            newObjet.getClass().getMethod("set" + attribut[i].getName(), double.class).invoke(newObjet, val);
                        }
                        if (attribut[i].getType().isInstance(new String())) {
                            String val = res.getString(attribut[i].getName());
                            newObjet.getClass().getMethod("set" + attribut[i].getName(), String.class).invoke(newObjet, val);
                        }
                        if (attribut[i].getType().isInstance(new Date())) {
                            Date val = res.getDate(attribut[i].getName());
                            newObjet.getClass().getMethod("set" + attribut[i].getName(), Date.class).invoke(newObjet, val);
                        }
                    }
                    lsobj.add(newObjet);
                }
                st.close();
                c.close();
                return lsobj;

            } catch (Exception e) {
                System.out.println(e);
                throw e;
            }
        }
    }

    // Insert Generaliser
    public void Insert(Connection c,String tableName) throws Exception{
        ConnectBase con = null;
        if (c==null) {
            try {
                con = new ConnectBase();
                Connection cn = con.connectToDataBase();
                Statement st = cn.createStatement();
                
                Field[] attributs= this.getClass().getDeclaredFields();
                String syntaxe= "Insert into" + tableName + "Values (";
                String valTemp= null;
                String linkValTemp;
                String rel=null;

                for(int i=0; i<attributs.length; i++){
                    valTemp= "'"+ this.getClass().getMethod("get" + attributs[i].getName()).invoke(this) +"'";
                    if(i!= attributs.length){   linkValTemp= ",";}
                    else{   linkValTemp=")";}
                    rel+= valTemp + linkValTemp;
                }

                st.executeQuery(syntaxe+rel);
                cn.commit();
                st.close();
                cn.close();
                
            }
            catch (Exception e) {
                throw e;
            }
        } else {
            try {
                Statement st = c.createStatement();
                
                Field[] attributs= this.getClass().getDeclaredFields();
                String syntaxe= "Insert into " + tableName + " Values (";
                String valTemp= null;
                String linkValTemp;
                String rel=null;

                for(int i=0; i<attributs.length; i++){
                    valTemp= "'"+ this.getClass().getMethod("get" + attributs[i].getName()).invoke(this) +"'";
                    if(i!= attributs.length){   linkValTemp= ",";}
                    else{   linkValTemp=")";}
                    rel+= valTemp + linkValTemp;
                }

                st.executeQuery(syntaxe+rel);
                c.commit();
                st.close();
                c.close();

            } catch (Exception e) {
                throw e;
            }
        }
        
    }

    public String completeZero(int seq, int lc){
        String result = "";
        int lenPref = getPrefix().length();
        int longPk = getPkLength();
        int L= longPk - lenPref - String.valueOf(seq).length();
        for (int i = 0; i < L; i++) {
            result = result.concat("0");
        }
        String id = getPrefix() + result+ seq;
        return id;
    }

    public int getseq(Connection c) throws Exception {
        String sql = "SELECT " + getSequenceName() + "()";
        System.out.println(sql);
        Statement stmt = c.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        result.next();
        int seq = result.getInt(1);
        return seq;
    }

    public String construirePK(Connection c) throws Exception{
        int seq= getseq(c);
        return completeZero(seq, getPkLength());
    }
    
}
