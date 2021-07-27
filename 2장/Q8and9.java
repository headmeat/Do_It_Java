package john.john;

import java.util.Scanner;

public class DayOfYear {
	static int[][] mdays = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}  //윤년
	};
	
	static int isLeap(int year) {
		return (year%4 == 0 && year%100 != 0 || year%400 == 0)? 1:0;
	}
	
	static int dayOfYear(int y, int m, int d) {
		int leap = isLeap(y); m--;
		
		while(--m>=0) d += mdays[leap][m];
		
		return d;
	}
	
	static int leftDayOfYear(int y, int m, int d) {
		int leap = isLeap(y);
		int days = mdays[leap][m-1]-d;
		
		while(++m<=12) days += mdays[leap][m-1];
		
		return days;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int retry;
		
		System.out.println("그 해 경과 일수를 구합니다.");
		
		do {
			System.out.println("년: "); int year = stdIn.nextInt();
			System.out.println("월: "); int month = stdIn.nextInt();
			System.out.println("일: "); int day = stdIn.nextInt();
			
			System.out.printf("올해는 %d일 남았습니다.\n", leftDayOfYear(year, month, day));
			
			System.out.println("한 번 더 할까요? (1.예 / 0. 아니오) : ");
			retry = stdIn.nextInt();
		}while(retry==1);
	}
}
