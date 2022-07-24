package com.latihan06;

class Person
{
    String name = "Suryania";
    int age = 22;
}
class Employee extends Person 
{
    float salary = 4000;
    String name = "Diana";
    int age = 23;
    
    void showInfo()
    {
        System.out.println("Name    : " + super.name);
        System.out.println("Age     : " + super.age);
        System.out.println("Salary  : " + salary);
    }
}

public class Demosuper 
{
    public static void main(String args[]) {
        Employee dian = new Employee();
        dian.showInfo();
    }
}
