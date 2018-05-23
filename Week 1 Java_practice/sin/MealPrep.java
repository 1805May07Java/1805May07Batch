package com.rev.sin;

public class MealPrep {
	public Meal prepareVegMeal (){
	      Meal meal = new Meal();
	      meal.addItem(new VegeBurgar());
	      meal.addItem(new Coke());
	      return meal;
	   }   

	   public Meal prepareNonVegMeal (){
	      Meal meal = new Meal();
	      meal.addItem(new FatBurgar());
	      meal.addItem(new CokeZero());
	      return meal;
	   }
}
