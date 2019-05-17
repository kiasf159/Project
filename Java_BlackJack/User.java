import java.util.Scanner;

public class User {
	Card_Deck card = new Card_Deck();
	private int score = 0;
	private String card1 = card.getUser_first_card();
	private String card2 = card.getUser_second_card();
	private String card3 = card.getUser_third_card();
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score) {
		this.score = this.score + score;
	}
		
	public String Change(String card)
	{
		card = "10";
		return card;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		User user = new User();
		Dealer dealer = new Dealer();
		Result result = new Result();
		
		int money = 0, betting = 0, answer, temp_score = 0, add_card;
		System.out.println("How much do you have? (If money is less then Zero, Game Over.) : ");
		money = input.nextInt();
		result.setMoney(money);
		while(result.getMoney() > 0)
		{
			System.out.printf("How much do you bet? (Minimum = 10) : ");
			betting = input.nextInt();
			result.setBetting(betting);
		
			System.out.println("내가 받은 카드 : " + user.card1 + ", " + user.card2);
			if(user.card1 == "A")
			{
				System.out.println("A를 11로 쓰시겠습니까? (Yes = 1, No = Integer except 1) : ");
				answer = input.nextInt();
				if(answer == 1)
					user.card1 = "11";
				else
					user.card1 = "1";
			}
			if(user.card1 == "J" || user.card1 == "Q" || user.card1 == "K")
			{
				user.card1 = user.Change(user.card1);
			}
		
			if(user.card2 == "A")
			{
				System.out.println("A를 11로 쓰시겠습니까? (Yes = 1, No = Integer except 1) : ");
				answer = input.nextInt();
				if(answer == 1)
					user.card2 = "11";
				else
					user.card2 = "1";
			}
			if(user.card2 == "J" || user.card2 == "Q" || user.card2 == "K")
			{
				user.card2 = user.Change(user.card2);
			}
			
			temp_score = Integer.parseInt(user.card1);
			user.setScore(temp_score);
			temp_score = Integer.parseInt(user.card2);
			user.addScore(temp_score);
		
			System.out.println("Dealer's first card : " + dealer.getCard1());
			System.out.println("Hit or Stand? (Hit = 1, Stand = Integer except 1) : ");
			add_card = input.nextInt();
			if(add_card == 1)
			{
				System.out.println("추가로 받은 카드 : " + user.card3);
				if(user.card3 == "A")
				{
					System.out.println("A를 11로 쓰시겠습니까? (Yes = 1, No = Integer except 1) : ");
					answer = input.nextInt();
					if(answer == 1)
						user.card3 = "11";
					else
						user.card3 = "1";
				}
				if(user.card3 == "J" || user.card3 == "Q" || user.card3 == "K")
				{
					user.card3 = user.Change(user.card3);
				}
				temp_score = Integer.parseInt(user.card3);
				user.addScore(temp_score);
			
			}
			result.setUser_score(user.score);
			dealer.dealer_set();
			temp_score = dealer.getScore();
			result.setDealer_score(temp_score);
			result.print();
		}
		System.out.println("You don't have money..");
	}
}
