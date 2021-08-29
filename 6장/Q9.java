package john.john;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
	static int cnt = 0, swp = 0;
	
	static void shellSort(int[] arr) {
		int h, n = arr.length;
		
		for(h = n/2;h>0;h/=2) {
			for(int i=h;i<n;i++) {
				int tmp = arr[i];
				int j;
				
				for(j=i-h;j>=0&&arr[j]>tmp;j-=h) {
					cnt+=1;
					arr[j+h] = arr[j];
				}
				
				arr[j+h] = tmp;
			}
		}
	}
	
	static void permuteShellSort(int[] arr) {
		int n = arr.length;
		int h;
		
		for(h=1;h<n/9;h=h*3+1);
		
		for(;h>0;h/=3) {
			for(int i=h;i<n;i++) {
				int tmp = arr[i];
				int j;
				
				for(j=i-h;j>=0&&arr[j]>tmp;j-=h) {
					cnt+=1;
					arr[j+h] = arr[j];
				}
				
				arr[j+h] = tmp;
			}
		}
	}
	
	static void insertSort(int[] arr) {
		int n = arr.length;
		
		for(int i=1;i<n;i++) {
			int tmp = arr[i];
			int j;
			
			for(j=i;j>0&&arr[j-1]>tmp;j--) {
				cnt+=1;
				arr[j] = arr[j-1];
			}
			
			arr[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {62, 90, 163, 54, 56, 102, 18, 167, 85, 58, 3, 39, 138, 51, 148, 51, 58, 49, 46, 2, 4, 11, 43, 143, 10, 154, 65, 129, 162, 49, 188, 24, 100, 200, 140, 72, 44, 8, 96, 40, 47, 158, 90, 133, 156, 163, 187, 5, 76, 136, 189, 60, 86, 63, 21, 133, 104, 39, 12, 61, 195, 60, 76, 53, 198, 79, 106, 86, 96, 5, 59, 90, 107, 161, 151, 187, 75, 50, 143, 189, 80, 171, 10, 191, 195, 91, 57, 165, 25, 77, 56, 125, 170, 168, 10, 176, 132, 75, 176, 193};
		//int[] arr = {4,5,6,1,3};
		/*
		for(int i=0;i<100;i++) {
			arr[i] = ThreadLocalRandom.current().nextInt(0, 200 + 1);
		}
		System.out.println(Arrays.toString(arr));
		*/
		insertSort(arr);
		
		System.out.println(Arrays.toString(arr));
		System.out.println("COUNT: "+cnt);
	}
}
