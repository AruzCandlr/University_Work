package mock_final;
// ID:6588108
// Name: Arus Thienmee
// Section:3
import java.util.ArrayList;
import java.util.List;

public class RobotTester {
	
	
	public static List<Robot> initializeRobots(String[] names, int[] position, int[] boardSize){
		
		// TODO Task 2: using try-catch to initialize only a robot with valid position
		List<Robot> output = new ArrayList<Robot>();
		for(int i = 0; i <  names.length ; i++) {
			try{
				output.add(new Robot(names[i],position[i],boardSize[i]));
			}
			catch(IllegalArgumentException e) {
				System.out.println(e.getLocalizedMessage());
			//	e.printStackTrace();
			
				
			}
		}

	
		return output;
	}

	public static void main(String[] args) {
		
		String[] names = {"A", "B", "C", "D", "E"};
		int[] position = {1, 3, 20, 5, -1};
		int[] boardSize = {5, 20, 10, 50, 5};
		
		// Five set of robot's parameters are given, but only three robot can be initialized which are robot A, B, and D
		// The robot C and E have invalid position 
		List<Robot> robots = initializeRobots(names, position, boardSize);
		
		System.out.println("\n=== List of Initialized Robots ===");
		for(Robot r: robots) {
			System.out.println(r);
		}
			
		
		// Testing move method, to check wheter the robot can be moved or not
		
		System.out.println("\n=== Test Moveable Interface and Move Method ===");
		// move robot A to the left
		boolean moved = robots.get(0).move('L', 1);
		System.out.println(moved?"MOVED => " + robots.get(0): "CANNOT MOVE => " + robots.get(0) );
		
		// move robot B to the right
		moved = robots.get(1).move('R', 10);
		System.out.println(moved?"MOVED => " + robots.get(1): "CANNOT MOVE => " + robots.get(1) );
		
		// move robot D to the right
		moved = robots.get(1).move('X', 40);
		System.out.println(moved?"MOVED => " + robots.get(2): "CANNOT MOVE => " + robots.get(2) );
				
	}

}
