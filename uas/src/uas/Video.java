package uas;

public class Video implements IntVideo
{
    private int statusvideo=0;
    
    public Video(){
        this.statusvideo = 1;
    }
    
    @Override
    public void putar()
    {
        boolean isputar = true;
        System.out.println("Putar Video!");
        System.out.println("---> Berputar");
    }
    @Override
    public void pause()
    {
        boolean isputar = false;
        if (isputar){
            if (this.statusvideo == posisidiam)
            {
                System.out.println("Pause Video!");
                System.out.println("--> Diam");
            }
        }else
        {
            System.out.println("Pause Video !");
            System.out.println("---> Sudah Diam");
        }
    }
}