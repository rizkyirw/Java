package com.latihan05;

public class Mobil 
{
    
    //property..................
    private String model;
    private int maxspeed;
    
    //behavior..................
    public void setModel(String param1)
    {
        model = param1;
    }
    public void setSpeed(int param2)
    {
        maxspeed = param2;
    }
    public String getModel()
    {
        return model;
    }
    public int getSpeed()
    {
        return maxspeed;
    }
    public static void main(String args[]) 
        {
        Mobil toyota01 = new Mobil();
        
        toyota01.setModel("Avanza");
        toyota01.setSpeed(120);
        
        System.out.println("Mobil   : " + toyota01.getModel());
        System.out.println("Mempunyai maxSpeed " + toyota01.getSpeed());
        System.out.println(" km per jam");
        }
}