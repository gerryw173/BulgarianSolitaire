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

	/**
	 * Sets the parameter as an arraylist of integers
	 * @param board
	 */
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
		int sum = 0; // sum of the all the cards removed

		for (int i = board.size() - 1; i >= 0; i--)
		{
			int a = board.get(i);
			a--; // removes card from the integer
			board.set(i,a); //replaces current integer with a - 1
			sum++;

			if(a == 0)  // checks if an integer is zero and then removes it from the arraylist
			{
				board.remove(i);
			}
		}

		board.add(sum); // adds int that is equal to the cards left

	}

	/**
	 * Returns if the game is over when all the integers correctly are in order
	 * @return
     */
	public boolean gameOver()
	{
		int[] answer = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		if(board.size() == 9)
		{
			for (int i = 0; i < answer.length; i++)
			{
				if (!board.get(i).equals(answer[i])) // if the board's int at index of i is not equal to answer's int at i
				{
					return false;
				}
			}

			return true; // game is over if the board is equal to answer
		}

		return false;
	}

	/**
	 * System out prints the whole arraylist
	 * @return
	 */
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
