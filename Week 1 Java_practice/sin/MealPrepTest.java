package com.rev.sin;

//import static org.junit.Assert.*;

import org.junit.Test;

public class MealPrepTest {

	@Test
	public void test() {
		MealPrep mealBuilder = new MealPrep();

	      Meal vegMeal = mealBuilder.prepareVegMeal();
	      System.out.println("Vege Meal");
	      vegMeal.showItems();
	      System.out.println("Total Cost: " + vegMeal.getCost());

	      Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
	      System.out.println("\n\nFatBurgar Meal");
	      nonVegMeal.showItems();
	      System.out.println("Total Cost: " + nonVegMeal.getCost());
	}

}
