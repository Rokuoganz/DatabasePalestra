package Gym1;

import java.sql.*;
import java.util.Scanner;


public class Tester {
	public static int request() {
		System.out.println("\nInserisci numero query da eseguire (da 1 a 18, 0 se EXIT): ");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		
		while(choice < 0 || choice > 18) {
			System.out.println("Numero inserito non corretto\nInserisci numero query da eseguire (da 1 a 19, 0 se EXIT): ");
			choice = in.nextInt();
		}
		
		return choice;
	}

	public static void main(String[] args) {
		Gymdb1 p = new Gymdb1();	
		
		int choice = -1;
		
		while(choice != 0) {
			choice = request();
			switch(choice) {
				case 1:
					p.query01();
					break;
				case 2:
					p.query02();
					break;
				case 3:
					p.query03();
					break;
				case 4:
					p.query04();
					break;
				case 5:
					p.query05();
					break;
				case 6:
					p.query06();
					break;
				case 7:
					p.query07();
					break;
				case 8:
					p.query08();
					break;
				case 9:
					p.query09();
					break;
				case 10:
					p.query10();
					break;
				case 11:
					p.query11();
					break;
				case 12:
					p.query12();
					break;
				case 13:
					p.query13();
					break;
				case 14:
					p.query14();
					break;
				case 15:
					p.query15();
					break;
				case 16:
					p.query16();
					break;
				case 17:
					p.query17();
					break;
				case 18:
					p.query18();
					break;
			}
		}
		p.releaseConnection();
	}
}
