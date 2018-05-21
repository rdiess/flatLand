import java.util.ArrayList;

/**
 * this is the flatland class which creates an object that is responsible for organizing the plants and
 * herbivores on the canvas
 * @author Ray Diess
 *
 */
public class FlatLand {
	
	private ArrayList<Herbivore> myHerbs;
	private ArrayList<Plant> myPlants;
	private ArrayList<Triangle> myTriangles;
	private ArrayList<Square> mySquares;
	private double myWidth;
	private double myHeight;
	private double myNumberOfHerbs;
	private double myNumberOfPlants;
	private double myNumberOfTriangles;
	private double myNumberOfSquares;
	private double counter=0;

	/**
	 * 
	 * @param w-represents the with of FlatLand
	 * @param h-represents the height of Flatland
	 * @param Herb-represents a herbivore
	 * @param Plant-represents a plant
	 * Square-represents a square predator
	 * Triangle-represents a triangle predator
	 * 
	 * numberofherbs-represents the number of herbivores
	 * numberofsquares-represents the number of squares
	 * numberofplants-represents the number of plants
	 * numberoftriangles-represents the number of triangles
	 * numberofsquares-represents the number of squares
	 * 
	 * 
	 * MyHerbs- a collection of herbivores
	 * MyPlants- an arraylist of plants
	 * mySquares-a collection of squares
	 * myTriangles-an arraylist of triangles
	 */
	/**
	 * 
	 * the flatland constructor, all parameters are defined above.
	 */
	public FlatLand(double w, double h, double Herb, double Plant,double Triangle, double Square){
		myWidth = w;
		myHeight = h;
		myNumberOfHerbs = Herb;
		myNumberOfPlants = Plant;
		myNumberOfTriangles=Triangle;
		myNumberOfSquares=Square;
		myHerbs = new ArrayList<Herbivore>();
		myPlants = new ArrayList<Plant>();
		myTriangles=new ArrayList<Triangle>();
		mySquares=new ArrayList<Square>();
		/**
		 * creates 300 plant objects
		 */
		for(int i = 0; i < 300; i++){
			Plant p = new Plant(this,1, 1000 *Math.random(), 1000 * Math.random());
			myPlants.add(p);
		

			
			
		}
		/**
		 * creates 20 herbivore objects
		 */
		for(int i = 0; i < 20; i++){
			Herbivore p = new Herbivore(this, 1, 1000 *Math.random(), 1000 * Math.random(),0);
			myHerbs.add(p);
		}
		/**
		 * creates 2 triangle objects
		 */
		for(int i=0; i<2; i++){
			Triangle t=new Triangle(this, 1000*Math.random(), 1000*Math.random(),0);
			myTriangles.add(t);
			
		}
		/**
		 * creates 2 square objects
		 */
		for(int i=0;i<2;i++){
			Square s=new Square(this, 1000*Math.random(),1000*Math.random(),0);
			mySquares.add(s);
		}
	}
	
	
	
	
	/**
	 * resets the canvas so that herbivores keep moving while plants are present
	 */
	public void runSimulation(){
		
		while(myPlants.size() > 0 && myHerbs.size()>0){
			
			StdDraw.clear();
			//counter++;
			/**
			 * invokes draw on every plant in the myPlants array
			 */
			for(Plant p : myPlants){
				p.draw();
				
				
			}
			/**
			 * invokes draw and move on all triangle objects in flatland and removes herbivores from the canvas depending
			 * on certain conditions involving the distance between some plant and some predator. These also sets the 
			 * rest counter equal to restmax(100) and therefore stops the triangle if the same distance conditions mentioned earlier
			 * are met.
			 */
		for(Triangle t: myTriangles){

			t.draw();
			t.move();
			Herbivore h=findNearestHerbivore(t);
			Plant p=findNearestPlant(t);
			
			
			if(FlatLand.removeHerbivore(t,h)==true){
				
				t.setrestcounter(t.restmax);
				myHerbs.remove(h);
				
					t.DirectionChange();
					t.numbereaten();
				
			
			}
		
			
			}

			/**
			 * invokes draw and move on every square and removes herbivores depending on whether or not certain 
			 * conditions are met. These conditions can be found in the findNearestHerbivore method below.
			 */
		for(Square s: mySquares){
			s.draw();
			s.move();
			Herbivore h=findNearestHerbivore(s);
			if(FlatLand.removeHerbivore(s, h)==true){
				myHerbs.remove(h);
				s.DirectionChange();
				s.numbereaten();
			}
			
		}
			/**
			 * invokes draw and move on every herbivore in the myHerbs array
			 */
			for(Herbivore h : myHerbs){
				h.draw();
				h.move();
					Plant p = findNearest(h);
				
				/**
				 * invokes the remove method(the one bult into java) on every plant in the myPlants array that has been eaten
				 * invokes direction change and eaten on herbivores that have contacted a Plant
				 */
				if(FlatLand.remove(h,p)){
					myPlants.remove(p);
					h.DirectionChange();
					h.eaten();
				}

			}
			
			
			StdDraw.show(1);
			counter++;
			
		}
		}
		
		
	
		
	
		
	
