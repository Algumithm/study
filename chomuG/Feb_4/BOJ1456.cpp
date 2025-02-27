#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;
long long a, b, cnt;
bool check[10000001];
long long LIMIT = (long long)1e14;

void makePrime() {
	check[0] = false;
	check[1] = false;
	long long sqrtB = sqrt(b);

	for (long long i = 2; i * i <= sqrtB; i++) {
		if (check[i]) {
			for (long long j = i * i; j <= sqrtB; j += i) {
				check[j] = false;
			}
		}
	}
	
	for (long long i = 2; i <= sqrtB; ++i) {
		if (check[i]) {
			long long power = i;
			while (power <= b / i) {
				power *= i;

				if (power > b) break;

				if (a <= power) {
					cnt++;
				}
			}
		}
	}
}


int main() {
	cin >> a >> b;
	for (int i = 0; i < 10000000; ++i) {
		check[i] = true;
	}
	makePrime();

	cout << cnt << endl;
	return 0;
}

/*
거의 소수.

1. int 값을 넘어가기 때문에 계산값이 long long을 넘어가지 않도록 신경쓴다.
2. 소수를 체크 하는 배열의 길이를 넘어서 확인하지 않도록 한다.
3. 에라토스테네스의 체 기법을 이용해 소수를 구해준다. 
  (j= i*i 하는 이유: i* (2, 3, 4 ...) 등은 이미 앞에서 처리했기 때문)

*/
