package controller;

public class Genre {
	//TODO PREGUNTAR PA PONER FINAL AL CODG
	
	private int codG;
	private String nameG;
	private boolean active;
	
	
	
	public Genre(int codG, String nameG, boolean active) {
		super();
		this.codG = codG;
		this.nameG = nameG;
		this.active = active;
	}
	
	
	
	public Genre() {
		super();
	}



	public int getCodG() {
		return codG;
	}
	public void setCodG(long l) {
		this.codG = (int) l;
	}
	public String getNameG() {
		return nameG;
	}
	public void setNameG(String nameG) {
		this.nameG = nameG;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}



	@Override
	public String toString() {
		return "Genre [codG=" + codG + ", nameG=" + nameG + ", active=" + active + "]";
	}



	public void add(Genre genre) {
		// TODO Auto-generated method stub
		
	}
	
	

}
