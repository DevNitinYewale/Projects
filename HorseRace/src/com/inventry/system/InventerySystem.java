package com.inventry.system;

import java.util.Scanner;

public class InventerySystem {
		private String userType;
		private String userName;
		private String userPass;
		
		public String getUserType() {
			return userType;
		}
		public void setUserType(String userType) {
			this.userType = userType;
		}
			
		public InventerySystem(String userType, String userName, String userPass) {
			super();
			this.userType = userType;
			this.userName = userName;
			this.userPass = userPass;
		}
		public InventerySystem() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public String toString() {
			return "InventerySystem [userType=" + userType + ", userName=" + userName + ", userPass=" + userPass + "]";
		}
		
		Scanner sc=new Scanner(System.in);
		public boolean login() {
			System.out.println("enter your user name and password: ");
			String user=sc.next();
			String pass=sc.next();
			if(user.equals(userPass) && pass.equals(userPass)) 
				return true;
			else
				return false;
		}
		
		public void register() {
			System.out.print("Enter user name: ");
			userName=sc.next();
			System.out.print("enter pass: ");
			userPass=sc.next();
			System.out.print("enter your name: ");
			String name=sc.nextLine();
			System.out.print("enter your email: ");
			String email=sc.next();
			System.out.print("enter contact no: ");
			long contact=sc.nextLong();
			
		}
		
		public void logOut() {
			System.exit(0);
		}
}
