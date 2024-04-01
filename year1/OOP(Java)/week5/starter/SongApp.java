public class SongApp {
	public static void main(String[] args) {
		Playlist myPlaylist = new Playlist("My Favorite Songs Playlist");
		
		System.out.println("Welcome to SongAPP");
		System.out.println("\nAdd songs --------------------------");
		myPlaylist.addSong(new Song("Perfect", 4.21));
		myPlaylist.addSong(new Song("How long", 3.30));
		myPlaylist.addSongAtIndex(new Song("End Game", 4.11), 0);
		myPlaylist.addSongAtIndex(new Song("Anywhere", 3.35), 2);
		myPlaylist.showPlaylist();
	
		System.out.println("\nRemove songs -----------------------");
		myPlaylist.removeSongByTitle("End Game");
		myPlaylist.removeSongByIndex(2);
		myPlaylist.showPlaylist();
		
		System.out.println("\nCheck error ------------------------");
		System.out.print("Add duplicate song: ");
		myPlaylist.addSong(new Song("Perfect", 3.38));
		
		System.out.print("Add song at invalid index (at most index now is 2): ");
		myPlaylist.addSongAtIndex(new Song("Find you", 3.38), 3);
		System.out.print("Remove not found song: ");
		myPlaylist.removeSongByTitle("Find you");
		System.out.print("Remove song at invalid index: ");
		myPlaylist.removeSongByIndex(3);
		
		
		// Uncomment these for bonus
//		System.out.println("\n**************** BONUS ***************");
//		Playlist bonus = new Playlist("Bonus Playlist");
//		bonus.addSong(new Song("Perfect", 4.21));
//		bonus.addSong(new Song("How long", 3.30));
//		bonus.addSongAtIndex(new Song("End Game", 4.11), 0);
//		bonus.addSongAtIndex(new Song("Anywhere", 3.35), 2);
//		bonus.showPlaylist();
//		
//		System.out.println("\nRearrange songs ---------------------");
//		bonus.moveUp(1);
//		bonus.moveDown(2);
//		bonus.showPlaylist();
	}
	
}
