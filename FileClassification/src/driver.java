

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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class driver {

	/**
	 * 
	 * Create a method where the system will operate
	 * 
	 * 
	 * */	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] FileDirectory2 = {
				"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Cartoons_Comics_Books.csv.ser.txt",
				"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Hobbies_Collectibles_Books.csv.ser.txt",
				"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Movies_TV.csv.ser.txt",
				"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Music_Radio_Books.csv.ser.txt",
				"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Nostalgia_Eclectic_Books.csv.ser.txt",
				"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Old_Time_Radio.csv.ser.txt",
				"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Sports_Sports_Memorabilia.csv.ser.txt",
				"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Trains_Planes_Automobiles.csv.ser.txt"				
		};
		
		String [] FileDirectory3 = {
				"Cartoons_Comics_Books.csv.ser.txt",
				"Hobbies_Collectibles_Books.csv.ser.txt",
				"Movies_TV.csv.ser.txt",
				"Music_Radio_Books.csv.txt",
				"Nostalgia_Eclectic_Books.csv.ser.txt",
				"Old_Time_Radio.csv.ser.txt",
				"Sports_Sports_Memorabilia.csv.ser.txt",
				"Trains_Planes_Automobiles.csv.ser.txt"				
		};
		
		String [] num = {
				"1","2","3","4","5","6","7","8",
			
					
		};
		
		
		//use for loop here to go every single book
		
		ReaderFile num1 = new ReaderFile();
		
		// do_part1();
	//	num1.ReaderFile();
		
		//Book book1 = new Book();
	//	Book.ReaderFile2();
		
	//	do_part3();

	
		
		
		
		String val1;
		do {
			System.out.println("------------------------------");
			System.out.println("           Main Menu");
			System.out.println("------------------------------");
			System.out.println("v View The Selected File");
			System.out.println("s Select a file view");
			System.out.println("x Exit");
			System.out.println("------------------------------\n");
			System.out.println("Enter Your Choice: ");
			Scanner kb = new Scanner(System.in);
			val1 = kb.next();
		if(val1.equals("s")) {

			System.out.println("------------------------------");
			System.out.println("  File Sub-Menu");
			System.out.println("------------------------------");
			//for(int i = 0; i<FileDirectory3.length; i++) {
				
				for(int j= 0; j<FileDirectory2.length;j++) {
			        String file = FileDirectory2[j];
			        int numline = 0;
			        try {
			            BufferedReader reader = new BufferedReader(new FileReader(file));
			            while (reader.readLine() != null) numline++;
			            reader.close();
			        } catch (IOException e) {
			            e.getMessage();
			        }
			    
				
				System.out.println(num[j] + ". "+FileDirectory3[j] + "				(" + numline+" Records)" );
				
				
				
				}
			//}
			
			System.out.println("9. Exit");
			System.out.println("Enter Your Choice: " + "");
			String val2 = kb.next();
			
			for(int j= 0; j<FileDirectory2.length;j++) {
		        String file = FileDirectory2[j];
		        int numline = 0;
		        try {
		            BufferedReader reader = new BufferedReader(new FileReader(file));
		            while (reader.readLine() != null) numline++;
		            reader.close();
		        } catch (IOException e) {
		            e.getMessage();
		        }
		    
			
			//System.out.println(num[j] + ". "+FileDirectory3[j] + "				(" + numline+" Records)" );
			
			if(val2.equals(num[j])) {
				System.out.println("viewing: "+ FileDirectory3[j]+"	 ("+ numline + " Records)");
				int val3 = kb.nextInt();
				if (val3==3) {
					System.out.println("Exiting the System");
					System.exit(0);
				}else {
					String s;
					Scanner kb1 = new Scanner(System.in);
					Scanner sc = null;
					Scanner sc2 = null;
					int numfile=0;

					int lineNumber = val3; 
					//int currentFile = j;
					boolean eofReached = false;

					while (!eofReached) {
					    try {
					        sc2 = new Scanner(new FileInputStream(FileDirectory2[j]));       
					    } catch (FileNotFoundException e) {
					        //System.out.println("Could not open file for reading.");
					        //issue when opening the file with two dots
					        //System.out.println("Program will terminate");
					    } catch (ArrayIndexOutOfBoundsException e) {
					        e.getMessage();
					    }

					    int currentLine = 1;
					    while (sc2.hasNextLine()) {
					        String content = sc2.nextLine();
					        if (currentLine == lineNumber) {
					            System.out.println(content);
					            break;
					        }
					        currentLine++;
					    }

					    System.out.println("Type number of the record you want to show, or -1 to show next previous record, or 0 to exit:");
					    int userChoice = kb1.nextInt();
					    if (userChoice == -1) {
					    	lineNumber--;
					        if (lineNumber < 0) {
					        	lineNumber = numfile - 1;
					        }
					        lineNumber = 1;
					    } else if (userChoice == 1) {
					    	lineNumber++;
					        if (lineNumber >= numfile) {
					        	lineNumber = 0;
					        }
					        lineNumber = 1;
					    } else if (userChoice == 0) {
					        eofReached = true;
					    } else {
					        lineNumber = userChoice;
					    }
					}

					System.out.println("EOF has been reached");

				}
			}
			
			else if(val2.equals("9")) {
				System.out.println("Exiting the System");
				System.exit(0);
			}
				
			
			
			
			}
			
			
		}else if(val1.equals("v")){
			System.out.println("Error: Must select a file first");
			
		}else if(val1.equals("x")) {
			System.out.println("Successull Exit");
			System.exit(0);
		}
		}while(!val1.contains("s") && !val1.contains("v") && !val1.contains("x"));
		
		/*else {
			System.out.println("Please enter a valid value");
			val1 = kb.next();
		}*/
		
		
		
	}

}
