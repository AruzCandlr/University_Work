import java.util.Date;

public class Invoice {
public int invoID;
private int vehID;
private double price;
private Date payTime;
boolean haveTurnin;
/**
 * @param invoID
 * @param vehID
 * @param price
 * @param payTime
 * @param haveTurnin
 */
public Invoice(int invoID, int vehID, double price, Date payTime, boolean haveTurnin) {
	super();
	this.invoID = invoID;
	this.vehID = vehID;
	this.price = price;
	this.payTime = payTime;
	this.haveTurnin = haveTurnin;
}
public int getInvoID() {
	return invoID;
}
public void setInvoID(int invoID) {
	this.invoID = invoID;
}
public int getVehID() {
	return vehID;
}
public void setVehID(int vehID) {
	this.vehID = vehID;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Date getPayTime() {
	return payTime;
}
public void setPayTime(Date payTime) {
	this.payTime = payTime;
}
public boolean isHaveTurnin() {
	return haveTurnin;
}
public void setHaveTurnin(boolean haveTurnin) {
	this.haveTurnin = haveTurnin;
}


}
