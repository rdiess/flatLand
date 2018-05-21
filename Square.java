import java.awt.Color;

/**
 * This is the Square class which is a child class of Predator
 * @author Diess
 *
 */
public class Square extends Predator {
	/**
	 * 
	 * @param f-represents the flatland the square inhabits
	 * @param x-represents the square's x coordinate
	 * @param y-represents the square's y coordiante
	 * @param e-represents the number of herbivores the Square has eaten
	 */
public Square(FlatLand f, double x, double y, int e) {
		super(f, x, y, e );
		
	}



@Override
/**
 * this method draws the square as a square and sets it equal to red or green depending on its
 * vicinity to a herbivore
 */
public void draw() {
	Herbivore h = myLand.findNearestHerbivore(this);
	if (predatordistance(this, h)<50){
		StdDraw.setPenColor(Color.red);
	}
	else{
		StdDraw.setPenColor(Color.green);
	}
	StdDraw.filledSquare(myX, myY, 5);
	
}

@Override
/**
 * this method sets up the motion of a square, the square is stationary until a herbivore comes within 50 units of it
 * at which point it moves towards the herbivore in question.
 */
	public void move(){
		Square s= new Square(myLand,myX,myY,killnumber);
		
	Herbivore h=myLand.findNearestHerbivore(s);
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
	
	if(predatordistance(s,h) >50 ){
	myX=myX;
		myY=myY;
		myX=myX;
	myY=myY;
		int randomx=(((int)Math.random() * 2 - 1) );
		 int randomy=((int)(Math.random() * 2 - 1) );
	myX=myX;
	myY=myY;
	 

	
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
	
	 if(predatordistance(s,h) < 50){
		myX = (myX + (h.getX() - myX)*3 / Predator.predatordistance(s, h));
		myY = (myY + (h.getY() - myY)*3 / Predator.predatordistance(s, h));
		
	}
	
	}
	


@Override
/**
 * the presence of this method is inconsequential but it is supposed to change the direction of the square randomly
 * after it has eaten a herbivore. This method should never get called except maybe in the rare case where two herbivores 
 * are in the square's range of "seeing" at the same time.
 */
public void DirectionChange() {
	{
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
 * returns true if the distance between a herbivore and predator is less than the diameter of herbivore plus one
 */
public boolean ate(Herbivore aHerb) {
	Square s= new Square(myLand,myX,myY,killnumber);
	if(predatordistance(s, aHerb)<=(aHerb.getDiameter()+1)){
		return true;
		}
	else{
	return false;
	}
}
/**
 * returns the x value of the square
 */
@Override
public double getX(){
	return myX;
}
//returns the y value of the predator
@Override
public double getY(){
	return myY;
}


}
