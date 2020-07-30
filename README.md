## 알고리즘 정리
* Stack 사용
    * 배열내부에서 여러개의 시작점,끝 점이 존재할 때 
* Queue 사용
    * 시간 개념이 들어갈 때 (시작시간, 종료시간, 총 걸린 시간 등)
    * LRU 캐시
* DFS 전략
    * 총 경우의 수 구하기
    * 최대 depth 가 정해져 있으면, 최단거리를 구하는데 사용 가능
* BFS 전략
    * 최단거리, 최단 경우의 수 구하기
* DP 전략 < `대회에서 많이 사용된다고 함`
    * n과 관련된 (n-1), (n-2) 가 있을떄, (n-1) + (n-2) = n 으로 표현가능할 때.
* 이진탐색
    * 여러 조건들을 주고, 최솟값을 선택할 때.
    * [입국심사](https://programmers.co.kr/learn/courses/30/lessons/43238), [달팽이](https://www.acmicpc.net/problem/2869)
* Ad hoc
    * 아이디어로 문제를 해결
    * ex> Sliding Window, 소수 구하기 (에라토스테네스의 체)
        * 막대기하나로 지구의 둘레를 구해서 유명했는데, 소수찾기 까지 했다니 대단 ..
    
### 알고리즘 후 겪는 변화들
* 예전보다 코드를 읽는 시간이 많아졌다.
    * before: 문제가 생길때 break point로 따라갔다면
    * after: 코드를 눈으로 보며 문제점들을 파악하는데 더 능숙해졌다.
* `기본기`에 대한 생각의 변화
    * before: 알고리즘과 실무는 별개로 생각 (알고리즘 몰라도 구현은 가능하니까)
    * after: 케이스별로 sort, search 최적화를 `습관적으로` 고민
* 코드 작성의 변화
    * 아무래도 많은 양의 코드를 쓰다보니, stream(), forEach(), map() 과 같이 간결하게 작성하는 잡기술이 생김

### 가장 많이 틀린 케이스
* 지금 이 한글자를 대충보면 `구햔`+`삽질`에 10분을 까먹는다는 것을 계속 생각하자.
* 문제를 80%만 이해하고 100% 이해했다고 착각한 상태
* 어떻게 하면 고칠 수 있을까?
    * 종이에 써본다.
    * 가능한 여러 테스트케이스를 작성해본다.
   
### 문제를 잘못 읽고 틀린 문제들
[기능개발](https://programmers.co.kr/learn/courses/30/lessons/42586?language=java) , [문자열압축](https://programmers.co.kr/learn/courses/30/lessons/60057), [프린터](https://programmers.co.kr/learn/courses/30/lessons/42587)
<br>
* 겸손하게 풀자. 자신감이 가장 큰 원인
* 실수할 것 같은 곳에 동그라미, 주석 달기.
* 코드가 복잡한 것 같다면, 문제를 잘못 이해한건 아닌가 생각해보기.
