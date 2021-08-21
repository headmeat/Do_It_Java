package john.john;

import java.util.Arrays;
import java.util.Scanner;
// 메소드 recur3의 비재귀적구현
class Hanoi {
	//n: 이동시킬 원반 수(원반 번호: 1~n(n: 최종)), x: 시작 기둥, y: 목적 기둥
	static void move(int n, int x, int y) {
		int stk[] = new int[100];//n 값
		int stk1[] = new int[100];//시작
		int stk2[] = new int[100];//목적
		
		int wonban[] = new int[] {3, 0, 0};
		
		int ptr = -1, sw = -1, sw2 = 0, cond = -1;
		
		while(true) {
			if(n>0) {
				stk[++ptr] = n;
				
				if(sw == -1) sw = 0;
				else if(sw == 0) y = 6 - x - y;
				else {
					x = 6 - x - y;
					sw = 0;
				}
				
				stk1[ptr] = x;
				stk2[ptr] = y;
				n -= 1;
				continue;
			}
			
			if(ptr!=-1) System.out.println(stk[ptr]+"번 원반: "+stk1[ptr]+"->"+stk2[ptr]);
			else return;
			
			wonban[stk1[ptr] - 1] -= 1;wonban[stk2[ptr] - 1] += 1;
			
			if(sw2 == 0) cond = stk[ptr];
			
			if(wonban[stk2[ptr] - 1] == cond) { //만족을 한다.
				sw = 0;sw2=0;ptr--;
			}else {
				sw = 1;sw2=1;
				x = stk1[ptr];
				y = stk2[ptr];
				n = stk[ptr--] - 1;
			}
			continue;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요.：");
		int x = stdIn.nextInt();
		
		move(x, 1, 3);
	}
}
