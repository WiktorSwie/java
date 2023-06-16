
public class Book {
String Title;
	
	public
	Book(String Title, String Author, String Genre) {
		this.Title=Title;
		this.Author=Author;
		this.Genre=Genre;
	}


	public Book() {
		
	}


	public String getTitle() {
		return Title;
	}

	
	public void setTitle(String Title) {
		this.Title = Title;
	}
	

	public String getAuthor() {
		return Author;
	}


	public void setAuthor(String Author) {
		this.Author = Author;
	}

	public String Author;
	
	int id; 
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
		
	}
	
	public String getGenre() {
		return Genre;
		
	}

	public void setGenre(String Genre) {
		this.Genre = Genre;
	
	}
	public String Genre;

	public static void remove(Book Title) {
		
	}

}