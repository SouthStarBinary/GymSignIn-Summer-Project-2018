/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saves;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import persons.Member;

/**
 *
 * @author jeanp
 */
public class SaveMembers {
    
    public void save (ArrayList<Member> member) {
              try {
         FileOutputStream fileOut = new FileOutputStream("employee.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(member);
         out.close();
         fileOut.close();
         System.out.println("Serialized data is saved in employee.ser");
      } catch (IOException i) {
         i.printStackTrace();
      }
    }
    
    public ArrayList<Member> load () {
        ArrayList<Member> list = null;
         try {
         FileInputStream fileIn = new FileInputStream("employee.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         list = (ArrayList<Member>) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
      } catch (ClassNotFoundException c) {
         System.out.println("Employee class not found");
         c.printStackTrace();
      }
        return list;
    }
    
}
