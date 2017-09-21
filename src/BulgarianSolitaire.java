import java.util.ArrayList;
import java.util.Random;

public class BulgarianSolitaire 
{
	private ArrayList<Integer> board;
	
	public BulgarianSolitaire()
	{
		Random randy = new Random();
		int remaining = 45; // cards in pile
		while(remaining > 0)
		{
			int x = randy.nextInt(remaining) + 1;
			remaining -= x;
			board.add(x);
		}
	}
	
	public BulgarianSolitaire(ArrayList<Integer> board)
	{
		this.board = board;
	}

	/**
	 * Subtracts 1 from each integer in the arraylist
	 * Gets rid of zeroes
	 * Add the amount removed at the end of the arraylist
	 */
	public void move()
	{
		int leftSum = 0;

		for (int i = board.size(); i > 0; i--)
		{
			int a = board.get(i);

			if(a == 0)
			{
				board.remove(i);
			}

			else
			{
				a --;
				board.set(i,a);
				leftSum++;
			}
		}

		board.add(leftSum); // adds the cards left
	}

	/**
	 * Returns if the game is over when all the integers correctly are in order
	 * @return
     */
	public boolean gameOver()
	{
		boolean[] checks = new boolean[8];
		if(board.size() == 9)
		{
			for (int i = 0; i < 9; i++)
			{
				if(board.get(i) == i)
				{
					checks[i] = true;
				}
			}

			for (int i = 0; i < checks.length; i++)
			{
				if(checks[i] == false)
				{
					return false;
				}
			}
		}
	}
	
	public String toString()
	{
		String str = "[";
		for (int i = 0; i < board.size(); i++)
		{
			str += board.get(i) + ", ";
		}

		return str.substring(0,str.length() - 2) + "]";
	}
}
