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
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class BookList {
	
/**
 * 
 * 
 * 
 * @author aymanearfaoui
 *
 *
 *Inner Node Class
 */
private class Node {
	
	//attributes of the Node Class
	private Book b;
	private Node next;
	
	//default constructor
	// sets attributes to null
	public Node() {
		b = null;
		next = null;
	}
	
	//parameterized constructor
	public Node(Book b, Node next) {
		this.b = b;
		this.next = next;
	}
	
	public void setBook(Book sb) {
		b = sb;
	}
	
	public void setNext(Node nb) {
		next = nb;
	}
	
	public Book getBook() {
		return b;
	}
	public Node getNext() {
		return next;
	}
	
	
}
	
	private Node head;
	
	//default constructor that initializes head to null
	public BookList() {
		head = null;
	}
	
	//default constructor that initializes head to null
	public Node getHead() {
		return head;
	}
		
	
	
	//AddtoStart method that adds a book to the node
	
	/**

	Adds the given book to the start of the circular linked list.
	A new node is created with the given book and it is set as the head of the circular list.
	@param a the book to be added to the start of list
	*/
	public void addToStart(Book a) {
		Node n = new Node(a, head);
		head = n;
		n = null;	
	}
	
	/**

	Stores the records of books published in the given year in a text file.
	creates an error file with the year it is created and the invalid year record is written to it.
	@param year the year for which the book records need to be stored
	*/
	
	public void storeRecordsByYear(int year) {
		Node temp = head;
		if(year <= 2018) {
		while(temp != null && temp.getNext() !=null) {
			if(temp.getBook().getYear() == year) {
				//create the file with the corresponding years
				PrintWriter pw = null;
				String File = Integer.toString(year)+ ".txt";
				
				try 
				{
					pw = new PrintWriter(new FileOutputStream(File,true));
				}
				catch(FileNotFoundException e)
				{
					System.out.println("Could not create the file");
				}
				System.out.println("File Created Successfully");
				pw.write(temp.getBook().toString() +"\n");
				pw.close();
			}
			
			temp = temp.getNext();
			}
		}else if(temp.getBook().getYear() == year) {
			
			System.out.println("Invalid Year");
			PrintWriter pw = null;
			String File = Integer.toString(year)+ "Err.txt";
			try 
			{
				pw = new PrintWriter(new FileOutputStream(File,true));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Could not create the file");
			}
			pw.write(temp.getBook().toString() +"\n");
		}
				
	}
	
	/**

	Inserts the given book before the node with the specified ISBN number.
	@param isbn the ISBN number of the node before which the book needs to be inserted
	@param b the book to be inserted into the circular linked list
	@return true if the insertion is good, false otherwise
	*/
	public boolean insertBefore(long isbn, Book b) {
		Node current = head;
		Node before = null;
		
		// go through the whole linklist
		while(current != null && current.getBook().getISBN() != isbn) {
			before = current;
			current = current.getNext();
		}
		// suppose now we found the node we needed 
		if(current != null && current.getNext()!=null) {
			Node bookBefore = new Node(b, current);
			if(before == head) {
				head.setNext(bookBefore);
			}else {
				before.setNext(bookBefore);
			}
			return true;
		}else 
			return false;
		
	}
	/**

	Inserts the given book between two nodes with the specified ISBN numbers.
	Traverses through the circular linked list to find the nodes with the given ISBN numbers.
	If found, a new node is created with the given book and inserted between the two nodes.
	Returns true if insertion is successful, false otherwise.
	@param isbn1 the ISBN number of the first node between which the book needs to be inserted
	@param isbn2 the ISBN number of the second node between which the book needs to be inserted
	@param b the book to be inserted into the circular linked list
	@return true if the insertion is successful, false otherwise
	*/

	public boolean insertBetween(long isbn1, long isbn2, Book b) {
		
		// go through the link list 
		
		Node current = head;
		Node before = null;
		while(current != null && (current.getBook().getISBN() !=  isbn1 && (current.getNext().getBook().getISBN() !=  isbn2 )))
		{
			before = current;
			current  = current.getNext();
		}
		
		if(current != null) {
			Node  Node2 = new Node(b, current);
			if(current.getBook().getISBN() ==  isbn1 && (current.getNext().getBook().getISBN() ==  isbn2 )){
				Node first = current;
				Node second = current.getNext();
				first = Node2;
				second  = Node2;	
			}
			return true;
		}else 
			return false;	
	}
	
	/**
	Displays the content of the circular linked list.
	Traverses through the list and prints the details of each book node.
	If the list is empty, prints a message indicating that there is nothing to display.
	*/
	
	public void displayContent() {
		Node temp = head;
		if (temp == null)
			System.out.println("There is nothing to display; list is empty. :(");
		else {
			System.out.println("Here is the content of the list: ");
			while(temp != null) {
				System.out.println(temp.getBook() + " ===>");
				temp = temp.getNext();
			}
			System.out.print("X");
		}
		
	}
	
	//delete consecutive sequence 
	
	/**

	Deletes consecutive repeated records in the circular linked list.
	Traverses through the list and deletes any consecutive book nodes that have the same details
	@return true if deletion is successful
	*/
	public boolean delConsecutiveRepeatedRecords() {
		Node temp =  head;
		Node next = head.getNext();
		System.out.println(next.getBook().getAuthor().equals(next.getNext().getBook().getAuthor()));
		while(next !=null) {
			while(next.getBook().equals(temp.getBook()) && next.getNext() != null) {
				next = next.getNext();	
				
			}
			temp.setNext(next);
			temp = next;
			next = temp.getNext();
		}
		return true;
	}
	public BookList extractAuthList(String aut) {
		BookList b = new BookList();
		Node temp = head;
		while (temp != null) {
			if(temp.getBook().getAuthor().equals(aut)) {
				b.addToStart(temp.getBook());
				
			}
			
			temp = temp.getNext();
		}
		b.displayContent();
		return b;
		
	}
	
	/**

	Swaps the positions of two nodes with the given ISBN values.
	@param isbn1 the ISBN of the first node to be swapped
	@param isbn2 the ISBN of the second node to be swapped
	@return true if the swap is successful, false otherwise
	*/
	
	public boolean swap(long isbn1, long isbn2) {
		
		Node temp = head;
		Node temp2 = head;
		
		Node tempnext = temp.getNext();
		
		while(temp !=null) {
			if(temp.getBook().getISBN() != isbn1 || temp.getBook().getISBN() != isbn2) {
				displayContent();
				System.out.println("No change");
			}else if (temp.getBook().getISBN() == isbn1) {
				if(temp2.getNext().getBook().getISBN() == isbn2) {
					temp= temp2.getNext();
					tempnext =temp;
					break;
				}
			}else if (temp.getBook().getISBN() == isbn1) {
				while(temp.getNext() != null) {
					if(temp.getBook().getISBN() == isbn2) {
						temp = temp.getNext();
						tempnext = temp;
					}
				}
			}
			break;
			
	} 
		temp = temp.getNext();
		return false;
	
	}	
	
	/*public String PrintInfo() {
		Scanner sc = new Scanner(System.in);
		BookList a = new BookList();
		Book books = null;
		String []div;
		while(sc.hasNextLine()) {
			 String content = sc.nextLine();
			 div = content.split(",");
			 books = new Book(div[0],div[1],Double.parseDouble(div[2]),Long.parseLong(div[3]),div[4],Integer.parseInt(div[5]));
			 a.addToStart(books);
			 
		}
		
		 
	}*/
	
	/**

	Writes the content of the linked list to a file named "Update_Books.txt".
	@throws FileNotFoundException if the file cannot be created or opened
	*/
	
		public void commit() {
			PrintWriter pw = null;
			Scanner sc = new Scanner(System.in);
			Node temp = head;
			String s;
			
			try {
				pw = new PrintWriter(new FileOutputStream("Update_Books.txt"));
			}catch(FileNotFoundException e) {
				System.out.println("Could not open/create the file to write to. "
						+ " Please check for problems such as directory permission"
						+ " or no available memory.");
			}
			if (temp == null) {
				s = "Nothing to print out";
				pw.write(s);
			}else {
				while(temp != null) {
					pw.write(temp.getBook().toString() +"\n" + " => ");
					temp = temp.getNext();
				}
			}
			
			pw.close();
			System.exit(0);		
			
		}
		
}
