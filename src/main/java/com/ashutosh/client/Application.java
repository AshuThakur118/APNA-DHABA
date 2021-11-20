package com.ashutosh.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ashutosh.bean.Login;
import com.ashutosh.bean.Menu;
import com.ashutosh.bean.Registration;
import com.ashutosh.dao.DataProcess;
import com.ashutosh.dao.FetchCart;
import com.ashutosh.service.Checkout;
import com.ashutosh.service.IRegistrationService;
import com.ashutosh.service.RegistrationService;

public class Application {

	public static void main(String[] args) throws IOException {
		String usrName, email, pasWord, gender;
		int num = 100;
		while (num != 0) {
			System.out.println("1. Login");
			System.out.println("2. Registration");
			System.out.print("Select Option: ");
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int opt = Integer.parseInt(br.readLine());
				System.out.println("----------------------------------------------------");
				switch (opt) {
				case 1:
					System.out.println("Hi :) :), Put data correct and Enjoy ");
					System.out.print("User Name : ");
					usrName = br.readLine();

					System.out.print("Password : ");
					pasWord = br.readLine();
				
					//LoginService log =new LoginService();

					Login login = new Login(usrName, pasWord);
					
					if(DataProcess.Fetch(login))
					{
						System.out.println("Welcome "+login.getUserName() + ":)");
						
						List<Menu> list = new ArrayList<Menu>();
						int num1 = 100;
						while (num1 != 0) {
							System.out.println("-----------------------------------------------------------");
							System.out.println("1. Look for all items");
							System.out.println("2. Checkout");
							System.out.println("0. Exit");
							System.out.print("Select Option: ");
							num1 = Integer.parseInt(br.readLine());

							FetchCart fetch = new FetchCart();

							switch (num1) {
							case 1:
								List<Menu> items=fetch.ReadData();
								System.out.print("\nChoose itemNo in range 0-"+(items.size()-1) + ": ");
								int num2 = Integer.parseInt(br.readLine());
								list.add(items.get(num2));
								System.out.println("Item added to cart");
								break;

							case 2:
								Checkout.FetchCart(list);
								break;
							case 0:
								System.out.println("Existed");
								break;
							default:
								System.out.println("Enter valid option");
								break;

							}

						}
					}
					else
					{
						System.out.println("Wrong Credentials");
					}

				case 2:
					System.out.println("Welcome :), Put 100% true Credential and be our member");
					System.out.print("Enter UserName: ");
					usrName = br.readLine();
					System.out.print("Enter Your Email: ");
					email = br.readLine();
					System.out.print("Enter Password: ");
					pasWord = br.readLine();
					System.out.print("Enter Your Gender: ");
					gender = br.readLine();
					Registration reg = new Registration(usrName, email, pasWord, gender);
					IRegistrationService register = new RegistrationService();
					if (register.validateRegistration(reg) && DataProcess.Store(reg)) {
						System.out.println("Congrats User Created...\n");
					} else {
						System.out.println("Please Enter Correct Details");
					}
					break;
				case 0:
					System.out.println("Existed :)");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option");
				}
			} catch (Exception nfe) {
				nfe.printStackTrace();
			}
		}
	}	
}