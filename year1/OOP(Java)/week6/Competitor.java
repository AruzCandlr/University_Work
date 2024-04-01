// File: Competitor.java
// Description: <DESCRIPTION>
// Lab: 6
// Task: 2

// ID: 6588108 
// Name: Arus Thienmee
// Section: 3
// Grader: Doungnapt
// On my honor, Arus Thienmee, this project assignment is my own work
// and I have not provided this code to any other students.

import java.util.*;

public class Competitor {
	
	private String fname, lname, nationality;
	private int age;
	private List<Score> score;
	private double w1, w2;
	private final int maxKpoint = 50;
	
	public Competitor(double w1, double w2) {
		fname = lname = nationality = "";
		age = 0;
		score = new ArrayList<>();
		this.w1 = w1;  this.w2 = w2;
	}
	
	//Set all attributes to the given parameters.
	public void setProfile(String fname, String lname, String nationality, int age)
	{
		
		this.fname = fname;
		this.lname = lname;
		this.nationality = nationality;
		this.age = age;
	}
	
	// Add jScore and sScore to the list of score
	// The first score will represent the round1 score for the competitor
	public void setScore(double jScore, double[] sScore) {
	
		Score entry = new Score();
		double jscoreForReal = (jScore/maxKpoint)*10;
		entry.setScores(jscoreForReal);
		entry.setScores(sScore);
		score.add(entry);
	}
	
	public void showProfile() {
		System.out.print("Name: "+this.fname+" "+this.lname+", Age:"+this.age+", Nationality:"+this.nationality);
	}
	
	// Display all raw score both (1) jump length and (2) Aerial Style from the given input round
	// [be careful] The input round must start from 1 not 0.
	// The format is present in Lab06 sheet
	public void showRawScore(int round) {
		
		System.out.println("Jumping score: " + getJScore(round));
		double[] aerial = score.get(round-1).getStyleScore();
		System.out.print("Aerial style (Raw) score: ");
		for(int i = 0; i < aerial.length; i++) {
			System.out.print("|"+aerial[i]);
		}
		System.out.print("|");
	}
	
	
   /*
    * Return the Jump Score (JScore) for the given round
	*  JScore = (jump length/maxKpoint)*10
    */
	public double getJScore(int round) {
		
		return score.get(round-1).getJumpScores();
	}
	
   /*
    * Return the final score (FScore) for the given round
    * jScpre comes from getJSCore (Score.java)
    * sScore comes from getCalibratedAverage (Score.java)
    * FScore = jScore*w1 + sScore*w2
    */
	public double getFinalScore(int round) {
		
		return getJScore(round)*w1 + score.get(round-1).getCalibratedAverage()*w2;
	}
	
	//This main is for testing your output
	public static void main(String[] args) {
		Competitor c1 = new Competitor(0.5, 0.5);
		Competitor c2 = new Competitor(0.2, 0.8);
		
		c1.setProfile("Somechai", "Jaidee", "Thai", 33);
		c2.setProfile("Brain", "Toss", "British", 35);
		
		System.out.println("===============================");
		//Competitor 1
		c1.setScore(45, new double[]{8.0,8.5,9.0,7.5,6.7,8.0});  //Round1
		c1.setScore(49, new double[]{10.0,8.5,9.0,7.5,6.7,8.0}); //Round2
		
		c1.showProfile();
		System.out.println("\n[Round1]");
		c1.showRawScore(1);
		System.out.format("\nFinal score: %.2f",c1.getFinalScore(1));
		
		System.out.println("\n[Round2]");
		c1.showRawScore(2);
		System.out.format("\nFinal score: %.2f",c1.getFinalScore(2));
		
		System.out.println("\n===============================");
		
		//Competitor 2
		c2.setScore(37, new double[]{9.0,9.5,9.0,7.5,8.7,8.0});  //Round1
		c2.setScore(48, new double[]{9.3,8.5,9.5,8.5,7.7,8.0}); //Round2
		
		c2.showProfile();
		System.out.println("\n[Round1]");
		c2.showRawScore(1);
		System.out.format("\nFinal score: %.2f",c2.getFinalScore(1));
		
		System.out.println("\n[Round2]");
		c2.showRawScore(2);
		System.out.format("\nFinal score: %.2f",c2.getFinalScore(2));
		
			
	}
	
	
}
