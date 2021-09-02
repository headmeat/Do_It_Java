package john.john;

public class Test2 {
	static int getLevel(int idx) {
		int i = 1, sum = 1;
		
		for(;idx>=sum;i++) sum += Math.pow(2, i);
		
		return i-1;
	}
	
	static void printTree(int[] arr) {
		int height = getLevel(arr.length-1)+1;
		int i = 0;
		
		int prev = 0, first_space = -1;
		//printing elements
		for(int level = 0;level <= height;level++) {
			//print first space
			first_space = (int)Math.pow(2, height-level)-2;
			
			//첫 공백 벌리기
			for(int j = 0;j<first_space;j++)System.out.print(" ");
			
			//원소 출력 + 원소 간 간격 벌리기
			for(int k = 0;k<Math.pow(2, level)&&i<arr.length;k++) {
				System.out.printf("%02d", arr[i++]);
				for(int j = 0;j<prev;j++) System.out.print(" ");
			}
			System.out.println();
			
			//에지 출력 전 첫 공백 벌리기
			for(int j = 0;j<Math.pow(2, height-level)-3;j++)System.out.print(" ");
			
			for(int k = 0;k<Math.pow(2, level)&&i<arr.length;k++) {
				if(2*Math.pow(2, level)+k<arr.length)
					System.out.print("/");
				if(2*Math.pow(2, level)+k<arr.length)
					System.out.print(" \\");
				for(int j = 0;j<prev-1;j++) System.out.print(" ");
			}
			System.out.println();
			prev = first_space;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
		
		//System.out.println(getLevel(0));
		printTree(arr);
	}
}
