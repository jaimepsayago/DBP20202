package model;

import java.util.Scanner;

public class Figura1 {


		public static final int Max_Value  = 4;
		public static final int Min_Value  = 1;
		public static final int Max_Value1  = 16;
		public static void main(String[] args) {
			for (int line= 1; line <=4; line++) {
			printTop();
			figuraSuperior();
			figuraInferior();
			printTop();
			bucle();
			figuraEscalon();
			
			}
		}
		public static void printTop() {
			System.out.print("#");
			for (int i = 1; i<=Max_Value1; i++) {
				System.out.print("=");
			}
			System.out.println("#");
		}

		public static void figuraSuperior() {
			for (int line= 1; line <=Max_Value ; line++) {
				System.out.print("|");	
				for (int space = 1; space <= (line * -2+8);space++) {
					System.out.print(" ");
				}	
				System.out.print("<>");
				for(int dot = 1; dot <=(line *4-4);dot ++) {
					System.out.print(".");
				}	
				System.out.print("<>");
				for(int space = 1;space <= (line *-2 +8);space++){
					System.out.print(" ");
				}
				System.out.println("|");
			}
		}
		public static void figuraInferior() {
			for (int line= 4; line >=Min_Value; line--) {
				System.out.print("|");	
				for (int space = 1; space <= (line * -2+8);space++) {
					System.out.print(" ");
				}	
				System.out.print("<>");
				for(int dot = 1; dot <=(line *4-4);dot ++) {
					System.out.print(".");
				}	
				System.out.print("<>");
				for(int space = 1;space <= (line *-2 +8);space++){
					System.out.print(" ");
				}
				System.out.println("|");
			}
		}
		public static void bucle() {
			for (int i = 1; i <=10; i++) {
				for (int j=1; j<=(10 + i); j++){
					System.out.print("");
				}
				for(int k =1; k<=i; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
			//Repeticion
			for (int i = 1; i <=10; i++) {
				for (int j=1; j<=(10 - i); j++){
					System.out.print(" ");
				}
				for(int k =1; k<=i; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
			System.out.println();
		}
		public static void figuraEscalon() {
			for (int i = 1; i <=5; i++) {
				for (int j=1; j<=(10 + i); j++){
					System.out.print("**");
				}
				for(int k =1; k<=i; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}