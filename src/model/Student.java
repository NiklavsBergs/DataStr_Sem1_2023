package model;

public class Student implements Comparable<Student>{
	private long id;
	private String name;
	private String surname;
	private Faculty faculty;
	private String personCode;
	
	private static long idCounter = 0;
	
	public Student() {
		setId();
		setName("Unknown");
		setSurname("Unknown");
		setFaculty(Faculty.other);
		setPersonCode("000000-00000");
	}
	
	public Student(String name, String surname, Faculty faculty, String personCode) {
		setId();
		setName(name);
		setSurname(surname);
		setFaculty(faculty);
		setPersonCode(personCode);
	}

	public long getId() {
		return id;
	}
	
	public void setId() {
		id = idCounter;
		idCounter++;
	}

	public String getName() {
		return name;
	}

	//Regex [A-ZĒŪĪĻĶĢŠĀČŅŽ]{1}[a-zēūīļķģšāčņž]+[ ]?([A-ZĒŪĪĻĶĢŠĀČŅŽ]{1}[a-zēūīļķģšāčņž]+)?
	public void setName(String name) {
		if(name!=null && name.matches("[A-ZĒŪĪĻĶĢŠĀČŅŽ]{1}[a-zēūīļķģšāčņž]+[ ]?([A-ZĒŪĪĻĶĢŠĀČŅŽ]{1}[a-zēūīļķģšāčņž]+)?")) {
			this.name = name;
		}
		else {
			this.name = "Unknown";
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if(surname!=null && surname.matches("[A-ZĒŪĪĻĶĢŠĀČŅŽ]{1}[a-zēūīļķģšāčņž]+[-]?([A-ZĒŪĪĻĶĢŠĀČŅŽ]{1}[a-zēūīļķģšāčņž]+)?")) {
			this.surname = surname;
		}
		else {
			this.surname = "Unknown";
		}
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		if(personCode!=null && personCode.matches("[0-9]{6}[-][0-9]{5}")) {
			this.personCode = personCode;
		}
		else {
			this.personCode = "000000-00000";
		}
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		if(faculty!=null) {
			this.faculty = faculty;
		}
		else {
			faculty = Faculty.other;
		}
		
	}
	
	public String toString() {
		return "" + id + ": " + name + " " + surname + ", " + personCode + ", " + faculty;
	}

	@Override
	public int compareTo(Student o) {
		if(surname.charAt(0) > o.surname.charAt(0)) {
			return 1;
		}
		else if (surname.charAt(0) < o.surname.charAt(0)) {
			return -1;
		}
		else {
			return 0;
		}
		
	}
	
	
	
}
