import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Ogre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oger extends Monster
{
    //Attribute

    //
    public Oger(){
        super();
        int leben = 2;
        getImage().scale(27,50);
    }

    //Methoden

    /**
     * Act - do whatever the Ogre wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
     * Ogre moves towards the hero. Moves only up, down, left and right.
     * Stands still if a wall is in the way.
     */
    public void movement(){
        //get the x- and y-coordinates of the hero
        World world = getWorld();
        List objects = world.getObjects(Hero.class);
        Hero hero = (Hero) objects.get(0);            
        int heroX = hero.getX(); 

        int heroY = getWorld().getObjects(Hero.class).get(0).getY();

        //get the distance to the hero on the x- and y-axis
        int difX = heroX - this.getX();
        int difY = heroY - this.getY();

        //get the absolute value of the distances
        int absDifX;
        int absDifY;

        if(difX < 0){
            absDifX = difX * -1;
        } else{
            absDifX = difX;
        }            
        if(difY < 0){
            absDifY = difY * -1;
        } else{
            absDifY = difY;
        }

        if(delay == 40)
        {
            delay = 0;

            //reduces the greater distance
            if(absDifX > absDifY){
                if(difX < 0){
                    moveToOffset(-1, 0);
                }
                if(difX > 0){
                    moveToOffset(1, 0);
                }            
            }

            else{
                if(difY < 0){
                    moveToOffset(0, -1);
                }
                if(difY > 0){
                    moveToOffset(0, 1);
                }
            }
        } else {
            delay = delay + 1;
        }
        //check if hero is next to wall
        int xWall = getWorld().getObjects(Wand.class).get(0).getX();
        int yWall = getWorld().getObjects(Wand.class).get(0).getY();
        int xOgre = this.getX();
        int yOgre = this.getY();
        int random = Greenfoot.getRandomNumber(1);
        if(xOgre == xWall-1 && absDifX > absDifY)
        {
            if (random == 0)
            {
                moveToOffset(0, 1);
            } else
            {
                moveToOffset(0, -1);
            }
        }
        if(xOgre == xWall+1 && absDifX > absDifY)
        {
            if (random == 0)
            {
                moveToOffset(0, 1);
            } else
            {
                moveToOffset(0, -1);
            }
        }
        if(yOgre == yWall-1 && absDifY > absDifX)
        {
            if (random == 0)
            {
                moveToOffset(1, 0);
            } else
            {
                moveToOffset(-1, 0);
            }
        }
        if(yOgre == yWall+1 && absDifY > absDifX)
        {
            if (random == 0)
            {
                moveToOffset(1, 0);
            } else
            {
                moveToOffset(-1, 0);
            }
        }

    }
}
