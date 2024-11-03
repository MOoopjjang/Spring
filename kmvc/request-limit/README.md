# Request-limit  

### 사용자 사용률제한 기능 Sample Application  

>#### Cloud 환경에서는 redis를 사용한 외부저장소에 user 접속 정보를 관리한다.

```
  * 제한조건
     - user당 일정시간구간안에 접속할수 있는 횟수 제한
     - local was의 InMemory로 구현
        ㄴ 추후 redis로 해당기능 이관예정!!!
  
 
```  

