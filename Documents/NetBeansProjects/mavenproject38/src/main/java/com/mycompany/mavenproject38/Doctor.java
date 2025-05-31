package com.mycompany.mavenproject38;

import java.util.Arrays;

public class Doctor extends Person implements  Checable{

    Date[] apoitment;
    private int count;
    private int max;
    int countApotmentAtDay;

    public Doctor(String name, int id, java.util.Date pirthDate) {
        super(name, id, pirthDate);
        max = 10;
        apoitment = new Date[max];
    }

    public Date[] getApoitment() {
        return apoitment;
    }

    public void setApoitment(Date[] apoitment) {
        this.apoitment = apoitment;
    }

    public void addApoitment(Date d) {
        
        if(count>=max){
            System.out.println("the apotment is full !");
            return;
        }
        
        for (int i = 0; i <apoitment.length; i++) {
            
            if(apoitment[i]!=null){
                if(apoitment[i].getManth()==d.getManth() && apoitment[i].getDay()==d.getDay()){
                    countApotmentAtDay++;
                    if(apoitment[i].getHour()==d.getHour()){
                        System.out.println("invaild apoitment tow apoitment in the same hour in the same day !");
                        return ;
                    }
                }
            }
            
        }
        if( countApotmentAtDay>2){
            System.out.println("invaild apoitment more than two apiytment per day !");
            return ;
        }
       
        apoitment[count++]=d;
        
        for (int i = 0; i <count; i++) {
            for (int j = 0; j <count-1; j++) {
                
               if(apoitment[j].getManth()>apoitment[j+1].getManth() ||apoitment[j].getManth()==apoitment[j+1].getManth() 
                       &&apoitment[j].getDay()>apoitment[j+1].getDay() || apoitment[j].getDay()==apoitment[j+1].getDay()
                       &&apoitment[j].getHour()>apoitment[j+1].getHour()
                       ){
                   Date temp=apoitment[j];
                   apoitment[j]=apoitment[j+1];
                   apoitment[j+1]=temp;
               }
                
            }
        }
       
    }

    @Override
    public String toString() {
        return super.toString()+"Doctor{" + "apoitment=" + Arrays.toString(apoitment) + '}';
    }

   
    
    @Override
    public void chek(Object o) {
        
        if(!(o instanceof Date)){
            System.out.println("invaild object tybe");
        }
        
        int countForImplements=0; 
        Date c = (Date)o;
        if(count >= max){
            System.out.println("cant add this apoitment");
        }
        
        for (int i = 0; i <count; i++) {
            if(c.getManth()==apoitment[i].getManth() && apoitment[i].getDay()==c.getDay()){
                countForImplements++;
                if(c.getHour()==apoitment[i].getHour()){
                    System.out.println("the apoitment cant add");
                    return ;
                }
            }
        }
        
        if(countForImplements>2){
            System.out.println("the apoitment cant add");
            return ;
        }
        System.out.println("the apotment can aded ");
    }

}
