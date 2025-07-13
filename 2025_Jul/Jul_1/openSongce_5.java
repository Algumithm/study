import java.util.*;

class Solution {
    // 단어 길이별로 저장
    Map<Integer, List<String>> wordMap = new HashMap<>();
    Map<Integer, List<String>> reversedWordMap = new HashMap<>();

    public int[] solution(String[] words, String[] queries) {
        // 단어를 길이별로 정렬된 리스트에 저장
        for (String word : words) {
            int len = word.length();

            wordMap.putIfAbsent(len, new ArrayList<>());
            reversedWordMap.putIfAbsent(len, new ArrayList<>());

            wordMap.get(len).add(word);
            reversedWordMap.get(len).add(new StringBuilder(word).reverse().toString());
        }

        // 정렬 (이진 탐색을 위해)
        for (List<String> list : wordMap.values()) {
            Collections.sort(list);
        }
        for (List<String> list : reversedWordMap.values()) {
            Collections.sort(list);
        }

        // 각 쿼리 처리
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int len = query.length();

            if (!wordMap.containsKey(len)) {
                answer[i] = 0;
                continue;
            }

            // 접두사 or 접미사에 따라 정방향 / 역방향 처리
            if (query.charAt(0) != '?') {
                // 접미사가 '?'인 경우 → 정방향
                String lower = query.replace('?', 'a');
                String upper = query.replace('?', 'z');
                answer[i] = countByRange(wordMap.get(len), lower, upper);
            } else {
                // 접두사가 '?'인 경우 → 역방향 매칭
                String reversedQuery = new StringBuilder(query).reverse().toString();
                String lower = reversedQuery.replace('?', 'a');
                String upper = reversedQuery.replace('?', 'z');
                answer[i] = countByRange(reversedWordMap.get(len), lower, upper);
            }
        }

        return answer;
    }

    // 이진 탐색으로 lower~upper 사이 단어 개수 반환
    private int countByRange(List<String> list, String lower, String upper) {
        int left = lowerBound(list, lower);
        int right = upperBound(list, upper);
        return right - left;
    }

    // lower bound: 이상
    private int lowerBound(List<String> list, String target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).compareTo(target) >= 0) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // upper bound: 초과
    private int upperBound(List<String> list, String target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).compareTo(target) > 0) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
