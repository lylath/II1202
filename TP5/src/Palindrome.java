import java.util.Scanner;

public class Palindrome {
	
	public static boolean isPalindrome(String phrase){
		if((phrase.length() == 2 && (phrase.charAt(0) == phrase.charAt(1))) || phrase.length() == 1) {
			return true;
		}
		if(phrase.charAt(0) != phrase.charAt(phrase.length() -1)){
			return false;
		}	
		return isPalindrome(phrase.substring(1, phrase.length() -1));
	}
	
	static public void palindrome(Scanner scan) {
		String phrase = scan.nextLine();
		boolean result=isPalindrome(phrase.toLowerCase());
		
		if (result==true)
			System.out.println("C'est un palindrome.");
		else
			System.out.println("Ce n'est pas un palindrome.");
	}
	
	public static void main(String[] args) {
		System.out.print("Entrez une phrase : ");
		Scanner scan = new Scanner(System.in);
		
		palindrome(scan);	
		
	}
}
