# Spring Cloud Project  
```
스프링 클라우드 서비스 구성을위한 테스트 Project  
```  

## 환경  
```
 - Open JDK 17
 - SpringBoot 3.2.8
 - Kotlin 1.9.24
```

### Module  
> config-server
> * 설정관리 서버 module  
> * port : 8888  

> edge-server  
> * Spring Cloud Gateway ( API Gateway Server )
> * port:9000

> morder  
> * Spring Cloud Client sample 1  
> * port: 8089 ( local )
> * Non-blocking Server  

> mprod  
> * Spring Cloud Client sample 2  
> * port:8087
> * Non-blocking + co-routine