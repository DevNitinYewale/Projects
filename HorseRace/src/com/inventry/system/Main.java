package com.inventry.system;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		InventerySystem inSys=new InventerySystem();
		System.out.println("enter user type: ");
		System.out.println(" 1. Customer\n 2. Employee\n 3. Admin");
		int type=sc.nextInt();
		/*
		while(type==1) {
			System.out.println("enter your chouce...!");
			System.out.println(" 1. Login \n 2. Register \n 3. LogOut");
			int n=sc.nextInt();
			switch(n) {
			case 1:
					boolean b=inSys.login();
					if(b)
						System.out.println("Login Successfully.....!");
					else
						System.out.println("Login failed..!");
					break;
			case 2:
					inSys.register();
					break;
			case 3:
					inSys.logOut();
					break;
			}
		}
		*/
		Customer cst=new Customer();
		while(true) {
			System.out.println("enter your chouce...!");
			System.out.println(" 1. AddToCart \n 2. GetBill \n 3. Exit");
			int n1=sc.nextInt();
			switch(n1) {
			case 1:
					List<Cart> cart=new ArrayList<Cart>();
					Cart ct=new Cart(101,"Pen",5.00);
					cart.add(ct);
					for(int i=0;i<5;i++) {
						ct=new Cart(102,"Pencil",2.0);
						cart.add(ct);
					}
					ListIterator itr=cart.listIterator();
					while(itr.hasNext())
					{
						System.out.println(itr.next());
					}
					cst.addToCart();
					break;
			case 2:
					
					cst.getBill();
					break;
			case 3:
					System.exit(0);
					break;
			}
		}
		
	
	}

}
