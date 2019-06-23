package Blackjack;

public class Result {
	private int p_score;
	private int d_score;
	private String message;
	
	public Result(int player_score, int dealer_score)
	{
		this.p_score = player_score;
		this.d_score = dealer_score;
	}
	
	public String discrimination()
	{
		if(p_score == 21)
		{
			message = "Player BlackJack, Congratulations!";
		}
		else if(d_score == 21)
		{
			message = "Dealer BlackJack..";
		}
		else if(p_score > 21)
		{
			message = "Player Bust! You lose..";
		}
		else if(d_score > 21)
		{
			message = "Dealer Bust! You Win!";
		}
		else if(p_score > d_score)
		{
			message = "You Win!";
		}
		else if(p_score < d_score)
		{
			message = "You lose..";
		}
		else
			message = "Push.";
		
		
		return message;
	}
}
