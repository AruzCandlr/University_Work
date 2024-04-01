
public class AlchemistTester {

	
	public static void main(String[]args) {
	
		
		MatAlchemy soap = new MatAlchemy("soap",Object3D.Material.Soap,1200);
		System.out.println(soap);
		Alchemist Ed = new Alchemist("Edward Elric");
		System.out.println(Ed);
		Ed.equipPhilosopherStone("Nigredo");
		soap = Ed.transmutation(soap, Object3D.Material.Gold , 50);
		System.out.println(soap);
		
	}

}
