import java.util.Arrays;
import java.util.Scanner;

public class Crible {
	public static void erathosteneR(boolean [] crible) {
		Arrays.fill(crible,true);
		erathosteneR_(crible, 2);
	}

	private static void erathosteneR_(boolean[] crible, int i) {
		if(i >= crible.length)
			return;
		
		while(!crible[i] && i < crible.length/2)
			i++;
		
		eliminer(crible, i);
		erathosteneR_(crible, i+1);
	}

	private static void eliminer(boolean[] crible, int i) {
		for(int j =2; (j * i) < crible.length; j++)
			crible[i*j] = false;
		
	}
	
	public static boolean isPremier(int i){ 
		boolean result = true;
		for (int j = 2; j < (i-1); j++) {
			if (i % j == 0){
				result = false;
				break;
			}	
		}
		return result;
	}
	
	public static  void premiers(int n) {
		boolean [] crible = new boolean[n+1];
		
		System.out.println("Les nombres premiers jusqu'à "+ n +" sont : ");
		erathosteneR(crible);
		
		for(int i = 2; i< crible.length ; i++)
			if(crible[i])
				System.out.println(i);
		
	}
	public static void main(String[] args) {
		System.out.print("Entrez un chiffre : ");
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		Crible.premiers(k);	
		
	}
}
