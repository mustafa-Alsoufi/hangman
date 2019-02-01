import java.util.Scanner;

public class hangman {
	public static void main(String[] args) {
		boolean playing = true;

		while(playing)
		{

			System.out.println("Starting the game of hangman...");
			System.out.print("How many incorrect attempts do you want? [1 - 20]: ");
			Scanner num = new Scanner(System.in);
			int attempts = num.nextInt();
			
			
			while (!(attempts >= 1 && attempts <= 20))
			{
				System.out.print("Invalid attempts number. Please choose a number from [1-20] ");
				attempts = num.nextInt();
			}
			System.out.print("What is the lengh of the word? [3 - 10]: ");
			Scanner len = new Scanner(System.in);
			int length = len.nextInt();

			while (length > 10 || length < 3)
			{
				System.out.print("Invalid length number. Please choose a number from [3-10] ");
				length = len.nextInt();
			}
			
			if((attempts > 1 && attempts <= 20) && (length >= 3 && length <=10))
			{
				wordGenerator wg = new wordGenerator(length);
				System.out.println("Attempts Remaining: " + attempts);	
				System.out.print("Choose a letter: ");
				Scanner c = new Scanner(System.in);
				char letter = c.next().charAt(0);
				while (Character.toLowerCase(letter) < 'a' || Character.toLowerCase(letter) >'z')
				{
					System.out.print("Invalid letter.\nChoose a letter: ");
					letter = c.next().charAt(0);
				}
				if (Character.toLowerCase(letter) >='a' && Character.toLowerCase(letter) <= 'z')
				{
					wg.wordAfterguessing(Character.toLowerCase(letter),attempts);
				
				}
		}
			System.out.println("Would you like to try again? [y/Y]");
			Scanner play = new Scanner(System.in);
			char ans = play.nextLine().charAt(0);
			while (Character.toLowerCase(ans) !='y' || Character.toLowerCase(ans) !='n')
			{
				if (Character.toLowerCase(ans) == 'y')
				{
				playing = true;
				}
			else if (Character.toLowerCase(ans) == 'n')
				{
					System.out.println("Have a good day!");
					break;
				}
			else
			{
				System.out.println("Wrong Answer\nWould you like to try again? [y/Y]");
				ans = play.nextLine().charAt(0);
			}
			}
			
			
		}
		
		
	}

}
