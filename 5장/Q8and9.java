package john.john;

import java.util.Arrays;

public class Queen {
	static int[] pos = new int[8];
	static boolean[] flag_a = new boolean[8], flag_b = new boolean[15], flag_c = new boolean[15];
	
	static void print() {
		for(int i=0;i<pos.length;i++) {//one row
			for(int j=0;j<pos.length;j++) {//for each col
				if(pos[j] == i) System.out.printf("%2s", "■");
				else System.out.printf("%2s", "□");
			}
			System.out.println();
		}
		System.out.println();
	}
	

	static void set(int i) {
		for(int j=0;j<8;j++) {
			if(flag_a[j] == false && flag_b[i+j] == false && flag_c[i-j+7] == false) {
				pos[i] = j;
				if(i==7) {
					print();
				}else {
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = true;
					set(i+1);
					flag_a[j] = flag_b[i+j] = flag_c[i-j+7] = false;
				}
			}
		}
	}

	static int check = 0;
	static int[] sw = new int[8];//pos[i]의 현재까지 계산했던 j 인덱스 상태 정보
	static int bwfw = 0;//0: 드가자, 1: 뒤로 빼고 이어서 해라
	
	static void set1(int i) {
		while(true) {
			for(sw[i] = (bwfw==0)?0:sw[i];sw[i]<8;sw[i]++) {
				if(flag_a[sw[i]] == false && flag_b[i+sw[i]] 
						== false && flag_c[i-sw[i]+7] == false) {
					pos[i] = sw[i];
					
					if(i==7) {
						print();
						i -= 1;
						flag_a[sw[i]] = flag_b[i+sw[i]] = flag_c[i-sw[i]+7] = false;
						break;
					}else {
						flag_a[sw[i]] = flag_b[i+sw[i]] = flag_c[i-sw[i]+7] = true;
						bwfw = 0;i += 1;sw[i] = -1;
					}
				}
			}
			
			bwfw = 1;i -= 1;
			if(i==-1) return;
			flag_a[sw[i]] = flag_b[i+sw[i]] = flag_c[i-sw[i]+7] = false;
			sw[i] += 1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("START");
		set(0);
		System.out.println("FINISH");
	}
}
