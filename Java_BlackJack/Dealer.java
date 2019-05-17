public class Dealer {
	Card_Deck card = new Card_Deck();
	Result result = new Result();
	private int score = 0;
	private String card1 = card.getDealer_first_card();
	private String card2 = card.getDealer_second_card();
	private String card3 = card.getDealer_third_card();
	
	public int getScore() {
		return score;
	}
	public String getCard1() {
		return card1;
	}
	public void setCard1(String card1) {
		this.card1 = card1;
	}
	public String getCard2() {
		return card2;
	}
	public void setCard2(String card2) {
		this.card2 = card2;
	}
	public String getCard3() {
		return card3;
	}
	public void setCard3(String card3) {
		this.card3 = card3;
	}
	public void dealer_set()
	{
		if(card1 == "A" && card2 == "A")
		{
			card1 = "11";
			card2 = "1";
		}
		if(card1 == "A")
		{
			card1 = "11";
		}
		if(card2 == "A")
		{
			card2 = "11";
		}
		if(card1 == "J" || card1 == "Q" || card1 == "K")
		{
			card1 = "10";
		}
		if(card2 == "J" || card2 == "Q" || card2 == "K")
		{
			card2 = "10";
		}
		score = score + Integer.parseInt(card1);
		score = score + Integer.parseInt(card2);
		if(score <= 16)
		{
			if(card3 == "A" && score < 11)
			{
				card3 = "11";
			}
			else if(card3 == "A")
				card3 = "1";
			if(card3 == "J" || card3 == "Q" || card3 == "K")
			{
				card3 = "10";
			}
			score = score + Integer.parseInt(card3);
		}
		
		//result.setDealer_score(score); 
		/* 기존에 Dealer_set 메소드에서 이 작업을 수행하려 했으나 반환값이 Result 클래스에 잡히지 않아서 어쩔 수 없이 
		   User 클래스에서 추가 작업을 실행하였습니다. */
	}
	
}
