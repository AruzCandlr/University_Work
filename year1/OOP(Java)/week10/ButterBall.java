
public class ButterBall extends Sphere implements Meltable, Comparable<Object3D> {

	public ButterBall(String _name, double _radius) {
		super(_name, Object3D.Material.Butter, _radius);
	}

	@Override
	public Object3D convertToOtherShape() {
		double _edge = Math.cbrt(this.getVolume());	
		return new Cube(this.getName(),this.getMaterial(),_edge);
	}

	@Override
	public int compareTo(Object3D o) {
		if(this.getSurface() >  o.getSurface()) {
			return 999;
		}
		if(this.getSurface() <  o.getSurface()) {
			return -999;
		}
		return  this.getName().compareTo(o.getName());
		
	}
	
	
}
