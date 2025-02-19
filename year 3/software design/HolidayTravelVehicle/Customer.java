import java.util.ArrayList;

public class Customer {

	public int cID;
	private String cName;
	private String cAddr;
	private String cPhone;
	/**
	 * @param cID
	 * @param cName
	 * @param cAddr
	 * @param cPhone
	 */
	public Customer(int cID, String cName, String cAddr, String cPhone) {
		super();
		this.cID = cID;
		this.cName = cName;
		this.cAddr = cAddr;
		this.cPhone = cPhone;
	}
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcAddr() {
		return cAddr;
	}
	public void setcAddr(String cAddr) {
		this.cAddr = cAddr;
	}
	public String getcPhone() {
		return cPhone;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	
	public void BuyVehicle() {
		//buy vehicle
	}
	
	public ArrayList<Vehicle> viewVehicle(){
		return null;
		//return list of all vehicles
	}
	
	public Invoice viewInvoice (int InvoiceNum) {
		return null;
		// look up the invoice by inputting invoice number
	}
	
}	
