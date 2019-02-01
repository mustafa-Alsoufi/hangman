import java.util.Random;
import java.util.Scanner;

public class wordGenerator {
	static String word;
	static char[] encryptedWord;
	final String words_3[] = {"sun","die","new","age","bus","raw","bad","pie","art","gym"};
	final String words_4[] = {"coin","load","find","pair","fill","soap","cash","hand","sick","tree"};
	final String words_5[] = {"pause"};
	//final String words_5[] = {"style","brake","punch","youth","pilot","union","spend","pause","plane","trend"};
	final String words_6[] = {"coffee","lawyer","agenda","moment","refund","broken","insure","dragon","record","shrink"};
	final String words_7[] = {"kitchen","clothes","company","neutral","gallery","deposit","failure","revenge","arrange","manager"};
	final String words_8[] = {"graduate","prisoner","equation","sunshine","distance","patience","official","organize","elephant","talented"};
	final String words_9[] = {"paragraph","tradition","structure","pollution","waterfall","clearance","emergency","admission","hilarious","nightmare"};
	final String words_10[] = {"incredible","prediction","investment","connection","girlfriend","reputation","programmer","settlement","generation","attractive"};
	
	hangman h = new hangman();

	public wordGenerator(int length)
	{
		switch (length)
		{
		case 3:
		{
			getRandomWord(words_3);
			break;
			
		}
		case 4:
		{
			getRandomWord(words_4);
			break;
		}
		case 5:
		{
			getRandomWord(words_5);
			break;
		}
		case 6:
		{
			getRandomWord(words_6);
			break;
		}
		case 7:
		{
			getRandomWord(words_7);
			break;
		}
		case 8:
		{
			getRandomWord(words_8);
			break;
		}
		case 9:
		{
			getRandomWord(words_9);
			break;
		}
		case 10:
		{
			getRandomWord(words_10);
			break;
		}
		default:
		{
			break;
		}
		}
	}
	public void getRandomWord(String[] array) {
	    int rnd = new Random().nextInt(array.length);
	    word = array[rnd];
	    char [] encryptedWord = word.toCharArray() ;
	    this.encryptedWord = encryptedWord;
	    System.out.print("\nThe word is: ");
	    for (int i=0;i < array[rnd].length();i++)
		{
	    	System.out.print("*");
	    	encryptedWord[i]='*';
		}
	    System.out.println(); 
	}
	public void wordAfterguessing(char c,int attempts)
	{
		
		boolean found=false,foundAgain=false;
		char[] newword = word.toCharArray();
		Scanner newC = new Scanner(System.in);
		
		while (! ((attempts ==0) ||  (new String(encryptedWord).equals(word))))	//while the remaining attempts not zero plus the word is not yet fully guessed
		{
			
			for (int i=0;i<word.length();i++)
			{
				if (encryptedWord[i] == Character.toLowerCase(c))									// the letter already been found.
				{
					System.out.println("The letter \'"+c+"\' has been found already");
					 foundAgain = true;
				}
				
				else if (Character.toLowerCase(c) == newword[i])									// The first time the letter been found.
				{
					encryptedWord[i] = Character.toLowerCase(c);
					found=true;
				}

			}
			if(found == false && foundAgain == false)						// wrong guess
			{
				
				attempts -= 1;
				System.out.println("The letter \'"+c+"\' is not in the word, please try again!");
				
			}
			
			else if (found = true && foundAgain == false)					// If this is the first time the letter been found
			{
				System.out.println("Good job!\n");
			}
			if ( ! new String(encryptedWord).equals(word))					// If the word is not guessed yet
			{
				System.out.print("Word: ");
				System.out.println(encryptedWord);
				System.out.println("Your remaining attempts: "+ attempts);
				System.out.print("Choose a letter: ");

				c = newC.next().charAt(0);
			}
			else if (new String(encryptedWord).equals(word))				// When the user guessed the word
			{
				System.out.println("The Word is: " + word);
				System.out.println("Congratulations You Won!");
			}
			found = false;
			foundAgain = false;
			
			if (attempts == 0)												// The user has been lost.
			{
				System.out.println("\nThe Word is: " + word);
				System.out.println("Try again next time!");
			}
		}
			
	}
	

}
