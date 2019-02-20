package relativesdatabase;

public class Person {
	private String name;
	private String relatives;
	private int birthYear;

	
	public String toString()
	{
		return this.name + " "+ this.birthYear+ " "+relatives;
	}
	
	public Person(String name, int birthYear,String relatives) 
	{
		this.name = name;		
		this.birthYear = birthYear;
		this.relatives = relatives;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelatives() {
		return relatives;
	}
	public void setRelatives(String relatives) {
		this.relatives = relatives;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}



}
