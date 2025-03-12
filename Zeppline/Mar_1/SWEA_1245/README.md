길이, 균형점, 자성체의 정보를 저장할 COUNT, BALANCE, ASTEROID를 선언

반환 조건용 최소 차이 상수 EPSILON 선언

균형점과 자성체의 인력을 계산할 getPower 함수 선언

균형점을 찾는 재귀함수 findBalancePoint 함수 선언

입력값을 전역변수에 저장 후 각 자성체 간 균형점 탐색

findBalancePoint
> 앞 쪽 자성체의 인력, 뒤 쪽 자성체의 인력 초기화
> 
> getPower를 통해 인력 값 주입
> 
> 인력 차이가 EPSILON보다 작을 시 균형점 저장 후 return
> 
> 인력이 약한쪽으로 중심점 갱신
> 
> 현재 중심점과 갱신된 중심점의 차이가 EPSILON보다 작을 시 균형점 저장 후 return
> 
> 갱신된 중심점에 맞춰서 재귀탐색

모든 균형점 탐색 출력
