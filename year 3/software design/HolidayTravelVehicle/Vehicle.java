import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	
	public int vehID;
	public String vName;
	public String vType; // could be enum
	public double basePrice;
	public String vInfo;
	private boolean isTurnedIn;
	

	/**
	 * @param vlist
	 * @param vehID
	 * @param vName
	 * @param vType
	 * @param basePrice
	 * @param vInfo
	 * @param isTurnedIn
	 */
	public Vehicle( int vehID, String vName, String vType, double basePrice, String vInfo, boolean isTurnedIn) {
		
		
		this.vehID = vehID;
		this.vName = vName;
		this.vType = vType;
		this.basePrice = basePrice;
		this.vInfo = vInfo;
		this.isTurnedIn = isTurnedIn;
		
	}
	
	public int getVehID() {
		return vehID;
	}
	public void setVehID(int vehID) {
		this.vehID = vehID;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvType() {
		return vType;
	}
	public void setvType(String vType) {
		this.vType = vType;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public String getvInfo() {
		return vInfo;
	}
	public void setvInfo(String vInfo) {
		this.vInfo = vInfo;
	}
	public boolean isTurnedIn() {
		return isTurnedIn;
	}
	public void setTurnedIn(boolean isTurnedIn) {
		this.isTurnedIn = isTurnedIn;
	}
	
	public String toString() {
		return  vehID + " "+ vName + " "+ vType +" "+basePrice +" "+ vInfo;
		
	}
	
}
