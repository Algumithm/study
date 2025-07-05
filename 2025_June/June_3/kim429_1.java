import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // 장르별 총 재생 수
        Map<String, Integer> genreTotalMap = new HashMap<>();
        // 장르별 재생 수 top2의 인덱스
        Map<String, List<Integer>> top2Map = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            List<Integer> list = top2Map.computeIfAbsent(genre, k -> new ArrayList<>());
            list.add(i);
            
            // plays 배열을 참고하여 정렬 (재생 수 내림차순, 인덱스 오름차순)
            list.sort((a, b) -> {
                if (plays[b] != plays[a]) return plays[b] - plays[a];
                return a - b;
            });
            
            // list에 2개만 남기기
            while(list.size() > 2){
                list.remove(list.size() -1);
            }
            
            // 총 재생 수
            genreTotalMap.put(genre, genreTotalMap.getOrDefault(genre, 00) + play);
            
        }
        
        // 장르를 총 재생 수 기준으로 정렬
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(genreTotalMap.entrySet());
        sortedGenres.sort((a, b) -> b.getValue() - a.getValue());
        
        // sortedGenres에 나오는 장르 순서대로
        // top2Map에 있는 index를 result에 더해주기
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedGenres) {
            List<Integer> songList = top2Map.get(entry.getKey());
            for (int idx : songList) {
                result.add(idx);
            }
        }

        // 결과 배열 변환 후 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
