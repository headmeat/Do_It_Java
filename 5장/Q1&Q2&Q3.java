package john.john;
import java.util.Scanner;

public class Factorial {
	//Q3) 배열 a의 모든 요소의 최대공약수를 구하는 다음 메서드를 작성하세요. 
	static int gcdArray(int[] a) {
		int idx = 0;
		int cmp = a[idx];
		
		for(int i=idx+1;i<a.length;i++) {
			cmp = gcd(cmp, a[i]);
		}
		
		return cmp;
	}
	
	//Q2) 재귀 메서드 호출을 사용하지 않고 실습 5-2의 gcd 메서드를 작성하세요.
	static int gcd(int x, int y) {
		int tmp;
		
		//재귀 호출은 매개변수로 계속 전달이 되기 때문에 원본 값이 훼손되지 않지만, 여기서는 tmp를 따로 두어서 스왑 방식이 필요함
		while(y != 0) {
			tmp = x;
			x = y;
			y = tmp % y;//정사각형으로 나누고 남은 변 길이
			System.out.println(x+" "+y);
		}
		
		return x;
	}
	
	//Q1) 재귀 메서드 호출을 사용하지 않고 실습 5-1의 factorial 메서드를 작성하세요.
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
