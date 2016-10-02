import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	static int guess;
	static int numb_to_guess;
	static int Low = 1;
	static int High = 100;
	static int numb_of_guesses = 5;
	
	public static void main(String[] args) {
		/*
		 * Skriv ett litet spel som låter användaren gissa på vilket tal du valt mellan 1-100. 
		 * Användaren ska få fem gissningar. 
		 * Gissar användaren för högt ska det meddelas och gissar användaren för lågt ska det meddelas så användaren vet hur den ska gissa nästa gång. 
		 * Om användaren gissar rätt ska det meddelas och spelet avslutas.
		 */

	
		// create a number to guess
		createNumber();
		//System.out.println("number to guess is : " + numb_to_guess);
				
		for(int i = 0; i < numb_of_guesses; i++) {

			Scanner input = new Scanner(System.in);
			System.out.println("Guess a number between " + Low + " - " + High + " : ");
		    validate(input);

		  	if(guess > numb_to_guess) {
		  		System.out.println("Your guess is too high!");
		  	}else if (guess < numb_to_guess) {
		  		System.out.println("Your guess is too low!");
		  	} else {
		  		System.out.println("Congratulations! You guessed correct: " + numb_to_guess);
		  		System.exit(0);
		  	}
		} System.out.println("No more guesses left");
	}

	private static Integer createNumber() {
		Random r = new Random();
		numb_to_guess = r.nextInt(High-Low) + Low;
		return numb_to_guess;
	}
	
	private static void validate(Scanner input) {
	    if(input.hasNextInt()) { 
	    	guess = input.nextInt();
	    	//input.close();
	    } else {
	    	System.out.println("input is not a Integer  / valid value");
	    	System.exit(1);
	    }
	    if(guess < Low || guess > High) {
	    	System.out.println(guess + " is not between " + Low + " - " + High);
	    	System.exit(1);
	    }
	}
}
