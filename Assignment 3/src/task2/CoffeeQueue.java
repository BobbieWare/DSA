package task2;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class CoffeeQueue
{
	private LinkedList<Customer>[] lines;
	private int hour;
	private int minute;	

	public CoffeeQueue()
	{
		this.lines = new LinkedList[4];
		this.hour = 8;
		this.minute = 0;
		for (int i = 0; i < lines.length; i++)
		{
			lines[i] = new LinkedList<Customer>();
		}
	}

	private String showLine(LinkedList<Customer> input)
	{
		LinkedList<Customer> input2 = new LinkedList<Customer>(input);

		String output = "O] |";

		for (int i = 0; i < 10; i++)
		{
			if (input2.poll() != null)
			{
				output += " O |";
			}
			else
			{
				output += "   |";
			}
		}

		if (input == lines[3])
		{
			return output + "\n";
		}
		return output + "\n                                           |\n";
	}

	private int noInQueue(LinkedList<Customer> input)
	{
		int no = 0;
		LinkedList<Customer> input2 = new LinkedList<Customer>(input);

		for (int i = 0; i < 10; i++)
		{
			if (input2.poll() != null)
			{
				no++;
			}
			else
			{
				return no;
			}
		}

		return no;
	}

	private int queuePick()
	{
		int no = 0;
		
		if (noInQueue(lines[0]) >= 10)
		{
			no = 1;
		}

		if (noInQueue(lines[0]) == 10 && noInQueue(lines[1]) == 10 && noInQueue(lines[2]) == 10
				&& noInQueue(lines[3]) == 10)
		{
			return 5;
		}

		if (noInQueue(lines[1]) < 10 && noInQueue(lines[0]) > noInQueue(lines[1]))
		{
			no = 1;
		}
		if (noInQueue(lines[2]) < 10 && noInQueue(lines[no]) > noInQueue(lines[2]))
		{
			no = 2;
		}
		if (noInQueue(lines[3]) < 10 && noInQueue(lines[no]) > noInQueue(lines[3]))
		{
			no = 3;
		}

		return no;
	}

	public void newCustomer(String name, String order)
	{
		if (queuePick() == 5)
		{
			System.out.println("The coffee show appears to be full and the customer doesn't enter the store.");
		}
		else
		{
			int wait = (int) (Math.random() * 4 + 2);

			lines[queuePick()].add(new Customer(name, order, wait));
		}
	}
	
	private void customerAddTime(int i) 
	{
		if (lines[i].peek() != null)
		{
			if (lines[i].peek().getOrderTime() - 1 == 0)
			{
				System.out.println("The customer: " + lines[i].poll() + " left the store \n");
			}
			else
			{
				lines[i].peek().setOrderTime(lines[i].peek().getOrderTime() - 1);
			} 
		}
	}
	
	public void addTime()
	{
		minute++;
		
		for (int i = 0; i < 4; i++)
		{
			customerAddTime(i);
		}
		
		if (minute == 60)
		{
			hour++;
			minute = 0;
		}
		if (hour == 13)
		{
			hour = 1;
		}
			
	}

	@Override
	public String toString()
	{
		String output =   "                      ~-_\n" 
						+ "                     _-~\n" 
						+ "                   c|_|   Time:" + hour + ":" + minute + "\n"
						+ "____________________________________________\n" 
						+ "                                           |\n"
						+ showLine(lines[0]) + showLine(lines[1]) + showLine(lines[2]) + showLine(lines[3])
						+ "___________________________________________|\n";

		return output;
	}
}
