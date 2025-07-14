import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Bombe extends Item
{
    private int timer=0;
    private int LevelTimer = 4;
    private int vorherigesLevel = 1;
    private double Fallgeschwindigkeit = 8.0;
    private final double MAX_GESCHWINDIGKEIT = 12.0;
    private double preciseY;
    public void act()
    {
        GameWorld world = (GameWorld) getWorld();
        int Level = world.Level;
        GreenfootImage image = new GreenfootImage("bomb.png");
        image.scale(75,75);
        setImage(image);
        if(Level > vorherigesLevel){
            if(Level < 10){
                Fallgeschwindigkeit = 8 + (Level / 2.0);
            } else {
                Fallgeschwindigkeit = Math.min(Fallgeschwindigkeit + (2.0 / Level), MAX_GESCHWINDIGKEIT);
            }
            vorherigesLevel = Level;
        }
        preciseY += Fallgeschwindigkeit;   // Fallgeschwindigkeit wird angewendet
        setLocation(getX(), (int) preciseY);
        if(isTouching(Korb.class)) {
            timer++;

            if(timer>=1){
                GameWorld welt = (GameWorld) getWorld();
                welt.addScore(-100);
                getWorld().removeObject(this);
            }
        }
        else if (isTouching(Boden.class)) {
            GameWorld welt = (GameWorld) getWorld();
            getWorld().removeObject(this);

        }
    }
}