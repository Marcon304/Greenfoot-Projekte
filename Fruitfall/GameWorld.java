 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class GameWorld extends World
{
    private int bananeTimer=0;
    private int meloneTimer=0;
    private int erdbeereTimer=0;
    private int bombTimer=0;
    private int Score=0;
    private int Timer=60;
    public int Level=1;
    private boolean Levelaufstieg = false;
    private int LevelScore = 150;
    private int FrameCounter = 0;
    private Startbildschirm Startbildschirm;
    public GameWorld(){
        super(1500,800,1);
        Greenfoot.setSpeed(50);
        GreenfootImage image = new GreenfootImage("Hintergrund.png");
        image.scale(1500,800);
        setBackground(image);
        showScore();
        showTimer();
        Level();
        Spieler korb = new Spieler();
        korb.getImage().scale(150, 150);
        addObject(korb, 750,640);
        addObject(new Boden(),750,750);
        addObject(new Korb(),750,640);

    }

    public void act(){
        showScore();
        spawnBanane();
        spawnMelone();
        spawnErdbeere();
        spawnBomb();
        Level();
        showTimer();
    }

    public void Level(){
        showText("Level: " + Level,80,70);
        if(Score >= LevelScore && Timer == 0)
        {
            Level++;
            showScore();
            showText("Level " + Level + "!",750,400);
            Levelaufstieg();
            if(Level <= 2){
                LevelScore += 150;
            } else if(Level <= 5){
                LevelScore += 200;
            } else {
                LevelScore += 300;
            }
            Timer = 60;
            Spieler korb = new Spieler();
            addObject(korb, 750,640);
            korb.getImage().scale(150, 150);
            Greenfoot.delay(180);
            showText("",750,400);

        }else if(Timer == 0 && Score <= LevelScore || Score < 0)
        {
            showText("Game Over",750,400);
            Levelaufstieg();
            AnzeigenEntfernen();
            Greenfoot.delay(180);
            Startbildschirm = new Startbildschirm();
            Startbildschirm.start();

        }
    }

    private void spawnBanane(){
        bananeTimer++;
        if(bananeTimer>=120)
        {
            int x = 50 + Greenfoot.getRandomNumber(1401);
            addObject(new Banane(),x,0);
            bananeTimer = 0;
        }

    }

    private void spawnMelone(){
        meloneTimer++;
        if(meloneTimer>=70 && Level>=5)
        {
            int x = 50 + Greenfoot.getRandomNumber(1401);
            addObject(new Melone(),x,0);
            meloneTimer = 0;
        }

    }

    private void spawnErdbeere(){
        erdbeereTimer++;
        if(erdbeereTimer>=90 && Level>=3)
        {
            int x = 50 + Greenfoot.getRandomNumber(1401);
            addObject(new Erdbeere(),x,0);
            erdbeereTimer = 0;
        }

    }

    private void spawnBomb(){
        bombTimer++;
        if(bombTimer>=300 && Level>=7)
        {
            int x = 50 + Greenfoot.getRandomNumber(1401);
            addObject(new Bombe(),x,0);
            bombTimer = 0;
        }

    }

    public void addScore(int points){
        Score += points;
        showScore();
    }

    private void Levelaufstieg(){
        List<Item> alleItems = getObjects(Item.class);
        for (Item item : alleItems) {
            removeObject(item);  

        }
        List<Spieler> alleSpieler = getObjects(Spieler.class);
        for (Spieler spieler : alleSpieler) {
            removeObject(spieler);  

        }
    }

    private void showScore() {
        showText("Punkte: " + Score + "/"+ LevelScore, 80, 30); 
    }

    private void showTimer(){
        showText("Zeit: " + Timer,80, 50);
        FrameCounter++;
        if(FrameCounter >=60){
            FrameCounter = 0;
            Timer--;
        }
    }
    
    private void AnzeigenEntfernen(){
    
    }
}