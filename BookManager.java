package projekcik;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
	public List<Book> Books = new ArrayList<>();
	private BooksDataBase BooksDB;
	
	public BookManager () {
		BooksDB = new BooksDataBase();
		Books = new ArrayList<Book>();
	}
	
	public void addBook(String NewTitle,String NewAuthor,String NewGenre)throws Exception {
		BooksDB.addBook(NewTitle, NewAuthor, NewGenre);
		Book NewBook = new Book(NewTitle, NewAuthor, NewGenre);
		Books.add(NewBook);
	} 
	
	public Boolean removeBook (String Title) throws Exception {
		Book tempBook = null;
		for (Book p : Books)
			if (p.getTitle().equals(Title)) {
				tempBook = p;
				break;
			}
		if (tempBook != null) {
			removeBook(tempBook);
			return true;
		}
		else
			return false;
	}
	
	public void removeBook (Book Title) throws Exception {
		BooksDB.removeBook(Title);
		Book.remove(Title);
	}
	
	public List<Book> readBooks() throws Exception {
		this.Books = BooksDB.getBook();
		return this.Books;
	}
	
	public List<Book> getBooks() throws Exception {
		if (this.Books == null || this.Books.size() == 0)
			this.Books = BooksDB.getBook();
		return this.Books;
	}
	
	public Book getBooks (String Title) {
		for (Book p : Books)
			if (p.getTitle().equals(Title)) {
				return p;
			}
		return null;
	}

}
