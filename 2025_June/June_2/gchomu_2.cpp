#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<string> solution(vector<string> expressions) {
    vector<string> formulas, equations, answers;
    int radix = -1;
    bool exactly = false;
    
    // 수식과 방정식 분리
    for (string expr : expressions) {
        if (expr.back() == 'X') equations.push_back(expr);
        else formulas.push_back(expr);
    }
    
    // 진수 판별
    for (string formula : formulas) {
        vector<int> nums;
        char op = '+';
        string num = "";
        
        for (char c : formula) {
            if (isdigit(c)) num += c;
            else {
                if (!num.empty()) { nums.push_back(stoi(num)); num = ""; }
                if (c == '+' || c == '-') op = c;
            }
        }
        if (!num.empty()) nums.push_back(stoi(num));
        
        if (nums.size() >= 3) {
            int a = nums[0], b = nums[1], c = nums[2];
            
            if (op == '+') {
                // 일의 자리에서 자릿수 올림 확인
                if ((a % 10) + (b % 10) != (c % 10)) {
                    exactly = true;
                    radix = (a % 10) + (b % 10) - (c % 10);
                    break;
                }
                // 십의 자리에서 자릿수 올림 확인  
                if (((a/10) % 10) + ((b/10) % 10) != ((c/10) % 10)) {
                    exactly = true;
                    radix = ((a/10) % 10) + ((b/10) % 10) - ((c/10) % 10);
                    break;
                }
            } else {
                // 일의 자리에서 자릿수 빌림 확인
                if ((a % 10) - (b % 10) != (c % 10)) {
                    exactly = true;
                    radix = -(a % 10) + (b % 10) + (c % 10);
                    break;
                }
            }
        }
        
        // 최소 진수 업데이트
        for (int n : nums) {
            while (n > 0) {
                radix = max(radix, n % 10 + 1);
                n /= 10;
            }
        }
    }
    
    // 방정식에서 최소 진수 업데이트
    for (string equation : equations) {
        string num = "";
        for (char c : equation) {
            if (isdigit(c)) num += c;
            else {
                if (!num.empty()) {
                    int n = stoi(num);
                    while (n > 0) {
                        radix = max(radix, n % 10 + 1);
                        n /= 10;
                    }
                    num = "";
                }
            }
        }
    }
    
    if (radix == 9) exactly = true;
    
    // 방정식 계산
    for (string equation : equations) {
        vector<int> nums;
        char op = '+';
        string num = "";
        
        for (char c : equation) {
            if (isdigit(c)) num += c;
            else {
                if (!num.empty()) { nums.push_back(stoi(num)); num = ""; }
                if (c == '+' || c == '-') op = c;
            }
        }
        
        int a = nums[0], b = nums[1];
        
        if (exactly) {
            // 정확한 진수를 아는 경우
            int result = 0, carry = 0, mult = 1;
            int ta = a, tb = b;
            
            while (ta > 0 || tb > 0 || carry > 0) {
                int da = ta % 10, db = tb % 10, dr = 0;
                if (op == '+') {
                    dr = da + db + carry;
                    carry = dr / radix;
                    dr %= radix;
                } else {
                    dr = da - db - carry;
                    if (dr < 0) { dr += radix; carry = 1; }
                    else carry = 0;
                }
                result += dr * mult;
                mult *= 10;
                ta /= 10; tb /= 10;
            }
            answers.push_back(equation.substr(0, equation.size()-1) + to_string(result));
        } else {
            // 정확한 진수를 모르는 경우 - overflow 체크
            if (op == '+') {
                if ((a % 10) + (b % 10) >= radix || ((a/10) % 10) + ((b/10) % 10) >= radix) {
                    answers.push_back(equation.substr(0, equation.size()-1) + "?");
                    continue;
                }
                int one = (a % 10) + (b % 10);
                int two = ((a/10) % 10) + ((b/10) % 10);
                int result = two * 10 + one;
                answers.push_back(equation.substr(0, equation.size()-1) + to_string(result));
            } else {
                if ((a % 10) - (b % 10) < 0) {
                    answers.push_back(equation.substr(0, equation.size()-1) + "?");
                    continue;
                }
                int one = (a % 10) - (b % 10);
                int two = ((a/10) % 10) - ((b/10) % 10);
                int result = two * 10 + one;
                answers.push_back(equation.substr(0, equation.size()-1) + to_string(result));
            }
        }
    }
    
    return answers;
}
