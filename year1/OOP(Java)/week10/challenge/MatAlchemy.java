
public class MatAlchemy extends Object3D {
	
	private double volume;
	public MatAlchemy(String name, Object3D.Material mat, double volume) {
		super(name,mat);
		this.volume = volume;
	}
	
	public void increaseVol(double x) {
		this.volume += x;
	}
	@Override
	public double getVolume() {
		return this.volume;
	}

	@Override
	public double getSurface() {
		//unnecessary for bonus so i gonna leave it there ;)
		return 0;
	}

	@Override
	public String toString() {
		return this.getName() + " type: " + this.getMaterial() + " have volume = " + this.getVolume();
	}
}
