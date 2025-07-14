import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blob1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Troll extends Monster
{
    int leben = 3;
    /**
     * Act - do whatever the Blob1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Attribute    
    

    
    //
    public Troll(){
        super();
        this.delay = 0;
        getImage().scale(50,47);
    }

    //Methoden
    public void act()
    {
        this.movement();
        HitByArrow();
    } 
    public void HitByArrow()
    {
       Actor arrow = getOneIntersectingObject(Arrow.class);
        if(arrow != null)
       {
        leben--;
         getWorld().removeObject(arrow);
       }
       if(leben == 0)
        getWorld().removeObject(this);
    
    }
    /**
     * Method movement
     * Blob moves randomly one cell up, down, left or right
     */
    public void movement(){
        if(delay == 40)
        {
            delay = 0;
            int zufall;
            zufall = Greenfoot.getRandomNumber(4);

            if(zufall == 0)
            {
                this.moveToOffset(0, -1); 
            }

            if(zufall == 1)
            {
                this.moveToOffset(0, 1); 
            }

            if(zufall == 2)
            {
                this.moveToOffset(1, 0); 
            }

            if(zufall == 3)
            {
                this.moveToOffset(-1, 0); 
            }
        } else {
            delay = delay + 1;
        }
        
    }
}
