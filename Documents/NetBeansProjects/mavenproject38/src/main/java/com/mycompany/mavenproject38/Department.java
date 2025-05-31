
package com.mycompany.mavenproject38;

import java.util.Arrays;


public class Department implements Checable {
    
    Patint [] patint;
    private int c=0;
    private int max;
    public Department() {
        max=5;
        patint=new Patint[max];
    }

    public Patint getPatint(int index) {
        return patint[index];
    }
    public Patint[] getPatint(){
        return patint;
    }

    public void setPatint(Patint p) {
        
        if(c<max){
        
        this.patint[c++] = p ;
        }
        else{
            System.out.println("the department is already full !");
        }
    }

    @Override
    public String toString() {
        return "Department{" + "patint=" + Arrays.toString(patint) + '}';
    }

    @Override
    public void chek(Object o) {
        
        if(c>=max){
            System.out.println("you cant add new patint");
            return ;
        }
        if(!(o instanceof Patint )){
            System.out.println("invaild tybe of object");
            return ;
        }
        System.out.println("you can add new patint");
     
    }
}
