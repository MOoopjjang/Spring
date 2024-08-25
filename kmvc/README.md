# kmvc ( Kotlin MVC Project)  

# 목적  
```
  - SpringBoot Framework에서 사용되는 기본 기술을 테스트하기위한 Sample Project  
```  
# 환경  
```
 - Open JDK 11
 - SpringBoot 2.6.6
 - Kotlin 1.6.10
 - MySQL 8.x
```

# Module  
> core  
> >* KMVC 모듈에서 공통적으로 사용되는 기능제공
> >* jwt
> >* file upload
> >* ...
> >* KMVC의 모든 module에서 core모듈을 implements 해야 된다.
> >* implementation(project(":core"))

> api  
> >* RESTFul API 테스트용 Module 

> auth  
> >* JWT 발급및 검증 기능제공 Module  

> cache
> >* Redis를 이용한 API cache기능  

> grpc-cli , grpc-if , grpc-serv  
> >* gRPC 테스트용 module  
> >* grpc-if : Interface Module  

> kafka_consumer , kafka_producer  
> >* kafka 테스트용 Module  

> redlock  
> >* redis를 이용한 분산락 테스트용 Module  

> security  
> >* SpringSecurity 테스트용 Module  

> web  
> >* Thymeleaf를 View Template로 사용하는 웹서비스 테스트용 Module