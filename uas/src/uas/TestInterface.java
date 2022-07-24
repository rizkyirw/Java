package uas;

public class TestInterface 
{
    public static void main(String[] args) 
    {
       Video videoplayer = new Video();
       System.out.println("Video saat ini: Diam");
       videoplayer.putar(); //Video berputar
       videoplayer.pause(); //Video Berhenti
       videoplayer.putar(); //Video berhenti
    }
}