import java.util.ArrayList;

/**
 * The purpose of this project is to practice using more complicated and interdependent classes with the standard draw class
 * in order to create a graphical simulation that is built from multiple classes.
 * @author Ray Diess
 *
 */

/**
 * This test driver uses theLand object to invoke the FlatLand methods along with StdDraw
 * to perform various actions. StdDraw is used to set the size and scale of the canvas, run simulation
 * actually draws the herbivores and plants and tells the herbivores and plants how to behave.
 * @author Diess
 *
 */
public class TestDriver {
	public static void main(String[] args) {
		FlatLand theLand = new FlatLand(1000.0, 1000.0, 20.0, 300.0,2,2);
		//StdDraw.clear();
		StdDraw.setCanvasSize(1000, 1000);
		StdDraw.setXscale(0.0, 1000.0);
		StdDraw.setYscale(0.0, 1000.0);
		theLand.runSimulation();
		StdDraw.show(1);
		
		theLand.printStatistics();
		}
		
	}
	
	
	
	
//}
