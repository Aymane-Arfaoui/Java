/**
 * NAME and ID : Aymane Arfaoui 40248780
 * COMP249
 * Assignment #3
 * Due Date : March 29 th2023
 * 
 * @author: Aymane Arfaoui
 * @version 27/3/2023
 * 
 * */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class ReaderFile {
	
	public static void ReaderFile() {
	String s;
	Scanner kb = new Scanner(System.in);
	Scanner sc = null;
	Scanner sc2 = null;
	int numfile;
	
/**
 * 
 * Opens the first file to read the number of files to read and which files to read
 */
	try 
	{
		sc = new Scanner(new FileInputStream("/Users/aymanearfaoui/Desktop/Concordia/2nd Semester/Comp249/Assignment3/Assg3_Needed_Files/part1_input_file_names.txt"));
		
	}
	catch(FileNotFoundException e) {
		System.out.println("Could not open file for reading.");
		System.out.println("Program will terminate");

	}
	
	System.out.println("Will proceed with reading the input files");
	System.out.println("Here are the names of the input files document ");
	numfile = sc.nextInt();
	String books;
	
	String [] booksToRead= new String[numfile];
	String junk = sc.nextLine();
	for(int i = 0; i<numfile; i++) {
		
		booksToRead[i] = sc.nextLine();
		
		
		//Input the file names
		System.out.println(booksToRead[i]);
	
		}
	
	//go through every file
	
	//
	for (int i = 0; i<numfile-1; i++) {
		
	try {
		
		sc2 = new Scanner(new FileInputStream("/Users/aymanearfaoui/Desktop/Concordia/2nd Semester/Comp249/Assignment3/Assg3_Needed_Files/"+booksToRead[i]));       
	}catch(FileNotFoundException e) {
		
		System.out.println("Could not open file for reading.");
		
		//issue when opening the file with two dots
		System.out.println("Program will terminate");
		
	}
	
	//While method does not print the very last line
	
	// make a for loop to go through every single book
	String contentConcat = "";
	String[] div;
		while(sc2.hasNextLine()) {
			 String content = sc2.nextLine();
			 div = content.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
			 
			 //Check Syntax Method
			 String FileName = booksToRead[i];
			
			 
			 CheckSyntax(div, FileName);
			 System.out.println(content);
			 
			}
		
		}
	
	}
	
	
	/**
	@param String[] ex: string that corresponds to the record
	@param String FileName : that corresponds to the filename

This method checks for syntax errors and creates the appropriate files
	 *  */

	
	// method that takes in the string and the fileName to display it in the error message
	public static void CheckSyntax(String[] ex, String FileName){
		
		PrintWriter pw = null;
		String s;
		Scanner kb = new Scanner(System.in);
		
		//title, authors, price, ISBN, genre, year
		
		//checking for the title
		if(ex[0].equals("")) {
			System.out.println("Title is Missing");
			try
			{
				pw = new PrintWriter(new FileOutputStream("syntax_error_file.text", true));	// Appending File
			}
			catch(FileNotFoundException e) 			
			{							   			// exception is automatically thrown if file cannot be created. 
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				System.exit(0);			   		   
			}
			pw.write("Syntax error in file: " + FileName);
			pw.write("\n=================");
			pw.write("\nError: missing title");
			pw.write("\nRecord: " + ex[1] + "," + ex[2] + ","  + ex[3] + "," + ex[4] + "," + ex[5] + "\n");	
			//close files
			pw.close();
				
			
			// check if author is missing
		}else if(ex[1].equals("")) {
			System.out.println("Author is Missing");
			try
			{
				pw = new PrintWriter(new FileOutputStream("syntax_error_file.text", true));	// Appending File
			}
			catch(FileNotFoundException e) 			
			{							   			// exception is automatically thrown if file cannot be created. 
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				System.exit(0);			   		   
			}
			pw.write("\nSyntax error in file: " + FileName);
			pw.write("\n=================");
			pw.write("\nError: missing Author");
			pw.write("\nRecord: " + ex[0] + "," + ex[2] + ","  + ex[3] + "," + ex[4] + "," + ex[5] + "\n");
			//close files
			pw.close();
				
				
		}else if(ex[2].equals("")) {
			System.out.println("Price is Missing");
			try
			{
				pw = new PrintWriter(new FileOutputStream("syntax_error_file.text", true));	// Appending File
			}
			catch(FileNotFoundException e) 			
			{							   			// exception is automatically thrown if file cannot be created. 
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				System.exit(0);			   		   
			}
			pw.write("Syntax error in file: " + FileName);
			pw.write("\n=================");
			pw.write("\nError: missing Price");
			pw.write("\nRecord: " + ex[0] + "," + ex[1] + ","  + ex[3] + "," + ex[4] + "," + ex[5] + "\n");
			//close files
			pw.close();
				
				
		}else if(ex[3].equals("")) {
			System.out.println("ISBN is Missing");
			try
			{
				pw = new PrintWriter(new FileOutputStream("syntax_error_file.text", true));	// Appending File
			}
			catch(FileNotFoundException e) 			
			{							   			// exception is automatically thrown if file cannot be created. 
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				System.exit(0);			   		   
			}
			pw.write("Syntax error in file: " + FileName);
			pw.write("\n=================");
			pw.write("\nError: missing ISBN number");
			pw.write("\nRecord: " + ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[4] + "," + ex[5] + "\n");
			//close files
			pw.close();
				
				
		}else if(ex[4].equals("")) {
			System.out.println("Genre is Missing");
			try
			{
				pw = new PrintWriter(new FileOutputStream("syntax_error_file.text", true));	// Appending File
			}
			catch(FileNotFoundException e) 			
			{							   			// exception is automatically thrown if file cannot be created. 
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				System.exit(0);			   		   
			}
			pw.write("Syntax error in file: " + FileName);
			pw.write("\n=================");
			pw.write("\nError: missing Genre");
			pw.write("\nRecord: " + ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[5] + "\n");
			
			//close files
			pw.close();
				
		}else if(ex[5].equals("")) {
			System.out.println("Year is Missing");
			try
			{
				pw = new PrintWriter(new FileOutputStream("syntax_error_file.text", true));	// Appending File
			}
			catch(FileNotFoundException e) 			
			{							   			// exception is automatically thrown if file cannot be created. 
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				System.exit(0);			   		   
			}
			pw.write("Syntax error in file: " + FileName);
			pw.write("\n=================");
			pw.write("\nError: missing Year");
			pw.write("\nRecord: " + ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4] + "\n");	
			
			pw.close();
				
		}	
		
		//CHECK FOR THE GENRE
		else if (ex[4].equals("CCB")) {
			try 
			{
				pw = new PrintWriter(new FileOutputStream("Cartoons_Comics_Books.csv.txt", true));
			}catch(FileNotFoundException e) {
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				
			}
			pw.write(ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ "," + ex[5]+"\n\n");
			pw.close();
			
		}else if (ex[4].equals("HCB")) {
			try 
			{
				pw = new PrintWriter(new FileOutputStream("Hobbies_Collectibles_Books.csv.txt", true));
			}catch(FileNotFoundException e) {
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				
			}
			pw.write(ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ "," + ex[5]+"\n\n");
			pw.close();
			
			
		}else if (ex[4].equals("MTV")) {
			try 
			{
				pw = new PrintWriter(new FileOutputStream("Movies_TV.csv.txt", true));
			}catch(FileNotFoundException e) {
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				
			}
			pw.write(ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ "," + ex[5]+"\n\n");
			pw.close();
			
			
		}else if (ex[4].equals("MRB")) {
			try 
			{
				pw = new PrintWriter(new FileOutputStream("Music_Radio_Books.csv.txt", true));
			}catch(FileNotFoundException e) {
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				
			}
			pw.write(ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ "," + ex[5]+"\n\n");
			pw.close();
			
			
		}
		
		else if (ex[4].equals("NEB")) {
			try 
			{
				pw = new PrintWriter(new FileOutputStream("Nostalgia_Eclectic_Books.csv.txt", true));
			}catch(FileNotFoundException e) {
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				
			}
			pw.write(ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ "," + ex[5]+"\n\n");
			pw.close();
			
			
		}
		
		else if (ex[4].equals("OTR")) {
			try 
			{
				pw = new PrintWriter(new FileOutputStream("Old_Time_Radio.csv.txt", true));
			}catch(FileNotFoundException e) {
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				
			}
			pw.write(ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ "," + ex[5]+"\n\n");
			pw.close();
			
			
		}
		else if (ex[4].equals("SSM")) {
			try 
			{
				pw = new PrintWriter(new FileOutputStream("Sports_Sports_Memorabilia.csv.txt", true));
			}catch(FileNotFoundException e) {
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				
			}
			pw.write(ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ "," + ex[5]+"\n\n");
			pw.close();
			
			
		}
		else if (ex[4].equals("TPA")) {
			try 
			{
				pw = new PrintWriter(new FileOutputStream("Trains_Planes_Automobiles.csv.txt", true));
			}catch(FileNotFoundException e) {
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				
			}
			pw.write(ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ "," + ex[5]+"\n\n");
			pw.close();
		}
			//If none of the genres are okay, then put it in the syntax error file:
			else {
				
				try 
				{
					pw = new PrintWriter(new FileOutputStream("syntax_error_file.text", true));
				}catch(FileNotFoundException e) {
					System.out.println("Could not open/create the file to write to. "
							+ " Please check for problems such as directory permission"
							+ " or no available memory.");
					
					
				}
				pw.write("\nError: Invalid Genre");
				pw.write(ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ "," + ex[5]+"\n\n");
				pw.close();
				
			}
		
	}	
	
}
