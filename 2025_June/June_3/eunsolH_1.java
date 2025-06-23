import java.util.*;


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String,Integer> genrePlay=new HashMap<>(); //장르별 재생수
        Map<String,List<int[]>> genreSongs=new HashMap<>();// 장르별 노래목록({고유번호,재생수})
        
        
        
        //장르별 총 재생수 계산&노래목록 저장
        for(int i=0;i<genres.length;i++){
            String genre=genres[i];
            int play=plays[i];
            
            int currentPlayCount;
            if(genrePlay.containsKey(genre)){
                currentPlayCount=genrePlay.get(genre); 
            }else{
                currentPlayCount=0; 
            }
            
            int updatedPlayCount = currentPlayCount + play;
            
            genrePlay.put(genre,updatedPlayCount);
            
            
            //장르별 곡 저장
            genreSongs.putIfAbsent(genre,new ArrayList<>());
            genreSongs.get(genre).add(new int[]{i,play});
            
            
            
        } 
        
        
        //장르를 총 재생 수 기준으로 정렬
        List<String> sortedGenres=new ArrayList<>(genrePlay.keySet());
        sortedGenres.sort((a,b)->genrePlay.get(b)-genrePlay.get(a));
        
        
        //결과저장
        List<Integer> result=new ArrayList<>();
        for(String genre:sortedGenres){
            List<int[]> songs=genreSongs.get(genre);
            
            songs.sort((a,b)->{
                if(b[1]==a[1]) return a[0]-b[0];
               return b[1]-a[1]; 
            });
            
            for(int i=0; i<songs.size() && i<2; i++){
                result.add(songs.get(i)[0]); //고유번호
            }
            
        }     
        
  
        int[] answer=new int[result.size()];
        
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        
        return answer;
    }
}
