

import java.util.ArrayList;

/**
 * DO NOT MODIFY THIS CLASS
 * @author MUICT
 *
 */

public class AudioApp {
	public static void main(String[] args) {
		Playlist myPlaylist = new Playlist("My Favorite Audios Playlist");
		
		System.out.println("Welcome to AudioAPP");
		
		// Adding general audio
		myPlaylist.addAudio(new Audio("Wave", 1.1));
		myPlaylist.addAudio(new Audio("Raining", 1.5));
		System.out.println("\n=== Playlist after adding two Audio objects ===");
		myPlaylist.showPlaylist();
		
		
		// Adding Song audio
		myPlaylist.addAudio(new Song("Perfect", 4.21, "Divide"));
		myPlaylist.addAudioAtIndex(new Song("End Game", 4.11, "Reputation"), 0);
		System.out.println("\n\n=== Playlist after adding two Song objects ===");
		myPlaylist.showPlaylist();
		
		
		// Adding Podcast audio
		myPlaylist.addAudio(new Podcast("A Survey of Data Science Methodologies", 25, "Data Skeptic", 102));
		myPlaylist.addAudioAtIndex(new Podcast("The Glorious Flamingo", 49, "Stuff You Should Know", 57 ), 1);
		System.out.println("\n\n=== Playlist after adding two Podcasts objects ===");
		myPlaylist.showPlaylist();
		
		
		// Count number of Song, and Podcast in the playlist
		System.out.println("Number of Songs: " + myPlaylist.getNumSongs());
		System.out.println("Number of Podcast: " + myPlaylist.getNumPodcasts());
		
		
		// Increase audio duration by 60 seconds
		int duration = myPlaylist.calTotalDuration();
		myPlaylist.increaseDuration(3, 60);
		System.out.println("\n\n=== Playlist after increase audio duration at index 3 by 60 seconds ===");
		myPlaylist.showPlaylist();
		System.out.println("Total Duration: before=" + duration + ", after=" + myPlaylist.calTotalDuration());
		System.out.println("\n*************** Congratulations! End of the lab assignment****************************\n");
		
		// BONUS 
		// Uncomment theis function to test your bonus
		testBonus(myPlaylist);
		
		
	}
	

	
	public static void testBonus(Playlist playlist) {
		
		System.out.println("**************** BONUS ********************************");
		ArrayList<Song> songs = playlist.getSongOnly();
		songs.get(0).setDuration(4.50);	// update the first song duration
		
		ArrayList<Podcast> podcasts = playlist.getPodcastOnly();
		podcasts.get(podcasts.size() - 1).setDuration(28.0); // update the last podcast duration
		System.out.println("\n=== Playlist after updating first song and last podcast duration");
		playlist.showPlaylist();
		
		// Modify current playlist
		int numRemovedSong = playlist.removeAudio(2);
		System.out.println("\n=== Playlist after removing " + numRemovedSong + " songs");
		playlist.showPlaylist();
		
		int numRemovedPodcast = playlist.removeAudio(3);
		System.out.println("\n=== Playlist after removing " + numRemovedPodcast + " podcasts");
		playlist.showPlaylist();
		
		playlist.addAudio(new Song("Find you", 3.38, "ABC"));
		int numRemovedAudiot = playlist.removeAudio(1);
		System.out.println("\n=== Playlist after adding a new song and removing " + numRemovedAudiot + " audios=");
		playlist.showPlaylist();
		
		int numError = playlist.removeAudio(0);
		if(numError == -1) {
			System.out.println("\nRemove Audio Error: Invalid option!");
		}
	}
	

	
}
