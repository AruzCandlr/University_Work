import java.util.ArrayList;
import java.util.List;

public class Admin {

	public static List<Vehicle> vlist;
	public int emID;
	public String sName;
	public String sAddr;
	/**
	 * @param emID
	 * @param sName
	 * @param sAddr
	 */
	public Admin(int emID, String sName, String sAddr) {
	
		vlist = new ArrayList<Vehicle>();
		this.emID = emID;
		this.sName = sName;
		this.sAddr = sAddr;
	}
	public void addVehicle(Vehicle a) {
		//add vehicle
		vlist.add(a);
		
	}
	public ArrayList<Vehicle> adminSideViewVehicle(){
		return null; // return vehicle by admin side
	}
	public int getEmID() {
		return emID;
	}
	public void setEmID(int emID) {
		this.emID = emID;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsAddr() {
		return sAddr;
	}
	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}
	public static void main (String[] args) {
		
		Vehicle x = new Vehicle(20, "testv1", "car", 100, "test info", false);
		Admin a = new Admin( 1,"Arus","lets assume that this string is an address" );
		a.addVehicle(x);
		
		
		System.out.println("Show vehicle list:");
		
		for(Vehicle i : vlist) {
			System.out.println(i);
		}
	}
	
}
