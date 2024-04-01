

/**
 * Complete this class by add your code in the // YOUR CODE HERE comment
 * @author MUICT
 *
 */

// File: Playlist.java
// Description: <DESCRIPTION>
// Lab: 7
//
// ID: 6588108 
// Name: Arus Thienmee
// Section: 3
// Grader: 
// On my honor, Arus Thienmee, this project assignment is my own work
// and I have not provided this code to any other students.


import java.util.ArrayList;

public class Playlist {
	
	// ********************** DO NOT MODIFY THIS PART *******************************************
	private String name;
	private ArrayList<Audio> list;
	
	public Playlist(String name) {
		this.name = name;
		this.list = new ArrayList<Audio>();
	}
	
	//to calculate total duration and return the value of total duration in second
	public int calTotalDuration() {
		int total = 0;
		for(Audio a: list) {
			total += a.getDurationSec();
		}
		return total;
	} 	
	
	//  to print the playlist on the console in the following format
	public void showPlaylist() {
		System.out.println(name);
		for(int i = 0; i < list.size(); i++) {
			System.out.println("[" + i + "] " + list.get(i).toString());
		}
	}
	
	// to check whether the audio is already in the playlist or not
	public boolean isDuplicate(Audio audio) {
		for(Audio a: list) {
			if(a.getTitle() == audio.getTitle()) {
				return true;
			}
		}
		return false;
	}
	
	// to add a new audio into the playlist 
	public boolean addAudio(Audio audio) {
		if(isDuplicate(audio)) {
			System.out.println( audio.getTitle() + " already in the playlist.");
			return false;
		}
		list.add(audio);
		return true;
	}
	
	// to add a new audio into the playlist at a given position (Note that the index in the playlist starts at ‘0’).
	public void addAudioAtIndex(Audio audio, int index) {
		if(index >= list.size() || index < 0) {
			System.out.println("Invalid Index");
		} else if(isDuplicate(audio)){
			System.out.println( audio.getTitle() + " already in the playlist.");
		}
		else {
			list.add(index, audio);
		}
	}
		
		
	// END OF DO NOT MODIFY *****************************************************************************************************
	
		
	
	public int getNumSongs() {
		// YOUR CODE HERE
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Song) {
				count++;
			}
		}
		return count;
		// ------------------------------------
	}
	
	
	public int getNumPodcasts() {
		// YOUR CODE HERE
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Podcast) {
				count++;
			}
		}
		return count;
		// ------------------------------------
	}
	
	
	public void increaseDuration(int i, int sec) {
		// YOUR CODE HERE
		int x = sec; 
		int y = list.get(i).getDurationSec();
		list.get(i).setDuration( x + y );
	}
	
	
	// *********** BONUS *******************************************
	// BONUS: to return all songs in the playlist, if there is no song in the list return empty list
	
	public ArrayList<Song> getSongOnly(){
		// YOUR CODE HERE
		ArrayList<Song> song = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Song) {
				song.add((Song)list.get(i));
			}
		}
		return song;
		// ------------------------------------
	}
	
	
	// BONUS: to return all podcasts in the playlist, if there is no podcast in the list return empty list
	public ArrayList<Podcast> getPodcastOnly(){
		// YOUR CODE HERE
		ArrayList<Podcast> podcast = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Podcast) {
				podcast.add((Podcast)list.get(i));
			}
		}
		return podcast;
		// ------------------------------------
	}
	
	// BONUS: to remove audio of specific class from the playlist according to the input parameter 1: Audio, 2: Song, and 3: Podcast
	// Note that Song and Podcast are considered as Audio. So, if number 1 is given, all the audio in the list will be removed.
	// and return number of removed items
	// YOUR CODE HERE
	public int removeAudio(int opt) {
		// YOUR CODE HERE
		int a = list.size();
		int b = getNumSongs();
		int c = getNumPodcasts();
		switch(opt){
		case 1:
			//removing all audio aka all of this
			list.removeAll(list);
			return a;
		case 2 :
			//removing all songs
			list.removeAll(getSongOnly());
			return b;
			
		case 3 :
			//removing all podcasts
			list.removeAll(getPodcastOnly());
			return c;
			
		}
		
		return -1;
		// ------------------------------------
		
	}
}
