/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jeanp
 */
public class Driver {
    
    public void start () {
        Scanner scnr = new Scanner(System.in);
		
        Client test = new Client("ms123","Monthly", "N/A");
		
        ArrayList<Member> memList = new ArrayList<>();
		
	memList.add(test);
		
	//System.out.println(test.toString());
        //System.out.println(memList.get(0).toString());
        String usrIn = "";
	while (usrIn.compareTo("exit") != 0) {
		usrIn = scnr.nextLine();
                
                if (usrIn.equals("!n") || usrIn.equals("!l") || usrIn.equals("exit")) {
                getCmd(usrIn, memList);
                }
                else {
                System.out.println(usrIn + " " + test.signInTime());
		Member target = findMem(memList, usrIn);
		if (target == null) {
		    System.out.println("Member not found");
		}
		else {
		    System.out.println(target.toString());
		}
               }
	}
    } 
    
    private void getCmd (String usrIn, ArrayList<Member> memList) {
        switch (usrIn) {
            case "!n": memList.add(newMember());
                break;
            case "!l": listMembers(memList);
                break;
            case "exit": System.out.println("Goodbye");
                break;
            default: 
                break;
        }
    }
    
    private Member findMem (ArrayList<Member> l, String target) { 
	for (int i = 0; i < l.size(); i++) {
	    if (l.get(i).getID().compareTo(target) == 0) {
		return l.get(i);
	    }
	}
	return null;
    }
    
    private void listMembers (ArrayList<Member> l) {
        int k = 1;
        for (Member i : l) {
            System.out.println(k + ".)" + i.toString());
            k++;
        }
    }
    
    private Member newMember () {
        Scanner scnr = new Scanner (System.in);
        String usrInID;
        String usrInMemtype;
        String usrInTrainer;
        System.out.println("new id #:");
        usrInID = scnr.nextLine();
        System.out.println("new Membership Type: ");
        usrInMemtype = scnr.nextLine();
        if (usrInMemtype.contentEquals("Trainer") || usrInMemtype.contentEquals("trainer")) {
            Trainer newMember = new Trainer(usrInID, usrInMemtype);
            return newMember;
        } 
        System.out.println("Member's Trainer:");
        usrInTrainer = scnr.nextLine();
        Client newMember = new Client(usrInID, usrInMemtype, usrInTrainer);
        System.out.println("Member Saved");
        return newMember;
    }
}
