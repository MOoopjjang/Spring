# event-task project  
#### Multi Threading 환경에서 안전하게 작업처리를 위한 sample  

```
- java.concurrcy  BlockingQueue API 사용
- Queue와 Backgroud Thread를 이용한 작업처리
```  

#### 구조  
```
 - EvtTaskManager ( Job 실행관리자 - 외부 접근 API 제공 )
    ㄴ TaskPendingExecutor 
      ( Job 대기자  - valid job과 invalid job을 구분하여 각각의 맞는 executor에 job 등록 )
    ㄴ TaskFailExecutor 
       ( 등록된F ail Job 실행 Thread )
    ㄴ TaskRunExecutor ( 작업 실행자 )
       ( 등록된 valid한 job을 실행하는 Thread
       
  --> EvtTaskManager -> TaskPendingExecutor -> TaskRunExecutor
                                            ㄴ> TaskFailExecutor
```


#### url  
```
 http://localhost:8099/event-task/t1
```


#### 진행상황  
> 진행중