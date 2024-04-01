import java.util.ArrayList;

public class SortingMovie {

	public static void main(String[] args) {
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		movieList.add(new Movie(1, "The Intern", 2009));
		movieList.add(new Movie(2, "The Gift", 2009));
		movieList.add(new Movie(3, "The Lost Room", 2009));
		movieList.add(new Movie(4, "The Gift", 2012));
		movieList.add(new Movie(5, "Pasolini", 2012));
		movieList.add(new Movie(6, "The Intern", 2009));
		movieList.add(new Movie(7, "American Ultra", 2019));
		movieList.add(new Movie(8, "Sweet Red Bean Paste", 2019));
		
		sort(movieList);
	}
	
	public static void sort (ArrayList<Movie>  movies) {
		// YOUR CODE GOES HERE
		System.out.println("old1");
		for(Movie i : movies) {
			System.out.println(i);
		}
		
		for(int i=0; i<movies.size(); i++){
			for(int j=1; j<movies.size(); j++) {
													
					if(	movies.get(j).compareTo(movies.get(j-1)) < 0) {
						Movie temp = movies.get(j);
						movies.set(j, movies.get(j-1));
						movies.set(j-1,temp); 
				}
			}
		}
		System.out.println("new1");
		for(Movie i : movies) {
			System.out.println(i);
		}
		
	}

}
