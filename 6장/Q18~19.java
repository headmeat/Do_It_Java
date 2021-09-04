package john.john;

import java.util.Arrays;

public class Test {
	static void printArr(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	
	static void fSort(int[] arr, int min, int max) {//max는 최대값
		int n = arr.length;
		int[] b = new int[n];
		int[] f = new int[max-min+1];
		
		for(int i=0;i<n;i++) {
			f[arr[i]-min] += 1;
			System.out.print("도수분포:");
			printArr(f);
		}System.out.println();
		
		for(int i=1;i<max-min+1;i++) {
			f[i] += f[i-1];
			System.out.print("누적분포:");
			printArr(f);
		}System.out.println();
		
		for(int i=n-1;i>=0;i--) {
			b[--f[arr[i]-min]] = arr[i];
			System.out.print("작업용 배열:");
			printArr(b);
		}System.out.println();
		
		for(int i=0;i<n;i++) {
			arr[i] = b[i];
			System.out.print("원본 배열:");
			printArr(arr);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5,-1,-2,-3,1,2,4,6,7,3};
		int max = arr[0], min = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			if(max<arr[i]) max = arr[i];
			if(min>arr[i]) min = arr[i];
		}
		
		fSort(arr, min, max);
		
		System.out.println(Arrays.toString(arr));
	}
}
