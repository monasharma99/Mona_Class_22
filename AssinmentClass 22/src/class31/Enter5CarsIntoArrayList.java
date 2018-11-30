package class31;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.formula.functions.T;

public class Enter5CarsIntoArrayList {

	public static void main(String[] args) {
		ArrayList<String> Cars = new ArrayList<>();
		Scanner k = new Scanner(System.in);
					
		for(int i= 0; i<5; i++) {
		System.out.println("Please Enter Names of any 5 Cars");
		String CarName = k.nextLine();
		Cars.add(CarName);
		}	
			
		if (Cars.contains("BMW")) {	
		System.out.println("Yes it is there");
		}
		 else  {
			System.out.println("No! it is not there");
		}
		}
	}

