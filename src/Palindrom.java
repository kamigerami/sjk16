import java.util.Scanner;

public class Palindrom {
  
	public static void main(String[] args) {
	 
	  // Kolla om inmatat ord/mening är samma baklänges (t.ex. “naturrutan”, “ni talar bra latin”)
		
		// improvements - case insensitivity
		// shorten by using reverse comparing instead
		
	  Scanner input = new Scanner(System.in);
	  System.out.println("Input a Palindrom: ");
	  // convert to string so we can get each char
	  String stringput = input.nextLine();
	  // close Scanner
	  input.close();
	  int length = stringput.length();
      for(int i = 0; i<length-1; i++) {
    	  // compare first and last character to each other.
    	  if(stringput.charAt(i) !=  stringput.charAt(length-1)) {
    		System.out.println(stringput + " " + "is not a Palindrom");
            System.exit(0);
    	  }
    	  length--;
      }
	  System.out.println(stringput + " " + "is a Palindrom");
  }
	
	
}
