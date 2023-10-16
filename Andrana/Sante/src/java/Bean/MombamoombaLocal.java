/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface MombamoombaLocal {
    
   public Personne getPr();
    public void setPr(Personne pr);

    public Commune getCm();

    public void setCm(Commune cm);

    public Cin getCn();

    public void setCn(Cin cn) ;
    
    public Mombamoomba getInfoPersonneByCIN(String cin);
    
}
