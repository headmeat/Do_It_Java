package john.john;

import java.util.Scanner;

public class SeqSearchSen {
	static int[] a;
	
	static void printBinShit(int pl, int pc, int pr) {
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
		System.out.print("   |");
		for(int i=0;i<a.length;i++) {
			if(i==pl) {
				if(pl!=pc && pr!=pc) System.out.print("<-");
				else System.out.print("<+");
			}else if(i==pc) System.out.print(" +");
			else if(i==pr) {
				if(pl!=pc && pr!=pc) System.out.print("->");
				else System.out.print("+>");
			}
			else System.out.print("  ");
		}
		
		if(pc==pl || pc==pr) System.out.print(" (중첩 발생 at:"+pc+")");
		
		System.out.print("\n  "+pc+"|");
		
		for(int i=0;i<a.length;i++) {
			System.out.print(" "+a[i]);
		}
		System.out.println();
	}
	
	static int binSearch(int[] a, int n, int key, boolean first) {
		int pl = 0; int pr = n-1; int pc; int idx = -1;
		
		do {
			pc = (pl+pr)/2;
			printBinShit(pl, pc, pr);
			if(a[pc]==key) {
				if(first) {
					idx = pc;
					pr = pc-1;
				}else {
					return pc;
				}
			}
			else if(a[pc] < key) pl = pc+1;
			else if(a[pc] > key) pr = pc-1;
		}while(pl <= pr);
		
		return idx;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("How many elements?");
		int num = stdIn.nextInt();
		a = new int[num];
		
		for(int i=0;i<num;i++) {
			System.out.print("Element for a["+i+"]:");
			a[i] = stdIn.nextInt();
			//System.out.println();
		}
		
		System.out.print("Looking for?");
		int key = stdIn.nextInt();
		
		//true for getting earliest element and false for getting the element found first.
		int idx = binSearch(a, num, key, true);
		
		if(idx==-1) System.out.println("배열 a에 "+key+"는 없습니다.");
		else System.out.println(key+"는 a["+idx+"]에 있습니다.");
	}
}
