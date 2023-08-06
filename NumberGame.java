package codsoft;
import java.util.Scanner;
import java.util.Random;
public class NumberGame {
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Number Guessing Game :) \nA random number will be generated between 1 to 100 \nYou'll get 5 attempts to guess the correct answer \n");
		Scanner s = new Scanner(System.in);
		Random random = new Random();
		int generatedNum = random.nextInt(1, 101);
		int totalAttempts = 5;
		int score = 0; 
		boolean numFound = false;
			
		 while(!numFound && totalAttempts > 0) {
				System.out.println("Enter your guess: ");
				int guess = s.nextInt();
				
				if(guess == generatedNum) {
					numFound = true;
					System.out.println("Congrats! You found the correct answer ");
					score += 1;
					break;
				}
				else if(guess > generatedNum) {
					System.out.println("Too high! Try a lower number");
					totalAttempts--;
				}
				else {
					System.out.println("Too low! Try a higher number");
					totalAttempts--;
				}
				if(totalAttempts == 0) {
				System.out.println("\nYou exhausted all your attempts");
				System.out.println("The correct number is " + generatedNum);
				System.out.println("Your score is " + score);
				break ;
				}
		}
		s.close();
	}
}
