import java.util.ArrayList;
/**
 * This is a parent class called Predator which holds all the methods that the child classes
 * Square and Triangle in the program.
 * @author Diess
 *
 */

public abstract class Predator {
	
protected double myX;
protected double myY;
protected int killnumber;
protected FlatLand myLand;
protected double randomx;
protected double randomy;
protected int restcounter=0;
protected int restmax = 100;

/**
 * This is the predator constructor.
 * @param f-represents a flatland that the predator inhabits
 * @param x-represents the x coordinate of the predator
 * @param y-represents the y coordinate of the predator
 * @param e
 * randomx and randomy are used to create random motion in the predators where they are needed
 */

public Predator(FlatLand f, double x, double y,int e  ){
	myLand = f;
	myX = x;
	myY = y;
	killnumber=e;
	randomx=Math.random()*2-1;
	randomy=Math.random()*2-1;
}
/**
 * this method draws the actual predator
 */
public abstract void draw();
/**
 * 
 * @return-returns the predator's restcounter which is used for the Triangle predator in keeping tack of how long
 * a given triangle should "sleep" or stay paralyzed.
 */
public int getrestcounter(){
	return restcounter;
}
/**
 * 
 * @param rest-this takes in an integer and sets the value of the restcounter equal to the parameter's value
 */
public void setrestcounter(int rest){
	restcounter = rest;
}
/**
 * 
 * @return-returns the x coordiante of the predator
 */
public double getX() {
	return myX;
}
/**
 * 
 * @param myX-takes in a double value and sets that value equal to the x coordinate of the predator
 */
public void setX(double myX) {
	this.myX = myX;
}
/**
 * 
 * @return-returns the y coordinate of the predator
 */
public double getY() {
	return myY;
}
/**
 * 
 * @param myY-takes in a double value and sets this number equal to the predator's y coordinate
 */
public void setY(double myY) {
	this.myY = myY;
}
/**
 * 
 * @return-returns the number of herbivores the predator has eaten
 */
public int getNumbereaten() {
	return killnumber;
}
/**
 * 
 * @param numbereaten-takes in an integer and sets this equal to the number of herbivores the predator has eaten
 */
public void setNumbereaten(int numbereaten) {
	this.killnumber = numbereaten;
}
/**
 * 
 * @return-returns the flatland object that the predator inhabits
 */
public FlatLand getLand() {
	return myLand;
}
public void setLand(FlatLand myLand) {
	this.myLand = myLand;
}
/**
 * returns the randomx value which sets up the predator's ability to move randomly
 * @return
 */
public double getRandomx() {
	return randomx;
}
/**
 * 
 * @param randomx-takes in a double value and sets this equal to the random x coordinate of the predator
 */
public void setRandomx(double randomx) {
	this.randomx = randomx;
}
/**
 * 
 * @return-returns the random y coordinate of the predator
 */
public double getRandomy() {
	return randomy;
}
/**
 * 
 * @param randomy-sets the parameter's value equal to the predator's y value
 */
public void setRandomy(double randomy) {
	this.randomy = randomy;
}
/**
 * sets up the predator's ability to move, I will elaborate in each child class.
 */
public abstract void move();
/**
 * 
 * @param aPred-represents a predator
 * @param aHerb-represents a herbivore
 * @return-returns a value representing the distance between a predator and a herbivore
 */
public static double predatordistance(Predator aPred, Herbivore aHerb){
	return Math.sqrt(((aPred.getX() - aHerb.getX()) * (aPred.getX() - aHerb.getX())) + ((aPred.getY()  - aHerb.getY()) * (aPred.getY() - aHerb.getY())));	
}
/**
 * a method which allows the predator to change direction after eating a herbivore
 */
public abstract void DirectionChange();
	/**
	 * 
	 * @return-returns an integer representing the number of herbivores that the predator has eaten
	 */
public abstract int numbereaten();

/**
 * 
 * @param aHerb-represents aHerbivore object
 * @return returns true or false based on the distance between a herbivore and predator
 */
public boolean ate(Herbivore aHerb) {
	// TODO Auto-generated method stub
	return false;
}
/**
 * 
 * @param aSquare-represents a square predator (probably is better form to just represent a predator, even if 
 * this method only applies in application to the Square child class)
 * @param aHerb-represents a herbavore
 * @return-Returns true or false based on the distance between a square or predator
 */
public static boolean ishidden(Square aSquare, Herbivore aHerb){
	if(predatordistance(aSquare, aHerb)>50){
		return true;
	}
	return false;
}
/**
 * 
 * @param aPred-represents a predator
 * @param aPlant-represents a plant
 * @return- returns the distance between the predator and the plant objects in question
 */
public static double plantdistance(Predator aPred, Plant aPlant){
	return Math.sqrt(((aPred.getX() - aPlant.getX()) * (aPred.getX() - aPlant.getX())) + ((aPred.getY()  - aPlant.getY()) * (aPred.getY() - aPlant.getY())));	
}

}




