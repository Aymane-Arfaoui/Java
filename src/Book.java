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







import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

/**Create a Book Class That will implement serializable to convert values to binary
 * 
 * 
 *  */
public class Book implements Serializable  {
	
	private String title;
	private String author;
	private double price;
	private String ISBN;
	private String genre;
	private int year;
/**
	@param title : title of the book 
	@param author : author of the book
	@param price : price of the book 
	@param ISBN: ISBN of the Book
	@param genre: genre of The book
	@param year: year of the book
	

	 *  */
	
	
	public Book(String title, String author, double price, String ISBN, String genre, int year) {
		
		this.title = title;
		this.author = author;
		this.price=price;
		this.ISBN = ISBN;
		this.genre = genre;
		this.year = year;
			
	}
	
	//setter methods
	public void setTitle(String ti) {
		title=ti;
		
	}
	public void setAuthor(String au) {
		author = au;
		
	}
	public void setPrice(double pr) {
		price = pr;
		
	}
	public void setISBN(String is) {
		ISBN = is;
		
	}
	public void setGenre(String ge) {
		genre = ge;
		
	}
	public void setYear(int y) {
		year = y;
		
	}
	
	//getter Methods
		
	public String getTitle() {
		return title;
		
	}
	public String getAuthor() {
		return author;
		
	}
	public double getPrice() {
		return price;
		
	}
	public String getISBN() {
		return ISBN;
		
	}
	public String getGenre() {
		return genre;
		
	}
	public int getYear() {
		return year;
		
	}
		
	//@override 
	public String toString() {
		return title + ", " + author + ", "+ price + ", "+ ISBN + ", "+ genre + ", "+ year + ", ";
	}
	
	//copy constructor
	
	public Book(Book bookCopy) {
		title  = bookCopy.title;
		author  = bookCopy.author;
		price  = bookCopy.price;
		ISBN  = bookCopy.ISBN;
		genre  = bookCopy.genre;
		year  = bookCopy.year;
	
	}
	
	/**@override Equals Method
	 * @param Object: every class is descendent of object  
	 * 
	 */
		public boolean equals(Object book1) {
			if (book1 == null || getClass() != book1.getClass())
				return false;
			else {
				Book book2 = (Book)book1;
			return super.equals(book2) && title == book2.title && 
					author == book2.author && price == book2.price &&
					ISBN == book2.ISBN && genre == book2.genre &&
					year ==book2.year;
			}
		}
		

	
		
	public static void ReaderFile2() {
			
			// create a string array of the name of the files
			String [] FileDirectory = {
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Cartoons_Comics_Books.csv.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Hobbies_Collectibles_Books.csv.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Movies_TV.csv.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Music_Radio_Books.csv.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Nostalgia_Eclectic_Books.csv.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Old_Time_Radio.csv.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Sports_Sports_Memorabilia.csv.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Trains_Planes_Automobiles.csv.txt"				
			};
			
			String s;
			Scanner kb = new Scanner(System.in);
			Scanner sc = null;
			Scanner sc2 = null;
			int numfile;
			
			
			for (int i=0; i<8; i++) {
				try {
					sc2 = new Scanner(new FileInputStream(FileDirectory[i]));       
				}catch(FileNotFoundException e) {
					
					System.out.println("Could not open file for reading.");
					
					//issue when opening the files
					System.out.println("Program will terminate");
					
				}
				
				String[] div;
				while(sc2.hasNextLine()) {
					String content = sc2.nextLine();
					div = content.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
					String FileName = FileDirectory[i];			
	
					
					try {
					CheckSemantics(div, FileName);
					}catch (ArrayIndexOutOfBoundsException e1) {
						System.out.println("Index out of bounds");
					}catch (NumberFormatException e1) {
						System.out.println("Number Format Exception");
					}
					/*catch (BadIsbn10Exception e) {
					System.out.println("Bad ISBN number");
					}*/
					
					System.out.println(content);
						
							 
				}
				
						
			}
			
			String [] FileDirectory2 = {
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Cartoons_Comics_Books.csv.ser.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Hobbies_Collectibles_Books.csv.ser.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Movies_TV.csv.ser.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Music_Radio_Books.csv.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Nostalgia_Eclectic_Books.csv.ser.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Old_Time_Radio.csv.ser.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Sports_Sports_Memorabilia.csv.ser.txt",
					"/Users/aymanearfaoui/eclipse-workspace/Comp249Assignment3/Trains_Planes_Automobiles.csv.ser.txt"				
			};
			

			for (int i=0; i<8; i++) {
				try {
					sc2 = new Scanner(new FileInputStream(FileDirectory2[i]));       
				}catch(FileNotFoundException e) {
					
					System.out.println("Could not open file for reading.");
					
					//issue when opening the files
					System.out.println("Program will terminate");
					
				}
				
				String[] div;
				Book [] books;
				while(sc2.hasNextLine()) {
					String content = sc2.nextLine();
					div = content.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
					String FileName = FileDirectory[i];		
					
					
					
				
					
						
							 
				}
				
			}
			
			
			
	}
	
	
	// create the book array 
	
	
	
