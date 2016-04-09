
public class Runner {

	public static void main(String[] args) {
		Tree<String> the = new Tree<String>("the");
		the.insert(the, "quick");
		the.insert(the, "brown");
		the.insert(the, "fox");
		the.insert(the, "jumps");
		the.insert(the, "over");
		the.insert(the, "the");
		the.insert(the, "lazy");
		the.insert(the, "dog");
		the.insert(the, "pinguin");
		the.parcoursProfondeurPrefixe();
		System.out.println("Le mot 'pinguin' apparait dans l'arbre : " +the.contains(the, "pinguin"));
		System.out.println("Je suis " + "'fox'" + " et je suis en position : " +the.profond(the, "fox"));
		Tree<Integer> zero = new Tree<Integer>(0);
		zero.insert(zero, 1);
		zero.insert(zero, 2);
		zero.insert(zero, 5);
		zero.insert(zero, 6);
		zero.insert(zero, 4);
		zero.parcoursProfondeurPrefixe();
		System.out.println("Je suis " + "'5'" +" et je suis en position : " + zero.profond(zero, 5));
	}

}
