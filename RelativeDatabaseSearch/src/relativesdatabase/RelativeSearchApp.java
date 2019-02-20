package relativesdatabase;

public class RelativeSearchApp {

	public static void main(String[] args) 
	{
		
		Person p1 = new Person("Ken",1962,"Bob,Sue,Jay,Kevin Bacon");
		Person p2 = new Person("Alan",1920,"Earl,Bob,Alice,Kevin Bacon,Clint Eastwood");
		Person p3 = new Person("Zoe",1989,"Jason,Liam,Susan");
		Person p4 = new Person("Andrew",2017,"Biff,Marty,George,Bob");
		Person p5 = new Person("Jane",2010,"Jack,Jill,Joe,Clint Eastwood");
		
		PersonDatabase pdb = new PersonDatabase();
		
		pdb.add(p1);
		pdb.add(p2);
		pdb.add(p3);
		pdb.add(p4);
		pdb.add(p5);
		
		System.out.println("Initial database");
		System.out.println(pdb);
		
		System.out.println("Search: Find any person related to Bob");
		PersonDatabase results = pdb.getSearchEngine().byRelative("Bob");
		System.out.println(results);
		
		System.out.println("Search: Find any person related to Bob and who was born before 1970");
		results = results.getSearchEngine().bornOn(1962);
		System.out.println(results);
		
		System.out.println("Search: Find any person related to Bacon and Eastwood");
		results = pdb.getSearchEngine().byRelative("Bacon");
		results = results.getSearchEngine().byRelative("Eastwood");
		System.out.println(results);
		
		
		
		

	}

}
