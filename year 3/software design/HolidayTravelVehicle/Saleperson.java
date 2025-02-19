
public class Saleperson {

	public int emID;
	public String sName;
	public String sAddr;
	/**
	 * @param emID
	 * @param sName
	 * @param sAddr
	 */
	public Saleperson(int emID, String sName, String sAddr) {
	
		this.emID = emID;
		this.sName = sName;
		this.sAddr = sAddr;
	}
	public Invoice CreateInvoice() {
		return new Invoice(emID, emID, emID, null, false);
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
	
}
