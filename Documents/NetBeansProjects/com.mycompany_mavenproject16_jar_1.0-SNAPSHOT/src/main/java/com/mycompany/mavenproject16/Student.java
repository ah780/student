package com.mycompany.mavenproject16;

import java.util.Arrays;
import java.util.Random;

public class Student {

    private String name;
    private String city;
    private String[] courses = new String[5];
    private int[] mark = new int[5];
    private int age;
    private String collage;
    private int id;
    private static int count, count2;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String city, int age, String collage) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.collage = collage;
        if ("it".equalsIgnoreCase(collage)) {
            this.id = ++count2 + 2000;
        } else if ("eng".equalsIgnoreCase(collage)) {
            this.id = ++count + 1000;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public int[] getMark() {
        return mark;
    }

    public void setMark(int[] mark) {
        this.mark = mark;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", city=" + city + ", courses=" + Arrays.toString(courses) + ", mark=" + Arrays.toString(mark) + ", age=" + age + ", collage=" + collage + ", id=" + id + '}';
    }

    public void fillo() {
        Random ran = new Random();
        for (int i = 0; i < mark.length; i++) {
            mark[i] = ran.nextInt(100 - 80 + 1) + 80;
        }
        courses = new String[]{"JAVA", "C++", "PAYTHON", "GO", "DART"};
    }

    public void fillo(Student s) {//copy

        this.name = s.name;
        this.age = s.age;
        this.mark = s.mark;
        this.courses = s.courses;
        this.collage = s.collage;
        this.city = s.city;
        this.id = s.id;
    }

    static public void fillo(Student[] s) {
        for (Student i : s) {
            i.fillo();
        }
    }

    public int maxo() {
        int max = mark[0];

        for (int i = 0; i < mark.length; i++) {
            if (max < mark[i]) {
                max = mark[i];
            }
        }
        return max;
    }

    static public int maxo(Student s) {//object

        int max = s.mark[0];

        for (int i = 0; i < s.mark.length; i++) {
            if (max < s.mark[i]) {
                max = s.mark[i];
            }
        }
        return max;
    }

    public static int maxo(Student[] arr) {

        int max = arr[0].mark[0];

        for (int i = 0; i < arr.length; i++) {
            int x = maxo(arr[i]);
            if (x > max) {
                max = x;
            }

        }

        return max;

    }

    public float avg() {
        int sum = 0;
        for (int i = 0; i < mark.length; i++) {
            sum += mark[i];
        }
        return sum / 5.0f;
    }

    public boolean fromTulkaream() {

        return "tulkaream".equalsIgnoreCase(city);

    }

    public static boolean fromTulkaream(Student s) {

        return "tulkaream".equalsIgnoreCase(s.city);

    }

    public static boolean fromTulkaream(Student[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (!fromTulkaream(arr[i])) {
                return false;
            }

        }
        return true;

    }

    public boolean fromCity(String city) {
        if (city == null) {
            return false;
        }
        if (city.equalsIgnoreCase(this.city)) {
            return true;
        }
        return false;
    }

    public static String[] listOfHero(Student[] arr) {

        String temp[] = new String[arr.length];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].mark.length; j++) {
                sum += arr[i].mark[j];
            }
            float avg = sum / 5.0f;
            if (avg >= 90) {
                temp[count++] = arr[i].name;
            }
        }
        String result[] = new String[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static float avrg(Student s) {

        int sum = 0;
        for (int i = 0; i < s.mark.length; i++) {
            sum += s.mark[i];
        }

        return sum / 5.0f;
    }

    public static String cmpare(Student s, Student s2) {

        if (avrg(s) > avrg(s2)) {
            return ("avarege for student " + s.name + " is higher");
        } else if (avrg(s2) > avrg(s)) {
            return ("avarege for student " + s2.name + " is higher");
        } else {
            return ("avarege for students " + s2.name + " " + s.name + " " + " is equel");
        }

    }

    public String compare(Student s) {

        float avg1 = avrg(this);
        float avg2 = avrg(s);

        if (avg1 > avg2) {
            return ("avarege for student " + this.name + " is higher");
        } else if (avg2 > avg1) {
            return ("avarege for student " + s.name + " is higher");
        } else {
            return ("avarege for students " + this.name + " " + s.name + " " + " is equel");
        }

    }

    public static String compare(Student[] arr) {

        int max = 0;
        for (int i = 0; i < arr.length; i++) {

            if (avrg(arr[i]) > avrg(arr[max])) {
                max = i;
            }
        }
        return ("the avrg for student " + " " + arr[max].name + " " + "is higher avrg");
    }

    public void addMark(String topic, int mark) {

        for (int i = 0; i < this.courses.length; i++) {

            if (topic.equalsIgnoreCase(this.courses[i])) {
                this.mark[i] = mark;
                break;
            }

        }

    }

    public static void addMark(Student s, String topic, int mark) {

        s.addMark(topic, mark);

    }

    public static void addMark(Student[] arr, String topic, String name, int mark) {

        for (int i = 0; i < arr.length; i++) {

            if (name.equalsIgnoreCase(arr[i].name)) {
                arr[i].addMark(topic, mark);
            }
        }

    }

    public static void sortByName(Student[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - 1; j++) {

                if (arr[j].name.compareTo(arr[j + 1].name) > 0) {
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

    public static void sortByAvrg(Student[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1; j++) {

                if (avrg(arr[j]) < avrg(arr[j + 1])) {
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }

    }

}
