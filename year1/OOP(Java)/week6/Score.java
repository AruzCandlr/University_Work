
// File: Score.java
// Description: <DESCRIPTION>
// Lab: 6
// Task: 1

// ID: 6588108 
// Name: Arus Thienmee
// Section: 3
// Grader: Doungnapt
// On my honor, Arus Thienmee, this project assignment is my own work
// and I have not provided this code to any other students.
/*
* This class stores scores and provide calibrated average about the scores from 6 judges. 
* This class will be used as a part of the Competitor class. 
*/
import java.util.Arrays;

public class Score {
	private double jumpScore;
	private double[] styleScore; 
	
	//The constructor should set all given attributes to 0.
	public Score() {
		
		this.jumpScore = 0;
		this.styleScore = null;
	}
	
	//This method set the jumpScore to the given score
	public void setScores(double score) {
		
		this.jumpScore = score;
	}
	
	//This method set the styleScore to the given score
	public void setScores(double[] scores) {
		this.styleScore =  scores;
		
	}
	
	//This method return the jumpScore
	public double getJumpScores() {
		
		return jumpScore;
	}
	
	//This method return the styleScore
	public double[] getStyleScore() {
		
		return styleScore;
	}
	
   /*
    * Return the average of the scores after excluding the minimum and maximum
    * value. In short, it should return 
    *   (SUM(this.scores) - MIN(this.scores) - MAX(this.scores))/(n-2), where
    * n is the length of the score list. 
    */
	public double getCalibratedAverage() {
		
		
		
		Arrays.sort(styleScore);                       
		return (Arrays.stream(styleScore).sum()-styleScore[0]-styleScore[styleScore.length-1])/(styleScore.length-2); 
	}
	
	//This main is for testing your output
	public static void main(String[] args) { 
		Score s1 = new Score();
		s1.setScores(9.5);
		s1.setScores(new double[] {5.5, 4.5, 3.5, 2.5, 1.5, 6.5});
		System.out.println(s1.getJumpScores());
		Arrays.sort(s1.styleScore);   
		System.out.println(Arrays.toString(s1.getStyleScore()));
		System.out.println(s1.getCalibratedAverage());
	}
}
