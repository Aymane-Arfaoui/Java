/*
 * NAME and ID : Aymane Arfaoui 40248780
 * COMP249
 * Assignment #1
 * Due Date : February 3rd 2023
 * 
 * @author: Aymane Arfaoui
 * 
 * */

//Import Scanner 
//import javax.swing.*;
//import java.awt.Color;
import java.util.Scanner;



public class PlayLadderAndSnake {
	

	public static void main(String[] args) {
		
	
		// TODO Auto-generated method stub
		
		/*Display A Welcome Message
		 * */
		

		System.out.println("Welcome the Snake and Ladder Game ! \n");

	     
	       
		//Tell the users to enter the number of players

		System.out.print("Please enter the number of Players: ");
	
		//Create a scanner that will record the user's input 
		Scanner Input = new Scanner(System.in);
		
		//Initialize a variable that takes the number of players 
		int NumPlayer = Input.nextInt();
		
		//Tell the user to input the name of the players 
		System.out.print("Type the name of the first player: ");
		
		//store name1 in String name1
		String name1 = Input.next();
		
		
		System.out.print("Type the name of the second player: ");
		//Store name2 in String Name2
		String name2 = Input.next();
		
		//Close the scanner 
		Input.close();
		//Create a game from the LadderAndSnake game 
		//That will take the num of players, name1 and name2
		LadderAndSnake game = new LadderAndSnake(NumPlayer,name1, name2);		
		
		//Print an initial message displaying the first instruction of the game 
		System.out.println("\n\nIn order to determine who will start,\neach player must "
				+ "throw a dice, the higher number will start.\n");
	//START THE GAME !!
		game.play();
		
		
	}
	

	
}
