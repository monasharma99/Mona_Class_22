package class24;

import java.util.ArrayList;

public class ArrayListOf5Intergers {

	public static void main(String[] args) {
		
			int  ArryList [] = new int [5];
			ArrayList<Integer> integer = new ArrayList<Integer>(5);
			integer.add(1);
			integer.add(2);
			integer.add(3);
			integer.add(4);
			integer.add(5);
			
			for (Integer x : integer)
			System.out.println(x);
			}
	
	}

