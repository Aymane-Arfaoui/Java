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


public class Book {
	
	private String title;
	private String author;
	private double price;
	private long ISBN;
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
	
	
	public Book(String title, String author, double price, long ISBN, String genre, int year) {
		
		this.title = title;
		this.author = author;
		this.price=price;
		this.ISBN = ISBN;
		this.genre = genre;
		this.year = year;
			
	}
	
	/**
	@param String : title of the book 
	setters and getters methods
	 *  */
	
	//setter methods
	public void setTitle(String ti) {
		title=ti;
		
		
	}
	/**
	@param String : author
	setters and getters methods
	 *  */	
	public void setAuthor(String au) {
		author = au;
	
	}
	
	/**
	@param double : price of the book
	setters and getters methods
	 *  */
	public void setPrice(double pr) {
		price = pr;
	
		/**
		@param long : ISBN of the book 
		setters and getters methods
		 *  */
	}
	
	/**
	@param long : set ISBN for the book
	setters and getters methods
	 *  */
	public void setISBN(long id) {
		ISBN = id;
		
	}
	/**
	@param String ge:set genre for the book
	setters and getters methods
	 *  */
	public void setGenre(String ge) {
		genre = ge;
		
		
	}
	/**
	@param int y : year of the book
	setters and getters methods
	 *  */
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
	public long getISBN() {
		return ISBN;
		
	}
	public String getGenre() {
		return genre;
		
	}
	public int getYear() {
		return year;
		
	}
		
	/**@override toString Method
	 *
	 * 
	 */
	public String toString() {
		return title + ", " + author + ", "+ price + ", "+ ISBN + ", "+ genre + ", "+ year + "\n";
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
	 * @param Object: every class is descendant of object  
	 * 
	 */
		public boolean equals(Object book1) {
			if (book1 == null || getClass() != book1.getClass())
				return false;
			else {
				Book book2 = (Book)book1;
			return 	title.equals(book2.title) && 
					author.equals(book2.author) && price == book2.price &&
					ISBN == book2.ISBN && genre.equals(book2.genre) &&
					year ==book2.year;
			}
		}
		
}
