package Blackjack;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
	ArrayList<Card> cards = new ArrayList<Card>();
	ArrayList<Card> playercards = new ArrayList<Card>();
	ArrayList<Card> dealercards = new ArrayList<Card>();
	
	//game phases
	boolean bool_hit_stay = true;
	boolean bool_dealer_turn = false;
	boolean bool_play_more = false;
	boolean bool_A_question = false;
	boolean A_answer = false;
	
	//questions / answers
	String A_question = "Would you wanna use 'A' as 11?";
	String play_more_question = "Play more? ";
	String message = " ";
	//calculate sum
	int player_sum = 0;
	int dealer_sum = 0;
	
	//bgcolor
	Color bgcolor = new Color(39, 119, 20);
	Color colorButton = new Color(64+7, 176+8, 16*15);
	Color colorButton2 = new Color(16*11+14, 21, 80);
	Font fontButton = new Font("Arial", Font.PLAIN, 30);
	Font shape_font = new Font("Times New Roman", Font.ITALIC, 20);
	Font card_font = new Font("Times New Roman", Font.BOLD, 40);
	Font question_font = new Font("Arial", Font.PLAIN, 30);
	Font result_font = new Font("Times New Roman", Font.BOLD, 25);
	int width = 1280;
	int height = 800;
	
	//button
	JButton bHit = new JButton();
	JButton bStay = new JButton();
	JButton bYes = new JButton();
	JButton bNo = new JButton();
	JButton bYes2 = new JButton(); //discriminate A
	JButton bNo2 = new JButton();
	
	//grid positions and dimensions
	int gridX = 50;
	int gridY = 50;
	int gridW = 900;
	int gridH = 400;
	
	//card dimensions and spacing
	int cardSpacing = 10;
	int cardEdge = 10;
	int CardW = gridW/6;
	int CardH = gridH/2;
	int CardAW = CardW - 2 * cardSpacing;
	int CardAH = CardH - 2 * cardSpacing;
	
	//totals/hit/stay grid positions and dimensions
	int msX = gridX + gridW + 50;
	int msY = gridY;
	int msW = gridW - 670;
	int msH = gridH;
	
	//question grid yes or no
	int quX = msX;
	int quY = msY + msH + 50;
	int quW = msW;
	int quH = 200;
	
	int rand = new Random().nextInt(52); //id value 0 ~ 51
	
	public GUI() {
		this.setTitle("Welcome To BlackJack");
		this.setSize(width, height);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Background bg = new Background();
		this.setContentPane(bg);
		this.setLayout(null);
		
		ActHit aHit = new ActHit();
		bHit.addActionListener(aHit);
		bHit.setBounds(msX + 55, msY + 60, 120, 80);
		bHit.setBackground(colorButton2);
		bHit.setFont(fontButton);
		bHit.setText("Hit");
		bg.add(bHit);
		
		ActStay aStay = new ActStay();
		bStay.addActionListener(aStay);
		bStay.setBounds(msX + 55, msY + 260, 120, 80);
		bStay.setBackground(colorButton);
		bStay.setFont(fontButton);
		bStay.setText("Stay");
		bg.add(bStay);
		
		ActYes aYes = new ActYes();
		bYes.addActionListener(aYes);
		bYes.setBounds(quX + 10, quY + 110, 100, 80);
		bYes.setBackground(colorButton);
		bYes.setFont(fontButton);
		bYes.setText("Yes");
		bg.add(bYes);
		
		ActNo aNo = new ActNo();
		bNo.addActionListener(aNo);
		bNo.setBounds(quX + 120, quY + 110, 100, 80);
		bNo.setBackground(colorButton2);
		bNo.setFont(fontButton);
		bNo.setText("No");
		bg.add(bNo);
		
		this.setVisible(true);
		
		String shape1 = "";
		int idSetter = 0;
		for(int i = 0; i < 4; i++)
		{
			if(i == 0)
			{
				shape1 = "Spades";
			}
			else if(i == 1)
			{
				shape1 = "Diamonds";
			}
			else if(i == 2)
			{
				shape1 = "Hearts";
			}
			else
			{
				shape1 = "Clubs";
			}
			for(int j = 2; j < 15; j++)
			{
				cards.add(new Card(j, shape1, idSetter));
				idSetter++;
			}
		}
		//create the cards
		rand = new Random().nextInt(52);
		playercards.add(cards.get(rand));
		cards.get(rand).cardUsed = true;
		
		rand = new Random().nextInt(52);
		while(true)
		{
			if(cards.get(rand).cardUsed == false)
			{
				dealercards.add(cards.get(rand));
				cards.get(rand).cardUsed = true;
				break;
			}
			else
			{
				rand = new Random().nextInt(52);
			}
		}
		
		rand = new Random().nextInt(52);
		while(true)
		{
			if(cards.get(rand).cardUsed == false)
			{
				playercards.add(cards.get(rand));
				cards.get(rand).cardUsed = true;
				break;
			}
			else
			{
				rand = new Random().nextInt(52);
			}
		}
		
		rand = new Random().nextInt(52);		
	}
	
	//init display
	public void refresh()
	{
		if(bool_hit_stay == true)
		{
			bHit.setVisible(true);
			bStay.setVisible(true);
			bYes.setVisible(false);
			bNo.setVisible(false);
		}
		else if (bool_dealer_turn == true)
		{
			bHit.setVisible(false);
			bStay.setVisible(false);
			bYes.setVisible(true);
			bNo.setVisible(true);
		}
		
		//sum
		int sum1 = 0, sum2 = 0;
		
		
		for (Card c : playercards)
		{
			sum1 = sum1 + c.value;
		}
		player_sum = sum1;
		for (Card c : dealercards)
		{
			sum2 = sum2 + c.value;
		}
		dealer_sum = sum2;
	}
	
	public class Background extends JPanel {
		
		public void paintComponent(Graphics g) {
			g.setColor(bgcolor);
			g.fillRect(0, 0, width, height);
			
			//grid painting(boundary)
			g.setColor(Color.white);
			g.drawRect(gridX, gridY, gridW, gridH);
			//log borders paintings(bottom boundary)
			g.drawRect(gridX, gridY + gridH + 50, gridW, gridH);
			//temporary totals and hit/stay messages
			g.drawRect(msX, msY, msW, msH);
			//play more question yes or no
			g.drawRect(quX, quY, quW, quH);
			if (bool_dealer_turn == true)
			{
				g.setFont(question_font);
				g.drawString(play_more_question, quX + 35, quY + 60);
				g.setFont(result_font);
				g.drawString("Player Score : " + Integer.toString(player_sum), gridX + 20, gridY + gridH + 80);
				g.drawString("Dealer Score: " + Integer.toString(dealer_sum), gridX + 20, gridY + gridH + 120);
				g.drawString(message, gridX + 20, gridY + gridH + 160);
			}
			else if (bool_hit_stay == true)
			{
				g.setFont(result_font);
				g.drawString("Your Score : " + Integer.toString(player_sum), gridX + 20, gridY + gridH + 80);
			}
			for(int i = 0; i < 3; i++)
			{
				g.drawRect(gridX + i*CardW + cardSpacing, gridY + cardSpacing, CardAW, CardAH);
				g.drawRect(gridX + i*CardW + cardSpacing, gridY + cardSpacing + CardH, CardAW, CardAH);
			}
			
			//Card images and Player cards
			int tmp = 0;
			for (Card c : playercards)
			{
				g.setColor(Color.white);
				g.fillRect(gridX + tmp * CardW + cardSpacing, gridY + cardSpacing + cardEdge, CardAW, CardAH - 2 * cardEdge);
				g.fillRect(gridX + tmp * CardW + cardSpacing + cardEdge, gridY + cardSpacing, CardAW - 2 * cardEdge, CardAH);
				g.fillOval(gridX + tmp * CardW + cardSpacing, gridY + cardSpacing, 2 * cardEdge, 2 * cardEdge);
				g.fillOval(gridX + tmp * CardW + cardSpacing + CardAW - 2 * cardEdge, gridY + cardSpacing, 2 * cardEdge, 2 * cardEdge);
				g.fillOval(gridX + tmp * CardW + cardSpacing, gridY + cardSpacing + CardAH - 2 * cardEdge, 2 * cardEdge, 2 * cardEdge);
				g.fillOval(gridX + tmp * CardW + cardSpacing + CardAW - 2 * cardEdge, gridY + cardSpacing + CardAH - 2 * cardEdge, 2 * cardEdge, 2 * cardEdge);
				g.setColor(Color.black);
				if(c.shape.equalsIgnoreCase("Diamonds"))
				{
					g.setColor(Color.magenta);
				}
				else if(c.shape.equalsIgnoreCase("Hearts"))
				{
					g.setColor(Color.red);
				}
				else if(c.shape.equalsIgnoreCase("Clubs"))
				{
					g.setColor(Color.darkGray);
				}
				g.setFont(shape_font);
				g.drawString(c.shape, gridX + tmp * CardW + cardSpacing * 2, gridY + 40);
				g.setFont(card_font);
				g.drawString(c.symbol, gridX + tmp * CardW + cardSpacing * 2, gridY + CardAH);
				tmp++;
			}
			
			//dealer cards
			tmp = 0;
			for (Card c : dealercards)
			{
				g.setColor(Color.white);
				g.fillRect(gridX + tmp * CardW + cardSpacing, gridY + CardH + cardSpacing + cardEdge, CardAW, CardAH - 2 * cardEdge);
				g.fillRect(gridX + tmp * CardW + cardSpacing + cardEdge, gridY + CardH + cardSpacing, CardAW - 2 * cardEdge, CardAH);
				g.fillOval(gridX + tmp * CardW + cardSpacing, gridY + CardH + cardSpacing, 2 * cardEdge, 2 * cardEdge);
				g.fillOval(gridX + tmp * CardW + cardSpacing + CardAW - 2 * cardEdge, gridY + CardH + cardSpacing, 2 * cardEdge, 2 * cardEdge);
				g.fillOval(gridX + tmp * CardW + cardSpacing, gridY + CardH + cardSpacing + CardAH - 2 * cardEdge, 2 * cardEdge, 2 * cardEdge);
				g.fillOval(gridX + tmp * CardW + cardSpacing + CardAW - 2 * cardEdge, gridY + CardH + cardSpacing + CardAH - 2 * cardEdge, 2 * cardEdge, 2 * cardEdge);
				g.setColor(Color.black);
				if(c.shape.equalsIgnoreCase("Diamonds"))
				{
					g.setColor(Color.magenta);
				}
				else if(c.shape.equalsIgnoreCase("Hearts"))
				{
					g.setColor(Color.red);
				}
				else if(c.shape.equalsIgnoreCase("Clubs"))
				{
					g.setColor(Color.darkGray);
				}
				g.setFont(shape_font);
				g.drawString(c.shape, gridX + tmp * CardW + cardSpacing * 2, gridY + CardAH + 60);
				g.setFont(card_font);
				g.drawString(c.symbol, gridX + tmp * CardW + cardSpacing * 2, gridY + CardAH + CardH);
				tmp++;
			}
		
		}
	}
	
	public class ActHit implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			rand = new Random().nextInt(52);
			while(true)
			{
				if(cards.get(rand).cardUsed == false)
				{
					playercards.add(cards.get(rand));
					cards.get(rand).cardUsed = true;
					break;
				}
				else
				{
					rand = new Random().nextInt(52);
				}
			}
			while(true)
			{
				if(cards.get(rand).cardUsed == false)
				{
					dealercards.add(cards.get(rand));
					cards.get(rand).cardUsed = true;
					break;
				}
				else
				{
					rand = new Random().nextInt(52);
				}
			}
			int sum = 0;
			for (Card c : dealercards)
			{
				sum = sum + c.value;
			}
			dealer_sum = sum;
			if(dealer_sum <= 16)
			{
				while(true)
				{
					if(cards.get(rand).cardUsed == false)
					{
						dealercards.add(cards.get(rand));
						cards.get(rand).cardUsed = true;
						break;
					}
					else
					{
						rand = new Random().nextInt(52);
					}
				}
			}
			Result result = new Result(player_sum, dealer_sum);
			message = result.discrimination();
			bool_hit_stay = false;
			bool_dealer_turn = true;
		}
	}
	
	public class ActStay implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			while(true)
			{
				if(cards.get(rand).cardUsed == false)
				{
					dealercards.add(cards.get(rand));
					cards.get(rand).cardUsed = true;
					break;
				}
				else
				{
					rand = new Random().nextInt(52);
				}
			}
			int sum = 0;
			for (Card c : dealercards)
			{
				sum = sum + c.value;
			}
			dealer_sum = sum;
			if(dealer_sum <= 16)
			{
				while(true)
				{
					if(cards.get(rand).cardUsed == false)
					{
						dealercards.add(cards.get(rand));
						cards.get(rand).cardUsed = true;
						break;
					}
					else
					{
						rand = new Random().nextInt(52);
					}
				}
			}
			Result result = new Result(player_sum, dealer_sum);
			message = result.discrimination();
			bool_hit_stay = false;
			bool_dealer_turn = true;
		}
	}
	
	public class ActYes implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			playercards.clear();
			dealercards.clear();
			while(true)
			{
				if(cards.get(rand).cardUsed == false)
				{
					playercards.add(cards.get(rand));
					cards.get(rand).cardUsed = true;
					break;
				}
				else
				{
					rand = new Random().nextInt(52);
				}
			}
			while(true)
			{
				if(cards.get(rand).cardUsed == false)
				{
					playercards.add(cards.get(rand));
					cards.get(rand).cardUsed = true;
					break;
				}
				else
				{
					rand = new Random().nextInt(52);
				}
			}
			while(true)
			{
				if(cards.get(rand).cardUsed == false)
				{
					dealercards.add(cards.get(rand));
					cards.get(rand).cardUsed = true;
					break;
				}
				else
				{
					rand = new Random().nextInt(52);
				}
			}
			bool_hit_stay = true;
			bool_dealer_turn = false;
			
		}
	}
	
	public class ActNo implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
		}
	}
	
	public class ActYes2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class ActNo2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
