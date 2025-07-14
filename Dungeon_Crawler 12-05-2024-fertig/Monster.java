import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Gegner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Charaktere
{
    //Attribute
    int leben = 2;
    int delay;
    boolean istImBusch = false;
    boolean HitArrow;
    
    //
    public Monster(){
        this.delay = 0;
    }

    //Methoden
    /**
     * Act - do whatever the Gegner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
    }
    

    /**
     * Method moveToOffset
     * Moves the monster on the grid
     * @param dx moves the monster the given amount of cells on the x-axis
     * @param dy moves the monster the given amount of cells on the x-axis
     */
    public void moveToOffset(int dx, int dy){
        int x = this.getX();
        int y = this.getY();
        if(istImBusch == false){
            this.setLocation(x+dx, y+dy);
        }
        
        //Monsters shuldn't be able to walk through walls, in chests or into bushes
        
        if(this.isTouching(Wand.class)){
            this.setLocation(x, y);
        }
        if(this.isTouching(Busch.class)){
            this.setLocation(x, y);
        }
        if(this.isTouching(Chest.class)){
            this.setLocation(x, y);
        }
    }
    
    
}