	/**
	 * prints the time elapsed by printing the variable counter, which increments every time the canvas
	 * is reset.
	 * this also prints which herbivores ate [some number] of plants. This is done
	 * by looking at each herbivore individually (cia a for loop) and invoking geteaten() on that herbivore
	 */
	public void printStatistics(){
		if(myHerbs.size()==0.0||myPlants.size()==0.0){
		System.out.println("Time Elapsed: "+counter);
		for(int i=0; i<myHerbs.size(); i++){
			System.out.println(" Herbivore " +i+" ate "+myHerbs.get(i).geteaten());
		}
		for(int i=0; i<myTriangles.size();i++){
			System.out.println(" Triangle " +i+" ate "+myTriangles.get(i).getNumbereaten());
		}
		for(int i=0; i<mySquares.size();i++){
			System.out.println("Square " +i+" ate "+mySquares.get(i).getNumbereaten());
		}
		}
	}
	
	
		
		
	
		
	
	
	/**
	 * This method returns an array of plants that are close to a herbivore. These plants are to be removed
	 * from myPlants.
	 * @param h-represents a herbivore
	 * @return-returns an array of plants that are sufficiently close to a herbivore
	 */
	public Plant findNearest(Herbivore h){
		 Plant theClosest=new Plant(this,h.getX(),h.getY(),1);
		 
		
		double minDistance = Double.MAX_VALUE;
		for(int i = 0; i < myPlants.size(); i++){
			if((Plant.distance(h, myPlants.get(i)) <= minDistance)){
				minDistance = Plant.distance(h, myPlants.get(i));
				theClosest = myPlants.get(i);
				
			}
		}
		return theClosest;
	}
	/**
	 * 
	 * @param p-represents a predator
	 * @return-returns the herbivore that is closest to the predator p.
	 */
	public Herbivore findNearestHerbivore(Predator p){
		Herbivore theClosest=new Herbivore(this,p.getX(),p.getY(),1,0);
		double minDistance=Double.MAX_VALUE;
		for(int i=0; i<myHerbs.size();i++){
			if((Predator.predatordistance(p, myHerbs.get(i))<=minDistance)){
				minDistance=Predator.predatordistance(p, myHerbs.get(i));
					theClosest=myHerbs.get(i);
				}
			}
		return theClosest;
		}
	/**
	 * 
	 * @param p-represents a predator
	 * @return-returns the plant object that is closest to the predator p
	 */
	public Plant findNearestPlant(Predator p){
		Plant theClosest=new Plant(this,p.getX(),p.getY(),1);
		double minDistance=Double.MAX_VALUE;
		for(int i=0; i<myPlants.size();i++){
			if((Predator.plantdistance(p, myPlants.get(i))<=minDistance)){
				minDistance=Predator.plantdistance(p, myPlants.get(i));
				theClosest=myPlants.get(i);
			}
		}
		return theClosest;
	}
	
	/**
	 * 
	 * @param aHerb-Herbivore object
	 * @param aPlant-Plant object
	 * @return-returns true or false depending on whether or not the diameter of a plant
	 * is greater than the distance between a herbivore and plant.
	 * This tells eclipse when a herbivore has made contact with a plant
	 */
public static boolean remove(Herbivore aHerb, Plant aPlant){
	if(Plant.distance(aHerb, aPlant)<aPlant.getDiameter()){
	return true;
}
return false;
}


/**
 * 
 * @param aPred-represents a predator
 * @param aHerb-Herbivore object
 * @return-returns true or false depending on the distance between the predator and herbivore as it relates
 * to the size of each(which is the same, hence the *2) 
 */
public static boolean removeHerbivore(Predator aPred, Herbivore aHerb){
	if(Predator.predatordistance(aPred, aHerb)<aHerb.getDiameter()*2){
		return true;
	}
	return false;
}

	 
	
	 
}

