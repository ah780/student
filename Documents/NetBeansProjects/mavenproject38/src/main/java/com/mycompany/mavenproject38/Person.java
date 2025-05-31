
package com.mycompany.mavenproject38;

import java.util.Date;


public class Person {
    
    String name;
    int id;
    Date pirthDate;

    public Person(String name, int id, Date pirthDate) {
        this.name = name;
        this.id = id;
        this.pirthDate = pirthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPirthDate() {
        return pirthDate;
    }

    public void setPirthDate(Date pirthDate) {
        this.pirthDate = pirthDate;
    }
    
    public int getAge(){
        return 2025-pirthDate.getYear();
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", id=" + id + ", pirthDate=" + pirthDate + '}';
    }
    
}
