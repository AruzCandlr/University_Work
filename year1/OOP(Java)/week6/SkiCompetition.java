// File: Competitor.java
// Description: <DESCRIPTION>
// Lab: 6
// Task: 3

// ID: 6588108 
// Name: Arus Thienmee
// Section: 3
// Grader: Doungnapt
// On my honor, Arus Thienmee, this project assignment is my own work
// and I have not provided this code to any other students.

import java.util.*;


public class SkiCompetition {
	
	private List<Competitor> competitors = new ArrayList<>();
	
	@SuppressWarnings("unused")
	private double w1;
	
	@SuppressWarnings("unused")
	private double w2;
	
	public SkiCompetition(double w1, double w2) {
		this.w1 = w1;
		this.w2 = w2;
	}
	
	public SkiCompetition() {
		this(0.5,0.5);
	}
	
   /*
    * Return the List of top 3 highest (final) score competitors for the given round
    * [Be careful] To get gold medal, you have to be in top 3 and also has a final score above 8.0   
    */
	
	public List<Competitor> getGoldMedal(List<Competitor> competitors, int round){
		
		
		List<Competitor> goldM = new ArrayList<>();
		
		for(int i = 0; i < competitors.size(); i++) {
			if(competitors.get(i).getFinalScore(round) > 8.0) {
				goldM.add(competitors.get(i));
			}
		}
		for(int i=0; i<goldM.size(); i++){
			for(int j=1; j<goldM.size(); j++) {
				Competitor temp;
					if(goldM.get(j).getFinalScore(round) > goldM.get(j-1).getFinalScore(round)) {
						temp = goldM.get(j);
						goldM.set(j, goldM.get(j-1));
						goldM.set(j-1,temp); 
					}
			}
		}
		while(goldM.size()>3) {
			goldM.remove(goldM.size()-1);
		
		}
		
	
		
		
        return goldM;
	}
	
    public void addCompetitor(Competitor c) {
    	if(!competitors.contains(c))
    		competitors.add(c);
    }
	
	
	public static void main(String[] args) {
		SkiCompetition season1 = new SkiCompetition();
		season1.addCompetitor(new Competitor(0.5,0.5));
		season1.addCompetitor(new Competitor(0.5,0.5));
		season1.addCompetitor(new Competitor(0.5,0.5));
		season1.addCompetitor(new Competitor(0.5,0.5));
		
		season1.competitors.get(0).setProfile("Brian", "Xavia", "American", 33);
		season1.competitors.get(0).setScore(45.0, new double[]{7.0,8.5,9.0,9.5,9.7,8.5}); //Round 1
		season1.competitors.get(0).setScore(18.0, new double[]{8.0,8.5,9.0,7.5,6.7,8.0}); //Round 2
		
		season1.competitors.get(1).setProfile("Albert", "Wattana", "French", 44);
		season1.competitors.get(1).setScore(46.5, new double[]{7.0,7.5,7.0,7.5,7.5,7.0}); //Round1
		season1.competitors.get(1).setScore(17.0, new double[]{8.0,8.5,9.0,9.5,9.5,10.0});//Round2
		
		season1.competitors.get(2).setProfile("Maja", "Luvinia", "Polish", 34);
		season1.competitors.get(2).setScore(45.3, new double[]{10.0,5.5,10.0,9.5,8.5,10.0}); //Round1
		season1.competitors.get(2).setScore(16.9, new double[]{9.0,9.5,9.0,8.5,10,9.5});	 //Round2
		
		season1.competitors.get(3).setProfile("Joby", "Beckett", "Australia", 21);
		season1.competitors.get(3).setScore(47.1, new double[]{6.0,8.0,9.5,8.5,9.5,8.5});	//Round1
		season1.competitors.get(3).setScore(37.8, new double[]{10.0,8.5,8.3,8.2,6.7,9.3});	//Round2
		
		System.out.println("[Round1]");
		System.out.println("== Scores Board ==");
		for(Competitor e : season1.competitors) {
			e.showProfile();
			System.out.format(" | Final Score: %.2f", e.getFinalScore(1));
			System.out.println("\n-----------------");
		}
		
		
		System.out.println("\n== List of Gold Medal ==");
		for(Competitor e : season1.getGoldMedal(season1.competitors, 1)){
			e.showProfile();
			System.out.format(" | Final Score: %.2f", e.getFinalScore(1));
			System.out.println("\n-----------------");
		}
		
		System.out.println("\n=================================");
		System.out.println("[Round2]");
		System.out.println("== Scores Board ==");
		for(Competitor e : season1.competitors) {
			e.showProfile();
			System.out.format(" | Final Score: %.2f", e.getFinalScore(2));
			System.out.println("\n-----------------");
		}
		
		
		System.out.println("\n== List of Gold Medal ==");
		for(Competitor e : season1.getGoldMedal(season1.competitors, 2)){
			e.showProfile();
			System.out.format(" | Final Score: %.2f", e.getFinalScore(2));
			System.out.println("\n-----------------");
		}
	}

}
