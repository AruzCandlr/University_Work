
public class PhilosopherStone extends MagnumOpus {

	private double useLimit;
	private boolean isUsable;
	
	public PhilosopherStone(MagnumOpus.stages x) {
		this.setUseLimit((double) usage[x.ordinal()]);
		isUsable = true;
	}
	
	
	public boolean use(double x) {
		if(this.useLimit <= 0 || x > this.useLimit) {
			System.out.println("philosopher stone is at it's limit!");
			isUsable = false;
			return false;
		}
		if(this.isUsable) {
			this.useLimit-=x;
			System.out.println("use a philosopher stone in part of extra mass " + x + " (unit)" );
			System.out.println("only " + useLimit + " mass can be subsitude with this philisopher stone.");
		}
		
		return true;
	}
	
	public boolean canUse() {
		return this.isUsable;
	}
			
	public double getUseLimit() {
		return useLimit;
	}
	public void setUseLimit(double useLimit) {
		this.useLimit = useLimit;
	}

	
}
