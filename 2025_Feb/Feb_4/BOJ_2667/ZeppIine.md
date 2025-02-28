그리드를 MAP에 char배열로 받아온 후 dfs탐색 시작

MAP[i][j]가 1이고 방문한 적 없을 경우 전역변수 HOUSECOUNT 초기화 후 dfs함수 checkBlock진입

현재 좌표가 0이 아닌 경우, 방문 처리 및 HOUSECOUNT 증가 후 다음 좌표 진입

dfs함수 종료 후 HOUSEARR에 HOUSECOUNT 삽입 및 COUNT 증가

HOUSTARR을 오름차순 정렬 후 전체크기-COUNT에서 전체크기만큼 HOUSEARR출력
