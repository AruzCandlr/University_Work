// File: Podcast.java
// Description: <DESCRIPTION>
// Lab: 7
//
// ID: 6588108 
// Name: Arus Thienmee
// Section: 3
// Grader: 
// On my honor, Arus Thienmee, this project assignment is my own work
// and I have not provided this code to any other students.


public class Podcast extends Audio {

	private String showName;
	private int epNum;
	
	public Podcast(String title, double duration, String showName, int epNum) {
		super(title, duration);
		
//		this.title = title;
//		this.duration = duration;
		this.showName = showName;
		this.epNum = epNum;
	}

	String getShowName(){
		return showName;
	}
	
	int getEpNum() {
		return epNum;
	}
	

	
	public String toString() {
		//<TITLE> (<DURATION>), Show - <SHOWNAME> ep.<EPNUM>
		return super.toString() + " Show - " + getShowName() + " ep."+getEpNum();
	}
}
