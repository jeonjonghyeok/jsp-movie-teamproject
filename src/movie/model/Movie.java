package movie.model;


public class Movie {

	public int id;
	public String name;

	public Movie(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	
}
