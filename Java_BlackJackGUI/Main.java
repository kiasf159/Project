package Blackjack;

public class Main implements Runnable{
	
	GUI gui = new GUI();

	public static void main(String[] args) {
		new Thread(new Main() ).start(); //start Thread
	}
	
	@Override
	public void run() {
		// non-stop
		while(true)
		{
			gui.refresh();
			gui.repaint();
		}
	}
}
