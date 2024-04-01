
public class WaxDie extends Cube implements Meltable, Comparable<Object3D> {

	public WaxDie(String _name, double _edge) {
		super(_name, Object3D.Material.Wax, _edge);
	}

	@Override
	public Object3D convertToOtherShape() {
		double _radius = Math.cbrt(((this.getVolume()*3)/4)/PI);	
		return new Sphere(this.getName(),this.getMaterial(),_radius);
	}

	@Override
	public int compareTo(Object3D o) {
		if(this.getVolume() >  o.getVolume()) {
			return 999;
		}
		if(this.getVolume() <  o.getVolume()) {
			return -999;
		}
			
		return this.getName().compareTo(o.getName());		
	}
	
	
}
