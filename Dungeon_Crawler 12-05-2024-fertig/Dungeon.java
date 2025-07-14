import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * 
 * 
 *        * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */    

    public boolean einführung = false;//Variable die angibt, ob die Einführung beendet wurde
    public boolean schlüssel = false;//Variable die angibt, ob der Spieler den Schlüssel auf der jeweiligen Ebene eingesammelt hat
    public boolean endsongPlayed = false;//Variable die angibt, ob der Endsong bereits gespielt wurde
    public int aktuellesLevel = 0;//Variable, welche die aktuelle Ebene des Spiels angibt
    public int hintergrundmusictimer = 0;//Timer der abläuft und bei Ablauf die Hintergrundmusic abspielt
    int textauswahl = 0;//Variable, die die Texte der Einführung ändert
    public int delayTimer = 0;//Delay zwischen der EInführung, damit diese nicht nach einem Click schon beendet ist
    public char [][][] levelListe = {
            { 
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},//Hintergrundbild der Einführung
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ','G',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            },
            { 
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},//Ebene 1
                {'T', 'H',' ',' ',' ',' ',' ',' ','W','D',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','W'},
                {'W', 'W','W','W','W',' ','W','P','W',' ','W','W','W','W','W','W','W','W','W',' ','W'},
                {'W', ' ',' ',' ',' ',' ','W',' ','W',' ',' ',' ',' ',' ',' ',' ',' ',' ','W',' ','W'},
                {'W', ' ','W','W','W','W','W','W','W',' ',' ',' ',' ',' ','P',' ','W',' ','W',' ','W'},
                {'W', ' ','W','P',' ',' ','W',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','W',' ','W'},
                {'W', 'P','W','O','W',' ','W',' ','W',' ',' ',' ','B',' ',' ',' ','W','W','W',' ','W'},
                {'W', ' ','W',' ','W',' ',' ',' ','W',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','W'},
                {'W', ' ','W',' ','W','W','W','W','W',' ',' ',' ',' ',' ',' ','V','W','W','W','W','W'},
                {'W', ' ','W',' ','W',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','W'},
                {'W', ' ','W',' ','W',' ','W',' ','W',' ','W','W','W',' ','W','W','W','W','W',' ','W'},
                {'W', ' ',' ',' ','W',' ','W',' ','W',' ',' ',' ','W',' ','W',' ',' ',' ','W',' ','W'},
                {'W', ' ','W','W','W','W','W',' ','W','W','W',' ','W',' ','W',' ','W',' ','W',' ','W'},
                {'W', ' ',' ',' ',' ',' ',' ','D','W','C',' ',' ','W',' ',' ',' ','W',' ',' ','P','W'},
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'}
            },
            {
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},//Ebene 2
                {'W', 'H',' ',' ',' ','W',' ',' ',' ',' ',' ',' ',' ',' ',' ','W',' ',' ',' ','P','W'},
                {'W', ' ',' ','W',' ','W',' ',' ',' ',' ',' ','W',' ',' ',' ','W',' ','W','W',' ','W'},
                {'W', ' ','W','W',' ','W',' ',' ',' ','W',' ','W',' ',' ',' ','W',' ','W','B',' ','W'},
                {'W', ' ','W','P',' ','W',' ',' ',' ','W',' ','W',' ',' ',' ',' ',' ','W','W',' ','W'},
                {'W', ' ','W',' ',' ','W','W',' ',' ','W','W','W','W','W',' ',' ',' ',' ','W',' ','W'},
                {'W', ' ','W','W',' ',' ',' ',' ',' ',' ','O','W','P',' ',' ',' ',' ',' ',' ',' ','W'},
                {'W', ' ','P','W',' ',' ','W',' ',' ',' ',' ','W','W',' ',' ','W','W','W','W',' ','W'},
                {'W', ' ',' ',' ',' ','V','W',' ','W','W','W','W',' ',' ',' ',' ',' ','O','W',' ','W'},
                {'W', ' ',' ','B',' ',' ','W',' ','W','P',' ',' ',' ',' ',' ',' ','W',' ',' ',' ','W'},
                {'W', ' ','W','W','W','W','W',' ','W',' ',' ','W',' ',' ',' ','W','W','W',' ',' ','W'},
                {'W', 'W','W',' ',' ',' ',' ',' ','W',' ','W','W','W','W',' ','W',' ',' ',' ',' ','W'},
                {'W', 'D',' ',' ',' ',' ','W','W','W',' ','W','O',' ',' ',' ','W',' ','W','W','W','W'},
                {'W', ' ',' ','W',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','W',' ',' ',' ','C','W'},
                {'W', 'W','W','W','W','W','T','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},
            },
            {
                {'W', 'W','W','W','W','W','W','W','W','T','W','W','W','W','W','W','W','W','W','W','W'},//Ebene 3
                {'W', ' ',' ','V','W','D',' ','P','W',' ',' ','W',' ',' ',' ','D','W',' ',' ',' ','W'},
                {'W', ' ',' ',' ','W','W',' ',' ','W','W',' ',' ',' ',' ','W','W','W','W',' ',' ','W'},
                {'W', ' ','W',' ','C','W',' ',' ',' ','W','W','W',' ',' ',' ',' ',' ',' ',' ','W','W'},
                {'W', ' ','W','W','W','W','W',' ',' ',' ',' ','W','W','W',' ',' ',' ','W',' ',' ','W'},
                {'W', ' ',' ','W','P','W',' ',' ',' ',' ','O',' ','W','P',' ',' ','W','W','W',' ','W'},
                {'W', ' ',' ',' ',' ','W',' ','W','W',' ',' ','W','W',' ',' ',' ','W',' ','W','W','W'},
                {'W', 'W','W','W',' ',' ',' ','W','B',' ','W','W',' ',' ','W',' ',' ',' ',' ','O','W'},
                {'W', ' ',' ',' ',' ',' ',' ','W',' ',' ',' ',' ',' ',' ','W',' ',' ','W',' ',' ','W'},
                {'W', ' ','W','W','W',' ',' ','W',' ',' ',' ',' ','W','W','W',' ','W','W','W',' ','W'},
                {'W', ' ',' ',' ','W','W','W','W','W','W',' ',' ',' ','W',' ',' ',' ','P','W',' ','W'},
                {'W', 'W','W',' ','W',' ',' ','W','P',' ',' ','W',' ','W',' ','W',' ',' ','W',' ','W'},
                {'W', ' ',' ',' ',' ',' ',' ',' ',' ','W','W','W',' ',' ',' ','W','W',' ',' ',' ','W'},
                {'W', 'B','W',' ',' ','W','H',' ',' ','W',' ',' ',' ',' ',' ',' ',' ',' ','W',' ','W'},
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},
            },
            {
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},//Ebene 4
                {'W', ' ',' ',' ',' ',' ',' ',' ','W','H',' ',' ',' ',' ','W',' ',' ',' ',' ','B','W'},
                {'W', ' ','W','W','W',' ','W','W','W',' ',' ','W','W',' ','W','W','W',' ',' ',' ','W'},
                {'W', ' ','W','O',' ',' ','W',' ',' ',' ',' ','W','P',' ',' ',' ','W','W',' ','W','W'},
                {'W', ' ','W',' ','W','W','W',' ','W','W','W','W',' ','W','W',' ','W',' ',' ',' ','W'},
                {'W', ' ','W',' ','W','P',' ',' ',' ',' ',' ',' ',' ','V','W',' ',' ',' ','W',' ','W'},
                {'W', ' ','W',' ','W','W','W',' ','W','W','W','W','W','W','W','W',' ','W','W',' ','W'},
                {'W', ' ',' ',' ',' ','C','W',' ',' ',' ','O','W',' ','W',' ',' ',' ',' ',' ',' ','W'},
                {'W', 'W',' ','W','W','W','W','W',' ',' ',' ',' ',' ','W',' ','W',' ',' ','W',' ','W'},
                {'W', ' ',' ',' ','P','W',' ','W','W','W',' ',' ',' ','W',' ','W','W',' ','W','W','W'},
                {'W', ' ','W','W',' ',' ',' ',' ',' ','W',' ','W',' ',' ',' ','W','P',' ','W',' ','T'},
                {'W', ' ','P','W','W','W','W','W',' ',' ',' ','W',' ','W',' ','W',' ',' ','W',' ','W'},
                {'W', 'D',' ',' ',' ','W',' ',' ',' ','W','W','W',' ','W',' ','W','W','W','W',' ','W'},
                {'W', ' ',' ','W',' ',' ',' ',' ',' ',' ',' ','W',' ','W',' ',' ',' ','D','B',' ','W'},
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},
            },
            {
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},//Ebene 5
                {'W', 'O',' ',' ',' ',' ','P','W',' ','W',' ',' ','O','W','P',' ',' ',' ','W','B','W'},
                {'W', ' ','W','W','W','W',' ',' ',' ','W',' ',' ','W','W',' ','W',' ',' ',' ',' ','W'},
                {'W', ' ',' ',' ',' ','W',' ','W','W','W',' ','W','W',' ',' ','W','W',' ','W','W','W'},
                {'W', ' ','W','W',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','W',' ','W',' ','W'},
                {'W', ' ','W','P',' ',' ','W',' ',' ',' ','W','W','W',' ','W',' ','W',' ',' ',' ','T'},
                {'W', ' ','W',' ','W',' ','W','W','W',' ','W',' ',' ',' ','W',' ',' ',' ','W',' ','W'},
                {'W', ' ',' ',' ','W',' ','W','V',' ',' ','W',' ','W',' ','W',' ','W','W','W',' ','W'},
                {'W', 'W','W',' ','W',' ','W',' ','W','W','W',' ','W','B','W',' ',' ',' ',' ',' ','W'},
                {'W', ' ',' ',' ','W',' ',' ',' ',' ','W',' ',' ','W','W','W','W','W','W',' ',' ','W'},
                {'W', ' ','W',' ','W','W','W',' ',' ',' ',' ',' ',' ',' ',' ','W','P',' ',' ','H','W'},
                {'W', ' ','W','W','W','B','W','W','W','W','W','W',' ','W',' ','W',' ',' ','W',' ','W'},
                {'W', ' ','W','D',' ',' ',' ',' ',' ','W','B','W',' ','W',' ','W','W','W','W',' ','W'},
                {'W', ' ',' ',' ','P','W',' ',' ','C','W',' ',' ',' ','W',' ',' ',' ',' ',' ',' ','W'},
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},
            },
            {
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},//Ebene 6
                {'W', 'P',' ',' ',' ','O','W','P',' ',' ',' ',' ',' ','W','O','W','V',' ',' ',' ','W'},
                {'W', ' ','W','W',' ',' ','W',' ','W','W','W','W',' ',' ',' ','W',' ','W','W',' ','W'},
                {'W', ' ',' ','W',' ',' ',' ',' ',' ','W',' ',' ',' ','W',' ','W',' ','W',' ',' ','W'},
                {'W', ' ','W','W',' ','W','W','W',' ','W',' ','W','W','W',' ','W',' ','W',' ',' ','W'},
                {'W', 'B','W',' ',' ',' ',' ','W','K',' ',' ',' ',' ',' ',' ','W',' ','W','W','H','W'},
                {'W', ' ','W',' ','W',' ',' ','W',' ',' ','W',' ','W',' ','W','W',' ','P','W',' ','W'},
                {'W', ' ',' ',' ','W',' ',' ',' ',' ',' ','W',' ','W',' ',' ',' ',' ',' ','W',' ','W'},
                {'W', ' ','W','W','W',' ','W','W','W','W','W',' ','W','W','W',' ','W','W','W',' ','W'},
                {'W', ' ',' ',' ',' ',' ',' ','W',' ',' ',' ',' ',' ',' ','W',' ',' ',' ',' ',' ','W'},
                {'W', 'W','W',' ','W','W',' ','W',' ','W','W','W','W',' ','W','C','W',' ',' ',' ','W'},
                {'T', ' ','W',' ','W','P',' ','W',' ','W','V','B','W',' ','W','W','W',' ','W',' ','W'},
                {'W', 'O','W',' ','W',' ','W','W',' ',' ',' ','W','W',' ',' ','P','W',' ','W','W','W'},
                {'W', ' ',' ',' ',' ',' ','W',' ',' ',' ',' ','W','B',' ',' ',' ',' ',' ',' ','B','W'},
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},
            },
            {
                {'W', 'W','W','T','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},//Ebene 7
                {'W', 'V',' ',' ',' ','W','D',' ',' ',' ',' ',' ',' ',' ',' ','W','V',' ',' ',' ','W'},
                {'W', ' ','W',' ',' ','W',' ',' ',' ','W','W',' ',' ',' ',' ','W',' ','W','C',' ','W'},
                {'W', ' ','W',' ','W','W',' ','W',' ',' ','W','W','W',' ','W','W',' ','W','W','W','W'},
                {'W', ' ','W',' ',' ',' ',' ','W',' ',' ',' ','V','W',' ','W',' ',' ',' ',' ','P','W'},
                {'W', ' ','W','P',' ','W',' ','W','W',' ',' ',' ','W',' ','W',' ','W',' ','W','W','W'},
                {'W', ' ','W','W','W','W',' ','W',' ',' ',' ',' ','W',' ','W',' ','W',' ',' ',' ','W'},
                {'W', ' ','W',' ',' ',' ',' ','W',' ','W','W',' ',' ',' ',' ',' ','W','W','W',' ','W'},
                {'W', ' ','W',' ','W',' ',' ','W','D','W','P',' ',' ','W',' ',' ',' ',' ','W',' ','W'},
                {'W', ' ',' ',' ','W',' ',' ',' ',' ','W',' ',' ',' ','W',' ','W',' ',' ','W',' ','W'},
                {'W', 'W',' ','W','W',' ','W',' ','W','W','W','W',' ','W',' ',' ',' ','W','W',' ','W'},
                {'W', 'H',' ','W','P','O','W',' ',' ',' ',' ','W',' ','W','W','W',' ','W',' ',' ','W'},
                {'W', ' ','W','W','W',' ','W','W','W',' ',' ','W',' ',' ','P','W',' ','W',' ','W','W'},
                {'W', ' ',' ',' ',' ',' ','W',' ',' ',' ',' ',' ',' ',' ',' ','W',' ',' ',' ','B','W'},
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},
            },
            {
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},//Ebene 8
                {'W', ' ',' ','H',' ',' ',' ',' ','W','P','W',' ','V','W','D',' ',' ',' ',' ','D','W'},
                {'W', ' ','B','W',' ',' ','W',' ','W',' ',' ',' ',' ','W',' ',' ',' ','W','B',' ','W'},
                {'W', ' ','W','W',' ',' ','W',' ','W','W','W','W',' ','W',' ',' ','W','W','W',' ','W'},
                {'W', ' ','W',' ',' ','W','W',' ',' ',' ',' ',' ',' ','W',' ','B','W',' ',' ',' ','W'},
                {'W', ' ','W',' ',' ','W','P',' ',' ','W','D',' ','W','W',' ','W','W',' ','W','W','W'},
                {'W', ' ',' ',' ',' ',' ',' ','W',' ','W','W',' ','W','P',' ',' ',' ',' ','W','P','W'},
                {'W', 'W','W','W','W','W','W','W',' ',' ','W',' ','W',' ','W','W','W','W','W',' ','W'},
                {'W', 'C',' ',' ',' ',' ',' ','W',' ','W','W',' ',' ',' ',' ',' ',' ','W','V',' ','W'},
                {'W', 'W','W','K','W','W',' ','W',' ',' ','W',' ','W',' ','W','W',' ','W',' ','W','W'},
                {'W', ' ',' ',' ','P','W',' ','W','W',' ',' ',' ','W',' ','W',' ',' ',' ',' ','B','W'},
                {'W', ' ','W','W',' ','W',' ',' ',' ',' ',' ','W','W',' ','W',' ','W',' ','W','W','W'},
                {'W', 'O','B','W',' ','W',' ','W','O','W',' ','W','V',' ','W','V','W',' ',' ','O','W'},
                {'W', ' ',' ',' ',' ',' ',' ','W',' ','W',' ',' ',' ','W','W',' ','W',' ',' ',' ','W'},
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','T','W','W'},
            },
            {
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','T','W','W'},//Ebene 9
                {'W', ' ',' ',' ','V','W',' ',' ',' ','O','W','D',' ',' ',' ','W','P',' ',' ',' ','W'},
                {'W', ' ','W','W','W','W',' ','W',' ',' ','W',' ','W','W',' ','W',' ',' ','W','B','W'},
                {'W', ' ','P','W',' ','W',' ','W','W',' ','W',' ',' ','W','W','W','W',' ','W','W','W'},
                {'W', ' ',' ',' ',' ',' ',' ',' ','W',' ','W','W',' ','O','W',' ',' ',' ','W',' ','W'},
                {'W', ' ','W','W','W',' ','W',' ',' ',' ',' ',' ',' ',' ','W',' ','W',' ',' ',' ','W'},
                {'W', ' ','W',' ',' ',' ','W','W','W','W','W',' ','W',' ',' ',' ','W',' ','W','W','W'},
                {'W', 'W','W',' ','W',' ',' ',' ','C','W',' ',' ','W','W','W',' ','W','V','W','P','W'},
                {'W', ' ',' ',' ','W',' ','W',' ',' ','W','B','W','W','B','W',' ',' ',' ','W',' ','W'},
                {'W', ' ','W','O','W','W','W','K',' ','W',' ',' ','W',' ',' ',' ','W','W','W',' ','W'},
                {'W', ' ','W',' ',' ',' ',' ',' ',' ',' ',' ',' ','W',' ','W',' ',' ',' ',' ',' ','W'},
                {'W', ' ','W','W','P','W',' ','W','W','W',' ','W','W',' ','W','W','W',' ','W','W','W'},
                {'W', 'V','B','W','W','W',' ',' ','P','W',' ','W',' ',' ','W',' ','W',' ','W','B','W'},
                {'W', ' ',' ',' ',' ',' ',' ',' ',' ','W',' ',' ',' ',' ','W',' ',' ',' ','H',' ','W'},
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},
            },
            {
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},//Ebene 10
                {'W', ' ',' ',' ',' ',' ',' ',' ',' ',' ','V',' ',' ',' ',' ',' ',' ',' ','H',' ','W'},
                {'W', ' ','W',' ','W','W',' ','W','W','W',' ','W','W','W',' ','W','W',' ','W',' ','W'},
                {'W', ' ','W',' ','W','B',' ','W','P',' ',' ',' ','O','W',' ','B','W',' ','W',' ','W'},
                {'W', 'O','W',' ',' ',' ',' ',' ',' ','W',' ','W',' ',' ',' ',' ',' ',' ',' ',' ','W'},
                {'W', ' ',' ',' ','W',' ','W',' ','W','W','B','W','W',' ','W',' ','W','P','W',' ','W'},
                {'W', 'W','W',' ','W',' ','W',' ',' ','W','W','W','P',' ','W',' ','W',' ','W',' ','W'},
                {' ', ' ','T',' ',' ','D','W','W',' ','K','C','K',' ','W','W',' ',' ',' ',' ',' ','W'},
                {'W', 'W','W',' ','W',' ','W',' ',' ','W','W','W',' ',' ','W',' ','W',' ','W',' ','W'},
                {'W', 'P',' ',' ','W',' ','W','O','W','W','B','W','W',' ','W',' ','W',' ','W',' ','W'},
                {'W', 'O','W',' ',' ',' ',' ',' ',' ','W',' ','W',' ',' ',' ',' ',' ',' ',' ',' ','W'},
                {'W', ' ','W',' ','W','B',' ','W',' ',' ',' ',' ',' ','W','D','B','W',' ','W',' ','W'},
                {'W', ' ','W',' ','W','W',' ','W','W','W','V','W','W','W',' ','W','W',' ','W','D','W'},
                {'W', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','P',' ',' ',' ',' ','W'},
                {'W', 'W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W','W'},
            },
            { 
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},//Endscreen
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','B','H','T',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ','Y',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','X',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            },
            { 
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','B',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
                {' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
            },
        };

    public void levelauswahl()//Wechselt zur nächsten Ebene    
    {   
        if (getObjects(Hero.class).get(0).touchesDoor()&&schlüssel==true){           
            aktuellesLevel = aktuellesLevel + 1; 
            schlüssel = false;//entfernt den Schlüssel für die nächste Ebene wieder
            reset();
            recreate(); 
        }
    }

    public void act()
    {
        Greenfoot.setSpeed(50);
        if(aktuellesLevel==11)//Zeigt bei Beendung des Spiels Siegestext an
        {
            showText("Du hast das Verlies bezwungen und den Armen das Gold zurückgegeben",10,4);
            showText("Die Dorfbewohner werden dich hierfür für immer verehren",10,5);
            if(endsongPlayed == false)//Siegessound wird einmal abgespielt, bei erreichen der 11ten Ebene
            {
                Greenfoot.playSound("Siegessound.mp3"); 
                endsongPlayed = true;
            }
        }
        einführung();
        if(einführung == true)//Methoden, die erst nach Beendung des Tutorials durch die act-Methode aufgerufen werden
        {
            if(hintergrundmusictimer==0)//Sobald der Musictimer abgelaufen ist
            {
                Greenfoot.playSound("Hintergrundmusik.mp3");//Hintergrundmusic wird abgespielt
                hintergrundmusictimer=2000;//Timer wird resettet
            }
            if(hintergrundmusictimer>0)//Setzt den Timer herunter
            {
                hintergrundmusictimer=hintergrundmusictimer-1;
            }
            levelauswahl();
            schlüsselerkennung();
        }
        if(delayTimer > 0)
        {
            delayTimer = delayTimer - 1;
        }
        if(aktuellesLevel > 0)
        {
            showText("Level: " + aktuellesLevel, 7, 0);
        }
        if(schlüssel == true)
        {
            showText("Schlüssel im Besitz", 2, 15);
        }
    }

    public void schlüsselerkennung()//Erkennt, ob der Held neben einer Truhe steht und fügt ihm einen Schlüssel zu
    {
        int xHero = getObjects(Hero.class).get(0).getX();
        int yHero = getObjects(Hero.class).get(0).getY();
        int xTruhe = getObjects(Chest.class).get(0).getX();
        int yTruhe = getObjects(Chest.class).get(0).getY();

        if(xHero == xTruhe-1 && yHero == yTruhe )
        {
            schlüssel = true;
        }
        if(xHero == xTruhe+1 && yHero == yTruhe )
        {
            schlüssel = true;
        }
        if(xHero == xTruhe && yHero == yTruhe-1 )
        {
            schlüssel = true;
        }
        if(xHero == xTruhe && yHero == yTruhe+1 )
        {
            schlüssel = true;
        }
    }

    public void einführung()//Ist für den Text der Einführung verantwortlich
    {
        if(einführung == false)
        {   
            if(Greenfoot.isKeyDown("e")&&textauswahl==2&&delayTimer==0)//Leerer Text, damit der vorige überschrieben wird und somit kein Text mehr sichtbar ist
            {
                showText(" ",10,4);
                showText(" ",10,5);    
                showText(" ",10,6);
                showText(" ",10,7);
                showText(" ",10,8);
                showText(" ",10,10);
                einführung = true;
                aktuellesLevel = aktuellesLevel + 1;
                reset();
                recreate();
            }
            if(Greenfoot.isKeyDown("e")&&textauswahl==1)//Weiterer Text(Erklärung der Steuerung)
            {
                showText("Bewege dich nun mithilfe von W-A-S-D durch das Labyrinth.",10,4);
                showText("Laufe auf jeder Ebene zur Truhe, um an die Schlüssel zu gelangen.",10,5);    
                showText("Mit diesen kannst du dann jeweils die Schlösser knacken um zur nächsten Ebene vorzudringen,",10,6);
                showText("Sammle die Pfeile auf um dich mit deinem Bogen (Linksklick der Maus) vor den Gegnern zu schützen.",10,7);
                showText("In einem Busch kannst du dich vor Gegnern verstecken.",10,8);
                showText("Drücke E um das Spiel zu beginnen",10,10);
                textauswahl = textauswahl +1;
                delayTimer = 40;
            }
            if(textauswahl==0)//Anfangstext(EInführung in die Spielstory)
            {
                showText("In den Schatten von Sherwood entschloss sich Robin Hood,",10,4);
                showText("den legendären Schatz aus dem verlassenen Verließ unter Nottingham Castle zu bergen.",10,5);    
                showText("Dieser Schatz, einst vom grausamen König gesammelt, sollte den Armen zurückgegeben werden.",10,6);
                showText("Um dies zu schaffen betritt Robin das Labyrinth des Verlieses bei Nacht.",10,7);
                showText("Trotz gefährlicher Gegner und engen Gängen stellst du dich nun dem Labyrinth",10,8);
                showText("Drücke E um fortzufahren",10,10);
                textauswahl = textauswahl +1;
            }
        }
    }

    public Dungeon()
    {    
        // Create a new world
        super(21, 15, 50);

        setBackground(new GreenfootImage("Basaltwand.png"));//Setzt das Hintergrundbild
        recreate();
    }

    public void recreate()//Baut jeweils das Dungeon auf
    {
        for (int y=0; y< this.levelListe[this.aktuellesLevel].length; y++){
            for (int i=0; i< this.levelListe[this.aktuellesLevel][y].length; i++) {
                if (this.levelListe[this.aktuellesLevel][y][i] == 'W')//Setzt für W Wände
                {
                    Wand wand = new Wand();
                    this.addObject(wand, i, y);
                }
                if(this.levelListe[this.aktuellesLevel][y][i] == 'T')//Setzt für T Türen
                {
                    Tuer tür = new Tuer();
                    this.addObject(tür, i, y);
                }
                if(this.levelListe[this.aktuellesLevel][y][i] == 'B')//Setzt für B Büsche
                {
                    Busch busch = new Busch();
                    this.addObject(busch, i, y);
                }
                if(this.levelListe[this.aktuellesLevel][y][i] == 'C')//Setzt für C Truhen
                {
                    Chest chest = new Chest();
                    this.addObject(chest, i, y);
                }
                if(this.levelListe[this.aktuellesLevel][y][i] == 'H')//Setzt für H Helden
                {
                    Hero held = new Hero();
                    this.addObject(held, i, y);
                }
                if (this.levelListe[this.aktuellesLevel][y][i] == 'P')//Setzt für A Pfeil auf die Welt
                {
                    PfeilAufsammeln pfeil = new PfeilAufsammeln();
                    this.addObject(pfeil, i ,y);
                }
                if(this.levelListe[this.aktuellesLevel][y][i] == 'D')//Setzt für C Truhen
                {
                    Drache drache = new Drache();
                    this.addObject(drache, i, y);
                }
                if(this.levelListe[this.aktuellesLevel][y][i] == 'O')//Setzt für C Truhen
                {
                    Oger oger = new Oger();
                    this.addObject(oger, i, y);
                }
                if(this.levelListe[this.aktuellesLevel][y][i] == 'K')//Setzt für C Truhen
                {
                    Troll troll = new Troll();
                    this.addObject(troll, i, y);
                }
                if(this.levelListe[this.aktuellesLevel][y][i] == 'V')//Setzt für C Truhen
                {
                    Wolverine wolverine = new Wolverine();
                    this.addObject(wolverine, i, y);
                }
                if (this.levelListe[this.aktuellesLevel][y][i] == 'G')//Setzt für G das Hintergrundbild der EInführung
                {
                    Background1 bild = new Background1();
                    this.addObject(bild, i, y);
                }
                if (this.levelListe[this.aktuellesLevel][y][i] == 'Y')//Setzt für Y den einen Teil des Abschlussbildes
                {
                    Background2 bild = new Background2();
                    this.addObject(bild, i, y);
                }
                if (this.levelListe[this.aktuellesLevel][y][i] == 'X')//Setzt für Y den anderen Teil des Abschlussbildes
                {
                    Background3 bild = new Background3();
                    this.addObject(bild, i, y);
                }
            }
        }
    }

    public void reset(){//Cleart jeweils das Dungeon, bevor es neu aufgebaut wird 
        {
            removeObjects(getObjects(Actor.class));
        }
    }
}

