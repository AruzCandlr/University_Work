
public class Sphere extends Object3D {

	private double radius;
	public Sphere(String _name, Material _matType, double _radius) {
		super(_name,_matType);
		//i just want it to look a bit weirder lol
		this.setRadius(_radius);
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getVolume() {
		return (4*PI*Math.pow(radius, 3))/3;
	}

	@Override
	public double getSurface() {
		return  4*PI*Math.pow(radius, 2);
	}

	

}
