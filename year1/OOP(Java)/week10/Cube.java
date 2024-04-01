
public class Cube extends Object3D {

	private double edge;
	public Cube(String _name, Material _matType, double _edge) {
		super(_name,_matType);
		//i just want it to look a bit weirder lol
		this.setEdge(_edge);
	}
	
	public double getEdge() {
		return edge;
	}

	public void setEdge(double edge) {
		this.edge = edge;
	}
	
	@Override
	public double getVolume() {
		return Math.pow(edge, 3);
	}

	@Override
	public double getSurface() {
		return 6 * Math.pow(edge, 2);
	}

	

}
