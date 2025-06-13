import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        List<String> unknowns = new ArrayList<>();
        List<String[]> known = new ArrayList<>();
        
        // 식 분류
        for (String expr : expressions) {
            String[] parts = expr.split(" ");
            if (parts[4].equals("X")) {
                unknowns.add(expr);
            } else {
                known.add(new String[]{parts[0], parts[1], parts[2], parts[4]});
            }
        }
        
        // 각 진법이 수식을 만족하는지 확인
        Set<Integer> possibleBases = new HashSet<>();
        for (int base = 2; base <= 9; base++) {
            boolean valid = true;
            
            // Known 수식 검증
            for (String[] expr : known) {
                String A = expr[0], op = expr[1], B = expr[2], C = expr[3];
                if (!isValidInBase(A, base) || !isValidInBase(B, base) || !isValidInBase(C, base)) {
                    valid = false;
                    break;
                }
                int a = Integer.parseInt(A, base);
                int b = Integer.parseInt(B, base);
                int c = Integer.parseInt(C, base);
                int res = op.equals("+") ? a + b : a - b;
                if (res != c) {
                    valid = false;
                    break;
                }
            }
            
            // Unknown 수식의 피연산자들이 해당 진법에서 유효한지 검증
            if (valid) {
                for (String expr : unknowns) {
                    String[] parts = expr.split(" ");
                    String A = parts[0], B = parts[2];
                    if (!isValidInBase(A, base) || !isValidInBase(B, base)) {
                        valid = false;
                        break;
                    }
                }
            }
            
            if (valid) possibleBases.add(base);
        }
        
        // unknown 수식 처리
        List<String> result = new ArrayList<>();
        for (String expr : unknowns) {
            String[] parts = expr.split(" ");
            String A = parts[0], op = parts[1], B = parts[2];
            Set<String> results = new HashSet<>();
            
            for (int base : possibleBases) {
                int a = Integer.parseInt(A, base);
                int b = Integer.parseInt(B, base);
                int c = op.equals("+") ? a + b : a - b;
                if (c < 0) continue;
                String cStr = Integer.toString(c, base);
                results.add(cStr);
            }
            
            if (results.size() == 1) {
                result.add(A + " " + op + " " + B + " = " + results.iterator().next());
            } else {
                result.add(A + " " + op + " " + B + " = ?");
            }
        }
        
        return result.toArray(new String[0]);
    }
    
    private static boolean isValidInBase(String s, int base) {
        for (char ch : s.toCharArray()) {
            if (Character.digit(ch, base) == -1) {
                return false;
            }
        }
        return true;
    }
}
