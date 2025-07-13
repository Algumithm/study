import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 차량 경로를 끝나는 시점(진출지점) 기준으로 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int cameraCount = 0;
        int cameraPosition = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (route[0] > cameraPosition) {
                // 현재 차량의 시작점이 기존 카메라 범위를 벗어나면 새로운 카메라 설치
                cameraPosition = route[1];
                cameraCount++;
            }
        }

        return cameraCount;
    }
}
