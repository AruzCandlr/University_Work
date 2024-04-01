

/**
 * DO NOT MODIFY THIS CLASS
 * @author MUICT
 *
 */
public class Audio {
	protected String title;		// audio's title	
	protected double duration;	// audio's duration in minute e.g., 3.14 = 3 minutes and 14 seconds
	
	public Audio(String title, double duration) {
		this.title = title;
		this.duration = duration;
	}
	
	// getTitle() to get audio's title
	public String getTitle() {
		return this.title;
	}
	
	// getDuration() to get audio's duration
	public double getDuration() {
		return this.duration;
	}
	
	// getDuration() in second
	public int getDurationSec() {
		return (int) (((int) duration * 60) + ((duration * 100) % 100));
	}
		
	// setTitle(String t) to set audio's title
	public void setTitle(String t) {
		this.title = t;
	}
	
	// setDuration(double d) to set audio's duration
	public void setDuration(double d) {
		this.duration = d;
	}
	
	// setDuration(int sec) to set audio's duration in second
	public void setDuration(int sec) {
		this.duration = (int)(sec/60) + (sec%60)/100.0;
	}
	
	
	// toString() method to return value of this audio
	public String toString() {
		return this.getClass().toString() + "->" + this.title + " (" + String.format("%.2f", this.duration) +")";
	}
}
