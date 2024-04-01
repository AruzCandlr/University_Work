package mock_final;


// ID:6588108
// Name: Arus Thienmee
// Section:3

public class Robot implements Moveable {
	
	// DO NOT MODIFY THESE METHODS
	String name;
	int position;		// position must start at 1
	int size;			// board's size
	
	public Robot(String n, int x, int size) {
		this.name = n;
		this.size = size;
		this.setPosition(x);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}
	

	public String toString() {
		return this.name + " is at position " + position + " of the board size " + size ;
	}
	
	// --- END OF DO NOT MODIFY ---


	// Complete this method to set a new position only when the given position is valid
	
	
	public void setPosition(int x) throws IllegalArgumentException{
		
		// TODO Task 1: throw exception here
		// YOUR CODE GOES HERE
		//
		
		this.position = x;
		if(x > this.size || x < 1) {
			throw new IllegalArgumentException(this.name+": Invalid position");
		}	
		
		
		
	}
	
	/**
	 * 
	 * @param direction is a character indicate the move direction either left(L) or right(R)
	 * @param step is the number of moving steps
	 * @return true if we can move the robot to a valid position, otherwise return false.
	 */
	public boolean move(char direction, int step) {
		boolean isMove = false;
		switch(direction) {
			case 'L':
				// TODO Task 3: complete this case
				// YOUR CODE GOES HERE
				
				return moveLeft(step);
			case 'R':
				// TODO Task 3: complete this case
				// YOUR CODE GOES HERE 
				
				return moveRight(step);
			default:
				System.out.println("Direction: " +  direction + " is an invalid direction!");
		}
		return isMove;
	}

	
	
	// TODO Task 3: implements interface
	// YOUR CODE GOES HERE
	//
	@Override
	public boolean moveLeft(int n) {
		
		int newPos = this.position -n;
		if(newPos > 0 && newPos < this.size ) {
			this.position = newPos;
			return true;
		}
			
		return false;
		
		
	}
	
	@Override
	public boolean moveRight(int n) {
		
		int newPos = this.position +n;
		if(newPos > 0 && newPos < this.size ) {
			this.position = newPos;
			return true;
		}
			
		return false;
	}

}
