import java.util.Arrays;

public class FileEntier {
	
	private int[] file;	
	public FileEntier(){
		file= new int[0];		
	}
	
	public void display(){
		System.out.println(Arrays.toString(file));
	}
		
	public void add(int add){
		int length = file.length;		
		
		int[] newTab = new int[length+1];
		
		if (length==0){
			newTab[0]=add;}
		else{
			for (int i = 0; i < length; i++) {				
				newTab[i] = file[i];
			}
			newTab[length]=add;
		}
			
		this.file=newTab;
		
	}
		
	public void take(){
		int length = file.length;
		int[] newTab = new int[length-1];
		for (int i = 1; i < length; i++) {
			int k = i-1;
			newTab[k]=file[i];
		}
		file=newTab;
	}
	public static void main(String[] args) {
	
	FileEntier liste = new FileEntier();
	
	System.out.println("On ajoute 1 et 5 à la liste :");
	liste.add(1);
	liste.add(5);
	liste.display();
	System.out.println("Puis on ajoute 3 :");
	liste.add(3);
	liste.display();
	System.out.println("Et finalement on retire le premier élément de la liste, qui ici est 1");
	liste.take();
	liste.display();
	}
}
