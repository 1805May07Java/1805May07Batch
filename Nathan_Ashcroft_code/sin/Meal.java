package com.rev.sin;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	private List<itm> items = new ArrayList<itm>();	

	   public void addItem(itm item){
	      items.add(item);
	   }

	   public float getCost(){
	      float cost = 0.0f;
	      
	      for (itm item : items) {
	         cost += item.price();
	      }		
	      return cost;
	   }

	   public void showItems(){
	   
	      for (itm item : items) {
	         System.out.print("Item : " + item.name());
	         System.out.print(", Packing : " + item.packing().pack());
	         System.out.println(", Price : " + item.price());
	      }		
	   }	
}
