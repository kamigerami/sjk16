import java.util.Scanner;

public class TreiRad {
	static Scanner input = new Scanner(System.in);
	static String[][] gameBoard = new String[3][3];
	static int numb_players;
	static String player1;
	static String player2;
	static int row;
	static int column;
	static String player_turn;
	static boolean full;
	static String brick;
	static int player1_score;
	static int player2_score;
	
	public static void main(String[] args) {
		// TODO - create computer player with automatic play
		// TODO - easily change game table
		
		MainMenu();
		Players();
		GameBoard();
	    Play();
	
	   input.close();
	
	}
	

	
	// MainMenu
	private static void MainMenu() {
		System.out.println("Tic Tac Toe");
		System.out.print("--------------");
		System.out.println();
		System.out.println("New Game");
	}
	
	// Players
	private static void Players() {
	System.out.println("How many human players? ");
	
	if(input.hasNextInt()) { 
		numb_players = input.nextInt();
		if(numb_players < 1 || numb_players >2) {
			System.out.println("Only 1 or 2 players can play.");
			System.exit(1);
		}
	} else {
		System.out.println("Only digits allowed");
		System.exit(1);
	}
	if(numb_players == 1) {
		System.out.println("Player1 name: ");
		player1 = input.next();
		player2 = "computer";
	} else {
		System.out.println("Player1 name: ");
		player1 = input.next();
		
		System.out.println("Player2 name: ");
		player2 = input.next();
	}
	}
	
	// GameBoard
	private static void GameBoard() {
		
	  for(int i = 0; i < gameBoard.length; i++) { 
		  for(int j = 0; j < gameBoard[i].length; j++) {
			  gameBoard[i][j] = "*";
			  System.out.print(gameBoard[i][j] + " ");
		  }
		  System.out.println();
	  }
   }
	
	// PrintGameBoard
	private static void PrintGameBoard() {
		  for(int i = 0; i < gameBoard.length; i++) { 
			  for(int j = 0; j < gameBoard[i].length; j++) {
				  System.out.print(gameBoard[i][j] + " ");
			  }
			  System.out.println();
		  }
	}
	
	// Play
	private static void Play() {
		boolean playing_now = true;
		System.out.println("Let's start playing");
		
		player_turn = player1;
		
		while(playing_now) {
		  System.out.println(player_turn + ", provide row ");
		  PrintRow();
		  row = input.nextInt() -1;
		  System.out.println("provide column: ");
		  PrintColumn();
		  column = input.nextInt() -1;
	
		  if(player_turn.equals(player1)) {
			  brick = "X";
			  CheckFull(row, column);
			  if(!full) {
			    gameBoard[row][column] = brick;
			    CheckWin(row, column, brick, player1);
			    player_turn = player2;
			  } else {
				  player_turn = player1;
				  System.out.println("try again: ");
			  }
		
		  } else {
			  brick = "O";
			  CheckFull(row, column);
			  if(!full) {
				  gameBoard[row][column] = brick;
				  CheckWin(row, column, brick, player2);
				  player_turn = player1;
			  } else {
			   player_turn = player2;
			   System.out.println("try again: ");
			  }
		  }	 
		  PrintGameBoard();
		  
  		}
	}

	// CheckWin
	private static void CheckWin(int row, int column, String brick, String player) {
		System.out.println("column is " + column);
		if(column == 0) { 
			// check horizontal
			if(gameBoard[row][column+1] == brick && gameBoard[row][column+2] == brick) {
				YouWin(player);
			}
		} else if(column == 1){
			// check horizontal
				if(gameBoard[row][column-1] == brick && gameBoard[row][column+1] == brick) {
				  YouWin(player);
				}
			
		} else if (column == 2){
			// check horizontal
			if(gameBoard[row][column-2] == brick && gameBoard[row][column-1] == brick) {
				YouWin(player);
			}
	
		}
	
		// check horizontal
		  
		// check vertical	
		
		// check diagonal
		
		// no win.	
		
	}	
	
	// YouWin
	private static void YouWin(String player) {
		System.out.println("Three in a row! " + player + " You WIN!");
		PrintGameBoard();
		MainMenu();
		Players();
		GameBoard();
	    Play();
		//System.exit(0);
	}
	
	// checkFull
	private static void CheckFull(int row, int column) {
		if(!gameBoard[row][column].contentEquals("*")) {
			System.out.println("Already taken!");
			full = true;
		} else {
			full = false;
		}
	}
		
    // PrintColumn
	// printRow
	private static void PrintColumn() {
		String[][] pcolumn = new String[1][3];
		// [1][2][3]
		pcolumn[0][0] = "[1]";
		pcolumn[0][1] = "[2]";
		pcolumn[0][2] = "[3]";
		for(int i = 0; i < pcolumn.length; i++) { 
			  for(int j = 0; j < pcolumn[i].length; j++) {
				  System.out.print(pcolumn[i][j] + " ");
			  }
			  System.out.println();
		  }
	}
	
	// printColumn
	
	// PrintRow
	private static void PrintRow() {
		String[][] prow = new String[3][1];
		// [1]
		// [2]
		// [3]
		prow[0][0] = "[1]";
		prow[1][0] = "[2]";
		prow[2][0] = "[3]";
		
		for(int i = 0; i < prow.length; i++) { 
			  for(int j = 0; j < prow[i].length; j++) {
				  System.out.print(prow[i][j] + " ");
			  }
			  System.out.println();
		  }
	}
	
}
