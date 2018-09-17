/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import java.util.ArrayList;

/**
 *
 * @author jeanp
 */
public class Trainer extends Member {
    
    private ArrayList<Client> trainerClients = new ArrayList<>();
    
    public Trainer (String ID, String firstName, String lastName, String memType) {
        super(ID, firstName, lastName,memType);
    }
    
    @Override
    public String toString () {
        return super.toString();
    }
}
