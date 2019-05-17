import java.util.Random;

public class Card_Deck {
	Random random = new Random();
	
	String card[] = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private String user_card1 = card[random.nextInt(12)];
	private String user_card2 = card[random.nextInt(12)];
	private String user_card3 = card[random.nextInt(12)];
	private String dealer_card1 = card[random.nextInt(12)];
	private String dealer_card2 = card[random.nextInt(12)];
	private String dealer_card3 = card[random.nextInt(12)];
	
	public String getUser_first_card()
	{
		return user_card1;
	}
	
	public String getUser_second_card()
	{
		return user_card2;
	}
	
	public String getUser_third_card()
	{
		return user_card3;
	}
	
	public String getDealer_first_card()
	{
		return dealer_card1;
	}
	
	public String getDealer_second_card()
	{
		return dealer_card2;
	}
	
	public String getDealer_third_card()
	{
		return dealer_card3;
	}
}
