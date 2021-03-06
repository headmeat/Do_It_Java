package john.john;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryChanger {
	static class cardConvRev {
		static void reverse(char[] d) {
			int mx = 0;
			
			for(int i=0;i<d.length;i++) {
				if(d[i] != '\u0000') mx = i+1;
				else break;
			}
			
			for(int i=0;i<mx/2;i++) {
				char tmp = d[i];
				d[i] = d[mx-i-1];
				d[mx-i-1] = tmp;
			}
		}
		
		static void printCalc(int x, int r, char c) {
			System.out.println();
		}
		
		static void cardConvR(int x, int r, char[] d) {
			int digits = 0;
			String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			
			System.out.println(r+" |    "+x+"\n  +-------");
			
			do {
				d[digits] = dchar.charAt(x % r);
				//printCalc(x, r, d[digits++]);
				x /= r;
				System.out.println(r+" |    "+x+"  ... "+d[digits++]+"\n  +------");
			}while(x != 0);
			
			System.out.println("       "+x+"  ... "+d[digits-1]);
			
			reverse(d); 
			/* changes original array as well just by passing to argument
			even if the method does not return any value(array). */
			
			System.out.println("Reversed Array: "+Arrays.toString(d));
		}
	}
	
	public static void main(String[] args) {
		char[] d = new char[32];
		
		cardConvRev.cardConvR(59, 2, d);
	}
}
