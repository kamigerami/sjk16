
public class FizzBuzz {

	public static void main(String[] args) {
		/*
		 * Skriv ett program som skriver ut varje tal mellan 1-100. 
		 * Men om talet innehåller en 3a skriva Fizz, 
		 * om det innehåller en 5a skriv Buzz. 
		 * Vill man göra det ännu svårare se till att programmet skriver ut 33 som FizzFizz, 
		 * 35 som FizzBuzz, 
		 * 53 som BuzzFizz, 
		 * 55 som BuzzBuzz.
		 * 
		 */		
         
		 for(int i = 0; i <= 100; i++) {
			 if (i == 33) {
				 System.out.println("FizzFizz");
			 } else if (i == 35) {
				 System.out.println("FizzBuzz");
			 } else if (i == 53 ) {
				 System.out.println("BuzzFizz");
			 } else if (i == 55) {
				 System.out.println("BuzzBuzz");
			 } else if(Integer.toString(i).contains("3")) {
				 System.out.println("Fizz");
			 } else if(Integer.toString(i).contains("5")) {
				 System.out.println("Buzz");
			 } else {
				 System.out.println(i);
			 }
		 }
	}

}
