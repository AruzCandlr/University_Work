
public class Song {
	
	private String title;		// song's title	
	private double duration;	// song's duration in minute e.g., 3.14 = 3 minutes and 14 seconds
	
	
	public Song(String t, double d) {
		this.title = t;
		this.duration = d;
	}
	
	// getTitle() to get song's title
	public String getTitle() {
		return this.title;
	}
	
	// getDuration() to get song's duration
	public double getDuration() {
		return this.duration;
	}
	
	// getDuration in second
	public int getDurationSec() {
		return (int) (((int) duration * 60) + ((duration * 100) % 100));
	}
		
	// setTitle(String t) to set song's title
	public void setTitle(String t) {
		this.title = t;
	}
	
	// setDuration(double d) to set song's duration
	public void setDuration(double d) {
		this.duration = d;
	}
	
	// toString() method to return value of this song
	public String toString() {
		return this.title + " (" + String.format("%.2f", this.duration) +")";
	}
	
	
}
