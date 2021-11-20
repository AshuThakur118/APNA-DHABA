package com.ashutosh.service;

import java.util.List;

import com.ashutosh.bean.Menu;

public class Checkout {
	public static void FetchCart(List<Menu> list) {
		double total = 0.0;

		for (Menu menu : list) {

			System.out.println(menu.getItemName() + " --> " + "₹" + menu.getItemPrice());

			total += menu.getItemPrice();
		}
		if (list.isEmpty()) {
			System.out.println("\nEmpty Cart");
		} 
		else {
			System.out.println("\nTotal Amount: " + "₹" + total);
		}
	}
}