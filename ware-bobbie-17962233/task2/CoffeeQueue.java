package task2;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class CoffeeQueue
{
	private LinkedList<Customer>[] lines;
	private int hour;
	private int minute;	
	private int maxLineLength;

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
	// pre: a valid line of customers can be empty.
	// post: a visual representation of customers in a specific line.
	{
		LinkedList<Customer> input2 = new LinkedList<Customer>(input);

		String output = "O] |";

		for (int i = 0; i < maxLineLength; i++)
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
	// pre: a valid queue of length 0-maxLineLength
	// post: returns the number of customers in that line.
	{
		int no = 0;
		LinkedList<Customer> input2 = new LinkedList<Customer>(input);

		for (int i = 0; i < maxLineLength; i++)
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
	// post: returns the index of the shortest length line.
	{
		int no = 0;
		
		if (noInQueue(lines[0]) >= maxLineLength)
		{
			no = 1;
		}

		if (noInQueue(lines[0]) == maxLineLength && noInQueue(lines[1]) == maxLineLength && noInQueue(lines[2]) == maxLineLength
				&& noInQueue(lines[3]) == maxLineLength)
		{
			return 5;
		}

		if (noInQueue(lines[1]) < maxLineLength && noInQueue(lines[0]) > noInQueue(lines[1]))
		{
			no = 1;
		}
		if (noInQueue(lines[2]) < maxLineLength && noInQueue(lines[no]) > noInQueue(lines[2]))
		{
			no = 2;
		}
		if (noInQueue(lines[3]) < maxLineLength && noInQueue(lines[no]) > noInQueue(lines[3]))
		{
			no = 3;
		}

		return no;
	}

	public void newCustomer(String name, String order)
	// pre: The desired name and order.
	// post: New customer is added to the shortest line.
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
	// post: progresses time for a given line, takes 1 wait time away for customer who had ordered and removes them if time will be 0.
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
	// post: progresses time for all queues and deals with 12 hours and 60 minute time.
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
	// post: returns a visual representation of the entire store.
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
