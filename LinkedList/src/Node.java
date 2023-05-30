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
public class Node {
	
	//attributes of the Node Class
	private Book b;
	private Node next;
	
	//default constructor
	// sets attributes to null
	public Node() {
		b = null;
		next = null;
	}
	
	/** Equals Method
	 * @param Book b: parameter that will take a book  
	 * @param Node next: parameter that will take a node  
	 * 
	 */
	public Node(Book b, Node next) {
		this.b = b;
		this.next = next;
	}
	
	/** Equals Method
	 * @param Book b: set Book method
	 * 
	 */
	public void setBook(Book sb) {
		b = sb;
	}
	/** Equals Method
	 * @param Node next: set Node method
	 * 
	 */
	
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
