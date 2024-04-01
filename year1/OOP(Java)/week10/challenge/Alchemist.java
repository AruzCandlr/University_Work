import java.util.HashMap;


public class Alchemist extends Human implements Alchemy{
	private PhilosopherStone stone;
	private boolean equipt = false;
	private static HashMap<String, MagnumOpus.stages> type =  new HashMap<>();
	
	public Alchemist(String name) {
		super(name);
		//alchemist knows about alchemy, so they have knowledge about magnum opus
		Alchemist.type.put("Nigredo",  MagnumOpus.stages.Nigerdo);
		Alchemist.type.put("Albedo",  MagnumOpus.stages.Albedo);
		Alchemist.type.put("Citriniras",  MagnumOpus.stages.Citriniras);
		Alchemist.type.put("Rubido",  MagnumOpus.stages.Rubido);
	}
	
	public void equipPhilosopherStone(String x) {
		System.out.println(this.getName()+" is equiped with philosopher stone, which is in "+x+" stage.");
		this.stone = new PhilosopherStone(type.get(x));
		this.equipt = true;
	}
	
	
	@Override
		public MatAlchemy transmutation(MatAlchemy x, Object3D.Material y, double z) {
			MatAlchemy transmuted = new MatAlchemy(x.getName()+"(transmuted)",y,z);
			
			if(x.getMass() < transmuted.getMass()) {
				if(this.equipt) {
					if(this.stone.use(transmuted.getMass()-x.getMass())) {
						System.out.println("trasmuted "+x.getName()+ " successfully");
					}
					else {
						this.kill(); 
						System.out.println("trasmuted failed");return new MatAlchemy("failed product", x.getMaterial(),-999);
						}
				}
				else {
					this.kill(); 
					System.out.println("trasmuted "+x.getName()+ " successfully");
					return new MatAlchemy("failed product", x.getMaterial(),-999);
					}
			}
			
			else if(x.getMass() > transmuted.getMass()) {
				double extraMass = x.getMass()-transmuted.getMass();
				double extraVol = extraMass/Object3D.DENSITIES[x.getMaterial().ordinal()];
				System.out.println("transmuted "+x.getName()+" successfully and got extra volume for around " + Math.round(extraVol) + " (unit)");
				System.out.println("transmuted extra volume to the output");
				transmuted.increaseVol(extraVol);
				
				
			}
			else {
				System.out.println("trasmuted "+x.getName()+ " successfully");
			}
			return transmuted;
		}
	

	

		@Override
	public String toString() {
		if(!this.alive) {
			return this.getName() + " wa mou shinderu from the rebound/n"
					+ "you should've never violate the law of equivalent exchange!";
		}
		return this.getName() + " is an alchemist.";
	}

		

}
