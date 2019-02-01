import java.util.Scanner;

public class hangman {
	public static void main(String[] args) {
		boolean playing = true;

			System.out.println("Starting the game of hangman...");
			System.out.print("How many incorrect attempts do you want? [1 - 20]: ");
			Scanner num = new Scanner(System.in);
			int attempts = num.nextInt();
			
			
			while (!(attempts >= 1 && attempts <= 20))
			{
				System.out.print("Invalid attempts number. Please choose a number from [1-20] ");
				attempts = num.nextInt();
			}
			System.out.print("What is the lengh of the word [3 - 10]: ");
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
		
	}

}
