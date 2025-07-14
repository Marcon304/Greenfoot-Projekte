import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Arrow extends Gegenstand
{
    private int speed = 1;
    
    public Arrow()
    {
        getImage().scale(50,15);
        
    }
    
    public void act()
    {
        move(speed);
        
        if(this.isTouching(Wand.class))
        
            getWorld().removeObject(this);
    }  
}

