package john.john;

import java.util.Scanner;

public class SeqSearchSen {
	static int[] a;
	
	static void printShit(int n) {
		System.out.print("   |");
		for(int i=0;i<2*n+1;i++)
			System.out.print(" ");
		
		System.out.println("*");
		
		System.out.print("  "+n+"|");
		
		for(int i=0;i<a.length;i++) {
			System.out.print(" "+a[i]);
		}
		System.out.println();
	}
	
	static int seqSearchSen(int[] a, int n, int key) {
		//보초법 수행
		int i;
		
		a[n] = key;
		
		System.out.print("   |");
		for(int j=0;j<a.length;j++) {
			System.out.print(" "+j);
		}
		System.out.println();
		System.out.print("---+");
		
		for(int j=0;j<a.length+1;j++) {
			System.out.print("--");
		}
		System.out.println();
		
		for(i=0;;i++) {
			printShit(i);
			if(a[i]==key) break;
		}
		
		return i==n?-1:i;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("How many elements?");
		int num = stdIn.nextInt();
		a = new int[num+1];//num+1 to add 보초병?
		
		for(int i=0;i<num;i++) {
			System.out.print("Element for a["+i+"]");
			a[i] = stdIn.nextInt();
			//System.out.println();
		}
		
		System.out.print("Looking for?");
		int key = stdIn.nextInt();
		
		int idx = seqSearchSen(a, num, key);
		
		if(idx==num) System.out.println("배열 a에 "+key+"는 없습니다.");
		else System.out.println(key+"는 a["+idx+"]에 있습니다.");
	}
}
