package com.mycompany.mavenproject16;

import java.util.Arrays;

public class Mavenproject16 {

    public static void main(String[] args) {

        Student arr[] = new Student[5];

        String names[] = new String[]{"ahmad", "ali", "mohamed", "rami", "sami"};

        for (int i = 0; i < arr.length; i++) {

            if (i % 2 == 0) {
                arr[i] = new Student(names[i], "tulkaream", 19, "eng");
            } else {
                arr[i] = new Student(names[i], "tulkaream", 19, "it");
            }
        }
        Student.fillo(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i].getCollage() + " " + arr[i].getId());
        }

        System.out.println(Student.maxo(arr));

        System.out.println(arr[0].fromTulkaream());
        System.out.println(Student.fromTulkaream(arr[0]));
        System.out.println(Student.fromTulkaream(arr));
        System.out.println(arr[0].fromCity("tulkaream"));

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getName() + " " + arr[i].avg());
        }
        System.out.println(Arrays.toString(Student.listOfHero(arr)));
        System.out.println(Student.cmpare(arr[0], arr[1]));
        System.out.println(arr[0].compare(arr[1]));
        System.out.println(Student.compare(arr));
        arr[0].addMark("c++", 100);
        System.out.println(arr[0]);
        Student.addMark(arr[1], "go", 100);
        System.out.println(arr[1]);

        Student s1 = new Student("ahmad", "tulkaream", 18, "it");
        Student s2 = new Student("ahmad", "tulkaream", 18, "it");
        s1.fillo();
        s2.fillo();
        System.out.println(Student.cmpare(s1, s2));

    }
}
