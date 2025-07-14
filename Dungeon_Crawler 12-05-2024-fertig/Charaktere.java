import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Charaktere here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charaktere extends Hindernis
{
    int leben;
    boolean istImBusch = false;
    /**
     * Act - do whatever the Charaktere wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public void moveToOffset(int dx, int dy){
        int x = this.getX();
        int y = this.getY();
        if(istImBusch == false){
            this.setLocation(x+dx, y+dy);
        }
        //Monsters shuldn't be able to walk through walls, in chests or into bushes
        
        
        if(this.isTouching(Chest.class)){
            this.setLocation(x, y);
        }
    }
    
}
