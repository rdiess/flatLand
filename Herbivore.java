import java.awt.Color;
import java.util.ArrayList;

/**
 * this Class represents a herbivore, which manifests as a cirlce with radius five
 * @author Ray Diess
 *
 */
public class Herbivore {
	/**instance variables for the Herbivore
	 * 
	 * myX-represents the x coordinate of the herbivore
	 * myY-represents the y coordinate of the herbivore
	 * myLand-represents the FlatLand object associated with the herbivore
	 * myDiameter- represents the diameter of a herbivore object
	 * numbereaten-a number that represents the number of plants a given herbivore comes into contact with
	 * randomx-variable representing an "invisible" x coordinate that the herbivore will follow when out of range of a plant
	 * randomy-variable representing an "invisible" y coordinate that the herbivore follows when far away from a plant
	 */
	private double myX;
	private double myY;
	private FlatLand myLand;
	private double myDiameter;
	private int numbereaten;
	private double randomx;
	private double randomy;

	/**
	 * 
	 *  X-represents the x coordinate of the herbivore
	 * Y-represents the y coordinate of the herbivore
	 * f-represents the FlatLand object associated with the herbivore
	 * Diameter- represents the diameter of a herbivore object
	 * e-a number that represents the number of plants a given herbivore comes into contact with
	 * randomx-variable representing an "invisible" x coordinate that the herbivore will follow when out of range of a plant
	 * randomy-variab
	 */
	public Herbivore(FlatLand f, double diameter, double x, double y,int e){
		myLand = f;
		myDiameter = diameter;
		myX = x;
		myY = y;
		numbereaten=e;
		randomx=Math.random()*2-1;
		randomy=Math.random()*2-1;
		
		
	}
	/**
	 * this method draws the herbivore object as a circle with an x and y coordinate and a radius of 5 on the canvas
	 */
	public void draw(){
		StdDraw.setPenColor(Color.black);
		StdDraw.circle(myX, myY, 5);
	}
	/**
	 * A boolean method taking in a plant object and returning either true or false.
	 * @param aPlant-represents some plant object
	 * @return returns either true or false depending on how close a herbivore object is to a plant object
	 */
	public boolean ate(Plant aPlant){
		Herbivore h= new Herbivore(myLand,myDiameter,myX,myY,numbereaten);
	if(aPlant.distance(h, aPlant)<=(aPlant.getDiameter()+1)){
		return true;
		}
	else{
	return false;
	}
	}

	/**
	 * 
	 * @return-returns the diameter of a herbivore object
	 */
	public double getDiameter() {
		return myDiameter;
	}

	/**
	 * 
	 * @param diameter -takes in a diameter and sets that diameter as the diameter of a herbivore object
	 * allows the user to change the diameter of a herbivore
	 */
	public void setDiameter(double diameter) {
		myDiameter = diameter;
	}
/**
 * 
 * @return-returns the x coordinate of a herbivore
 */
	public double getX() {
		return myX;
	}
	
	
/**
 * 
 * @param x-takes in a double parameter and sets this value as the x coordinate of a herbivore object
 */
	public void setX(double x) {
		myX = x;
	}
/**
 * 
 * @return -returns the y coordinate of a herbivore object
 */
	public double getY() {
		return myY;
	}
/**
 * 
 * @param y-takes in a parameter of type double and sets this to be the herbivore object's y coordinate
 */
	public void setY(double y) {
		myY = y;
	}
	/**
	 * 
	 * @return-returns the number of plants eaten by a herbivore
	 */
	public int geteaten(){
		return numbereaten;
	}
	/**
	 * 
	 * @return- adds one to the number of plants eaten every time this method is called.
	 */
	public int eaten(){
		return numbereaten++;
	}
	/**
	 * 
	 * @return-returns the FlatLand object associated with a herbivore
	 */
	public FlatLand getFlatLand(){
		return myLand;
	}
	/**
	 * sets up the behavior of the herbivore in terms of movement. If the 
	 * herbivore is close to a plant object, it will make contact with that object
	 * if the herbivore is out of range of a plant it will move randomly. 
	 * This method relies on methods findNearest and Distance to allow the plants and herbivores to interact
	 */
	public void move(){
		Herbivore h= new Herbivore(myLand,myDiameter,myX,myY,numbereaten);
		
	Plant p = myLand.findNearest(h);
	if(myX>1000){
		myX=0;
	}
	else if(myX<0){
		myX=1000;
	}
	if(myY>1000){
		myY=0;
	}
	else if(myY<0){
		myY=1000;
	}
	
	if(distance(h,p) >50 ){
		myX=myX+randomx;
		myY=myY+randomy;
		myX=Math.random()+myX;
	myY=Math.random()+myY;
		int randomx=(((int)Math.random() * 2  - 1) );
		 int randomy=((int)(Math.random() * 2 - 1) );
	myX=(Math.random()*2-1.5)*1+myX;
	myY=(Math.random()*2-1.5)*1+myY;
	 

	
		 if(myX>1000){
				myX=0;
			}
			else if(myX<0){
				myX=1000;
		}
		if(myY>1000){
			myY=0;
		}
		else if(myY<0){
			myY=1000;
		}
	}
	
	else if(distance(h,p) < 100){
		myX = myX + (p.getX() - myX) / Plant.distance(h, p);
		myY = myY + (p.getY() - myY) / Plant.distance(h, p);
		
	}
	Square s=new Square(myLand,myX,myY,0 );
	if (Predator.predatordistance(s, h)<50){
		myX = myX - (s.getX() - myX) / Predator.predatordistance(s, h);
		myY = myY - (s.getY() - myY) / Predator.predatordistance(s, h);
		
	}
	
	}
	
	//Herbivore h= new Herbivore(myLand,myDiameter,myX,myY);
//	myX = myX + (p.getX() - myX) / Plant.distance(h, p);
//	myY = myY + (p.getY() - myY) / Plant.distance(h, p);
	
		
		
	

	/**
	 * Finds the distance between a herbivore and a plant
	 * @param aHerb-herbivore object
	 * @param aPlant-plant object
	 * @return-returns a double value representing the distance between a herbivore and plant
	 */
	public static double distance(Herbivore aHerb, Plant aPlant){
		return Math.sqrt(((aHerb.getX() - aPlant.getX()) * (aHerb.getX() - aPlant.getX())) + ((aHerb.getY()  - aPlant.getY()) * (aHerb.getY() - aPlant.getY())));
	}
	/**
	 * tells the herbivore to change direction when it has eaten a plant.
	 * Math.random is used along with two operators to allow the herbivore to move down/up or right/left
	 * according to the value of math.random(). This lets the herbivores change direction randomly when they have eaten a
	 * plant.
	 */
	public void DirectionChange(){
		randomx=Math.random()*2-1;
		randomy=Math.random()*2-1;
		if((randomx<=.5)&&(randomx>=.5)){
			randomx*=1.9;
		}
		if((randomy<=.5)&&(randomy>=.5)){
			randomy*=1.9;
	}
	}

	
}
