
import java.util.LinkedList;

public class Tree<T extends Comparable<T>> {
	
	private T name;
	private Tree<T> sonRight;
	private Tree<T> sonLeft;
	
	public Tree(T name) {
		this.name = name;
	}

	public Tree(T name, Tree<T> sonLeft, Tree<T> sonRight) {
		this.name = name;
		this.sonRight = sonRight;
		this.sonLeft = sonLeft;
	}
	
	@Override
	public String toString() {
		if (isLeaf()){
			return "I'm leaf \t" + name;
		}
		else {
			return "I'm submit \t" + name;
		}
	}
	
	public void parcoursProfondeurPrefixe(){
		System.out.println(toString());
		if (sonLeft != null){
			sonLeft.parcoursProfondeurPrefixe();
		}
		if (sonRight !=null){
			sonRight.parcoursProfondeurPrefixe();
		}
	}
	
	public void parcoursProfondeurInfixe(){
		if (sonLeft != null){
			sonLeft.parcoursProfondeurInfixe();
		}
		System.out.print(toString());
		if (sonRight !=null){
			sonRight.parcoursProfondeurInfixe();
		}
	}

	public void parcoursProfondeurPostfixe(){
		if (sonLeft != null){
			sonLeft.parcoursProfondeurPostfixe();
		}
		if (sonRight !=null){
			sonRight.parcoursProfondeurPostfixe();
		}
		System.out.println(toString());
	}
	
	public boolean isLeaf(){
		return (sonRight==null && sonLeft==null);
	}
	
	public int profondeur() {
		if(isLeaf()){
			return 1;
		}
		else if(sonRight==null){
			return 1 + sonLeft.profondeur();
		}
		else if(sonLeft==null){
			return 1 + sonRight.profondeur();
		}
		else{
			return 1 + Math.max(sonLeft.profondeur(), sonRight.profondeur());
		}
	}
	

	public void parcourlargeur(){
		LinkedList<Tree<T>> file = new LinkedList<Tree<T>>();
		file.add(this);
		while (! file.isEmpty()){
			Tree<T> current = file.removeFirst();
			System.out.print(current.name);
			if (current.sonLeft != null){
				file.add(current.sonLeft);
			}
			if (current.sonRight != null){
				file.add(current.sonRight);
			}
		}
	}
	
	 public void insert(Tree<T> tree, T node){
		 int compare = tree.getName().compareTo(node);
		 if(compare<0) {//gauche
			 if(tree.sonLeft!=null){
				 insert(tree.sonLeft,node);
			 } else {
				 tree.sonLeft = new Tree<T>(node);
			 }
		 } else if(compare==0) {
			 //nothing to do
		 } else if (compare>0) {//droite
			 if(tree.sonRight!=null){
				 insert(tree.sonRight,node);
			 } else {
				 tree.sonRight = new Tree<T>(node);
			 }
		 }
		 
	 }

	public T getName() {
		T name = Tree.this.name;
		return name;
	}
	public int profond(Tree<T> tree, T node) {
		int result = -1;
		int compare = tree.getName().compareTo(node);
		if (compare < 0) { // gauche
			if (tree.sonLeft != null) {
				result =1+profond(tree.sonLeft, node);
			} else {
				result = -1000;
			}
		} else if (compare > 0) { // droite
			if (tree.sonRight != null) {
				result=1+profond(tree.sonRight, node);
			} else {
				result = -1000;
			}
		} else if (compare == 0) {
			result =0;
		}
		return result;
	}
	public boolean contains(Tree<T> tree, T node){
		boolean result = false;
		 int compare = tree.getName().compareTo(node);
		 if(compare<0) {//gauche
			 if(tree.sonLeft!=null){
				 result = contains(tree.sonLeft,node);
			 } else {
				 result=false;
			 }
		 } else if(compare==0) {
			 result = true;
		 } else if (compare>0) {//droite
			 if(tree.sonRight!=null){
				 result = contains(tree.sonRight,node);
			 } else {
				 result = false;
			 }
		 }
		 return result;
		 
	 }
}
