import java.util.Scanner;

public class PersonNummer {

	  static String pnumb;
	  static String lastFour;
	  static String day;
	  static String month;
	  static String year;
	  static String century;
	  static Boolean failure = false;
	  static int[] pnum_controll = new int[9];
	  static int tot;
	  
	public static void main(String[] args) {
		/*
	  Kontrollera om inmatad sträng är ett giltigt personnummer (rätt antal tecken, giltigt födelsedatum och kontrollsiffra)
	  De nio första siffrorna i personnumret multipliceras växelvis med 2 och 1.
      En delsumma som är på fler än två siffror, exempelvis 14, betraktas som två delsummor på 1 respektive 4.
      Addera sedan alla delsummor till en totalsumma.
      Beräkna differensen mellan totalsumman och det tiotal som är närmast ovanför totalsumman. Görs enklast med modulo 10 vars innebörd inte kommer förklaras närmare här.
      Differensen, eller resten från beräkningen med modulo 10, ska vara samma som den tionde siffran, kontrollsiffran, i personnumret. Om så är fallet, är det ett giltigt personnummer.	
	 */

	  Scanner input = new Scanner(System.in);
	  System.out.println("Input a personnummer: ");
	  String stringput = input.nextLine();
	  input.close();

	  // remove whitespace and non visible characters
	  stringput = stringput.replaceAll("\\s+","");

	  // clean up the input and convert to digits
	  if (stringput.contains("-")) {
		  // create pnumb without dash
		  pnumb = removeDash(stringput);
		  // extract lastFour digits
		  lastFour = getLastFour(stringput);
		  pnumb = pnumb + lastFour;
	  } else { 
		  pnumb = stringput;
		  lastFour = stringput.substring(stringput.length()-4,stringput.length());
	  }

	  // 10 or 12
      if (pnumb.length() == 10) { 
    	  year = pnumb.substring(0,2);
    	  month = pnumb.substring(2, 4);
    	  day   = pnumb.substring(4,6);
      } else {
    	  century = pnumb.substring(0,2);
    	  year = pnumb.substring(2,4);
    	  month = pnumb.substring(4, 6);
    	  day   = pnumb.substring(6,8);
      }
	  
	  
      doValidate(failure);
      
	} // end of main
	

	public static void doValidate(Boolean failure) {
		
		  // validate total length of pnumb
		  if (pnumb.length() < 10 || pnumb.length() > 12) {
			  System.out.println("Length of : " + pnumb + " (" + pnumb.length() + ")" + "is too long. Must be between 10 and 12");
			  failure = true;
		  }
		  //if(pnumb.length())
		  // validate month
		  if(Integer.parseInt(month) < 01 || Integer.parseInt(month) > 12) { 
			  System.out.println("Month is not a correct value: " + month + " needs to be between 01 - 12");
			  failure = true;
		  }
		  // validate day
		  if(Integer.parseInt(day) < 01 || Integer.parseInt(day) > 31) { 
			  System.out.println("Day is not a correct value: " + day + " needs to be between 01 - 31");
			  failure = true;
		  }
		  
		  if(failure) { 
			  System.out.println("Some of the values were not correct");
			  System.exit(1);
			} else { 
		  // validate controll number
		  
		  // loop through last 9
		  // multiply by 2 and 1 each time
		  // split answer if more than 1 character
		  // save answer to array of int
		  // add each int in array together
		  // modulu 10%
		  // compare lastFour digit to the answer

		  
		  for(int i = 0; i < 9; i++) { 
			  // first 9 of dob
			  String dob = year + month + day + lastFour.substring(0,3);
			  pnum_controll[i] = Integer.parseInt(String.valueOf(dob.charAt(i)));
		  }
		  for(int i = 0; i <= pnum_controll.length-1; i+=2) { 
			  // 0 2 4 6 8
			  // 8 0 2 6 7
		
			  int res = pnum_controll[i] * 2;
	//		  System.out.println(pnum_controll[i] + "*2");
			  if(res > 10){
	//			  System.out.println(res);
	//			  System.out.println(" 1 " + " + " + (res%10));
				  tot += 1 + (res%10);
	//			  System.out.println("res is : " + res + " tot is : " + tot);
			  } else {
	//			  System.out.println(res);
				  tot += res;
	//			  System.out.println("res is : " + res + " tot is : " + tot);
			  }
		  }
		  for(int x = 1; x < pnum_controll.length-1; x+=2) {
				// 1 3 5 7 9
				// 5 1 9 5
			  int res = pnum_controll[x] * 1;
	//		  System.out.println(pnum_controll[x] + "*1");
			  tot += res;
	//		  System.out.println("res is : " + res + " tot is : " + tot);
		  }
		  int controll_numb = 10-(tot%10);
		 System.out.println("controll number is : " + controll_numb);
		 int last = Integer.parseInt(lastFour.substring(3));
		 if(controll_numb == last) {
			 System.out.println(year + month + day + "-" + lastFour + " is a valid personnummer");
			 System.out.println("Controllernumber : " + last + " matches " + lastFour.substring(0,3) + "(" + lastFour.substring(3) + ")");
		 } else {
			 System.out.println(pnumb + " is not a valid personnummer");
		 }
		 
		}
		
	}
	
	// assumes dash
	private static String removeDash(String number) {
			  // get index of char before dash
		      int last_index = number.indexOf("-");
		      
			  String pnumb = number.substring(0, last_index);
		      return pnumb;
	}
	
	// assumes dash
	private static String getLastFour(String number) { 
		      // get last 4 control digits
		      String lastFour;
			  // get it's index
			  int index_of_dash = number.indexOf('-');
			  lastFour = number.substring(index_of_dash+1,number.length());
		      return lastFour;
	}

}
