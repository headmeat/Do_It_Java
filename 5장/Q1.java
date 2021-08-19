package john.john;
import java.util.Scanner;

public class Factorial {
	static int factorial(int n) {
		int res = 1;
		
		while(n>0) {
			res *= n;
			n--;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int x = 10;
		
		System.out.println(factorial(x));
	}
}
