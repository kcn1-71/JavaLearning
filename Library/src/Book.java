public class Book extends publication 
{	
	String author; 
	String publishers;
	
	public Book (String name, int year, int shelf, String author, String publishers)
	{
		super(name, year, shelf);
		this.author=author;
		this.publishers=publishers;
	}
	
	public void Print()
	{
		System.out.print("Название:" + name + "\n" +
							  "Год:" + year + "\n" +
							"Полка:" + shelf + "\n" +
							"Автор:" + author + "\n" + 
					  "Издтельство:" + publishers + "\n");
	}
}
