import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Melone extends Item
{
    private int timer=0;
    private int LevelTimer = 4;
    private int vorherigesLevel = 1;
    private double Fallgeschwindigkeit = 7.0;
    private final double MAX_GESCHWINDIGKEIT = 12.0;
    private double preciseY;
    public void act()
    {
        GameWorld world = (GameWorld) getWorld();
        int Level = world.Level;
        if(LevelTimer > 1 && Level > vorherigesLevel){
            LevelTimer--;
            
        }
        GreenfootImage image = new GreenfootImage("Melone.png");
        image.scale(75,75);
        setImage(image);
        if(Level > vorherigesLevel){
            if(Level < 10){
                Fallgeschwindigkeit = 7 + (Level / 2.0);
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
                welt.addScore(15);
                getWorld().removeObject(this);
            }
        }
        else if (isTouching(Boden.class)) {
            GameWorld welt = (GameWorld) getWorld();
            welt.addScore(-15);
            getWorld().removeObject(this);

        }
    }
}
