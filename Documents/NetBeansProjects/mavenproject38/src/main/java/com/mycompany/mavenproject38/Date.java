
package com.mycompany.mavenproject38;


public class Date {
    
    private int manth;
    private int day;
    private int hour;

    public Date(int manth, int day, int hour) {
        this.manth = manth;
        this.day = day;
        setHour(hour);
    }

    public int getManth() {
        return manth;
    }

    public void setManth(int manth) {
        this.manth = manth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if(hour==10 || hour==14){
            this.hour=hour;
        }
        else{
            System.out.println("invaild hour !");
        }
    }

    @Override
    public String toString() {
        return "Date{" + "manth=" + manth + ", day=" + day + ", hour=" + hour + '}';
    }
    
    
}
