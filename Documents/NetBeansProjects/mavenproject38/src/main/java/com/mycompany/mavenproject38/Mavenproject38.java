
package com.mycompany.mavenproject38;
import java.util.Date;

public class Mavenproject38 {

    public static void main(String[] args) {
        
       
        Date d = new Date(11,12,2006);
        
        Department [] dept = new Department[2];
        
        dept[0]=new Department();
        dept[0].setPatint(new Patint("mahmos",111,d));
        dept[0].setPatint(new Patint("ahmad",112,d));
        dept[0].setPatint(new Patint("ali",123,d));
        dept[0].setPatint(new Patint("mld",1234,d));
        dept[0].setPatint(new Patint("ali",123,d));
        dept[1]=new Department();
        dept[1].setPatint(new Patint("rami",222,d));
        dept[1].setPatint(new Patint("mlhomd",1235,d));
        dept[1].setPatint(new Patint("ali",123,d));
        dept[1].setPatint(new Patint("ali",123,d));
        dept[1].setPatint(new Patint("ali",123,d));
         
        printDeptPatint(dept);
        
    }
    
    public static void printDeptPatint(Department [] dept){
        
        for (int i = 0; i <dept.length; i++) {
            
            for (int j = 0; j <dept[i].getPatint().length; j++) {
                
                if(dept[i].getPatint(j).getName().charAt(0)=='M' ||dept[i].getPatint(j).getName().charAt(0)=='m'
                        &&dept[i].getPatint(j).getName().charAt(dept[i].getPatint(j).getName().length()-1)=='D' ||dept[i].getPatint(j).getName().charAt(dept[i].getPatint(j).getName().length()-1)=='d'
                        ){
                    System.out.println(dept[i]);
                }
                
            }
           
        }
        
    }
}
