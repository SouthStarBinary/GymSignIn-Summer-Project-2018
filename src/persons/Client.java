/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

/**
 *
 * @author jeanp
 */
public class Client extends Member {
    
    //Trainer trainer;
    String trainer;
    
    public Client(String ID, String memType, String Trainer) {
        super(ID, memType);
        this.trainer = Trainer;
    }
    
    @Override
    public String toString() {
        return super.toString() + " " + trainer;
    }
    
    
}
