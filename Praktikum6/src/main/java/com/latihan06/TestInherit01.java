package com.latihan06;

class Employee 
{
    float salary = 40000;
}
class Programmer extends Employee
{
    int bonus = 10000;
}
class TestInherit01 
{    
    public static void main(String args[]) 
    {
        Programmer p = new Programmer();
        System.out.println("Programmer Salary is            : " + p.salary);
        System.out.println("Bonus of Programmer Salary is   : " + p.bonus);
    }
}
