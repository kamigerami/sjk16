import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// A leap year is divisable by 4, but not by 100 (except if divisable by 400.)

		Scanner input = new Scanner(System.in);
		System.out.println("Input year : ");
		Integer intput = input.nextInt();
		input.close();
		if ( ((intput % 4) == 0 ) && ( (intput % 100) != 0) || (intput % 400) == 0) {
	      System.out.println(intput + " " + "is a leap year");
		} else {
			System.out.println(intput + " " + "is not a leap year");
		}
	}
}
