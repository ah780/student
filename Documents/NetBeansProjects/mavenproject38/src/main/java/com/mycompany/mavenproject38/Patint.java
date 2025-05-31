
package com.mycompany.mavenproject38;

import java.util.Date;


public class Patint extends Person {
    
    Department dept;

    public Patint(String name , int id , Date pirthDate ,Department dept) {
        super(name,id,pirthDate);
        this.dept=dept;
    }
    public Patint(String name , int id , Date pirthDate ){
        super(name,id,pirthDate);
    }
    public Department getDept() {
        return dept;
    }
    public void setDept(Department dept) {
        this.dept = dept;
    }
    @Override
    public String toString() {
        return super.toString()+"Patint{" + "dept=" + dept + '}';
    }
}
