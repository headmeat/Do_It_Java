package john.john;

public class YMD {
	static int[][] mdays = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
			{31, 29, 31, 30, 31 ,30, 31, 31, 30, 31, 30, 31}, //윤년
	};
	
	int y; int m; int d;
	
	YMD(int y, int m, int d) {
		if(m>=1 && m<=12 && d>=1 && d<=31)
			this.y = y; this.m = m; this.d = d;
	}
	
	int isLeap(int y) {
		return (y%4 == 0 && y%100 != 0 || y%400 == 0) ? 1:0;
	}
	
	void printDate() {
		System.out.println(y+"년 "+m+"월 "+d+"일입니다.");
	}
	
	YMD after(int n){
		int leap = isLeap(y);
		
		//copy date of today
		int d_idx = d; int m_idx = m; int y_idx = y;
		
		while(true) {
			//if month changes with n left
			if(d_idx+n>mdays[leap][m_idx-1]) {
				n -= mdays[leap][m_idx-1] - d_idx;
				
				d_idx = 0;
				
				if(m_idx+1>12) {
					m_idx = 1; y_idx += 1; leap = isLeap(y_idx);
				}else m_idx += 1;
				
				//n-=1;
			//else month does not change with left n
			}else {
				d_idx = d_idx+n;
				break;
			}
		}
		
		return new YMD(y_idx, m_idx, d_idx);
	}
	
	YMD before(int n){
		int leap = isLeap(y);
		int y_idx = y; int m_idx = m; int d_idx = d;
		
		System.out.println(n);
		
		while(true) {
			System.out.println("M: "+m_idx);
			if(d_idx - n < 1) {
				n -= d_idx;
				System.out.println("D_DAY: "+n);
				if(m_idx - 1 < 1) {
					y_idx -= 1; m_idx = 12; leap = isLeap(y_idx);
				}else {
					m_idx -= 1;
				}
				
				d_idx = mdays[leap][m_idx];
			}else {
				d_idx -= n;
				break;
			}
		}
		
		return new YMD(y_idx, m_idx, d_idx);
	}
	
	public static void main(String[] args) {
		YMD ymd = new YMD(2021, 7, 27);
		
		YMD ymd2 = ymd.after(143);
		ymd2.printDate();
	}
}
