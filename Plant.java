import java.awt.Color;
import java.util.ArrayList;

/**
 * this is the Plant class which sets up what a plant object is and how it should behave.
 * @author Ray Diess
 *
 */
public class Plant {
	private double myDiameter;
	private double myX;
	private double myY;
	private FlatLand myLand;
	
	/**
	 * The Plant constructpr
	 * @param f-represents the FlatLand object associated with a plant
	 * @param diameter-represents the diameter of the circular plant object
	 * @param x-represents the x coordinate of the plant object
	 * @param y-represents the y coordinate of the plant object
	 */
	Plant(FlatLand f, double diameter, double x, double y){
		myDiameter = diameter;
		myX = x;
		myY = y;
		myLand=f;
	}
	/**
	 * void method which draws the Plant object as a circle with diameter 1 and some x and y coordinate
	 */
	public void draw(){
		ArrayList<Plant> Plants=new ArrayList<Plant>();
		StdDraw.setPenColor(Color.black);
		StdDraw.circle(myX, myY, 1);
		//Plants=myLand.remove();
		//for(Plant p: Plants){
			//p.clear();
		//}
		
		
	}
	/**
	 * unused method meant to tell the plant how to "dissapear"
	 */
	public void clear(){
		StdDraw.circle(myX,myY,0);
	}
	/**
	 * 
	 * @return-returns the diameter of a plant object
	 */
	public double getDiameter() {
		return myDiameter;
	}
/**
 * 
 * @param diameter-takes in a double parameter and sets this number as the diameter of the plant
 */
	public void setDiameter(double diameter) {
		myDiameter = diameter;
	}

/**
 * 
 * @return-returns the x coordinate of the plant
 */
	public double getX() {
		return myX;
	}
/**
 * 
 * @param x-takes in a parameter of type double and sets this as the x coordiante of a plant
 */
	public void setX(double x) {
		myX = x;
	}
/**
 * 
 * @return-returns the y coordinate of a plant object
 */
	public double getY() {
		return myY;
	}
/**
 * 
 * @param y-takes in a parameter of type double and sets this equal to the y coordinate of the plant object
 */
	public void setY(double y) {
		myY = y;
	}
	/**
	 * 
	 * @return-returns the FlatLand object associated with the plant
	 */
	public FlatLand getFlatLand(){
		return myLand;
	}
	/**
	 * this method finds the distance between a herbivore and a plant
	 * @param aHerb-represents a herbivore object
	 * @param aPlant-represents a plant object
	 * @return-returns a value of type double that represents the distance between a plant and herbivore
	 */
	public static double distance(Herbivore aHerb, Plant aPlant){
		return Math.sqrt(((aHerb.getX() - aPlant.getX()) * (aHerb.getX() - aPlant.getX())) + ((aHerb.getY()  - aPlant.getY()) * (aHerb.getY() - aPlant.getY())));
	}
	

	
	
	
}
