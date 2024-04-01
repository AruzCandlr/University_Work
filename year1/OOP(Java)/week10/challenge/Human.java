
public class Human extends Object3D{

	protected boolean isAlchemist = false;
	protected boolean alive;
	public Human(String name) {
		super(name,null);
		this.alive = true;
	}
	public boolean isHuman() {
		return true;
	}
	public void kill() {
		System.out.println(this.getName() + "recieves rebound and dies");
		this.alive = false;
	}
	/****
	 * I search up the internet about 
	 * how much average human volume and surface area is
	 * lol O)w(O
	 */
	@Override
	public double getVolume() {
	
		return 62000.00;
	}

	@Override
	public double getSurface() {
		
		return 18000.00;
	}
	@Override
	public String toString() {
		if(!this.alive) {
			return this.getName() + " wa mou shinderu!";
		}
		return this.getName() +  " is a random hopeless human.";
	}



}
