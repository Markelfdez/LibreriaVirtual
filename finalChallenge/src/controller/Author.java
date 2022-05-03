package controller;

import java.time.LocalDate;

public class Author {
	private String codAu;
	private String nameA;
	private String surname;
	private LocalDate birthDate;
	private LocalDate deathDate;
	private boolean active;
	
	
	
	public Author() {
		super();
	}

	public Author(String codAu, String nameA, String surname, LocalDate birthDate, LocalDate deathDate,
			boolean active) {
		super();
		this.codAu = codAu;
		this.nameA = nameA;
		this.surname = surname;
		this.birthDate = birthDate;
		this.deathDate = deathDate;
		this.active = active;
	}

	public String getCodAu() {
		return codAu;
	}
	
	public void setCodAu(String codAu) {
		this.codAu = codAu;
	}
	
	public String getNameA() {
		return nameA;
	}
	
	public void setNameA(String nameA) {
		this.nameA = nameA;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public LocalDate getDeathDate() {
		return deathDate;
	}
	
	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Author [codAu=" + codAu + ", nameA=" + nameA + ", surname=" + surname + ", birthDate=" + birthDate
				+ ", deathDate=" + deathDate + ", active=" + active + "]";
	}
	
	
}
