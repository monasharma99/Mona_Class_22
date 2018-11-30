package class31;

import java.util.ArrayList;

public class MeargArrayList {

	public static void main(String[] args) {

		ArrayList<String> food = new ArrayList<>();

		food.add("Rice");
		food.add("Pasta");
		food.add("Burgur");
		food.add("Piza");
		food.add("Dosa");
		ArrayList<String> fruits = new ArrayList<>();

		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Pear");
		fruits.add("Kiwi");
		fruits.add("Papaya");

		food.addAll(fruits);

		for (String t : food) {

			System.out.println(t);

		}
	}
}
//Perfect