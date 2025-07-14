import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Charaktere
{
    //Attribute
    private int movementCooldown;
    int leben = 100; //Startleben ist 100
    int damage = 1;
    private ArrayList<Arrow> inventory;
    private boolean canBeDamaged;
    private int counter = 0;

    //
    public Hero(){
        inventory = new ArrayList<Arrow>();
        this.movementCooldown = 0;
        canBeDamaged = true; // Der Held kann zu Beginn Schaden erleiden
    }

    private void checkForArrowPickup() {
        Actor pfeil = getOneIntersectingObject(PfeilAufsammeln.class);
        if (pfeil != null) {
            // Füge Pfeil zum Inventar hinzu
            inventory.add(new Arrow());
            // Entferne den Pfeil von der Karte
            getWorld().removeObject(pfeil);
            counter = counter +1;
        }
    }

    public void checkForShooting() {
        if (Greenfoot.mousePressed(null) && !inventory.isEmpty()) {
            // Schieße den Pfeil nur, wenn das Inventar nicht leer ist

            Arrow arrow = new Arrow();
            getWorld().addObject(arrow, getX(), getY());
            int X = Greenfoot.getMouseInfo().getX();
            int Y = Greenfoot.getMouseInfo().getY();
            arrow.turnTowards(X,Y);
            arrow.move(1);
            inventory.remove(0);
            counter = counter -1;
        }
    }

    //Methoden
    public void act()
    {
        this.movement();
        this.movementCooldown++;
        buschinteraktionen();
        damage();
        checkForArrowPickup();
        checkForShooting();
        this.getWorld().showText("Pfeile: " + counter, 1, 0);
        this.getWorld().showText("Leben: " + this.leben, 4, 0);
    }

    public void damage()
    {
        if (canBeDamaged && isTouching(Oger.class)) {
            leben-=20;
            canBeDamaged = false; // Setze den Cool-Down
            Greenfoot.delay(10); // Setze die Dauer des Cool-Downs in Frames

        }
        if (canBeDamaged && isTouching(Troll.class)) {
            leben-=50;
            canBeDamaged = false; // Setze den Cool-Down
            Greenfoot.delay(10); // Setze die Dauer des Cool-Downs in Frames

        }
        if (canBeDamaged && isTouching(Wolverine.class)) {
            leben-=25;
            canBeDamaged = false; // Setze den Cool-Down
            Greenfoot.delay(10); // Setze die Dauer des Cool-Downs in Frames

        }
        if (canBeDamaged && isTouching(Drache.class)) {
            leben-=20;
            canBeDamaged = false; // Setze den Cool-Down
            Greenfoot.delay(10); // Setze die Dauer des Cool-Downs in Frames

        }
        if (!canBeDamaged && !isTouching(Monster.class)) {
            canBeDamaged = true; // Deaktiviere den Cool-Down, wenn das Monster den Helden nicht mehr berührt
        }
        if(leben <= 0)
        { 
            getWorld().showText("You Died! - press reset and run to try again!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
            // Spielende implementieren
        }

    }

    public void buschsprung(int dx, int dy){
        int x = this.getX();
        int y = this.getY();
        this.setLocation(x+dx, y+dy);
    }

    public void buschinteraktionen(){
        int xHero = this.getX();
        int yHero = this.getY();
        int xBusch = getWorld().getObjects(Busch.class).get(0).getX();
        int yBusch = getWorld().getObjects(Busch.class).get(0).getY();

        if(Greenfoot.isKeyDown("e"))//Buschinteraktion
        {   if(xHero == xBusch-1 && yHero == yBusch )
            {
                this.buschsprung(+1, 0);
                istImBusch = true;
            }
            if(xHero == xBusch+1 && yHero == yBusch )
            {
                this.buschsprung(-1, 0);
                istImBusch = true;
            }
            if(xHero == xBusch && yHero == yBusch-1 )
            {
                this.buschsprung(0, +1);
                istImBusch = true;
            }
            if(xHero == xBusch && yHero == yBusch+1 )
            {
                this.buschsprung(0, -1);
                istImBusch = true;
            }
        }
    }

    /**
     * Method movement
     * Hero moves a cell up, down, left or right when the w-a-s-d-keys are pressed
     */
    public void movement(){
        int x = this.getX();
        int y = this.getY();
        if (this.movementCooldown <= 10) {return;}
        if (Greenfoot.isKeyDown("w")){
            moveToOffset(0, -1);
            istImBusch = false;
            this.movementCooldown = 0;
        }        
        if (Greenfoot.isKeyDown("s")){
            moveToOffset(0, 1);
            istImBusch = false;
            this.movementCooldown = 0;
        }        
        if (Greenfoot.isKeyDown("a")){
            moveToOffset(-1, 0);
            istImBusch = false;
            this.movementCooldown = 0;
        }        
        if (Greenfoot.isKeyDown("d")){
            moveToOffset(1, 0);
            istImBusch = false;
            this.movementCooldown = 0;
        }  
        if(this.isTouching(Wand.class)){
            this.setLocation(x, y);
        }
    }

    public boolean touchesDoor () {
        return this.isTouching(Tuer.class);
    }

}