# Edge-Server  
```
Spring Cloud Gateway Server
```  

### 구조  
```
 client (:9000/morder/info/1 )--> Edge-Server( :9000 ) <---> Order-Application ( :8089 )  
 client (:9000/mprod/info/1 ) -->          "           <---> Productionn-Applicationn ( :8087 )
```