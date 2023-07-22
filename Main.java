package ArrayList;

public class Main {

	public static void main(String[] args) {

		MyArrayList<Integer> intObj = new MyArrayList<Integer>();
		
		
		intObj.add(44);
		intObj.add(45);
		intObj.add(46);
		intObj.add(47);
		
		System.out.println(intObj.size());
		System.out.println(intObj.isEmpty());
		
		
	} 
}