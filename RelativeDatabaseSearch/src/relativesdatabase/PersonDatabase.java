package relativesdatabase;

import java.util.ArrayList;

public class PersonDatabase {

	private ArrayList<Person> persons;
	private SearchEngine search;

	public String toString()
	{
		String out = "";
		out+= "Database contains: "+this.persons.size()+" people ";
		for(Person p : this.persons)
		{
			out+="\n"+p;
		}
		//out+= this.persons.toString();
		return "---------\n"+out+"\n";
	}

	public PersonDatabase()
	{
		this(new ArrayList<Person>());		
	}

	public SearchEngine getSearchEngine()
	{
		return this.search;
	}

	public PersonDatabase(ArrayList<Person> persons)
	{
		this.setPersons(persons);
		this.search = new SearchEngine(this);
	}

	public ArrayList<Person> getPersons() 
	{
		return persons;
	}

	private void setPersons(ArrayList<Person> persons) 
	{
		this.persons = persons;
	}


	public void add(Person p) 
	{
		this.persons.add(p);	
	}
}
