/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

public abstract class Member {

    private String ID;
    private String membershipType;
    private ArrayList<String> checkInHistory;
	
    public Member (String ID, String memType) { 
	this.ID = ID;
	this.membershipType = memType;
	this.checkInHistory = new ArrayList<>();
    }
	
    public String getID () { 
	return this.ID;
    }
	
    public void updateMemberType (String newMemType) { 
	this.membershipType = newMemType;
    }
	
    public String signInTime () {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat f = new SimpleDateFormat("MM.dd.yyyy G 'at' HH:mm:ss z");
	return f.format(cal.getTime());
    }
	
    @Override
    public String toString() { 
	return this.getClass().getSimpleName() + " " + ID + " " + membershipType;
    }
}

