public class Result {
	private int user_score;
	private int dealer_score;
	private int money;
	private int betting;
	
	public int getBetting() {
		return betting;
	}
	public void setBetting(int betting) {
		this.betting = betting;
		if(betting < 10 || betting > money)
		{
			System.out.println("Rulebreaker ... ");
			System.exit(0);
		}
		this.money = this.money - betting;
		System.out.println("Left Money : " + this.money);
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getUser_score() {
		return user_score;
	}
	public void setUser_score(int user_score) {
		this.user_score = user_score;		
	}
	public int getDealer_score() {
		return dealer_score;
	}
	public void setDealer_score(int dealer_score) {
		this.dealer_score = dealer_score;
	}
	
	public void print()
	{
		System.out.println("Your Score : " + this.user_score + ", Dealer Score : " + this.dealer_score);
		
		if(user_score == 21 && dealer_score == 21)
		{
			System.out.println("Push. (=Draw)");
			this.money = this.money + this.betting;
		}
		if(user_score == 21)
		{
			System.out.println("Blackjack!");
			this.money = this.money + (3 * this.betting / 2); //단순히 이기는 것보다 더 많이 받고자 설정
		}
		else if(dealer_score == 21)
		{
			System.out.println("Dealer Blackjack! You lose..");
		}
		else if(user_score > 21)
		{
			System.out.println("Bust! You lose..");
		}
		else if(dealer_score > 21)
		{
			System.out.println("Dealer Bust! You win!");
			this.money = this.money + 2 * this.betting;
		}
		else if(user_score > dealer_score)
		{
			System.out.println("You win!");
			this.money = this.money + 2 * this.betting;
		}
		else if(user_score < dealer_score)
		{
			System.out.println("You lose..");
		}
		else
		{
			System.out.println("Push. (=Draw)");
			this.money = this.money + this.betting;
		}
		System.out.println("Left Money : " + this.money);
	}
}
