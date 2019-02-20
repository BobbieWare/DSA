package relativesdatabase;

public class SearchEngine {

	private PersonDatabase pdb;

	//--------------------------------------------------------------------------------------------------------------
	public PersonDatabase byRelative(String relativeName)
	{
		PersonDatabase results = new PersonDatabase();

		for(Person p : pdb.getPersons())
		{
			if(p.getRelatives().toLowerCase().contains(relativeName.toLowerCase()))
			{
				results.add(p);
			}
		}
		return results;
	}
	//--------------------------------------------------------------------------------------------------------------
	public PersonDatabase byName(String name)
	{
		PersonDatabase results = new PersonDatabase();

		for(Person p : pdb.getPersons())
		{
			if(p.getName().toLowerCase().contains(name.toLowerCase()))
			{
				results.add(p);
			}
		}
		return results;
	}
	//--------------------------------------------------------------------------------------------------------------
	public SearchEngine(PersonDatabase pdb)
	{
		this.pdb = pdb;
	}
	//--------------------------------------------------------------------------------------------------------------
	public PersonDatabase bornBefore(int year) {
		PersonDatabase results = new PersonDatabase();

		for(Person p : pdb.getPersons())
		{
			if(p.getBirthYear()<year)
			{
				results.add(p);
			}
		}
		return results;	
	}
	//--------------------------------------------------------------------------------------------------------------
	public PersonDatabase bornOn(int year)
	{
		return this.bornBetween(year,year);
	}
	//--------------------------------------------------------------------------------------------------------------
	public PersonDatabase bornBetween(int startYear,int endYear) 
	{
		PersonDatabase results = new PersonDatabase();

		for(Person p : pdb.getPersons())
		{
			if((p.getBirthYear()>=startYear)&&(p.getBirthYear()<=endYear))
			{
				results.add(p);
			}
		}
		return results;	
	}
	//--------------------------------------------------------------------------------------------------------------
	public PersonDatabase bornAfter(int year) {
		PersonDatabase results = new PersonDatabase();

		for(Person p : pdb.getPersons())
		{
			if(p.getBirthYear()>year)
			{
				results.add(p);
			}
		}
		return results;	
	}
	//--------------------------------------------------------------------------------------------------------------
}
