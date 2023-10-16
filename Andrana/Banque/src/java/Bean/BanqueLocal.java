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
public interface BanqueLocal {
    
    public String getId();

    public void setId(String id);

    public String getBank_name();

    public void setBank_name(String bank_name);

    public String getBank_location();

    public void setBank_location(String bank_location);

    public String getCommune();

    public void setCommune(String commune);

    public String getCount_name();

    public void setCount_name(String count_name);
    
    public Banque getBanqueInfoByCIN(String cin);
}
