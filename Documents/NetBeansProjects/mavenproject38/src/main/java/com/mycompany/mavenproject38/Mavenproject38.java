package com.mycompany.mavenproject38;

import java.util.Date;

public class Mavenproject38 {

    public static void main(String[] args) {

       Department d1 = new Department("Med");
        Department d2 = new Department("high");
         Department d3 = new Department("easy");
       Patint p1 = new Patint("ali",111, new java.util.Date(2005 - 1900, 1, 1),d1);
       Patint p2 = new Patint("MahmoD",112, new java.util.Date(2004 - 1900, 12, 11),d1);
       
       d1.setPatint(p1);
       d1.setPatint(p2);
       
       Department [] all= {d1,d2,d3};
       printDeptPatint(all);

    }

    public static void printDeptPatint(Department[] dept) {

        for (Department dept1 : dept) {
           for(Patint p : dept1.getPatint()){
               if(p!=null){
                   String name = p.getName();
                   
                   if(name.startsWith('M'+"") || name.startsWith('m'+"") && name.endsWith('d'+"") || name.endsWith('D'+"")){
                       System.out.println("Department "+dept1.getName() + " Patint "+name);
                   }
               }
           }
        }

    }
}
