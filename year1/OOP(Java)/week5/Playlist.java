package solution;

//File: Arus Thienmee
//Description: print the rectangle data(about coordinates,width and height)
//Assignment Number: 1
//
//ID: 6588108
//Name: Arus Thienmee
//Section: 3
//Grader: Prach
//
//On my honor, Arus Thienmee, this lab assignment is my own work
//and I have not provided this code to any other students.
import java.util.ArrayList;

public class Playlist {
	
	ArrayList<Song> list = new ArrayList<>();
	String lname = null;
	public Playlist(String name) {
		lname = name;
	}
	
	boolean addSong(Song song) {
		
		boolean check = true;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle() == song.getTitle()) {
				check = false;
			}
		}
		
		if(check) {
		list.add(song);	
		}
		else {
			System.out.println(song.getTitle() +" already in the playlist");
		}
		
		return check;
	}
	
	boolean addSongAtIndex(Song song, int index) {
		
		boolean check = true;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTitle() == song.getTitle()) {
				check = false;
			}
		}
		
		
		if(check) {
			if(index >= list.size()) {
				System.out.println("Invalid index");
			}
			else {
				list.add(index, song);
			}
		
		}
		
		return check;
	}
	
	boolean removeSongByIndex(int index) {
		if(index < 0 || index >= list.size()) {
			System.out.println("Invalid index");
			return false;
		}
		list.remove(index);
		return true;
	}
	
	Song removeSongByTitle(String title) {
		
		for(int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle()== title) {
				Song rec = list.get(i);
				list.remove(i);
				return rec;
			}
		}
		System.out.println("Not found.");
		return null;
	}
	
	double getPlaylistDuration() {
		double sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i).getDurationSec();
		}
		return sum/=60;
	}
	
	ArrayList<Song> getTooLongSongs (double minute){
		ArrayList<Song> TooLong = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getDuration() > minute ) {
				TooLong.add(list.get(i));
			}
		}
		return TooLong;
	}
	
	void showPlaylist() {
		System.out.println(lname);
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("[%d] %s (%.2f)\n",i,list.get(i).getTitle(), list.get(i).getDuration());
			}
	}
	
	void moveUp(int index) {
		Song temp = list.get(index);
		list.set(index, list.get(index-1));
		list.set(index-1, temp);
		
	}
	
	void moveDown(int index) {
		Song temp = list.get(index);
		list.set(index, list.get(index+1));
		list.set(index+1, temp);
		
	}
	
}
