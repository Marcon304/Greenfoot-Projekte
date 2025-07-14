import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Erdbeere here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Erdbeere extends Item
{
    private int timer=0;
    private int LevelTimer = 6;
    private int vorherigesLevel = 1;
    private double Fallgeschwindigkeit = 6.0;
    private final double MAX_GESCHWINDIGKEIT = 12.0;
    private double preciseY;
    public void act()
    {
        GameWorld world = (GameWorld) getWorld();
        int Level = world.Level;
        if(LevelTimer > 1 && Level > vorherigesLevel){
            LevelTimer--;

        }
        GreenfootImage image = new GreenfootImage("Erdbeere.png");
        image.scale(75,75);
        setImage(image);
        if(Level > vorherigesLevel){
            if(Level < 10){
                Fallgeschwindigkeit = 6 + (Level / 2.0);
            } else {
                Fallgeschwindigkeit = Math.min(Fallgeschwindigkeit + (2.0 / Level), MAX_GESCHWINDIGKEIT);
            }
            vorherigesLevel = Level;
        }

        preciseY += Fallgeschwindigkeit;   // Fallgeschwindigkeit wird angewendet
        setLocation(getX(), (int) preciseY);
        if(isTouching(Korb.class)) {
            timer++;

            if(timer>=LevelTimer){
                GameWorld welt = (GameWorld) getWorld();
                welt.addScore(10);
                getWorld().removeObject(this);
            }
        }
        else if (isTouching(Boden.class)) {
            GameWorld welt = (GameWorld) getWorld();
            welt.addScore(-10);
            getWorld().removeObject(this);

        }
    }
}
