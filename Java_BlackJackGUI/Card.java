package Blackjack;

public class Card {
	int number, value, id;
	String shape, name, symbol;
	boolean cardUsed = false;
	
	public Card(int number, String shape, int id)
	{
		this.number = number;
		this.shape = shape;
		this.id = id;
		if(number < 11) 
		{
			symbol = Integer.toString(number);
			name = Integer.toString(number);
			value = number;
		}
		else if(number == 11)
		{
			symbol = "J";
			name = "JACK";
			value = 10;
		}
		else if(number == 12)
		{
			symbol = "Q";
			name = "QUEEN";
			value = 10;
		}
		else if(number == 13)
		{
			symbol = "K";
			name = "KING";
			value = 10;
		}
		else
		{
			symbol = "A";
			name = "ACE";
			value = 11;
		}
	}
}