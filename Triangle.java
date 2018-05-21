import java.awt.Color;
/**
 * This is the Triangle class which is a child class of Predator
 * @author Diess
 *
 */
public class Triangle extends Predator {
	/**
	 * 
	 * @param f-represents the flatland the triangle inhabits
	 * @param x-represents the triangle's x coordinate
	 * @param y-represents the triangle's y coordiante
	 * @param e-represents the number of herbivores the triangle has eaten
	 */
	public Triangle(FlatLand f, double x, double y, int e) {
		super(f, x, y, e);

	}
/** 
 * draws the triangle as three lines and turns it red based on a case that is true all the time
 */
	@Override
	public void draw() {
		Herbivore h = myLand.findNearestHerbivore(this);
		if (predatordistance(this, h)<1000){
			StdDraw.setPenColor(Color.red);
		}
		
		StdDraw.line(myX, myY, myX + 10, myY + 10);
		StdDraw.line(myX, myY, myX - 10, myY + 10);
		StdDraw.line(myX + 10, myY + 10, myX - 10, myY + 10);
	}
/**
 * sets up the movement of the triangle. the triangle will stop for 100 counts after eating a herbivore.
 * The triangle will chase a herbivore that comes within 200 units of it while it is "awake" The
 * triangle will move towards a plant if it is not frozen and there are no herbivores in sight.
 * The triangle will move randomly if none of the aforementioned conditions are true
 */
	@Override
	public void move() {
		Triangle t = this;
		Plant p = myLand.findNearestPlant(t);
		Herbivore h = myLand.findNearestHerbivore(t);

		
		if (restcounter <= 0){
			if (predatordistance(t, h) < 200) {
				myX = (myX + (h.getX() - myX) * 2 / Predator.predatordistance(t, h));
				myY = (myY + (h.getY() - myY) * 2 / Predator.predatordistance(t, h));
			}
	
			else if (predatordistance(t, h) > 200) {
				if (plantdistance(t, p) < 200) {
					myX = (myX + (p.getX() - myX) * 2
							/ Predator.plantdistance(t, p));
					myY = (myY + (p.getY() - myY) * 2
							/ Predator.plantdistance(t, p));
				}
				
				else {
					myX = myX + randomx;
					myY = myY + randomy;
					myX = Math.random() + myX;
					myY = Math.random() + myY;
					int randomx = (((int) Math.random() * 2 - 1));
					int randomy = ((int) (Math.random() * 2 - 1));
					myX = (Math.random() * 2 - 1.5) * 1 + myX;
					myY = (Math.random() * 2 - 1.5) * 1 + myY;
				}
			}
	
			
	
			if (myX > 1000) {
				myX = 0;
			} else if (myX < 0) {
				myX = 1000;
			}
			if (myY > 1000) {
				myY = 0;
			} else if (myY < 0) {
				myY = 1000;
			}
		}
		else{
			restcounter --;
		}
	}

	@Override
	/**
	 * the presence of this method is inconsequential but it is supposed to change the direction of the Triangle randomly
	 * after it has eaten a herbivore. This method should never get called except maybe in the rare case where two herbivores 
	 * are in the Triangle's range of "seeing" at the same time.
	 */
	public void DirectionChange() {
		randomx = Math.random() * 2 - 1;
		randomy = Math.random() * 2 - 1;
		if ((randomx <= .5) && (randomx >= .5)) {
			randomx *= 1.9;
		}
		if ((randomy <= .5) && (randomy >= .5)) {
			randomy *= 1.9;
		}

	}

	@Override
	/**
	 * allows the number of herbivores eaten to accrete everytime a square causes a herbivore to disappear
	 */
	public int numbereaten() {
		// TODO Auto-generated method stub
		return killnumber++;
	}

	@Override
	/**
	 * returns true if the distance between a herbivore and triangle predator is less than the diameter of herbivore plus one
	 */
	public boolean ate(Herbivore aHerb) {
		Triangle t = new Triangle(myLand, myX, myY, killnumber);
		if (predatordistance(t, aHerb) <= (aHerb.getDiameter() + 1)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * returns the x value of the triangle
	 */
	public double getX() {
		return myX;
	}

	@Override
	/**
	 * returns the y value of the triangle
	 */
	public double getY() {
		return myY;
	}

	@Override
	/**
	 * returns the rest counter of the triangle which tells it when to freeze and when to move again.
	 */
	public int getrestcounter() {
		return restcounter;
	}

}
