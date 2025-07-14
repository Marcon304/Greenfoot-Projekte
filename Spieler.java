import greenfoot.*;

public class Spieler extends Actor
{
    public void Bild(){
        GreenfootImage image = new GreenfootImage("Korb.png");
        image.scale(150,150);
        setImage(image);
    }
    public void act()
    {
        GreenfootImage image = new GreenfootImage("Korb.png");
        image.scale(150,150);
        setImage(image);
        if(Greenfoot.isKeyDown("left") && getX()>= 71) {
            move(-20);
        }
        if(Greenfoot.isKeyDown("right") && getX()<= 1429) {
            move(20);
        }
        Korb line = (Korb)getWorld().getObjects(Korb.class).get(0);
        line.setLocation(getX(), getY() - getImage().getHeight() / 100);
    }
    
}