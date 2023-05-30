/**
 * NAME and ID : Aymane Arfaoui 40248780
 * COMP249
 * Assignment #4
 * Due Date : April 17th 2023
 * 
 * @author: Aymane Arfaoui
 * @version 17/4/2023
 * 
 * */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = null;
		String FileName = "Books.txt";
		String line;
		//open the file books.text and read it 
		String div[];
		ArrayList<Book> arrLst = new ArrayList<Book>();
		BookList bkLst = new BookList();
		Book books = null;
		
		try {
			sc = new Scanner(new FileInputStream(FileName));
		}
		catch(FileNotFoundException e) {
			System.out.println("Could not open the File for reading");
		}
			while(sc.hasNextLine()) {
				 String content = sc.nextLine();
				 div = content.split(",");
				 books = new Book(div[0],div[1],Double.parseDouble(div[2]),Long.parseLong(div[3]),div[4],Integer.parseInt(div[5]));
				 bkLst.addToStart(books);
				 
			}
			for(int i = 0; i<arrLst.size(); i++)
			arrLst.add(books);
			//bkLst.storeRecordsByYear(1905);
			
			//bkLst.displayContent();
			//bkLst.extractAuthList("Roy Malan");

			//bkLst.delConsecutiveRepeatedRecords();
			//bkLst.displayContent();
			//Node nodes = bkLst.getHead(); 
			//while(nodes !=null) {
				//System.out.println(nodes.getBook());
				//nodes = nodes.getNext();
				
			//}
			boolean cond = true;
			do {
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Please select from the menu, what operation you wish to Operate !\n ");
			System.out.println("1. Give me a year and I would extract all records of that year and store them in a file for that year: ");
			System.out.println("2. Ask me to delete all consecutive repeated records: ");
			System.out.println("3. Give me an author name and I will create a new list with the records of this author and display them: ");
			System.out.println("4. Give me an ISBN number and a Book object, and I will insert Node with the book before the record with this ISBN ");
			System.out.println("5. Give me 2 ISBN numbers and a Book object, and I will insert a Node between them, if I find them: ");
			System.out.println("6. Give me 2 ISBN numbers and I will swap them in the list for rearrangement of records; of course if they exist! ");
			System.out.println("7. Tell me to COMMIT! Your command is my wish. I will commit your list to a file called Updated_Books; ");
			System.out.println("8. Tell me to STOP TALKING. Remember, if you do not commit, I will not! ");
			
			int choice = sc1.nextInt();
			switch(choice) {
			case 1: 
				System.out.println("Please select the year you wish to extract records from and store them in a file");
				try {
				int year = sc1.nextInt();
				bkLst.storeRecordsByYear(year);
				}catch(InputMismatchException e) {
					System.out.println("Could not create the file");
					break;
				}
				break;
			
			case 2:
				System.out.println("Files will be deleted");
				bkLst.delConsecutiveRepeatedRecords();
				bkLst.displayContent();
				break;
				
			case 3:
				Scanner stringsc = new Scanner(System.in);
				System.out.println("Select the author's name you wish to extract");
				String s = stringsc.nextLine();
				System.out.println(s);
				bkLst.extractAuthList(s);
				break;
				
			case 4:
				try {
				Scanner stringsc2 = new Scanner(System.in);
				System.out.println("Please select a valid ISBN number");
				long isbn = sc1.nextLong();
				//System.out.println(isbn);
				System.out.println("Please select a valid Book you would like to insert");
				String bookobj = stringsc2.nextLine();
				//System.out.println(bookobj);
				Book bookobj1;
				String div2[];
				 String content = bookobj;
				div2 = content.split(",");
				bookobj1 = new Book(div2[0],div2[1],Double.parseDouble(div2[2]),Long.parseLong(div2[3]),div2[4],Integer.parseInt(div2[5]));
				//System.out.println(bookobj);
					bkLst.insertBefore(isbn,bookobj1);
					bkLst.displayContent();
				}catch(Exception e) {
					System.out.println("The entries you are entering are not correct");
				}
				System.out.println("Here is the list");
				bkLst.displayContent();
				break;
				
			case 5:
				Scanner stringsc3 = new Scanner(System.in);
				System.out.println("Please enter two valid isbn numbers");
				long isbn3 = sc1.nextLong();
				long isbn4 = sc1.nextLong();
				System.out.println("Please select a valid Book you would like to insert");
				String bookobj = stringsc3.nextLine();
				//System.out.println(bookobj);
				Book bookobj1;
				String div2[];
				String content = bookobj;
				div2 = content.split(",");
				bookobj1 = new Book(div2[0],div2[1],Double.parseDouble(div2[2]),Long.parseLong(div2[3]),div2[4],Integer.parseInt(div2[5]));
				bkLst.insertBetween(isbn3,isbn4, bookobj1);
				bkLst.displayContent();
				break;
				
			case 6:
				System.out.println("Please enter two valid isbn numbers");
				long isbn = sc1.nextLong();
				long isbn2 = sc1.nextLong();
				bkLst.swap(isbn,isbn2);
				bkLst.displayContent();
				break;
			case 7:
				try {
				bkLst.commit();
				}catch(Exception e) {
					System.out.println("File Could Not be created");
				}
				System.out.println("File created successfully");
				break;
			case 8:
				System.out.println("Program Stops");
				cond = false;
				System.exit(0);
				
			default:
				System.out.println("Please enter a valid entry");
				
				}
			
			}while(cond);
			
			
			
			
	}

}
