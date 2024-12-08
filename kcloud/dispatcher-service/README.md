# dispatcher service project

```
Spring Cloud Functional Service example
- 스프링 function 기능을 이용하여 함수와 함수를 합성하여 호출
```

### 구성
```
- pack() : 생산자
- label() : 소비자
```  

### 주요코드   
```
 * DispatchingFunctions : pack() , label() 메소드 정의
 * spring.cloud.function.definition=pack|label      # 스프링 클라우드 함수가 관리할 함수 정의  
 * DispatchingFunctionsIntegrationTests  # 테스트 코드
```  




