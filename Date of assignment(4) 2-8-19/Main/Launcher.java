package Main;

import java.util.ArrayList;
import java.util.List;

import Annotations.Food;
import Annotations.Time;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import Entities.Burger;
import Entities.FoodItem;
import Entities.Pizza;

public class Launcher {

	/*
	 * Creating list of class' objects
	 */
	public static void generator() {

		List<FoodItem> foodItem = new ArrayList<>();
		Pizza pizza = new Pizza();
		Burger burger = new Burger();

		foodItem.add(pizza);
		foodItem.add(burger);
//		Annotations(foodItem);

		foodItem.forEach(Launcher::Annotations);
	}

	/*
	 * Implementing annotations and displaying values
	 */
	static void Annotations(FoodItem foodItems) {

		Class c = foodItems.getClass();
		Annotation annotation = c.getAnnotation(Food.class);
		Food food = (Food) annotation;
		System.out.print("\nFood name:: " + food.name());
		System.out.print("\t,Food price:: " + food.price());

		Method m = null;
		try {
			m = c.getMethod("setTimeDetails");
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Annotation annotation2 = m.getAnnotation(Time.class);
		Time time = (Time) annotation2;
		System.out.print("\nPrepare time:: " + time.prepareTime());
		System.out.print("\t,Cook time:: " + time.cookTime());
		System.out.print("\t,Send time:: " + time.sendTime());
	}

	/*
	 * Main class that calls generator that creates the list
	 *
	 */
	public static void main(String[] args) {

		generator();
	}
}
