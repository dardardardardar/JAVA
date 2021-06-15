package TermProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		for(;;)
		{
			System.out.println();
			System.out.println("**** 환영합니다. PIcar 프로그램입니다. ****");
			System.out.println();
			System.out.println("1.자동차 구입  2.자동차 보험  3.프로그램 종료");
			System.out.println();
			System.out.print("선택 => ");
			int category = keyboard.nextInt();

			if(category == 1) {
				Car.car();
			    System.out.println("===========================================");
			}
			else if(category == 2) Register.register();
			else if (category == 3) {System.out.println("프로그램이 종료되었습니다. 저희 프로그램을 이용해주셔서 감사합니다."); break;}
			else { System.out.println("잘못 입력하셨습니다. 다시 한번 입력해주시기 바랍니다."); }

		}
	}
}
