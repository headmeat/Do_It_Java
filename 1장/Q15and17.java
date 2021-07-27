package ax;

import java.util.Scanner;

public class TriangleLB {
	static void triangleLU(int n) {
		for(int i=n;i>0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void triangleRU(int n) {
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<n;j++) {
				 if(j<i) {
					 System.out.print(" ");
					 continue;
				 }
				 System.out.print("*");
			 }
			 System.out.println();
		 }
	}
	
	static void triangleRB(int n) {
		 for(int i=n-1;i>=0;i--) {
			 for(int j=0;j<n;j++) {
				 if(i>j) {
					 System.out.print(" ");
					 continue;
				 }
				 System.out.print("*");
			 }
			 System.out.println();
		 }
	}
	
	static void spira(int n) {
		int pivot = n-1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<2*n+1;j++) {
				if(j>=pivot-i && j<=pivot+i) {
					System.out.print("*");
				}else System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	static void npira(int n) {
		int pivot = n-1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<2*n+1;j++) {
				if(j>=pivot-i && j<=pivot+i) {
					System.out.print(i+1);
				}else System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n;
		
		do {
			System.out.println("몇단 삼각형인 부분?");
			n = stdIn.nextInt();
		}while(n<=0);
		
		npira(n);
	}
}