	//fix ISBN addition 
	
	/**
	@param String[] ex: string that corresponds to the record
	@param String FileName : that corresponds to the filename

This method checks for semantic errors and creates the appropriate files
	 *  */
	
	public static void CheckSemantics(String[] ex, String FileName)  {
		PrintWriter pw = null;
		String s;
		Scanner kb = new Scanner(System.in);
		
		
		//CHECK IF ISBN is good turn it into a sum
		String ISBNCondition = ex[3];
		int sum = 0;
		
		for (int k = 0; k < ISBNCondition.length(); k++) {
		   
		    int num = Integer.parseInt(String.valueOf(ISBNCondition.charAt(k)));
		    
		    sum += num;
		}
		
		if(Double.parseDouble(ex[2])<0) {
			System.out.println("Wrong Price Value");
			try
			{
				pw = new PrintWriter(new FileOutputStream("semantic_error_file.text", true));	// Appending File
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
			pw.write("\nError: Wrong Price Value");
			pw.write("\nRecord: " + ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+", "+ ex[5] + "\n");	
			//close files
			pw.close();
				
			
			// check if YEAR IS good
		}else if(Integer.parseInt(ex[3]) % 11!=0) {
			System.out.println("ISBN number is not a Multiple of 11");
			try
			{
				pw = new PrintWriter(new FileOutputStream("semantic_error_file.text", true));	// Appending File
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
			pw.write("\nError: ISBN number not a multiple of 11");
			pw.write("\nRecord: " + ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ ", " +ex[5] + "\n");
			//close files
			pw.close();
				
				
		}else if(Integer.parseInt(ex[3]) % 11!=0) {
			System.out.println("ISBN number is not a Multiple of 13");
			try
			{
				pw = new PrintWriter(new FileOutputStream("semantic_error_file.text", true));	// Appending File
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
			pw.write("\nError: ISBN number not a multiple of 13");
			pw.write("\nRecord: " + ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ ", "+ ex[5] + "\n");
			//close files
			pw.close();
				
				
		}	
		else if (ex[4].equals("CCB")) {
			try 
			{
				pw = new PrintWriter(new FileOutputStream("Cartoons_Comics_Books.csv.ser.txt",true));
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
				pw = new PrintWriter(new FileOutputStream("Hobbies_Collectibles_Books.csv.ser.txt",true));
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
				pw = new PrintWriter(new FileOutputStream("Movies_TV.csv.ser.txt",true));
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
				pw = new PrintWriter(new FileOutputStream("Music_Radio_Books.csv.ser.txt",true));
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
				pw = new PrintWriter(new FileOutputStream("Nostalgia_Eclectic_Books.csv.ser.txt",true));
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
				pw = new PrintWriter(new FileOutputStream("Old_Time_Radio.csv.ser.txt",true));
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
				pw = new PrintWriter(new FileOutputStream("Sports_Sports_Memorabilia.csv.ser.txt",true ));
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
				pw = new PrintWriter(new FileOutputStream("Trains_Planes_Automobiles.csv.ser.txt",true));
			}catch(FileNotFoundException e) {
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
				System.out.print("Program will terminate.");
				
			}
			pw.write(ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ "," + ex[5]+"\n\n");
			pw.close();
		}else if(Integer.parseInt(ex[5])>2010 || Integer.parseInt(ex[5]) <1995) {
			System.out.println("Year out of Bounds");
			try
			{
				pw = new PrintWriter(new FileOutputStream("semantic_error_file.text", true));	// Appending File
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
			pw.write("\nError: Wrong Year");
			pw.write("\nRecord: " + ex[0] + "," + ex[1] + ","  + ex[2] + "," + ex[3] + "," + ex[4]+ ", "+ex[5] + "\n");
			//close files
			pw.close();

		}
			
	
			}	
		}	
		
	
					

		





