package john.john;

import java.util.Scanner;
// 메소드 recur3의 비재귀적구현

class Recur3_05_05 {
	// 메소드 recur의 비재귀적 구현
  /* 아래의 recur3 메서드를 비재귀적으로 구현하세요.
  static void recur3(int n){
    if(n>0){
      recur3(n-1);
      recur3(n-2);
      System.out.println(n);
    }
  }
  */
	static void recur3(int n) {
		int[] sstk = new int[100];
		int[] nstk = new int[100];
		int sw = 0;
		int ptr = -1;
		
		while(true) {
			if(n>0) {
				sstk[++ptr] = sw;
				nstk[ptr] = n;
				
				if(sw == 0) {
					n -= 1;
				}else if(sw == 1) {
					n -= 2;
					sw = 0;
				}
				
				continue;
			}
			
			do {
				n = nstk[ptr];
				sw = sstk[ptr--] + 1;
				
				if(sw == 2) {
					System.out.println(n);
					if(ptr < 0) {
						return;
					}
				}
			}while(sw==2);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요.：");
		int x = stdIn.nextInt();

		recur3(x);
	}
}
