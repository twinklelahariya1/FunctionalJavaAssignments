package Entities;

import Annotations.Food;
import Annotations.Time;

@Food(name = "Pizza", price = 200)
public class Pizza extends FoodItem {

	String name;
	int price;

	@Override
	@Time(prepareTime = 10, cookTime = 20, sendTime = 50)
	public int setTimeDetails() {

		return timeTaken;

	}

}
