package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Main0318_암호만들기 { // 백준 1759암호만들기
	static int L, C;
	static char[] a;
	static char[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		a = new char[C];
		result = new char[L];
		for (int i = 0; i < C; i++) {
			a[i] = sc.next().charAt(0);
		}

		sc.close();
		Arrays.sort(a);
		getCode(0,0);
	}

	static void getCode(int start, int cnt) {
		if (cnt == L) {
			int num = 0;
			for (int i = 0; i < L; i++) {
				if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
					num++;
				}
			}
			if (num >=1 && L-num>=2) {

				for (char re : result) {
					System.out.print(re);
				}
				System.out.print("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			result[cnt] = a[i];
			getCode(i+1, cnt+1);
		}
	}
}
