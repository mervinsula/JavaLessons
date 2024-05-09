package JavaBasics;

import java.util.Arrays;

public class ArraysString {

	public static void main(String[] args) {
		String pokemon1 = new String("Charizard");
		String pokemon2 = "Charizard";
		String pokemon3 = "Charizard";
		
		System.out.println(pokemon1 == pokemon2); // false -> different objects
		System.out.println(pokemon2 == pokemon3); // true -> same object
		System.out.println(pokemon1.equals(pokemon2)); // true -> checks the values
		
		pokemon1 += "(Fire Type)";
		System.out.println(pokemon1);
		
//				int[] rooms = new int[5];
//				int[] rooms = {2,1,5,4,5};	
////				Arrays.fill(rooms,1);
//					
//
//					for(int j = 0;j< 5;j++) {
//						System.out.print(rooms[j]);
//
//					}
//
////				Arrays.sort(rooms);
////				
////				for(int j = 0;j< 5;j++) {
////					System.out.print(rooms[j]);
////
////				}
//				
//				System.out.println(" " + Arrays.binarySearch(rooms,5));
	}

}
