import javax.swing.JFrame;

/**
 * NAME and ID : Aymane Arfaoui 40248780
 * COMP249
 * Assignment #1
 * Due Date : February 3rd 2023
 * 
 * @author: Aymane Arfaoui
 * @version 2/2/2023
 * 
 * */


/**
 * Create a method LadderAndSnake that will create: a 2D board that contains integer,
 * 2 integers, player1 and player2 that will record the values of the player 
 * Create also two strings to store the name of the players
 * 
 * Create 2 2d board that will store where the snakes and ladders are
 * */
	public class LadderAndSnake {
	
	private  int [][] board = new int[10][10];
	static  int player1;
	static  int player2;
	private String p1;
	private String p2;
	
	private int[][] ladders = {{80,100},{71,91},{51,67},{21,42},
							{36,44},{1,38},{28,84},{4,14},
							{9,31}};
							
	private int[][] snakes= {{98,78},{97,76},{95,24},{93,68},
							{79,19},{64,60},{48,30},{16,6}};
	
		

	
	/**Create a Constructor that initializes the number of players 
	 * and sets the board to 10
	 * 
	 * @param Players integer that records the number of players 
	 * @param one records the name of the first player
	 * @param two records the name of the second player
	 *  
	 *  */

	
	public LadderAndSnake(int Players, String one, String two){
			
		this.p1 = one;
		this.p2 = two;
			
	/*
	 * Create an if statement to verify if the user correctly entered 2 players 
	 * Display the appropriate message if the number of players entered is above 2 or less than 2
	 * 
	 * */	
		
		if (Players > 2) {
			System.out.print("Warning: You must Select 2 players for the Game to START !");
			System.exit(0);
		}else if (Players < 2)
				{
			System.out.print("ERROR: Cannot execute the game with less than 2 players!");
			System.exit(0);
			
				}
		
		/*
		 * If the number of players entered is correct, then display the board
		 * 
		 * The board must start at 100 at board[0][0] and decrease from there following a special sequence 
		 * */
		else {
		int k =101;
		
		for(int i = 0; i < 10; i++) {
			
			for (int j = 0; j<10; j++) {
					k--;
					board[i][j]= k;
				
				
					
				}

			}
		
		
		}
		
		/*
		 * 
		 * Go inside every single element of the for loop of the board and change only the values that are on an 
		 * odd row !
		 * 
		 * take the very last value on the row and put it as the first one, before-last one and put in the second one and 
		 * so on...
		 * 
		 * 
		 * */
	
	
		for (int p = 0; p<board.length; p++) {
			System.out.println();
			for(int s = 0; s<board[p].length; s++) {
				if(p%2 == 0)
				System.out.print("| " + board[p][s] + "	|");
				
			}
			if(p%2 != 0) {
				for(int z = 0; z < board[p].length/2; z++) {
					int temp = board[p][z];
					board[p][z] = board[p][board.length-z-1];
					board[p][board.length-z-1] = temp;
					System.out.print("| " + board[p][z] + "	|");
					
			}
					for(int d = 5; d < board[p].length; d++) {
						System.out.print("| " + board[p][d] + "	|");
				
			}
			
			}
		}
	
	
	}
	
	/**
	 * Create a method that flips the dice and selects a value from 1 to 6 (including 1 and 6)
	 * 
	 * @return the number that is displayed by the flipDice() method.
	 * */

	public static int flipDice() {
		int numDice = (int)(1+(Math.random() * 6 ));
		return numDice;
		
	}
	
/**
 * 
 * Create a method where the main part of the game will take place 
 * This method is void and will take manipulate player1 and player2 
 * 
 * 
 * */
	
	public void play() {
		
		//The values of the flipDice are stored in player1 and player2
		
		player1 = flipDice();
		player2 = flipDice();
		
		
		int p=1;
		
		//Create a condition that when the values of the two players are equal
		//Display the correct message and attempt to break the tie until either player 1 or player 2
		//has the the highest number
		while (player1 == player2) {
			
			System.out.println(p1+ " got the dice value : "
					+ player1 +" \n"+  p2 + " got the dice value : " + 
					player2);
			System.out.println("A tie was achieved between "
					+p1+ " and"+ p2 + " .\nAttempting to break "
					+ "the tie. ");
			
					p++;
				player1 = flipDice();
				player2 = flipDice();
			
				if (player1 > player2 || player2 > player1) {
					break;
				}
				else 
					continue;
				
		}
		
		//******************************FIRST CASE OF THE GAME *****************************************
		
		//In this case, we manipulate the the case where the value of dice of player 1 is higher than that of 
		//player 2 
		 if(player1 > player2) {
			System.out.println(p1+" got a dice value of: " + 
								player1 + "\n" + p2 + " got a dice value of: "
								+ player2);
			
			System.out.println("Reached Final Decison on order of playing: \n"
					+ p1 +  " then " + p2 +  " It took " + p + " attempts \n"
							+ "before a decision could be made\n\n");
//Create a for loop that will alternate between player1 and player2
/*This takes initializes position1 (player1) and position2(player2) to 0
 * 
 * */
for (int position2= 0, position1 = 0; position1<100&&position2 <100;) {	
	
	//store the values of the dice in a variable a for position2 and 
	//in integer b for position1
	int b = flipDice();
	int a = flipDice();
	
	position2 += a;
	
	position1 += b;
	
	
	//SPECIAL CONDITION: If the players are on the same square, the first there gets sent back to 0

	if ((position1 == position2)&&((position1&position2)>0)) {
	System.out.println(p1 + " rolled: " + b + " and is now at square: " + position1);
	position1 = 0;
	//Display the appropriate message : 
	System.out.println(p2 + "***********8 has landed on the same spot as " + p1 +  ". " + p1 + " is now at 0.\n");
	position2 += a;
	
	
	
	}
	
	//Create an if statement showing when the player reaches 100 and Wins
	if (position1 == 100) {
		
		//display the correct message and exit the game 
		System.out.println(p1 + " rolled: " + b +". "+ p1+ " WON !! ");
			System.exit(0);
	}
	/*This is the other special condition where if the position is over 100
	 * the player goes to the square in proportion of the value he exceeded 100 by 
	 * if he is at 99 and rolls 4, he goes back to 97 ...
	 * 
	 * */
			else if(position1 > 100) {
				position1 = 100-(position1-100);
				System.out.println(p1 + "\n rolled: " + b + p1 + " went over 100 and is now at " + (position1));
			} 
			
	//Initialize a boolean ladder value that is false at first since there are no ladders
	boolean isLadder = false;
	
	/*Create a for loop that creates an array out of the array containing the positions of the ladders
	 *
	 * */
	for (int []ladder : ladders) {
		
		if(position1 == ladder[0]) {
			position1 = ladder[1];
			//isLadder is now true since a ladder was reached.
			isLadder = true;
			
			//if the position 100 is reached with a ladder; tell the player he won and got a ladder
			if (position1 == 100) {
				
				System.out.println("\nYUPI ! "+p1 + " rolled "+ b +" and got a LADDER. "+p1
						+ " WON !! ");
				
				//exit the game 
				System.exit(0);
				
			}
			
			
			//if 100 is not reached simply print that the player got a ladder and show his position
			else {
			System.out.println("\nYESSS!!! "+p1+ " rolled: " + b + 
					" and got a LADDER !! " + p1 + " is now at square: " + position1);
			
			}
			 
			}
		
		//************EXACT SAME THING WITH THE LADDERS EXCEPT IT IS WITH SNAKES
	} 
	boolean isSnake = false;
	for (int []snake : snakes) {
		if(position1 == snake[0]) {
			position1 = snake[1];
			
			
			System.out.println("\nOh No!! " + p1 + " rolled: " + b + 
					" and got a SNAKE !! " +p1+ " is now at square: " + position1);
			isSnake =true;
			break;
			}
		}
	
	
	 if (!isSnake && !isLadder && position1<100 &&position1!=0)
	System.out.println("\n"+p1 + " rolled: " + b + " and is now at square: " + position1);
				
		//*************REPEAT THE PROCESS BUT FOR POSITION 2 THIS TIME !
	 
				if (position2 == 100) {
					System.out.println(p2 + " rolled: " + a +". "+ p2+ " WON !! ");
						System.exit(0);
				}
						else if(position2 > 100) {
							position2= 100-(position2-100);
							System.out.println(p2 + "\n rolled: " + a + p2 + " went over 100 and is now at " + (position2));
						} 
							 isLadder = false;
								for (int []ladder : ladders) {
									if(position2 == ladder[0]) {
										position2 = ladder[1];
										if (position2 == 100) {
											System.out.println("\nYUPI ! "+p2 + " rolled "+ a+" and got a LADDER. " + p2
													+ "  WON !! ");
											System.exit(0);
										}else {
											
										System.out.println("\nYESSS!!! "+p2+ " rolled: " + a+ 
												" and got a LADDER !! " + p2 + " is now at square: " + position2);
										 isLadder = true;
										 break;
										}
									}
										
								} 
								 isSnake = false;
								for (int []snake : snakes) {
									if(position2 == snake[0]) {
										position2 = snake[1];
										System.out.println("\nOh No!! " + p2 + " rolled: " + a + 
												" and got a SNAKE !! " +p2+ " is now at square: " + position2);
										isSnake =true;
										break;
										}
									}
								 if (!isSnake && !isLadder && position2<100 && position2!=0)
								System.out.println(p2 + " rolled: " + a + " and is now at square: " + position2);
					
				}
					
			

		 }
		 
		 
		 //**************SAME AS PREVIOUS CODE *ONLY THIS TIME PLAYER 2 STARTS *******************************
		 
		 
			//The case in which player 2 has a higher dice value than player 1
		 
		else if (player2 > player1) {
			
			System.out.println(p2+" got a dice value of: " + 
					player2 + "\n" + p1 + " got a dice value of: "
					+ player1);

			System.out.println("Reached Final Decison on order of playing: \n"
					+ p2 +  " then " + p1 +  " It took " + p + " attempts \n"
					+ "before a decision could be made\n\n");
	
			
			//Create a for loop that will alternate between player1 and player2
			 /*This takes initializes position1 (player1) and position2(player2) to 0
			  * 
			  * */
			for (int position2= 0, position1 = 0; position1<100&&position2 <100;) {
				int a = flipDice();
				position2 += a;
				
				int b = flipDice();
				position1 += b;
				
				//SPECIAL CONDITION: If the players are on the same square, the first there gets sent back to 0
				if ((position1 == position2)&&((position1&position2)>0)) {
					System.out.println(p2 + " rolled: " + a + " and is now at square: " + position2);
					position2 = 0;
					System.out.println(p1 + " **************has landed on the same spot as " + p2 +  ". " + p2 + " is now at 0.\n");
					position1+=b;
					
				}
				
		
				 if (position2 == 100) {
					System.out.println(p2 + " rolled: " + a +". "+ p2+ " WON !! ");
						System.exit(0);
				}
						else if(position2 > 100) {
							position2= 100-(position2-100);
							System.out.println(p2 + "\n rolled: " + a + p2 + " went over 100 and is now at " + (position2));
						} 
				
				 
							boolean isLadder = false;
								for (int []ladder : ladders) {
									if(position2 == ladder[0]) {
										position2 = ladder[1];
										if (position2 == 100) {
											System.out.println("\nYUPI ! "+p2 + " rolled "+ a + " and got a LADDER. " + p2 
													+ " and WON !! ");
											System.exit(0);
										}else {									
										System.out.println("\nYESSS!!! "+p2+ " rolled: " + a + 
												" and got a LADDER !! " + p2 + " is now at square: " + position2);
										if(position2 == 100)
											System.exit(0);
										 isLadder = true;
										 break;
										}
										}
										
								} 
								boolean isSnake = false;
								for (int []snake : snakes) {
									if(position2 == snake[0]) {
										position2 = snake[1];
										
					
										System.out.println("\nOh No!! " + p2 + " rolled: " + a + 
												" and got a SNAKE !! " +p2+ " is now at square: " + position2);
										isSnake =true;
										break;
										}
									}
								
							
								 if (!isSnake && !isLadder && position2<100 && position2!=0)
								 System.out.println("\n"+p2 + " rolled: " + a + " and is now at square: " + position2);
				
			
				if (position1 == 100) {
					System.out.println(p1 + " rolled: " + b +". "+ p1+ " WON !! ");
						System.exit(0);
				}
				
				
						else if(position1 > 100) {
							position1 = 100-(position1-100);
							System.out.println(p1 + "\n rolled: " + b + p1 + " went over 100 and is now at " + (position1));
						}
				
				isLadder = false;
				for (int []ladder : ladders) {
					if(position1 == ladder[0]) {
						position1 = ladder[1];

						if (position1 == 100) {
							System.out.println("\nYUPI ! "+p1 + " rolled "+ b + " and got a LADDER " + p1 + " got a ladder"
									+ " and WON !! ");
							System.exit(0);
						}else {									
						System.out.println("\nYESSS!!! "+p1+ " rolled: " + b + 
								" and got a LADDER !! " + p1 + " is now at square: " + position1);
						if(position2 == 100)
							System.exit(0);
						 isLadder = true;
						 break;
						}
				}
					
						
				} 
				isSnake = false;
				for (int []snake : snakes) {
					if(position1 == snake[0]) {
						position1 = snake[1];
						
						if (position1 == 100) {
							System.out.println("\n"+p1 + " rolled: " + b + " " + p1 + " WON !! ");
							System.exit(0);
						}
						
						else {
						System.out.println("\nYESSS!!! "+p1+ " rolled: " + b + 
								" and got a LADDER !! " + p1 + " is now at square: " + position1);
						if(position1 == 100)
							System.exit(0);
						isSnake =true;
						break;
						}
						
					}
				}
				if (!isSnake && !isLadder && position1<100 && position1!=0)
				System.out.println("\n"+p1 + " rolled: " + b + " and is now at square: " + position1);
					
			}
			
			
		}
		
	
	}
	

		
}
	
	
	
				

